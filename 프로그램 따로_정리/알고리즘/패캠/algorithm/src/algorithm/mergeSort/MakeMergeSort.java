package algorithm.mergeSort;

import java.util.ArrayList;

public class MakeMergeSort {

    public ArrayList<Integer> makeMerge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergeList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE_1 오른쪽 왼쪽 다있을때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergeList.add(rightList.get(rightPoint));
                rightPoint += 1;
            } else {
                mergeList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }
        // CASE_2 왼쪽만
        while (leftList.size() > leftPoint) {
            mergeList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }

        // CASE_3 오른쪽만

        while (rightList.size() > rightPoint) {
            mergeList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }

        return mergeList;
    }

    public ArrayList<Integer> makeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1){
            return dataList;
        }
        int middle = dataList.size() / 2;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        System.out.println("right : " + right);
        left = this.makeSplitFunc(new ArrayList<Integer>(dataList.subList(0, middle)));
        right = this.makeSplitFunc(new ArrayList<Integer>(dataList.subList(middle, dataList.size())));

        return this.makeMerge(left, right);
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add((int) (Math.random() * 100));
        }

        MakeMergeSort mergeSort = new MakeMergeSort();
        System.out.println(mergeSort.makeSplitFunc(dataList));
    }
}
