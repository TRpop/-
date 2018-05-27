public class MaxHeap implements Heap {
    private int[] heap;
    private int size;
    // Don't add field!!!!!!!
    // Don't add field!!!!!!!
    // Don't add field!!!!!!!
    // Don't add field!!!!!!!

    public MaxHeap() {
        this.heap = new int[10];
        this.size = 0;
    }

    private MaxHeap(int[] array, int size) {
    	int[] temp = new int[size + 1];
    	System.arraycopy(array, 0, temp, 1, size);
        this.heap = temp;
        this.size = size;
        this.buildHeap();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == heap.length-1;
    }

    @Override
    public void add(int element) {
        // TODO : Fill it !!
    	if(this.isFull()){
    		resize();
    		add(element);
    	}else{
    		this.size++;
        	this.heap[this.size] = element;
        	this.buildHeap();
    	}
    }

    @Override
    public int max() {
        // TODO : Fill it !!
    	if(this.isEmpty()){
    		return 201502273;
    	}else{
    		return this.heap[1];
    	}
    }

    @Override
    public int removeMax() {
        // TODO : Fill it !!
    	if(this.isEmpty()){
    		return 201502273;
    	}else{
    		int temp = this.heap[1];
    		MaxHeap.swap(this.heap, 1, this.size);
    		//this.heap[this.size] = Integer.MIN_VALUE;
    		this.size--;
    		this.buildHeap();
    		return temp;
    	}
        
    }

    @Override
    public int size() {
        return size;
    }

     public void heapify(int index) {
         // TODO : Fill it !!
    	 if(!this.isEmpty()){
    		 int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
    		 if(2*index <= this.size){
    			 left = this.heap[2*index];
    		 }
    		 if(2*index + 1 <= this.size){
    			 right = this.heap[2*index + 1];
    		 }
    		 if(left < right){
    			 if(right > this.heap[index]){
    				 MaxHeap.swap(this.heap, index, 2*index + 1);
    				 this.heapify(2*index + 1);
    			 }
    		 }else{
    			 if(left > this.heap[index]){
    				 MaxHeap.swap(this.heap, index, 2*index);
    				 this.heapify(2*index);
    			 }
    		 }
    	 }
    }

    public void buildHeap() {
        // TODO : Fill it !!
    	for(int i = this.size / 2; i > 0; i--){
    		this.heapify(i);
    	}
    }

    public boolean increaseKey(int target, int num) {
        // TODO : Fill it !!
    	for(int i = 1; i <= this.size; i++){
    		if(target == this.heap[i]){
    			this.heap[i] = num;
    			this.buildHeap();
    			return true;
    		}
    	}
        return false;

    }

    public static int[] heapSort(int[] array, int size) {
        // TODO : Fill it !!
    	MaxHeap sorting = new MaxHeap(array, size);
    	int[] sorted = new int[size];
    	int i = 0;
    	while(!sorting.isEmpty()){
    		sorted[i++] = sorting.removeMax();
    	}
    	
        return sorted;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");
        for (int i = 1; i <= size; ++i) {
            stringBuilder.append(heap[i]).append(" ");
        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    private void resize() {
        int[] newHeap = new int[this.heap.length*2];
        System.arraycopy(this.heap, 0, newHeap, 0, this.heap.length);
        this.heap = newHeap;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
