public class MaxHeap implements Heap {
	private int[] heap; //
	private int size;
	// Don't add field!!!!!!!
	// Don't add field!!!!!!!
	// Don't add field!!!!!!!
	// Don't add field!!!!!!!

	/*
	 * MaxHeap�� Default Constructor
	 * heap�� �ش��ϴ� array�� ũ�� 10¥�� array�� �ʱ�ȭ
	 * size = 0
	 */
	public MaxHeap() {
		this.heap = new int[10];
		this.size = 0;
	}

	/*
	 * HeapSort���� ���Ǵ� private constructor
	 * heap�� �ش��� array�� �Է¹����� �ش� array�� size�� �Է¹޴´�.
	 */
	private MaxHeap(int[] array, int size) {
		int[] temp = new int[size + 1];	//�Էµ� array���� �ϳ� �� ū array�� �����.
		System.arraycopy(array, 0, temp, 1, size);	//���ο� ����� 0���ڸ��� ���� 1������ �Էµ� ��̸� �����سִ´�.
		this.heap = temp;
		this.size = size;
		this.buildHeap();	//heap ����
	}

	/*
	 * MaxHeap�� ��������� Ȯ���ϴ� �޼ҵ�
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/*
	 * MaxHeap�� �� á���� Ȯ���ϴ� �޼ҵ�
	 * heap array�� ���̺��� �ϳ� ���� ���� size�� ������
	 * �� �����̴�. (0���ڸ��� ����ֱ⶧��)
	 */
	@Override
	public boolean isFull() {
		return size == heap.length - 1;
	}

	/*
	 * ���ο� ���� Heap�� �ִ� �޼ҵ�
	 * Heap�� �� á���� resize�� ���ְ� �ٽ� add�� ȣ���Ѵ�.
	 * size�� �ϳ� �ø��� heap�� �� �ڿ� ���ο� ���� �־��� ��
	 * buildHeap�� ȣ���Ѵ�.
	 */
	@Override
	public void add(int element) {
		// TODO : Fill it !!
		if (this.isFull()) {
			resize();
			add(element);
		} else {
			this.size++;
			this.heap[this.size] = element;
			this.buildHeap();
		}
	}

	/*
	 * ���� Heap���� ���� ū ���� ��ȯ�ϴ� �޼ҵ�
	 * ������� 201502273�� ��ȯ�ϰ�
	 * ���� ������ heap array�� 1�� �ڸ��� �ִ� ���� ��ȯ�Ѵ�.
	 */
	@Override
	public int max() {
		// TODO : Fill it !!
		if (this.isEmpty()) {
			return 201502273;
		} else {
			return this.heap[1];
		}
	}

	/*
	 * ���� ū ���� �����ϴ� �޼ҵ�
	 * Heap�� ������� 201502273�� ��ȯ�ϸ�
	 * 1����ġ�� ���� ���� ������ ��
	 * ���� ������ ���� �ڿ� �ִ� ���� 1���ڸ��� ���� �ٲ� �� size�� 1 ���̰�
	 * buildHeap�� ȣ���Ѵ�.
	 * �׸��� �����ص״� 1���ڸ� ���� ��ȯ�Ѵ�.
	 */
	@Override
	public int removeMax() {
		// TODO : Fill it !!
		if (this.isEmpty()) {
			return 201502273;
		} else {
			int temp = this.heap[1];
			MaxHeap.swap(this.heap, 1, this.size);
			// this.heap[this.size] = Integer.MIN_VALUE;
			this.size--;
			this.buildHeap();
			return temp;
		}

	}

	/*
	 * size�� getter
	 */
	@Override
	public int size() {
		return size;
	}

	/*
	 * �ش� ���� �� ���� ��带 MaxHeap���� ����� ���� �޼ҵ�
	 * �ش� index�� ���� �� ����� child�� ���Ͽ� ���� ū ���� root�� �����ϰ�
	 * �ٲ� child�� root�� �Ͽ� ��������� �����Ѵ�.
	 */
	public void heapify(int index) {
		// TODO : Fill it !!
		if (!this.isEmpty()) {
			int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
			if (2 * index <= this.size) {
				left = this.heap[2 * index];
			}
			if (2 * index + 1 <= this.size) {
				right = this.heap[2 * index + 1];
			}
			if (left < right) {
				if (right > this.heap[index]) {
					MaxHeap.swap(this.heap, index, 2 * index + 1);
					this.heapify(2 * index + 1);
				}
			} else {
				if (left > this.heap[index]) {
					MaxHeap.swap(this.heap, index, 2 * index);
					this.heapify(2 * index);
				}
			}
		}
	}

	/*
	 * heapify�� child�� �ִ� ��� ��忡�� ������� ���� ū ���� root�� ������ �Լ��̴�.
	 */
	public void buildHeap() {
		// TODO : Fill it !!
		for (int i = this.size / 2; i > 0; i--) {
			this.heapify(i);
		}
	}

	/*
	 * target�� ���� ���� �����ִ� ����� ���� num���� �ٲٰ� �ٽ� MaxHeap�� �����ϵ��� ���ش�.
	 */
	public boolean increaseKey(int target, int num) {
		// TODO : Fill it !!
		for (int i = 1; i <= this.size; i++) {
			if (target == this.heap[i]) {
				this.heap[i] = num;
				this.buildHeap();
				return true;
			}
		}
		return false;

	}

	/*
	 * MaxHeap�� �̿��Ͽ� sorting�� ���ִ� static method
	 * sorting�� ���ϴ� array�� �Է����ְ� �ش� array�� MaxHeap�� �����
	 * Max���� �̾Ƴ��� sorting�� �����Ѵ�.
	 */
	public static int[] heapSort(int[] array, int size) {
		// TODO : Fill it !!
		MaxHeap sorting = new MaxHeap(array, size);
		int[] sorted = new int[size];
		int i = 0;
		while (!sorting.isEmpty()) {
			sorted[i++] = sorting.removeMax();
		}

		return sorted;
	}

	/*
	 * print�������� ����� �������ִ� �Լ�
	 * ���� heap array�� ����ִ� ������� ������ش�.
	 */
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

	/*
	 * array�� size�� Ű���ִ� �Լ�
	 * ������ 2��ũ���� array�� ����� ���� array�� �������ش�.
	 */
	private void resize() {
		int[] newHeap = new int[this.heap.length * 2];
		System.arraycopy(this.heap, 0, newHeap, 0, this.heap.length);
		this.heap = newHeap;
	}

	/*
	 * �� ��带 �ٲپ��ִ� �޼ҵ�
	 * �Էµ� array���� i�� j�� �ִ� ���� ���� �ٲپ��ش�.
	 */
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
