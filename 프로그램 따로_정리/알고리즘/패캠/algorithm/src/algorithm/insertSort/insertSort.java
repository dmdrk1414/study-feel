package algorithm.insertSort;

import algorithm.selectSort.MakeSelectSort;

import java.util.ArrayList;
import java.util.Collections;

public class insertSort {
    public ArrayList<Integer> insert(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index++) {
            for (int index_2 = index + 1; index_2 > 0; index_2--) {
                if (dataList.get(index_2) < dataList.get(index_2 - 1)) {
                    Collections.swap(dataList, index_2, index_2 - 1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            array.add((int) (Math.random() * 100));
        }
        insertSort test = new insertSort();
        System.out.println(test.insert(array));
    }
}
