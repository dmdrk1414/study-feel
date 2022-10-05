package algorithm.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class MakeQuickSort {
    public ArrayList<Integer> quickSort (ArrayList<Integer> dataList){
        if (dataList.size() <= 1){
            return dataList;
        }
        int pivot = dataList.get(0);

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for (int index = 1; index < dataList.size(); index++) {
            if (dataList.get(index) > pivot){
                rightArr.add(dataList.get(index));
            } else {
                leftArr.add(dataList.get(index));
            }
        }
        ArrayList<Integer> mergedArr = new ArrayList<>();
        mergedArr.addAll(this.quickSort(leftArr));
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(this.quickSort(rightArr));

        return mergedArr;
    }

    public static void main(String[] args) {
       ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add((int)(Math.random() * 100));
        }

        Integer[] array = { 4,1,2,5,6};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));

        MakeQuickSort test = new MakeQuickSort();
        System.out.println(test.quickSort(list)  );
    }
}
