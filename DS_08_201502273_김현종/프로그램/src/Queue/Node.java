package Queue;

import tree.BinaryNode;

public class Node {
    private Node next;
    private Node prev;
    private BinaryNode value;

    /*
     * Node의 Constructor
     */
    Node() {
        next = this;
        prev = this;
    }

    /*
     * Node의 Constructor
     * 입력받은 값을 this.value의 값으로 초기화
     */
    private Node(BinaryNode value) {
        this.value = value;
    }

    /*
     * Queue의 마지막에 값을 넣는 함수
     * 받은 값을 값으로 갖는 새 Node를 생성하여 
     * prev Node의 next로 설정한다.
     * 그리고 새 Node의 prev Node는 현재 Node의 prev Node로 하고
     * 새 Node의 next Node는 현재 Node로 한다.
     * 그리고 현재 Node의 prev Node는 새로운 Node로 한다.
     */
    public void addLast(BinaryNode value) {
        Node newNode = new Node(value);

        this.prev.next = newNode;
        newNode.prev = this.prev;
        newNode.next = this;
        this.prev = newNode;
    }

    /*
     * 첫번째 Node를 삭제하고 반환하는 메소드이다.
     * 현재 Node의 next Node를 삭제할 Node의 next Node로 바꾸고
     * next Node의 prev Node를 현재 Node로 설정하고 삭제한 Node를 반환한다.
     */
    public Node removeFirst() {
        Node node = this.next;
        this.next = node.next;
        this.next.prev = this;
        return node;
    }

    /*
     * next의 getter
     */
    public Node getNext() {
        return this.next;
    }

    /*
     * value의 getter
     */
    public BinaryNode getValue() {
        return this.value;
    }

}
