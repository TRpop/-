public class BinarySearchTree {
	BinaryNode root;

	/*
	 * BinarySearchTree�� Constructor
	 * root�� null�� �ʱ�ȭ
	 */
	BinarySearchTree() {
		this.root = null;
	}

	/*
	 * x Node�� �� ������ ��忡�� value�� ���� ���� �������ִ� Node�� ã��
	 * toDelete���� true�̸� �ش��带 ������ �� ��ȯ�ϰ�
	 * toDelete���� false�̸� �׳� �ش� ��带 ��ȯ�Ѵ�.
	 */
	BinaryNode findNode(BinaryNode x, int value, boolean toDelete) {
		// TODO
		if (x != null && x.getValue() != value) {	//Leaf�� �ƴϰ� ��ã������
			if (x.getValue() < value) {	//���� ��� ������ value�� �� ũ��
				return findNode(x.getRight(), value, toDelete);	//Right Child���� �̾� ã�´�.
			} else {
				return findNode(x.getLeft(), value, toDelete);
			}
		} else if (x != null && x.getValue() == value) {	//ã���� ���
			if (toDelete) {
				return deleteNode(x);	//��� ���� �� ��ȯ
			}
			return x;	//��� �׳� ��ȯ
		} else {	//x == null, ã�� ���Ѱ��
			return x;
		}
	}

	/*
	 * Tree�� Node�� �����ϴ� �޼ҵ�
	 * root Node �ؿ� node�� �����Ѵ�.
	 */
	void insertNode(BinaryNode root, BinaryNode node) {
		// TODO
		if (root == null) {	//root�� null�ΰ��
			this.root = node;	//this.root�� node�� ����
		} else if (root.getValue() < node.getValue()) {	//���� ��� ������ node�� ���� �� ū���
			if (root.hasRight())	//Right Child�� ������
				insertNode(root.getRight(), node);	//Right Child�� root�� Recursive�ϰ� ó��
			else {	//Right Child�� ������
				root.setRight(node);	//node�� root�� Right Child�� �Ѵ�.
				node.setParent(root);
			}
		} else {	//���� ��尪���� node�� ���� �� �۰ų� ���� ���
			if (root.hasLeft())	//Left Child�� ������
				insertNode(root.getLeft(), node);	//Left Child�� root�� Recursive�ϰ� ó��
			else {	//Left Child�� ������
				root.setLeft(node);	//node�� root�� Left Child�� �Ѵ�.
				node.setParent(root);
			}
		}
	}

	/*
	 * �ش� ���� ���� ��� �� ���� ���� ���� ���� ��带 ��ȯ�ϴ� �޼ҵ�
	 * BinarySearchTree������ Left Most Node�� ���� ���� ���� ���� ����̹Ƿ�
	 * Left Most�� ��ȯ�Ѵ�.
	 */
	BinaryNode treeMinimum(BinaryNode node) {
		// TODO
		if (node.hasLeft())
			return treeMinimum(node.getLeft());
		else
			return node;
	}

	/*
	 * ���� ���� ���� ���� ���� Node�� �����ϴ� �޼ҵ�
	 */
	BinaryNode deleteNode(BinaryNode z) {
		// TODO
		if (z.hasLeft() && z.hasRight()) { // has both
			BinaryNode rightMinimum = treeMinimum(z.getRight());	//successor�� �����´�.

			if (rightMinimum.getParent() == z) {	//successor�� z�� Right child�� ���
				rightMinimum.setLeft(z.getLeft());	//successor�� Left Child�� z�� Left Child�� ����
				z.getLeft().setParent(rightMinimum);
				transplant(z, rightMinimum);	//successor�� z�� transplant
			} else {	//successor�� z�� Right child�� �ƴѰ��

				rightMinimum.getParent().setLeft(rightMinimum.getRight());	//successor�� Left Child�� successor�� Right Child�� ����
				if (rightMinimum.hasRight())	//successor�� Right Child�� ����������
					rightMinimum.getRight().setParent(rightMinimum.getParent());	//successor�� Right Child�� Parent�� successor�� Parent�� ����

				rightMinimum.setRight(z.getRight());	//z�� child�� successor���� ������.
				rightMinimum.setLeft(z.getLeft());
				z.getLeft().setParent(rightMinimum);
				z.getRight().setParent(rightMinimum);
				z.setLeft(null);	//z�� child�� ����
				z.setRight(null);

				transplant(z, rightMinimum);	//successor�� z�� transplant
			}

			return z;	//z�� ��ȯ
		} else if (z.hasLeft()) { // has only Left Child
			transplant(z, z.getLeft());	//z�� Left Child�� z�� transplant
			return z;	//z�� ��ȯ
		} else if (z.hasRight()) { // has only Right Child
			transplant(z, z.getRight());	//z�� Right Child�� z�� transplant
			return z;	//z�� ��ȯ
		} else { // Leaf
			transplant(z, null);	//null�� z�� transplant
			return z;	//z�� ��ȯ
		}
	}

	/*
	 * source�� des�� Parent�� ������ �޼ҵ�
	 */
	void transplant(BinaryNode des, BinaryNode source) {
		// TODO
		if (!des.hasParent()) {	//�������� Parent�� ������
			this.root = source;	//source�� root�� ����
		} else if (des == des.getParent().getLeft()) {	//des�� Left Child�̸�
			des.getParent().setLeft(source);	//source�� des�� Parent�� Left Child�� ����
		} else {	//des�� Right Child�̸�
			des.getParent().setRight(source);	//source�� des�� Parent�� Right Child�� ����
		}
		if (source != null) {	//source�� null�� �ƴϸ�
			source.setParent(des.getParent());	//source�� Parent�� des�� Parent�� ����
		}
	}

	/*
	 * BinarySearchTree�� ����ϴ� �޼ҵ�
	 */
	void printTree(BinaryNode node, int depth) {
		// TODO
		if (node != null) {	//node�� null�� �ƴϸ�
			for (int i = 0; i < depth; i++) {	//depth��ŭ
				System.out.print("\t");	//tab�� ����ϰ�
			}
			System.out.println(node.getValue());	//node�� value�� ����ϰ�
			printTree(node.getLeft(), depth + 1);	//node�� Left Child ���
			printTree(node.getRight(), depth + 1);	//node�� Right child ���
		}
	}

	/*
	 * root�� Getter
	 */
	BinaryNode getRoot() {
		return this.root;
	}
}
