package algorithm.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {

    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        for (int stand = 0; stand < array.size() - 1; stand++) {
            Integer temp = stand;
            for (int index = stand + 1; index < array.size(); index++) {
                if (array.get(temp) > array.get(index)) {
                    temp = index;
                }
                Collections.swap(array, stand, temp);
            }
        }
        return array;
    }

    public Integer search(ArrayList<Integer> array, Integer isData) {
        Integer middle = array.size() / 2;
        System.out.println(middle);

        if (isData < array.get(middle)) {
            middle = middle / 2;
        }

        return 0;
    }

    public static void main(String[] args) {
//        BinarySearch test = new BinarySearch();
//        ArrayList<Integer> array = new ArrayList<>();
//        int size = 100;
//        for (int i = 0; i < size; i++) {
//            array.add((int) (Math.random() * 100));
//        }

        ArrayList<Integer> array = new ArrayList<>();
        int size = 100;
        for (int i = 0 ; i < size ; i++){
            array.add((int)(Math.random() * 100));
        }

        System.out.println(array);

        BinarySearch testSort = new BinarySearch();
        System.out.println( testSort.sort(array));

    }
}
