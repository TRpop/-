public class CircularArrayQueue {
	private static final int DEFAULT_MAX_SIZE = 10;//기본 최대 크기
    private int maxSize;//Queue의 최대 크기
    private int front;//Queue의 front
    private int rear;//Queue의 rear
    private String[] elements;

    /*
     * CircularArrayQueue의 기본 Constructor
     * this(maxSize)를 호출한다.
     */
    CircularArrayQueue() {
    	this(CircularArrayQueue.DEFAULT_MAX_SIZE);
    }

    /*
     * CircularArrayQueue의 Constructor
     * 받은 값으로 Queue의 최대 크기를 지정하고 front, rear를 0으로 초기화 하고
     * maxSize의 크기로 String Array의 객체를 만든다.
     */
    public CircularArrayQueue(int maxSize) {
    	this.maxSize = maxSize;
    	this.front = 0;
    	this.rear = 0;
    	this.elements = new String[this.maxSize];
	}

    /*
     * Queue에 넣는 함수
     * Queue가 꽉 차 있는지 확인하고
     * 꽉 차있으면 return false
     * 그렇지 않으면 rear가 가리키는 부분에 받은 값을 넣어주고 rear를 1 올린뒤
     * maxSize로 Mod연산 해준다.
     */
	public boolean enQueue(String string) {
		if(isFull()){
			System.out.println("ERROR : 큐가 꽉 차서 삽입이 불가능합니다.");
			return false;
		}else{
			this.elements[this.rear] = string;
			this.rear = (this.rear+1)%this.maxSize;
			return true;
		}
		
    }

	/*
     * Queue에서 빼는 함수
     * Queue가 비었는지 확인하고
     * 꽉 비어있으면 return false
     * 그렇지 않으면 front가 가리키는 부분의 값을 반환할 변수에 저장하고
     * front가 가리키는 부분을 null로 초기화해준다.
     * 그리고 front를 1 올리고 maxSize로 Mod연산 해 준뒤
     * 삭제했던 값을 반환해준다.
     */
    public String deQueue() {
    	if(isEmpty()){
    		System.out.println("ERROR : 큐에 원소가 없습니다.");
    		return "";
    	}else{
    		String temp = this.elements[this.front];
    		this.elements[this.front] = null;
    		this.front = (this.front+1)%this.maxSize;
    		return temp;
    	}
    }

    /*
     * 받은 Integer값의 크기만큼의 개수를 deQueue해 주는 함수
     * for문으로 입력받은 만큼 반복하며 deQueue해준다.
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
     * 현재 Queue의 모습을 출력하는 함수
     * Queue에 있는 값을 모두 저장하기 위한 StringBuilder를 선언하고
     * for문으로 size만큼 반복하며 front에서 i만큼의 offset이 있는 곳의 값을 append해준다.
     * 반복문이 끝나면 만들어진 String을 반환해준다.
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
     * Queue의 front에 있는 값을 반환해주는 함수
     */
    public String front() {
    	return this.elements[this.front];
    }

    /*
     * Queue의 현재 size를 반환하는 함수
     * rear가 front보다 크거나 같으면 rear-front를 반환하고
     * 그 반대이면 maxSize + rear - front를 반환한다.
     */
    public int size() {
    	if(this.front <= this.rear){
    		return this.rear - this.front;
    	}else{
    		return this.maxSize + this.rear - this.front;
    	}
    }

    /*
     * 현재 Queue가 비었는지 안비었는지 반환하는 함수
     * 비었으면 true를 반환한다.
     */
    public boolean isEmpty() {
    	return this.rear == this.front;
    }

    /*
     * 현재 Queue가 꽉 찼는지 꽉 차지 않았는지 반환하는 함수
     * 꽉 찼으면 true를 반환한다.
     */
    public boolean isFull() {
    	return (this.rear + 1)%this.maxSize == this.front;
    }

}