public class Sort_201502273 {
    private int[] dataSet;	//데이터가 들어갈 어레이
    private int[] bucket;	//임시 저장 어레이
    private int size;	//데이터의 길이(크기)

    void initDataSet(String dataSet) {	//dataSet을 받은값으로 초기화하는 메소드
        String dataset[] = dataSet.split(" ");	//공백을 기준으로 String을 잘라 String Array를 만든다.
        this.size = dataset.length;	//어레이의 길이가 size이다.
        this.dataSet = new int[this.size];	//size만큼의 길이를 갖는 int array 생성
        this.bucket = new int[this.size];	//size만큼의 길이를 갖는 int array 생성
        for (int i = 0; i < this.size; i++) {	//size만큼 순회하며
            this.dataSet[i] = Integer.parseInt(dataset[i]);	//Sting을 int로 Parce하여 저장
        }
    }

    int getSize() {	//size의 getter
        return this.size;
    }

    void bubbleSort() {	//버블정렬을 수행하는 메소드
	//TODO
    	for(int i = 0; i < this.size; i++) {	//size만큼 반복하며
    		for(int j = this.size - 1; j > i; j--) {	//정렬되지 않은 부분만 실행
    			if(this.dataSet[j] < this.dataSet[j - 1]) {	//현재값이 측 값보다 크면
    				this.swap(j, j - 1);	//현재값과 좌측값의 위치를 바꾼다.
    			}
    		}
    	}
    }

    void insertionSort() {	//삽입정렬을 수행하는 메소드
	//TODO
    	for(int j = 1; j < this.size; j++) {//size - 1만큼 수행하며
    		int key = dataSet[j];	//움직일 값을 설정
    		
    		int i = j - 1;	//움직일 값의 좌측 index
    		while(i >= 0 && dataSet[i] > key) {	//index가 0혹은 양수이거나 해당 정렬된 위치의 값이 key값보다 크면 반복
    			dataSet[i + 1] = dataSet[i];	//key값의 위치를 덮어 씌우며 Right Shift
    			i--;	//index = index - 1;
    		}
    		dataSet[i + 1] = key;	//처음으로 정렬된 곳의 값이 더 큰곳의 우측에, 혹은 큰값이 없으면 0번 위치에 key값 저장
    	}
    }

    void mergeSort(int begin, int end) {	//merge sort를 수행하는 메소드
	//TODO
    	if(end - begin < 2) return;	//남은 Element가 1개이면 함수 종료
    	
    	int middle = (begin + end)/2;	//가운데 인덱스 추출
    	
    	mergeSort(begin, middle);	//처음부터 중간까지를 재귀적 호출
    	mergeSort(middle, end);		//중간부터 끝까지를 재귀적 호출
    	merge(begin, middle, end);	//나누어진 조각을 합치며 정렬
    	copyArray(begin, end);	//임시 어레이에서 원래 어레이로 어레이 복사
    }

    private void merge(int begin, int middle, int end) {	//정렬을 하며 합병하는 함수
	//TODO
    	int i = begin, j = middle;	//합병하려는 두 덩어리 내부의 index
    	for(int k = begin; k < end; k++) {	//begin부터 end까지 순회
    		/*
    		 * 두 덩어리에 있는 값을 크기순으로 bucket에 저장
    		 * 작은값부터 bucket에 넣는다.
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

    private void copyArray(int begin, int end) {	//어레이를 복사하는 메소드
    	System.arraycopy(bucket, begin, dataSet, begin, end - begin);	//어레이 복사
    }

    void quickSort(int p, int r) {	//quick sort를 수행하는 메소드
	//TODO
    	if(p < r) {	//파티션 첫 인덱스(피봇)보다 파티션 마지막 인덱스가 크면
    		int q = partition(p, r);	//r위치의 값을 정렬한 후 해당 인덱스를 받아온다.
    		quickSort(p, q - 1);	//q값을 기준으로 좌측 파티션을 재귀로 돌린다.
    		quickSort(q + 1, r);	//q값을 기준으로 우측 파티션을 재귀로 돌린다.
    	}
    }

    int partition(int p, int r) {
	//TODO
    	int x = dataSet[r];	//r인덱스위치의 값을 저장
    	int i = p - 1;
    	for(int j = p; j < r; j++) {	//p에서 r 전까지 돌며
    		if(dataSet[j] < x) {	//j위치의 값이 r위치의 값보다 작으면 
    			i++;
    			this.swap(i, j);	//i위치의 값과 j위치의 값을 swap
    		}
    	}	//r의 값보다 작은 값들은 i + 1기준 좌측에, 같거나 큰 값들은 우측에 두게 해준다.
    	this.swap(i + 1, r);	//r위치의 값보다 작은 값들의 마지막 인덱스 우측의 값과 r위치의 값을 바꾼다.
    	return i + 1;	//r위치에 있던 값이 있는 인덱스 반환, 정렬 완료된 인덱스 반환
    }

    void swap(int index1, int index2) {	//두 인덱스에 있는 값을 서로 바꾸는 함수
        int temp = dataSet[index1];	//임시값에 저장
        dataSet[index1] = dataSet[index2];	//index1의 값을 index2의 값으로 덮어 씌우기
        dataSet[index2] = temp;	//임시값으로 index2의 값을 덮어 씌우기
    }
    
    void print() {
    	for(int i = 0; i < this.size; i++) {
    		System.out.print(dataSet[i] + " ");
    	}
    	System.out.println("");
    }
}

