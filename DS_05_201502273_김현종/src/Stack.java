public class Stack {
    private String[] stack;
    private int size;
    private int maxSize;
    private final static int DEFAULT_MAX_SIZE = 5;
    
    Stack() {
        //TODO
    	this(Stack.DEFAULT_MAX_SIZE);	//Stack(int) ȣ��
    }
    
    /*
     * Stack(int )������
     * ���� ������ ������ �ִ��� �����ϰ�
     * �������� ����� String Array�� �����Ѵ�.
     * ���� size�� -1�� �ʱ�ȭ�Ѵ�.
     */
    Stack(int maxSize){
    	this.maxSize = maxSize;
    	this.stack = new String[this.maxSize];
    	size = -1;
    }

    /*
     * ���ÿ� ���� Push�ϴ� �޼ҵ�
     * ���� Stack�� �� ���ִ��� Ȯ���� �� �� á���� ����� �ø��� �ڽ��� �ٽ� ȣ���Ѵ�.
     * �� ���� �ʾ����� ���� Stack�� size�� 1 �ø��� ���� string���� peek�� �ִ´�.
     * �׸��� true�� ��ȯ�Ѵ�.
     */
    public boolean push(String string) {
        //TODO
    	if(!isFull()){
    		this.size++;
        	this.stack[this.size] = string;
        	return true;
    	}else{
    		this.resize();
    		return this.push(string);
    	}
    }

    /*
     * Stack�� pop�޼ҵ�
     * ��ȯ�� ���� ���� Stack�� peek���� ������ �� Stack�� ���� size�� 1 ���δ�.
     * �׸��� ������ ���� ��ȯ�Ѵ�.
     */
    public String pop() {
        //TODO
    	String ret = this.stack[this.size];
    	this.size--;
    	return ret;
    }

    /*
     * Stack�� peek���� ��ȯ�ϴ� �Լ�
     * ���� Stack�� �� ���� �ִ� ���� ��ȯ�Ѵ�.
     */
    public String peek() {
        //TODO
    	if(!isEmpty())	return this.stack[this.size];
    	else return "";
    }

    /*
     * ���� Stack�� size���� -1�̸� true�� ��ȯ�Ѵ�.
     */
    public boolean isEmpty() {
        //TODO
    	return this.size == -1;
    }

    /*
     * ���� Stack�� size + 1�� Stack�� maxSize�� ������  true�� ��ȯ�Ѵ�.
     */
    public boolean isFull() {
        //TODO
    	return this.size+1 == this.maxSize;
    }

    /*
     * Stack�� ũ�⸦ �������ϴ� �Լ�
     * ���� maxSize�� �� ���� ũ�⸦ ���� ��̸� �����
     * ���� stack�̶�� ����� ���� ������ �� ���簪�� ������ ���θ��簪�� ���Ѵ�.
     * maxSize�� �ι�� �Ѵ�.
     */
    private void resize() {
        String[] newStack = new String[maxSize * 2];
        System.arraycopy(stack, 0, newStack, 0, maxSize); // �޸𸮸� �����մϴ�.
        stack = newStack;
        maxSize *= 2;
    }
}
