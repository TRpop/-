public class MainClass_11_201502273 {
    public static void main(String args[]){
        IO_Manager_201502273 io = new IO_Manager_201502273();
        Sort_201502273 sort = new Sort_201502273();
        long start, end;
        System.out.println("Start to Compare Each Sorting Methods Performance");
        //System.out.println("input : 5 1 2 8 9 7 4 6 3 10 15 50 30 22 34 52");
        System.out.println("================BubbleSort_O(n^2)================");
        sort.initDataSet(io.readData());
        //sort.initDataSet("5 1 2 8 9 7 4 6 3 10 15 50 30 22 34 52");
        start = System.currentTimeMillis();
        sort.bubbleSort();
        end = System.currentTimeMillis();
        System.out.println("Taken Time(ms) : " + (end-start));
        //sort.print();

        System.out.println("================InsertionSort_O(n^2)================");
        sort.initDataSet(io.readData());
        //sort.initDataSet("5 1 2 8 9 7 4 6 3 10 15 50 30 22 34 52");
        start = System.currentTimeMillis();
        sort.insertionSort();
        end = System.currentTimeMillis();
        System.out.println("Taken Time(ms) : " + (end-start));
        //sort.print();

        System.out.println("================MergeSort_O(nlog2(n))================");
        sort.initDataSet(io.readData());
        //sort.initDataSet("5 1 2 8 9 7 4 6 3 10 15 50 30 22 34 52");
        start = System.currentTimeMillis();
        sort.mergeSort(0,sort.getSize());
        end = System.currentTimeMillis();
        System.out.println("Taken Time(ms) : " + (end-start));
        //sort.print();

        System.out.println("================QuickSort_O(nlog2(n))================");
        sort.initDataSet(io.readData());
        //sort.initDataSet("5 1 2 8 9 7 4 6 3 10 15 50 30 22 34 52");
        start = System.currentTimeMillis();
        sort.quickSort(0, sort.getSize()-1);
        end = System.currentTimeMillis();
        System.out.println("Taken Time(ms) : " + (end-start));
        //sort.print();

    }

}
