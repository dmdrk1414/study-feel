package algorithm.selectSort;

import algorithm.solveBackjane.Main;

import java.util.ArrayList;
import java.util.Collections;

public class SelectSort {
    public ArrayList<Integer> insertSort (ArrayList<Integer> dataList){
        int lowst; // lowst 변수는 기준이 되는 변수이다.
        for (int stand = 0; stand < dataList.size() - 1; stand++) {
            // 처음 for문의 인수가 들어간다
            // dataList.size는 - 1 을 안해주면  두번째 for 문에서 바운더리 오류가 나온다.
            lowst = stand;
            for (int index = stand + 1; index < dataList.size(); index++) {

                // 만약에 lowst 보다 작은게 있으면?
                // 그당시의 index는 lowst에 들어 간다.
                if (dataList.get(lowst) > dataList.get(index)){
                    lowst = index;
                }
            }
            Collections.swap(dataList, lowst, stand);
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            array.add((int) (Math.random() * 100));
        }
        SelectSort test = new SelectSort();
        System.out.println(test.insertSort(array));

    }
}
