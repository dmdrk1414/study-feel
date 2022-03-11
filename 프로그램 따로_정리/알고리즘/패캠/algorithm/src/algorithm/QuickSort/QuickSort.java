package algorithm.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public ArrayList<Integer> sort (ArrayList<Integer> dataList){
        if (dataList.size() <= 1){
            return dataList;
        }
        // left   pivot   right
        int pivot = dataList.get(0);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int index = 1; index < dataList.size(); index++) {
            // pivot  보다 작으면 left
            if (dataList.get(index) < pivot){   // 0  0
                left.add(dataList.get(index));
            } else {
                right.add(dataList.get(index));
            }
        }


        ArrayList<Integer> mergeList = new ArrayList<>();
        mergeList.addAll(sort( left ));
        mergeList.addAll(Arrays.asList(pivot));
            mergeList.addAll(sort(right));


        return mergeList;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 100));
        }

        QuickSort quickSort = new QuickSort();
        System.out.println( quickSort.sort(list) );
    }
}
