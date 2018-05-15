package tree;

import Queue.LinkedQueue;

public class BinaryTree {
	private BinaryNode root;
	private String order;
	
	/*
	 * BinaryTree의 Constructor
	 * 저장해야하는 value와 저장할 order를 나타내는
	 * 두 파라미터를 받는다.
	 * order를 저장하고 저장할 value를 parse한다.
	 */
	public BinaryTree(String value, String order) {
		// Don't save the value.
		this.order = order;
		parse(value);
	}

	/*
	 * 저장할 String을 parse하는 메소드
	 * this.order의 값에 따라 
	 * parseToPreOrder, parseToPostOrder,
	 * parseToLevelOrder, parseToInorder를 호출하여
	 * 값을 넘긴다.
	 */
	private void parse(String value) {
		if ("preOrder".equals(this.order)) {
			parseToPreOrder(value);
		} else if ("postOrder".equals(this.order)) {
			parseToPostOrder(value);
		} else if ("levelOrder".equals(this.order)) {
			parseToLevelOrder(value);
		} else {
			parseToInorder(value);
		}
	}

	/*
	 * 입력값을 inorder로 parse하는 메소드
	 * 입력 값이 비었을 경우 값 할당 없이 root를
	 * BinaryNode의 객체로 할당한다.
	 * 입력값이 있을경우 makeInorderTree에 입력값을 넘기고
	 * 반환값을 root로 취한다.
	 */
	private void parseToInorder(String value) {
		if ("".equals(value)) {
			this.root = new BinaryNode();
		} else {
			this.root = makeInorderTree(value);
		}
	}

	/*
	 * 입력된 값을 inorder Tree로 만들어 반환하는 메소드
	 * 입력된 값이 비었으면 null을 반환하고
	 * 값이 있으면 String의 중간에 있는 값을 찾아서
	 * 처음 반을 재귀적으로 돌리고 얻은 결과를 왼쪽 트리, 
	 * String중간에 있는 값을 Node의 값으로 갖는 BinaryNode를 root로
	 * 뒤쪽 반을 재귀적으로 돌리고 얻은 결과를 오른쪽 트리로 하는 큰 트리를 반환한다.
	 */
	private BinaryNode makeInorderTree(String value) {
		// TODO : Fill it
		if ("".equals(value))
			return null;

		int length = value.length();
		int middle = length / 2;
		BinaryNode left = makeInorderTree(value.substring(0, middle));
		BinaryNode root = new BinaryNode(value.substring(middle, middle + 1));
		BinaryNode right = makeInorderTree(value.substring(middle + 1, length));

		root.setLeft(left);
		root.setRight(right);

		return root;

	}

	/*
	 * 입력값을 preorder로 parse하는 메소드
	 * 입력 값이 비었을 경우 값 할당 없이 root를
	 * BinaryNode의 객체로 할당한다.
	 * 입력값이 있을경우 makePreOrderTree에 입력값을 넘기고
	 * 반환값을 root로 취한다.
	 */
	private void parseToPreOrder(String value) {
		if ("".equals(value)) {
			this.root = new BinaryNode();
		} else {
			this.root = makePreOrderTree(value);
		}
	}

	/*
	 * 입력된 값을 preorder Tree로 만들어 반환하는 메소드
	 * 입력된 값이 비었으면 null을 반환하고
	 * 값이 있으면 String의 처음에 있는 값을 찾아서
	 * 처음 값을 값으로 갖는 Node를 root로
	 * 남은 부분 중 처음 반을 재귀적으로 돌리고 얻은 결과를 왼쪽 트리, 
	 * 뒤쪽 반을 재귀적으로 돌리고 얻은 결과를 오른쪽 트리로 하는 큰 트리를 반환한다.
	 */
	private BinaryNode makePreOrderTree(String value) {
		// TODO : Fill it
		if ("".equals(value))
			return null;

		int length = value.length();
		int middle = length / 2;
		BinaryNode root = new BinaryNode(value.substring(0, 1));
		BinaryNode left = makePreOrderTree(value.substring(1, middle + 1));
		BinaryNode right = makePreOrderTree(value.substring(middle + 1, length));

		root.setLeft(left);
		root.setRight(right);

		return root;
	}

	/*
	 * 입력값을 postorder로 parse하는 메소드
	 * 입력 값이 비었을 경우 값 할당 없이 root를
	 * BinaryNode의 객체로 할당한다.
	 * 입력값이 있을경우 makePostOrderTree에 입력값을 넘기고
	 * 반환값을 root로 취한다.
	 */
	private void parseToPostOrder(String value) {
		if ("".equals(value)) {
			this.root = new BinaryNode();
		} else {
			this.root = makePostOrderTree(value);
		}
	}

	/*
	 * 입력된 값을 preorder Tree로 만들어 반환하는 메소드
	 * 입력된 값이 비었으면 null을 반환하고
	 * 값이 있으면 String의 중간에 있는 값을 찾아서
	 * 처음 반을 재귀적으로 돌리고 얻은 결과를 왼쪽 트리, 
	 * 마지막 하나를 뺸 뒤쪽 반을 재귀적으로 돌리고 얻은 결과를 오른쪽 트리, 
	 * 마지막 값을 값으로 갖는 Node를 root로 하는 큰 트리를 반환한다.
	 */
	private BinaryNode makePostOrderTree(String value) {
		// TODO : Fill it
		if ("".equals(value))
			return null;

		int length = value.length();
		int middle = length / 2;
		BinaryNode left = makePostOrderTree(value.substring(0, middle));
		BinaryNode right = makePostOrderTree(value.substring(middle, length - 1));
		BinaryNode root = new BinaryNode(value.substring(length - 1, length));
		root.setLeft(left);
		root.setRight(right);

		return root;

	}

	/*
	 * 입력값을 levelorder로 parse하는 메소드
	 * 입력 값이 비었을 경우 값 할당 없이 root를
	 * BinaryNode의 객체로 할당한다.
	 * 입력값이 있을경우 makeLevelOrderTree에 입력값을 넘기고
	 * 반환값을 root로 취한다.
	 */
	private void parseToLevelOrder(String value) {
		if ("".equals(value)) {
			this.root = new BinaryNode();
		} else {
			this.root = makeLevelOrderTree(value);
		}
	}

	/*
	 * 입력된 값을 levelorder Tree로 만들어 반환하는 메소드
	 * Queue를 하나 선언하고 입력값의 첫번쨰 값을 값으로 갖는 Node를 하나 선언한다.
	 * 그리고 q에 해당 node를 넣고 q가 빌때까지 
	 * Queue에서 값을 빼서 root로 정의하고 해당 번째 값을 갖는 BinaryNode를 선언하여
	 * Queue에 넣어주고 root에 왼쪽 오른쪽에 붙힌다.
	 * 반복문이 끝난 후 node를 반환한다.
	 */
	private BinaryNode makeLevelOrderTree(String value) {
		// TODO : Fill it
		LinkedQueue q = new LinkedQueue();
		BinaryNode node = new BinaryNode(value.substring(0, 1));
		q.add(node);
		for (int i = 1; !q.isEmpty(); i+=2) {
			BinaryNode root = q.remove();
			if (i + 1 <= value.length()) {
				root.setLeft(new BinaryNode(value.substring(i, i + 1)));
				q.add(root.getLeft());
			}
			if(i + 2 <= value.length()){
				root.setRight(new BinaryNode(value.substring(i + 1, i + 2)));
				q.add(root.getRight());
			}
			
		}
		
		return node;
	}

	/*
	 * inorder로 Tree를 검색하는 메소드이다.
	 * BinaryNode를 받아오고 StringBuilder를 선언하여
	 * 왼쪽 자식노드가 있으면 해당 노드를 재귀적으로 돌리며 얻은 값을 append하고
	 * 그리고 받아온 Node가 가지고 있는 값을 append하고
	 * 오른쪽 자식노드가 있으면 해당노드를 재귀적으로 돌리며 얻은 값을 append한다.
	 * 그리고 만든 String을 반환한다.
	 */
	private String inorder(BinaryNode node) {
		// TODO : Fill it
		StringBuilder sb = new StringBuilder();
		if (node.hasLeft())
			sb.append(inorder(node.getLeft()));
		sb.append(node.getValue());
		if (node.hasRight())
			sb.append(inorder(node.getRight()));

		return sb.toString();
	}

	/*
	 * preorder로 Tree를 검색하는 메소드이다.
	 * BinaryNode를 받아오고 StringBuilder를 선언하여
	 * 받아온 Node가 가지고 있는 값을 append하고
	 * 그리고 왼쪽 자식노드가 있으면 해당 노드를 재귀적으로 돌리며 얻은 값을 append하고
	 * 오른쪽 자식노드가 있으면 해당노드를 재귀적으로 돌리며 얻은 값을 append한다.
	 * 그리고 만든 String을 반환한다.
	 */
	private String preOrder(BinaryNode node) {
		// TODO : Fill it
		StringBuilder sb = new StringBuilder();
		sb.append(node.getValue());
		// System.out.print(node.getValue());
		if (node.hasLeft())
			sb.append(preOrder(node.getLeft()));
		if (node.hasRight())
			sb.append(preOrder(node.getRight()));

		return sb.toString();
	}

	/*
	 * postorder로 Tree를 검색하는 메소드이다.
	 * BinaryNode를 받아오고 StringBuilder를 선언하여
	 * 왼쪽 자식노드가 있으면 해당 노드를 재귀적으로 돌리며 얻은 값을 append하고
	 * 오른쪽 자식노드가 있으면 해당노드를 재귀적으로 돌리며 얻은 값을 append하고
	 * 받아온 Node가 가지고 있는 값을 append한다.
	 * 그리고 만든 String을 반환한다.
	 */
	private String postOrder(BinaryNode node) {
		// TODO : Fill it
		StringBuilder sb = new StringBuilder();
		if (node.hasLeft())
			sb.append(postOrder(node.getLeft()));
		if (node.hasRight())
			sb.append(postOrder(node.getRight()));
		sb.append(node.getValue());

		return sb.toString();
	}

	/*
	 * levelOrder로 Tree를 검색하는 메소드이다.
	 * BinaryNode를 받아오고 StringBuilder를 선언하고
	 * Queue를 하나 선언한다.
	 * Queue에 받아온 Node를 넣고 Queue가 빌때까지 반복문을 돌리며
	 * Queue에서 값을 하나 빼고 빼온 값을 append하고 왼쪽 자식이 있으면 해당 노드를 Queue에 넣고
	 * 오른쪽 자식이 있으면 해당 노드를 Queue에 넣어준다.
	 * 위를 반복하고 반복문이 끝난 뒤 만든 String을 반환한다.
	 */
	private String levelOrder(BinaryNode node) {
		// TODO : Fill it
		LinkedQueue q = new LinkedQueue();
		StringBuilder sb = new StringBuilder();

		q.add(node);

		while (!q.isEmpty()) {
			BinaryNode root = q.remove();
			sb.append(root.getValue());
			if (root.hasLeft())
				q.add(root.getLeft());
			if (root.hasRight())
				q.add(root.getRight());
		}

		return sb.toString();
	}

	/*
	 * 이 Tree에 있는 값을 반환하는 메소드이다.
	 * 현재 Tree의 order에 따라 preOrder, postOrder,
	 * levelOrder, inorder함수를 호출하여 이 Tree의 root 노드를 넘겨주고
	 * 해당 메소드에서 얻은 String을 반환한다.
	 */
	public String getValue() {
		String value;
		if ("preOrder".equals(this.order)) {
			value = preOrder(this.root);
		} else if ("postOrder".equals(this.order)) {
			value = postOrder(this.root);
		} else if ("levelOrder".equals(this.order)) {
			value = levelOrder(this.root);
		} else {
			value = inorder(this.root);
		}

		return value;
	}

	/*
	 * 이 Tree가 가지고 있는 value를 levelorder의 형태로 검색하며 
	 * 트리의 모습으로 터미널에 출력해주는 함수이다.
	 */
	public void print() {
		LinkedQueue queue = new LinkedQueue();	//Queue 선언
		queue.add(this.root);	//Queue에 root를 넣는다.
		int level = this.root.level();	//root의 level을 얻어온다.
		String interval = "%" + (int) Math.pow(2, this.root.height()) + "s";	//2^(root.height)만큼을 띄우는 형식
		StringBuilder tree = new StringBuilder();	//StringBuilder 선언
		while (!queue.isEmpty()) {	//Queue가 빌때까지 반복
			BinaryNode currentNode = queue.remove();	//Queue에서 Node를 하나 가지고와서
			if (currentNode != null) {	//가져온 Node가 null이 아니면
				if (level < currentNode.level()) {	//해당 Node의 level이 기존의 level보다 커졌으면
					level = currentNode.level();	//level 갱신
					interval = "%" + (int) Math.pow(2, currentNode.height()) + "s";	//interval 재 계산
					tree.append("\n");	//next line
				}
				queue.add(currentNode.getLeft());	//왼쪽 자식을 Queue에 넣는다.
				queue.add(currentNode.getRight());	//오른쪽 자식을 Queue에 넣는다.
				//interval만큼씩 띄워서 현재 Node의 값 append
				tree.append(String.format(interval, currentNode.getValue())).append(String.format(interval, ""));
			} else {	//가져온 Node가 null이면
				//interval만큼씩 띄워서 "" append
				tree.append(String.format(interval, "")).append(String.format(interval, ""));
			}
		}
		System.out.println(tree.toString());	//반복문이 끝나고 만들어진 String 출력
	}
}
