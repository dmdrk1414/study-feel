package algorithm.selectSort;

import algorithm.sort.bubbleSort.MakeBubbleSort;

import java.util.ArrayList;
import java.util.Collections;

public class MakeSelectSort {

    public ArrayList<Integer> makeSelectSort(ArrayList<Integer> dataList) {
        int lowNumber = 0;

        for (int stand = 0; stand < dataList.size() - 1; stand++) {
            lowNumber = stand;
            for (int index_2 = lowNumber + 1; index_2 < dataList.size(); index_2++) {
                if (dataList.get(lowNumber) > dataList.get(index_2)) {
                    lowNumber = index_2;
                }
            }
                Collections.swap(dataList, stand, lowNumber);
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testArray.add((int) (Math.random() * 100));
        }

        System.out.println(testArray.size());

        MakeSelectSort selectSort = new MakeSelectSort();
        System.out.println(selectSort.makeSelectSort(testArray));
    }
}
