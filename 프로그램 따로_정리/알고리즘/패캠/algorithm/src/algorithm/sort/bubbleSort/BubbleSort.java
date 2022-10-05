package algorithm.sort.bubbleSort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for (int index = 0; index < dataList.size() - 1; index++) {
            // swap 이되면 true로 봐뀐다;
            boolean swap = false;

            for (int index_2 = 0; index_2 < dataList.size() - 1; index_2++) {
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
       ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testData.add((int)(Math.random() * 100));
        }

        BubbleSort bSort = new BubbleSort();
        System.out.println( bSort.sort(testData));

    }
}
