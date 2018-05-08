import java.util.LinkedList;
import java.util.Queue;

public class Tree<T> {
	private T value;
	private Tree<T> leftChild;
	private Tree<T> rightChild;
	private static int level;

	/*
	 * Tree의 생성자
	 * 모두 null로 초기화
	 */
	public Tree() {
		this.value = null;
		this.leftChild = null;
		this.rightChild = null;
	}

	/*
	 * 원소, leftChild, rightChild 모두 입력값으로 초기화하는 생성자
	 */
	public Tree(T anElement, Tree<T> leftChild, Tree<T> rightChild) {
		this.value = anElement;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	// 왼쪽 자식을 가지고 있는지 확인
	public boolean hasLeftChild() {
		return (this.leftChild != null);
	}

	// 오른쪽 자식을 가지고 있는지 확인
	public boolean hasRightChild() {
		return (this.rightChild != null);
	}

	// Leaf인지 확인
	public boolean isLeaf() {
		return (this.leftChild == null) && (this.rightChild == null);
	}

	/*
	 * 왼쪽 자식이 있으면 해당 트리의 height값을 가져오고
	 * 오른쪽 자식도 있으면 해당 트리의 height값을 가져와 둘 중 큰 값을 반환하는 메소드
	 * 트리의 height를 알 수 있다.
	 */
	public int height() {
		int leftHeight = 0;
		if (this.hasLeftChild()) {
			leftHeight = this.leftChild.height();
		}
		int rightHeight = 0;
		if (this.hasRightChild()) {
			rightHeight = this.rightChild.height();
		}
		if (leftHeight > rightHeight)
			return (leftHeight + 1);
		else
			return (rightHeight + 1);
	}

	/*
	 * 왼쪽 자식의 트리수를 가져오고
	 * 오른쪽 자식의 트리수도 가져와 둘이 합쳐
	 * 총 트리에 있는 노드의 수를 반환하는 함수
	 */
	public int numberOfTrees() {
		int numberOfLeftTrees = 0;
		if (this.hasLeftChild()) {
			numberOfLeftTrees = this.leftChild.numberOfTrees();
		}
		int numberOfRightTrees = 0;
		if (this.hasRightChild()) {
			numberOfRightTrees = this.rightChild.numberOfTrees();
		}
		return (1 + numberOfLeftTrees + numberOfRightTrees);
	}

	//해당 트리의 노드의 값을 반환하는 함수
	public T element() {
		return this.value;
	}

	// 원소 설정하기: setter for element
	public void setElement(T anElement) {
		this.value = anElement;
	}

	/*
	 * 해당 트리의 왼쪽 자식을 반환하는 함수
	 */
	public Tree<T> leftChild() {
		return this.leftChild;
	}

	// left의 자식을 설정함: setter for leftChild
	public void setLeftChild(Tree<T> leftChild) {
		this.leftChild = leftChild;
	}

	/*
	 * 해당 트리의 오른쪽 자식을 반환하는 함수
	 */
	public Tree<T> rightChild() {
		return this.rightChild;
	}

	// right의 자식을 설정함: setter for rightChild
	public void setRightChild(Tree<T> rightChild) {
		this.rightChild = rightChild;
	}

	/*
	 * inorder로 Tree를 검사하는 함수
	 * 왼쪽 자식, root, 오른쪽 자식순으로 검사한다.
	 */
	public void inorder(Tree<T> root) {
		if (root != null) {
			inorder(root.leftChild());
			visit(root);
			inorder(root.rightChild());
		}
	}

	/*
	 * preorder로 Tree를 검사하는 함수
	 * root, 왼쪽 자식, 오른쪽 자식순으로 검사한다.
	 */
	public void preorder(Tree<T> root) {
		if (root != null) {
			visit(root);
			preorder(root.leftChild());
			preorder(root.rightChild());
		}
	}

	/*
	 * postorder로 Tree를 검사하는 함수
	 * 왼쪽 자식, 오른쪽 자식, root순으로 검사한다.
	 */
	public void postorder(Tree<T> root) {
		if (root != null) {
			postorder(root.leftChild());
			postorder(root.rightChild());
			visit(root);
		}
	}

	/*
	 * postorder로 Tree를 검사하는 함수
	 * Queue에 root를 넣고 q에서 하나씩 꺼내며 검사하고
	 * 자식이 있을 경우 q에 넣는 것을 q가 빌때까지 반복한다.
	 */
	public void levelorder(Tree<T> root) {
		Queue<Tree<T>> q = new LinkedList<Tree<T>>();

		q.offer(root);

		while (!q.isEmpty()) {
			Tree<T> temp = q.poll();
			if (temp != null) {
				visit(temp);
				q.offer(temp.leftChild);
				q.offer(temp.rightChild);
			}
		}
	}

	/*
	 * 노드를 검사하는 함수
	 * 노드값을 터미널에 출력한다.
	 */
	private void visit(Tree<T> element) {
		// TODO Auto-generated method stub
		System.out.println(element.element());
	}
}
