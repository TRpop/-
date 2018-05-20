public class BinaryNode {
    private int value;	//node�� value
    private BinaryNode parent;	//node�� Parent node
    private BinaryNode left;	//node�� Left Child
    private BinaryNode right;	//node�� Right Child

    /*
     * BinaryNode�� Constructor
     * ���� ������ value�� �ʱ�ȭ�ϰ�
     * left, right, parent�� null�� �ʱ�ȭ
     */
    BinaryNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    /*
     * value�� getter
     */
    public int getValue() {
        return value;
    }

    /*
     * parent�� setter
     */
    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }

    /*
     * left�� setter
     */
    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    /*
     * right�� setter
     */
    public void setRight(BinaryNode right) {
        this.right = right;
    }

    /*
     * parent�� getter
     */
    public BinaryNode getParent() {
        return this.parent;
    }

    /*
     * left�� getter
     */
    public BinaryNode getLeft() {
        return this.left;
    }

    /*
     * right�� getter
     */
    public BinaryNode getRight() {
        return this.right;
    }

    /*
     * parent�� ���θ� ��ȯ�ϴ� �޼ҵ�
     */
    public boolean hasParent() {
        return this.parent != null;
    }

    /*
     * left�� ���θ� ��ȯ�ϴ� �޼ҵ�
     */
    public boolean hasLeft() {
        return this.left != null;
    }

    /*
     * right�� ���θ� ��ȯ�ϴ� �޼ҵ�
     */
    public boolean hasRight() {
        return this.right != null;
    }

}
