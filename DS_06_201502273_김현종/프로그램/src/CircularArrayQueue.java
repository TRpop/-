public class CircularArrayQueue {
	private static final int DEFAULT_MAX_SIZE = 10;//�⺻ �ִ� ũ��
    private int maxSize;//Queue�� �ִ� ũ��
    private int front;//Queue�� front
    private int rear;//Queue�� rear
    private String[] elements;

    /*
     * CircularArrayQueue�� �⺻ Constructor
     * this(maxSize)�� ȣ���Ѵ�.
     */
    CircularArrayQueue() {
    	this(CircularArrayQueue.DEFAULT_MAX_SIZE);
    }

    /*
     * CircularArrayQueue�� Constructor
     * ���� ������ Queue�� �ִ� ũ�⸦ �����ϰ� front, rear�� 0���� �ʱ�ȭ �ϰ�
     * maxSize�� ũ��� String Array�� ��ü�� �����.
     */
    public CircularArrayQueue(int maxSize) {
    	this.maxSize = maxSize;
    	this.front = 0;
    	this.rear = 0;
    	this.elements = new String[this.maxSize];
	}

    /*
     * Queue�� �ִ� �Լ�
     * Queue�� �� �� �ִ��� Ȯ���ϰ�
     * �� �������� return false
     * �׷��� ������ rear�� ����Ű�� �κп� ���� ���� �־��ְ� rear�� 1 �ø���
     * maxSize�� Mod���� ���ش�.
     */
	public boolean enQueue(String string) {
		if(isFull()){
			System.out.println("ERROR : ť�� �� ���� ������ �Ұ����մϴ�.");
			return false;
		}else{
			this.elements[this.rear] = string;
			this.rear = (this.rear+1)%this.maxSize;
			return true;
		}
		
    }

	/*
     * Queue���� ���� �Լ�
     * Queue�� ������� Ȯ���ϰ�
     * �� ��������� return false
     * �׷��� ������ front�� ����Ű�� �κ��� ���� ��ȯ�� ������ �����ϰ�
     * front�� ����Ű�� �κ��� null�� �ʱ�ȭ���ش�.
     * �׸��� front�� 1 �ø��� maxSize�� Mod���� �� �ص�
     * �����ߴ� ���� ��ȯ���ش�.
     */
    public String deQueue() {
    	if(isEmpty()){
    		System.out.println("ERROR : ť�� ���Ұ� �����ϴ�.");
    		return "";
    	}else{
    		String temp = this.elements[this.front];
    		this.elements[this.front] = null;
    		this.front = (this.front+1)%this.maxSize;
    		return temp;
    	}
    }

    /*
     * ���� Integer���� ũ�⸸ŭ�� ������ deQueue�� �ִ� �Լ�
     * for������ �Է¹��� ��ŭ �ݺ��ϸ� deQueue���ش�.
     */
    public void removes(int i) {
    	String temp;
    	for(int j = 0; j < i; j++){
    		temp = this.deQueue();
    		if(temp != "")
    			System.out.println("[DeQueue] The Deleted Element is '" + temp + "'.");
    		else break;
    	}
    }

    /*
     * ���� Queue�� ����� ����ϴ� �Լ�
     * Queue�� �ִ� ���� ��� �����ϱ� ���� StringBuilder�� �����ϰ�
     * for������ size��ŭ �ݺ��ϸ� front���� i��ŭ�� offset�� �ִ� ���� ���� append���ش�.
     * �ݺ����� ������ ������� String�� ��ȯ���ش�.
     */
    public String printQueue() {
    	StringBuilder temp = new StringBuilder();
    	temp.append("[ ");
    	for(int i = 0; i < this.size(); i++){
    		temp.append(this.elements[(this.front + i)%this.maxSize] + " ");
    	}
    	temp.append("]");
    	
    	return temp.toString();
    }

    /*
     * Queue�� front�� �ִ� ���� ��ȯ���ִ� �Լ�
     */
    public String front() {
    	return this.elements[this.front];
    }

    /*
     * Queue�� ���� size�� ��ȯ�ϴ� �Լ�
     * rear�� front���� ũ�ų� ������ rear-front�� ��ȯ�ϰ�
     * �� �ݴ��̸� maxSize + rear - front�� ��ȯ�Ѵ�.
     */
    public int size() {
    	if(this.front <= this.rear){
    		return this.rear - this.front;
    	}else{
    		return this.maxSize + this.rear - this.front;
    	}
    }

    /*
     * ���� Queue�� ������� �Ⱥ������ ��ȯ�ϴ� �Լ�
     * ������� true�� ��ȯ�Ѵ�.
     */
    public boolean isEmpty() {
    	return this.rear == this.front;
    }

    /*
     * ���� Queue�� �� á���� �� ���� �ʾҴ��� ��ȯ�ϴ� �Լ�
     * �� á���� true�� ��ȯ�Ѵ�.
     */
    public boolean isFull() {
    	return (this.rear + 1)%this.maxSize == this.front;
    }

}