public class Sort_201502273 {
    private int[] dataSet;	//�����Ͱ� �� ���
    private int[] bucket;	//�ӽ� ���� ���
    private int size;	//�������� ����(ũ��)

    void initDataSet(String dataSet) {	//dataSet�� ���������� �ʱ�ȭ�ϴ� �޼ҵ�
        String dataset[] = dataSet.split(" ");	//������ �������� String�� �߶� String Array�� �����.
        this.size = dataset.length;	//����� ���̰� size�̴�.
        this.dataSet = new int[this.size];	//size��ŭ�� ���̸� ���� int array ����
        this.bucket = new int[this.size];	//size��ŭ�� ���̸� ���� int array ����
        for (int i = 0; i < this.size; i++) {	//size��ŭ ��ȸ�ϸ�
            this.dataSet[i] = Integer.parseInt(dataset[i]);	//Sting�� int�� Parce�Ͽ� ����
        }
    }

    int getSize() {	//size�� getter
        return this.size;
    }

    void bubbleSort() {	//���������� �����ϴ� �޼ҵ�
	//TODO
    	for(int i = 0; i < this.size; i++) {	//size��ŭ �ݺ��ϸ�
    		for(int j = this.size - 1; j > i; j--) {	//���ĵ��� ���� �κи� ����
    			if(this.dataSet[j] < this.dataSet[j - 1]) {	//���簪�� �� ������ ũ��
    				this.swap(j, j - 1);	//���簪�� �������� ��ġ�� �ٲ۴�.
    			}
    		}
    	}
    }

    void insertionSort() {	//���������� �����ϴ� �޼ҵ�
	//TODO
    	for(int j = 1; j < this.size; j++) {//size - 1��ŭ �����ϸ�
    		int key = dataSet[j];	//������ ���� ����
    		
    		int i = j - 1;	//������ ���� ���� index
    		while(i >= 0 && dataSet[i] > key) {	//index�� 0Ȥ�� ����̰ų� �ش� ���ĵ� ��ġ�� ���� key������ ũ�� �ݺ�
    			dataSet[i + 1] = dataSet[i];	//key���� ��ġ�� ���� ����� Right Shift
    			i--;	//index = index - 1;
    		}
    		dataSet[i + 1] = key;	//ó������ ���ĵ� ���� ���� �� ū���� ������, Ȥ�� ū���� ������ 0�� ��ġ�� key�� ����
    	}
    }

    void mergeSort(int begin, int end) {	//merge sort�� �����ϴ� �޼ҵ�
	//TODO
    	if(end - begin < 2) return;	//���� Element�� 1���̸� �Լ� ����
    	
    	int middle = (begin + end)/2;	//��� �ε��� ����
    	
    	mergeSort(begin, middle);	//ó������ �߰������� ����� ȣ��
    	mergeSort(middle, end);		//�߰����� �������� ����� ȣ��
    	merge(begin, middle, end);	//�������� ������ ��ġ�� ����
    	copyArray(begin, end);	//�ӽ� ��̿��� ���� ��̷� ��� ����
    }

    private void merge(int begin, int middle, int end) {	//������ �ϸ� �պ��ϴ� �Լ�
	//TODO
    	int i = begin, j = middle;	//�պ��Ϸ��� �� ��� ������ index
    	for(int k = begin; k < end; k++) {	//begin���� end���� ��ȸ
    		/*
    		 * �� ����� �ִ� ���� ũ������� bucket�� ����
    		 * ���������� bucket�� �ִ´�.
    		 */
    		if(i < middle && (j >= end || dataSet[i] <= dataSet[j])) {
    			bucket[k] = dataSet[i];
    			i++;
    		} else {
    			bucket[k] = dataSet[j];
    			j++;
    		}
    	}
    }

    private void copyArray(int begin, int end) {	//��̸� �����ϴ� �޼ҵ�
    	System.arraycopy(bucket, begin, dataSet, begin, end - begin);	//��� ����
    }

    void quickSort(int p, int r) {	//quick sort�� �����ϴ� �޼ҵ�
	//TODO
    	if(p < r) {	//��Ƽ�� ù �ε���(�Ǻ�)���� ��Ƽ�� ������ �ε����� ũ��
    		int q = partition(p, r);	//r��ġ�� ���� ������ �� �ش� �ε����� �޾ƿ´�.
    		quickSort(p, q - 1);	//q���� �������� ���� ��Ƽ���� ��ͷ� ������.
    		quickSort(q + 1, r);	//q���� �������� ���� ��Ƽ���� ��ͷ� ������.
    	}
    }

    int partition(int p, int r) {
	//TODO
    	int x = dataSet[r];	//r�ε�����ġ�� ���� ����
    	int i = p - 1;
    	for(int j = p; j < r; j++) {	//p���� r ������ ����
    		if(dataSet[j] < x) {	//j��ġ�� ���� r��ġ�� ������ ������ 
    			i++;
    			this.swap(i, j);	//i��ġ�� ���� j��ġ�� ���� swap
    		}
    	}	//r�� ������ ���� ������ i + 1���� ������, ���ų� ū ������ ������ �ΰ� ���ش�.
    	this.swap(i + 1, r);	//r��ġ�� ������ ���� ������ ������ �ε��� ������ ���� r��ġ�� ���� �ٲ۴�.
    	return i + 1;	//r��ġ�� �ִ� ���� �ִ� �ε��� ��ȯ, ���� �Ϸ�� �ε��� ��ȯ
    }

    void swap(int index1, int index2) {	//�� �ε����� �ִ� ���� ���� �ٲٴ� �Լ�
        int temp = dataSet[index1];	//�ӽð��� ����
        dataSet[index1] = dataSet[index2];	//index1�� ���� index2�� ������ ���� �����
        dataSet[index2] = temp;	//�ӽð����� index2�� ���� ���� �����
    }
    
    void print() {
    	for(int i = 0; i < this.size; i++) {
    		System.out.print(dataSet[i] + " ");
    	}
    	System.out.println("");
    }
}

