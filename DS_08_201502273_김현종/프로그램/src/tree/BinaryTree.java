package tree;

import Queue.LinkedQueue;

public class BinaryTree {
	private BinaryNode root;
	private String order;
	
	/*
	 * BinaryTree�� Constructor
	 * �����ؾ��ϴ� value�� ������ order�� ��Ÿ����
	 * �� �Ķ���͸� �޴´�.
	 * order�� �����ϰ� ������ value�� parse�Ѵ�.
	 */
	public BinaryTree(String value, String order) {
		// Don't save the value.
		this.order = order;
		parse(value);
	}

	/*
	 * ������ String�� parse�ϴ� �޼ҵ�
	 * this.order�� ���� ���� 
	 * parseToPreOrder, parseToPostOrder,
	 * parseToLevelOrder, parseToInorder�� ȣ���Ͽ�
	 * ���� �ѱ��.
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
	 * �Է°��� inorder�� parse�ϴ� �޼ҵ�
	 * �Է� ���� ����� ��� �� �Ҵ� ���� root��
	 * BinaryNode�� ��ü�� �Ҵ��Ѵ�.
	 * �Է°��� ������� makeInorderTree�� �Է°��� �ѱ��
	 * ��ȯ���� root�� ���Ѵ�.
	 */
	private void parseToInorder(String value) {
		if ("".equals(value)) {
			this.root = new BinaryNode();
		} else {
			this.root = makeInorderTree(value);
		}
	}

	/*
	 * �Էµ� ���� inorder Tree�� ����� ��ȯ�ϴ� �޼ҵ�
	 * �Էµ� ���� ������� null�� ��ȯ�ϰ�
	 * ���� ������ String�� �߰��� �ִ� ���� ã�Ƽ�
	 * ó�� ���� ��������� ������ ���� ����� ���� Ʈ��, 
	 * String�߰��� �ִ� ���� Node�� ������ ���� BinaryNode�� root��
	 * ���� ���� ��������� ������ ���� ����� ������ Ʈ���� �ϴ� ū Ʈ���� ��ȯ�Ѵ�.
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
	 * �Է°��� preorder�� parse�ϴ� �޼ҵ�
	 * �Է� ���� ����� ��� �� �Ҵ� ���� root��
	 * BinaryNode�� ��ü�� �Ҵ��Ѵ�.
	 * �Է°��� ������� makePreOrderTree�� �Է°��� �ѱ��
	 * ��ȯ���� root�� ���Ѵ�.
	 */
	private void parseToPreOrder(String value) {
		if ("".equals(value)) {
			this.root = new BinaryNode();
		} else {
			this.root = makePreOrderTree(value);
		}
	}

	/*
	 * �Էµ� ���� preorder Tree�� ����� ��ȯ�ϴ� �޼ҵ�
	 * �Էµ� ���� ������� null�� ��ȯ�ϰ�
	 * ���� ������ String�� ó���� �ִ� ���� ã�Ƽ�
	 * ó�� ���� ������ ���� Node�� root��
	 * ���� �κ� �� ó�� ���� ��������� ������ ���� ����� ���� Ʈ��, 
	 * ���� ���� ��������� ������ ���� ����� ������ Ʈ���� �ϴ� ū Ʈ���� ��ȯ�Ѵ�.
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
	 * �Է°��� postorder�� parse�ϴ� �޼ҵ�
	 * �Է� ���� ����� ��� �� �Ҵ� ���� root��
	 * BinaryNode�� ��ü�� �Ҵ��Ѵ�.
	 * �Է°��� ������� makePostOrderTree�� �Է°��� �ѱ��
	 * ��ȯ���� root�� ���Ѵ�.
	 */
	private void parseToPostOrder(String value) {
		if ("".equals(value)) {
			this.root = new BinaryNode();
		} else {
			this.root = makePostOrderTree(value);
		}
	}

	/*
	 * �Էµ� ���� preorder Tree�� ����� ��ȯ�ϴ� �޼ҵ�
	 * �Էµ� ���� ������� null�� ��ȯ�ϰ�
	 * ���� ������ String�� �߰��� �ִ� ���� ã�Ƽ�
	 * ó�� ���� ��������� ������ ���� ����� ���� Ʈ��, 
	 * ������ �ϳ��� �A ���� ���� ��������� ������ ���� ����� ������ Ʈ��, 
	 * ������ ���� ������ ���� Node�� root�� �ϴ� ū Ʈ���� ��ȯ�Ѵ�.
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
	 * �Է°��� levelorder�� parse�ϴ� �޼ҵ�
	 * �Է� ���� ����� ��� �� �Ҵ� ���� root��
	 * BinaryNode�� ��ü�� �Ҵ��Ѵ�.
	 * �Է°��� ������� makeLevelOrderTree�� �Է°��� �ѱ��
	 * ��ȯ���� root�� ���Ѵ�.
	 */
	private void parseToLevelOrder(String value) {
		if ("".equals(value)) {
			this.root = new BinaryNode();
		} else {
			this.root = makeLevelOrderTree(value);
		}
	}

	/*
	 * �Էµ� ���� levelorder Tree�� ����� ��ȯ�ϴ� �޼ҵ�
	 * Queue�� �ϳ� �����ϰ� �Է°��� ù���� ���� ������ ���� Node�� �ϳ� �����Ѵ�.
	 * �׸��� q�� �ش� node�� �ְ� q�� �������� 
	 * Queue���� ���� ���� root�� �����ϰ� �ش� ��° ���� ���� BinaryNode�� �����Ͽ�
	 * Queue�� �־��ְ� root�� ���� �����ʿ� ������.
	 * �ݺ����� ���� �� node�� ��ȯ�Ѵ�.
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
	 * inorder�� Tree�� �˻��ϴ� �޼ҵ��̴�.
	 * BinaryNode�� �޾ƿ��� StringBuilder�� �����Ͽ�
	 * ���� �ڽĳ�尡 ������ �ش� ��带 ��������� ������ ���� ���� append�ϰ�
	 * �׸��� �޾ƿ� Node�� ������ �ִ� ���� append�ϰ�
	 * ������ �ڽĳ�尡 ������ �ش��带 ��������� ������ ���� ���� append�Ѵ�.
	 * �׸��� ���� String�� ��ȯ�Ѵ�.
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
	 * preorder�� Tree�� �˻��ϴ� �޼ҵ��̴�.
	 * BinaryNode�� �޾ƿ��� StringBuilder�� �����Ͽ�
	 * �޾ƿ� Node�� ������ �ִ� ���� append�ϰ�
	 * �׸��� ���� �ڽĳ�尡 ������ �ش� ��带 ��������� ������ ���� ���� append�ϰ�
	 * ������ �ڽĳ�尡 ������ �ش��带 ��������� ������ ���� ���� append�Ѵ�.
	 * �׸��� ���� String�� ��ȯ�Ѵ�.
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
	 * postorder�� Tree�� �˻��ϴ� �޼ҵ��̴�.
	 * BinaryNode�� �޾ƿ��� StringBuilder�� �����Ͽ�
	 * ���� �ڽĳ�尡 ������ �ش� ��带 ��������� ������ ���� ���� append�ϰ�
	 * ������ �ڽĳ�尡 ������ �ش��带 ��������� ������ ���� ���� append�ϰ�
	 * �޾ƿ� Node�� ������ �ִ� ���� append�Ѵ�.
	 * �׸��� ���� String�� ��ȯ�Ѵ�.
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
	 * levelOrder�� Tree�� �˻��ϴ� �޼ҵ��̴�.
	 * BinaryNode�� �޾ƿ��� StringBuilder�� �����ϰ�
	 * Queue�� �ϳ� �����Ѵ�.
	 * Queue�� �޾ƿ� Node�� �ְ� Queue�� �������� �ݺ����� ������
	 * Queue���� ���� �ϳ� ���� ���� ���� append�ϰ� ���� �ڽ��� ������ �ش� ��带 Queue�� �ְ�
	 * ������ �ڽ��� ������ �ش� ��带 Queue�� �־��ش�.
	 * ���� �ݺ��ϰ� �ݺ����� ���� �� ���� String�� ��ȯ�Ѵ�.
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
	 * �� Tree�� �ִ� ���� ��ȯ�ϴ� �޼ҵ��̴�.
	 * ���� Tree�� order�� ���� preOrder, postOrder,
	 * levelOrder, inorder�Լ��� ȣ���Ͽ� �� Tree�� root ��带 �Ѱ��ְ�
	 * �ش� �޼ҵ忡�� ���� String�� ��ȯ�Ѵ�.
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
	 * �� Tree�� ������ �ִ� value�� levelorder�� ���·� �˻��ϸ� 
	 * Ʈ���� ������� �͹̳ο� ������ִ� �Լ��̴�.
	 */
	public void print() {
		LinkedQueue queue = new LinkedQueue();	//Queue ����
		queue.add(this.root);	//Queue�� root�� �ִ´�.
		int level = this.root.level();	//root�� level�� ���´�.
		String interval = "%" + (int) Math.pow(2, this.root.height()) + "s";	//2^(root.height)��ŭ�� ���� ����
		StringBuilder tree = new StringBuilder();	//StringBuilder ����
		while (!queue.isEmpty()) {	//Queue�� �������� �ݺ�
			BinaryNode currentNode = queue.remove();	//Queue���� Node�� �ϳ� ������ͼ�
			if (currentNode != null) {	//������ Node�� null�� �ƴϸ�
				if (level < currentNode.level()) {	//�ش� Node�� level�� ������ level���� Ŀ������
					level = currentNode.level();	//level ����
					interval = "%" + (int) Math.pow(2, currentNode.height()) + "s";	//interval �� ���
					tree.append("\n");	//next line
				}
				queue.add(currentNode.getLeft());	//���� �ڽ��� Queue�� �ִ´�.
				queue.add(currentNode.getRight());	//������ �ڽ��� Queue�� �ִ´�.
				//interval��ŭ�� ����� ���� Node�� �� append
				tree.append(String.format(interval, currentNode.getValue())).append(String.format(interval, ""));
			} else {	//������ Node�� null�̸�
				//interval��ŭ�� ����� "" append
				tree.append(String.format(interval, "")).append(String.format(interval, ""));
			}
		}
		System.out.println(tree.toString());	//�ݺ����� ������ ������� String ���
	}
}
