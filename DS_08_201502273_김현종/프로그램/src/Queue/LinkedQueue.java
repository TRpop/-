package Queue;

import tree.BinaryNode;

public class LinkedQueue {
    private Node head;

    /*
     * LinkedQueue�� Constructor
     * ���� ���� Node�� head�� �����Ѵ�.
     */
    public LinkedQueue() {
        this.head = new Node();
    }

    /*
     * �ش� Queue�� ������� Ȯ���ϴ� �޼ҵ�
     */
    public boolean isEmpty() {
        return head.getNext() == head;
    }

    /*
     * Queue�� ���ο� ���� �ִ� �޼ҵ�
     * �޾ƿ� ���� head�� addLast�� ȣ���Ͽ� �ѱ��.
     */
    public void add(BinaryNode binaryNode) {
        head.addLast(binaryNode);
    }

    /*
     * �ش� Queue���� ���� �ϳ� �����ϰ� ��ȯ�ϴ� �޼ҵ�
     * Queue�� ������� null�� ��ȯ�ϰ�
     * �׷��� ������ first�� ����� ���� ��ȯ�Ѵ�.
     */
    public BinaryNode remove() {
        if (isEmpty()) {
            return null;
        }
        return head.removeFirst().getValue();
    }


}
