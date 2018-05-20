public class BinaryNode {
    private int value;	//node의 value
    private BinaryNode parent;	//node의 Parent node
    private BinaryNode left;	//node의 Left Child
    private BinaryNode right;	//node의 Right Child

    /*
     * BinaryNode의 Constructor
     * 받은 값으로 value를 초기화하고
     * left, right, parent를 null로 초기화
     */
    BinaryNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    /*
     * value의 getter
     */
    public int getValue() {
        return value;
    }

    /*
     * parent의 setter
     */
    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }

    /*
     * left의 setter
     */
    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    /*
     * right의 setter
     */
    public void setRight(BinaryNode right) {
        this.right = right;
    }

    /*
     * parent의 getter
     */
    public BinaryNode getParent() {
        return this.parent;
    }

    /*
     * left의 getter
     */
    public BinaryNode getLeft() {
        return this.left;
    }

    /*
     * right의 getter
     */
    public BinaryNode getRight() {
        return this.right;
    }

    /*
     * parent의 여부를 반환하는 메소드
     */
    public boolean hasParent() {
        return this.parent != null;
    }

    /*
     * left의 여부를 반환하는 메소드
     */
    public boolean hasLeft() {
        return this.left != null;
    }

    /*
     * right의 여부를 반환하는 메소드
     */
    public boolean hasRight() {
        return this.right != null;
    }

}
