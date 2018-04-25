public class Stack {
    private String[] stack;
    private int size;
    private int maxSize;
    private final static int DEFAULT_MAX_SIZE = 5;
    
    Stack() {
        //TODO
    	this(Stack.DEFAULT_MAX_SIZE);	//Stack(int) 호출
    }
    
    /*
     * Stack(int )생성자
     * 받은 값으로 스택의 최댓값을 지정하고
     * 스택으로 사용할 String Array를 선언한다.
     * 현재 size는 -1로 초기화한다.
     */
    Stack(int maxSize){
    	this.maxSize = maxSize;
    	this.stack = new String[this.maxSize];
    	size = -1;
    }

    /*
     * 스택에 값을 Push하는 메소드
     * 현재 Stack이 꽉 차있는지 확인한 뒤 꽉 찼으면 사이즈를 늘리고 자신을 다시 호출한다.
     * 꽉 차지 않았으면 현재 Stack의 size를 1 올리고 받은 string값을 peek에 넣는다.
     * 그리고 true를 반환한다.
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
     * Stack의 pop메소드
     * 반환할 값을 현재 Stack의 peek에서 가져온 후 Stack의 현재 size를 1 줄인다.
     * 그리고 삭제한 값을 반환한다.
     */
    public String pop() {
        //TODO
    	String ret = this.stack[this.size];
    	this.size--;
    	return ret;
    }

    /*
     * Stack의 peek값을 반환하는 함수
     * 현재 Stack의 맨 위에 있는 값을 반환한다.
     */
    public String peek() {
        //TODO
    	if(!isEmpty())	return this.stack[this.size];
    	else return "";
    }

    /*
     * 현재 Stack의 size값이 -1이면 true를 반환한다.
     */
    public boolean isEmpty() {
        //TODO
    	return this.size == -1;
    }

    /*
     * 현재 Stack의 size + 1이 Stack의 maxSize와 같으면  true를 반환한다.
     */
    public boolean isFull() {
        //TODO
    	return this.size+1 == this.maxSize;
    }

    /*
     * Stack의 크기를 재조정하는 함수
     * 현재 maxSize의 두 배의 크기를 갖는 어레이를 만들고
     * 현재 stack이라는 어레이의 값을 복사한 뒤 현재값은 버리고 새로만든값을 취한다.
     * maxSize는 두배로 한다.
     */
    private void resize() {
        String[] newStack = new String[maxSize * 2];
        System.arraycopy(stack, 0, newStack, 0, maxSize); // 메모리를 복사합니다.
        stack = newStack;
        maxSize *= 2;
    }
}
