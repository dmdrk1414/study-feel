package algorithm.sort.bubbleSort;


import java.util.ArrayList;
import java.util.Collections;

public class MakeBubbleSort {
public ArrayList<Integer> makeSort (ArrayList<Integer> dataList){

    for (int index_1 = 0; index_1 < dataList.size() -1; index_1++) {
        boolean swap = false;

        for (int index_2 = 0; index_2 < dataList.size() -1; index_2++) {
            if (dataList.get(index_2) > dataList.get(index_2 + 1)){
                Collections.swap(dataList, index_2, index_2 + 1);
                swap = true;
            }
        }
        if (swap == false){
            break;
        }

    }
    return dataList;
}

    public static void main(String[] args) {
       ArrayList<Integer> testArray = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testArray.add((int) (Math.random() * 100));
        }

        MakeBubbleSort Bsort = new MakeBubbleSort();

        System.out.println(Bsort.makeSort(testArray));
    }
}
