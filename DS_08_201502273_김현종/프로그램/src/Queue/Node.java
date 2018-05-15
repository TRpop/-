package Queue;

import tree.BinaryNode;

public class Node {
    private Node next;
    private Node prev;
    private BinaryNode value;

    /*
     * Node�� Constructor
     */
    Node() {
        next = this;
        prev = this;
    }

    /*
     * Node�� Constructor
     * �Է¹��� ���� this.value�� ������ �ʱ�ȭ
     */
    private Node(BinaryNode value) {
        this.value = value;
    }

    /*
     * Queue�� �������� ���� �ִ� �Լ�
     * ���� ���� ������ ���� �� Node�� �����Ͽ� 
     * prev Node�� next�� �����Ѵ�.
     * �׸��� �� Node�� prev Node�� ���� Node�� prev Node�� �ϰ�
     * �� Node�� next Node�� ���� Node�� �Ѵ�.
     * �׸��� ���� Node�� prev Node�� ���ο� Node�� �Ѵ�.
     */
    public void addLast(BinaryNode value) {
        Node newNode = new Node(value);

        this.prev.next = newNode;
        newNode.prev = this.prev;
        newNode.next = this;
        this.prev = newNode;
    }

    /*
     * ù��° Node�� �����ϰ� ��ȯ�ϴ� �޼ҵ��̴�.
     * ���� Node�� next Node�� ������ Node�� next Node�� �ٲٰ�
     * next Node�� prev Node�� ���� Node�� �����ϰ� ������ Node�� ��ȯ�Ѵ�.
     */
    public Node removeFirst() {
        Node node = this.next;
        this.next = node.next;
        this.next.prev = this;
        return node;
    }

    /*
     * next�� getter
     */
    public Node getNext() {
        return this.next;
    }

    /*
     * value�� getter
     */
    public BinaryNode getValue() {
        return this.value;
    }

}
