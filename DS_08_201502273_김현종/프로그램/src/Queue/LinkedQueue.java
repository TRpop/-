package Queue;

import tree.BinaryNode;

public class LinkedQueue {
    private Node head;

    /*
     * LinkedQueue의 Constructor
     * 값이 없는 Node를 head로 지정한다.
     */
    public LinkedQueue() {
        this.head = new Node();
    }

    /*
     * 해당 Queue가 비었는지 확인하는 메소드
     */
    public boolean isEmpty() {
        return head.getNext() == head;
    }

    /*
     * Queue에 새로운 값을 넣는 메소드
     * 받아온 값을 head의 addLast를 호출하여 넘긴다.
     */
    public void add(BinaryNode binaryNode) {
        head.addLast(binaryNode);
    }

    /*
     * 해당 Queue에서 값을 하나 제거하고 반환하는 메소드
     * Queue가 비었으면 null을 반환하고
     * 그렇지 않으면 first를 없어며 값을 반환한다.
     */
    public BinaryNode remove() {
        if (isEmpty()) {
            return null;
        }
        return head.removeFirst().getValue();
    }


}
