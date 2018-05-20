public class BinarySearchTree {
	BinaryNode root;

	/*
	 * BinarySearchTree의 Constructor
	 * root를 null로 초기화
	 */
	BinarySearchTree() {
		this.root = null;
	}

	/*
	 * x Node와 그 하위의 노드에서 value와 같은 값을 가지고있는 Node를 찾고
	 * toDelete값이 true이면 해당노드를 삭제한 뒤 반환하고
	 * toDelete값이 false이면 그냥 해당 노드를 반환한다.
	 */
	BinaryNode findNode(BinaryNode x, int value, boolean toDelete) {
		// TODO
		if (x != null && x.getValue() != value) {	//Leaf가 아니고 못찾았으면
			if (x.getValue() < value) {	//현재 노드 값보다 value가 더 크면
				return findNode(x.getRight(), value, toDelete);	//Right Child에서 이어 찾는다.
			} else {
				return findNode(x.getLeft(), value, toDelete);
			}
		} else if (x != null && x.getValue() == value) {	//찾았을 경우
			if (toDelete) {
				return deleteNode(x);	//노드 삭제 후 반환
			}
			return x;	//노드 그냥 반환
		} else {	//x == null, 찾지 못한경우
			return x;
		}
	}

	/*
	 * Tree에 Node를 삽입하는 메소드
	 * root Node 밑에 node를 삽입한다.
	 */
	void insertNode(BinaryNode root, BinaryNode node) {
		// TODO
		if (root == null) {	//root가 null인경우
			this.root = node;	//this.root를 node로 설정
		} else if (root.getValue() < node.getValue()) {	//현재 노드 값보다 node의 값이 더 큰경우
			if (root.hasRight())	//Right Child가 있으면
				insertNode(root.getRight(), node);	//Right Child를 root로 Recursive하게 처리
			else {	//Right Child가 없으면
				root.setRight(node);	//node를 root의 Right Child로 한다.
				node.setParent(root);
			}
		} else {	//현재 노드값보다 node의 값이 더 작거나 같은 경우
			if (root.hasLeft())	//Left Child가 있으면
				insertNode(root.getLeft(), node);	//Left Child를 root로 Recursive하게 처리
			else {	//Left Child가 없으면
				root.setLeft(node);	//node를 root의 Left Child로 한다.
				node.setParent(root);
			}
		}
	}

	/*
	 * 해당 노드와 하위 노드 중 가장 작은 값을 가진 노드를 반환하는 메소드
	 * BinarySearchTree에서는 Left Most Node가 가장 작은 값을 가진 노드이므로
	 * Left Most를 반환한다.
	 */
	BinaryNode treeMinimum(BinaryNode node) {
		// TODO
		if (node.hasLeft())
			return treeMinimum(node.getLeft());
		else
			return node;
	}

	/*
	 * 받은 노드와 같은 값을 갖는 Node를 삭제하는 메소드
	 */
	BinaryNode deleteNode(BinaryNode z) {
		// TODO
		if (z.hasLeft() && z.hasRight()) { // has both
			BinaryNode rightMinimum = treeMinimum(z.getRight());	//successor를 가져온다.

			if (rightMinimum.getParent() == z) {	//successor가 z의 Right child인 경우
				rightMinimum.setLeft(z.getLeft());	//successor의 Left Child를 z의 Left Child로 설정
				z.getLeft().setParent(rightMinimum);
				transplant(z, rightMinimum);	//successor를 z에 transplant
			} else {	//successor가 z의 Right child가 아닌경우

				rightMinimum.getParent().setLeft(rightMinimum.getRight());	//successor의 Left Child를 successor의 Right Child로 설정
				if (rightMinimum.hasRight())	//successor가 Right Child를 갖고있으면
					rightMinimum.getRight().setParent(rightMinimum.getParent());	//successor의 Right Child의 Parent를 successor의 Parent로 설정

				rightMinimum.setRight(z.getRight());	//z의 child를 successor에게 붙힌다.
				rightMinimum.setLeft(z.getLeft());
				z.getLeft().setParent(rightMinimum);
				z.getRight().setParent(rightMinimum);
				z.setLeft(null);	//z의 child를 삭제
				z.setRight(null);

				transplant(z, rightMinimum);	//successor를 z로 transplant
			}

			return z;	//z를 반환
		} else if (z.hasLeft()) { // has only Left Child
			transplant(z, z.getLeft());	//z의 Left Child를 z에 transplant
			return z;	//z를 반환
		} else if (z.hasRight()) { // has only Right Child
			transplant(z, z.getRight());	//z의 Right Child를 z에 transplant
			return z;	//z를 반환
		} else { // Leaf
			transplant(z, null);	//null을 z에 transplant
			return z;	//z를 반환
		}
	}

	/*
	 * source를 des의 Parent에 붙히는 메소드
	 */
	void transplant(BinaryNode des, BinaryNode source) {
		// TODO
		if (!des.hasParent()) {	//목적지에 Parent가 없으면
			this.root = source;	//source를 root로 설정
		} else if (des == des.getParent().getLeft()) {	//des가 Left Child이면
			des.getParent().setLeft(source);	//source를 des의 Parent의 Left Child로 설정
		} else {	//des가 Right Child이면
			des.getParent().setRight(source);	//source를 des의 Parent의 Right Child로 설정
		}
		if (source != null) {	//source가 null이 아니면
			source.setParent(des.getParent());	//source의 Parent를 des의 Parent로 설정
		}
	}

	/*
	 * BinarySearchTree를 출력하는 메소드
	 */
	void printTree(BinaryNode node, int depth) {
		// TODO
		if (node != null) {	//node가 null이 아니면
			for (int i = 0; i < depth; i++) {	//depth만큼
				System.out.print("\t");	//tab을 출력하고
			}
			System.out.println(node.getValue());	//node의 value를 출력하고
			printTree(node.getLeft(), depth + 1);	//node의 Left Child 출력
			printTree(node.getRight(), depth + 1);	//node의 Right child 출력
		}
	}

	/*
	 * root의 Getter
	 */
	BinaryNode getRoot() {
		return this.root;
	}
}
