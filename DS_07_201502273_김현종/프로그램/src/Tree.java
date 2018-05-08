import java.util.LinkedList;
import java.util.Queue;

public class Tree<T> {
	private T value;
	private Tree<T> leftChild;
	private Tree<T> rightChild;
	private static int level;

	/*
	 * Tree�� ������
	 * ��� null�� �ʱ�ȭ
	 */
	public Tree() {
		this.value = null;
		this.leftChild = null;
		this.rightChild = null;
	}

	/*
	 * ����, leftChild, rightChild ��� �Է°����� �ʱ�ȭ�ϴ� ������
	 */
	public Tree(T anElement, Tree<T> leftChild, Tree<T> rightChild) {
		this.value = anElement;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	// ���� �ڽ��� ������ �ִ��� Ȯ��
	public boolean hasLeftChild() {
		return (this.leftChild != null);
	}

	// ������ �ڽ��� ������ �ִ��� Ȯ��
	public boolean hasRightChild() {
		return (this.rightChild != null);
	}

	// Leaf���� Ȯ��
	public boolean isLeaf() {
		return (this.leftChild == null) && (this.rightChild == null);
	}

	/*
	 * ���� �ڽ��� ������ �ش� Ʈ���� height���� ��������
	 * ������ �ڽĵ� ������ �ش� Ʈ���� height���� ������ �� �� ū ���� ��ȯ�ϴ� �޼ҵ�
	 * Ʈ���� height�� �� �� �ִ�.
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
	 * ���� �ڽ��� Ʈ������ ��������
	 * ������ �ڽ��� Ʈ������ ������ ���� ����
	 * �� Ʈ���� �ִ� ����� ���� ��ȯ�ϴ� �Լ�
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

	//�ش� Ʈ���� ����� ���� ��ȯ�ϴ� �Լ�
	public T element() {
		return this.value;
	}

	// ���� �����ϱ�: setter for element
	public void setElement(T anElement) {
		this.value = anElement;
	}

	/*
	 * �ش� Ʈ���� ���� �ڽ��� ��ȯ�ϴ� �Լ�
	 */
	public Tree<T> leftChild() {
		return this.leftChild;
	}

	// left�� �ڽ��� ������: setter for leftChild
	public void setLeftChild(Tree<T> leftChild) {
		this.leftChild = leftChild;
	}

	/*
	 * �ش� Ʈ���� ������ �ڽ��� ��ȯ�ϴ� �Լ�
	 */
	public Tree<T> rightChild() {
		return this.rightChild;
	}

	// right�� �ڽ��� ������: setter for rightChild
	public void setRightChild(Tree<T> rightChild) {
		this.rightChild = rightChild;
	}

	/*
	 * inorder�� Tree�� �˻��ϴ� �Լ�
	 * ���� �ڽ�, root, ������ �ڽļ����� �˻��Ѵ�.
	 */
	public void inorder(Tree<T> root) {
		if (root != null) {
			inorder(root.leftChild());
			visit(root);
			inorder(root.rightChild());
		}
	}

	/*
	 * preorder�� Tree�� �˻��ϴ� �Լ�
	 * root, ���� �ڽ�, ������ �ڽļ����� �˻��Ѵ�.
	 */
	public void preorder(Tree<T> root) {
		if (root != null) {
			visit(root);
			preorder(root.leftChild());
			preorder(root.rightChild());
		}
	}

	/*
	 * postorder�� Tree�� �˻��ϴ� �Լ�
	 * ���� �ڽ�, ������ �ڽ�, root������ �˻��Ѵ�.
	 */
	public void postorder(Tree<T> root) {
		if (root != null) {
			postorder(root.leftChild());
			postorder(root.rightChild());
			visit(root);
		}
	}

	/*
	 * postorder�� Tree�� �˻��ϴ� �Լ�
	 * Queue�� root�� �ְ� q���� �ϳ��� ������ �˻��ϰ�
	 * �ڽ��� ���� ��� q�� �ִ� ���� q�� �������� �ݺ��Ѵ�.
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
	 * ��带 �˻��ϴ� �Լ�
	 * ��尪�� �͹̳ο� ����Ѵ�.
	 */
	private void visit(Tree<T> element) {
		// TODO Auto-generated method stub
		System.out.println(element.element());
	}
}
