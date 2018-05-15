package tree;

public class BinaryNode {
    private String value;
	private BinaryNode parent;
    private BinaryNode left;
    private BinaryNode right;
    
    /*
     * BinaryNode�� Constructor
     */
    BinaryNode() {
    }

    /*
     * BinaryNode�� Constructor
     * ���� value�� this.value�� �Ҵ�
     */
    BinaryNode(String value) {
        this.value = value;
    }
    
    /*
     * ���� ����� level�� ��ȯ�ϴ� �޼ҵ�
     * �θ� Node�� ������ 1�� ��ȯ�ϰ� �׷��� ������ �θ� ����� level + 1�� ��ȯ�Ѵ�.
     */
    public int level() {
        if (parent == null) {
            return 1;
        }
        return parent.level() + 1;
    }

    /*
     * �ش� Node�� height�� ��ȯ�ϴ� �޼ҵ�
     * �ش� Node�� Leaf�̸� 1�� ��ȯ�Ѵ�.
     * ���� �ڽ��� ������ �ش� ����� height�� �޾ƿ���
     * ������ �ڽ��� ������ �ش� ����� height�� �޾ƿ�
     * �� �� �� ū ��  + 1�� ��ȯ�Ѵ�.
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
     * �ڽ��� �� ������ �� �ڽĿ��� ��������� ��� ���� �޾ƿ� +1�Ͽ� ��ȯ�ϰ�
     * ���� �ڽ��� ������ ���� �ڽ��� �����ִ� ������ ��������� �޾ƿ� +1�Ͽ� ��ȯ�ϰ�
     * ������ �ڽ��� ������ ������ �ڽ��� �����ִ� ������ ��������� �޾ƿ� +1�Ͽ� ��ȯ�ϰ�
     * �ڽ��� ������ 1�� ��ȯ�Ѵ�.
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
     * value�� getter
     */
    public String getValue() {
        return value;
    }

    /*
     * ���� �ڽ��� setter
     * ���� �ڽ��� parent�� �ڽ����� �����Ѵ�.
     */
    public void setLeft(BinaryNode left) {
        if (left != null) {
            this.left = left;
            this.left.parent = this;
        }
    }

    /*
     * ������ �ڽ��� setter
     * ������ �ڽ��� parent�� �ڽ����� �����Ѵ�.
     */
    public void setRight(BinaryNode right) {
        if (right != null) {
            this.right = right;
            right.parent = this;
        }
    }

    /*
     * ���� �ڽ��� getter
     */
    public BinaryNode getLeft() {
        return this.left;
    }
    
    /*
     * ������ �ڽ��� getter
     */
    public BinaryNode getRight() {
        return this.right;
    }

    /*
     * ���� �ڽ��� �ִ��� Ȯ���ϴ� �޼ҵ�
     */
    public boolean hasLeft() {
        // TODO : Fill it
    	return this.left != null;
    }

    /*
     * ������ �ڽ��� �ִ��� Ȯ���ϴ� �޼ҵ�
     */
    public boolean hasRight() {
        // TODO : Fill it
    	return this.right != null;
    }

    /*
     * �� ��尡 Leaf���� Ȯ���ϴ� �޼ҵ�
     */
    public boolean isLeaf() {
        // TODO : Fill it
    	return !(this.hasLeft() || this.hasRight());
    }

}
