package tree;

public class BinaryNode {
    private String value;
	private BinaryNode parent;
    private BinaryNode left;
    private BinaryNode right;
    
    /*
     * BinaryNode의 Constructor
     */
    BinaryNode() {
    }

    /*
     * BinaryNode의 Constructor
     * 받은 value를 this.value에 할당
     */
    BinaryNode(String value) {
        this.value = value;
    }
    
    /*
     * 현재 노드의 level을 반환하는 메소드
     * 부모 Node가 없으면 1을 반환하고 그렇지 않으면 부모 노드의 level + 1을 반환한다.
     */
    public int level() {
        if (parent == null) {
            return 1;
        }
        return parent.level() + 1;
    }

    /*
     * 해당 Node의 height를 반환하는 메소드
     * 해당 Node가 Leaf이면 1을 반환한다.
     * 왼쪽 자식이 있으면 해당 노드의 height를 받아오고
     * 오른쪽 자식이 있으면 해당 노드의 height를 받아와
     * 둘 중 더 큰 값  + 1을 반환한다.
     */
    public int height() {
        // TODO : Fill it
    	if(this.isLeaf()) return 1;
    	else{
    		int leftHeigth = 0;
    		if(this.hasLeft()){
    			leftHeigth = this.left.height();
    		}
    		int rightHeigth = 0;
    		if(this.hasRight()){
    			rightHeigth = this.right.height();
    		}
    		return leftHeigth > rightHeigth ? leftHeigth + 1 : rightHeigth + 1;
    	}
    }

    /*
     * 자식이 둘 있으면 두 자식에게 재귀적으로 노드 수를 받아와 +1하여 반환하고
     * 왼쪽 자식이 있으면 왼쪽 자식이 갖고있는 노드수를 재귀적으로 받아와 +1하여 반환하고
     * 오른쪽 자식이 있으면 오른쪽 자식이 갖고있는 노드수를 재귀적으로 받아와 +1하여 반환하고
     * 자식이 없으면 1을 반환한다.
     */
    public int numberOfNodes() {
        // TODO : Fill it
    	if(this.hasLeft() && this.hasRight()){
    		return this.left.numberOfNodes() + this.right.numberOfNodes() + 1;
    	}else if(this.hasLeft()){
    		return this.left.numberOfNodes() + 1;
    	}else if(this.hasRight()){
    		return this.right.numberOfNodes() + 1;
    	}else{
    		return 1;
    	}
    }
    
    /*
     * value의 getter
     */
    public String getValue() {
        return value;
    }

    /*
     * 왼쪽 자식의 setter
     * 왼쪽 자식의 parent를 자신으로 지정한다.
     */
    public void setLeft(BinaryNode left) {
        if (left != null) {
            this.left = left;
            this.left.parent = this;
        }
    }

    /*
     * 오른쪽 자식의 setter
     * 오른쪽 자식의 parent를 자신으로 지정한다.
     */
    public void setRight(BinaryNode right) {
        if (right != null) {
            this.right = right;
            right.parent = this;
        }
    }

    /*
     * 왼쪽 자식의 getter
     */
    public BinaryNode getLeft() {
        return this.left;
    }
    
    /*
     * 오른쪽 자식의 getter
     */
    public BinaryNode getRight() {
        return this.right;
    }

    /*
     * 왼쪽 자식이 있는지 확인하는 메소드
     */
    public boolean hasLeft() {
        // TODO : Fill it
    	return this.left != null;
    }

    /*
     * 오른쪽 자식이 있는지 확인하는 메소드
     */
    public boolean hasRight() {
        // TODO : Fill it
    	return this.right != null;
    }

    /*
     * 이 노드가 Leaf인지 확인하는 메소드
     */
    public boolean isLeaf() {
        // TODO : Fill it
    	return !(this.hasLeft() || this.hasRight());
    }

}
