package heap;

import java.util.ArrayList;
import java.util.Collections;

public class MakeHeapBasick {
    ArrayList<Integer> HeapArray;

    public MakeHeapBasick(Integer data) {
        HeapArray = new ArrayList<Integer>();

        this.HeapArray.add(null);
        this.HeapArray.add(data);
    }

    public boolean insertdata(Integer data) {
        if (this.HeapArray == null) {
            this.HeapArray = new ArrayList<Integer>();

            this.HeapArray.add(null);
            this.HeapArray.add(data);
        }

        // 있다면?
        this.HeapArray.add(data);

        int inserted_id = this.HeapArray.size() - 1;

        while (this.makeUp(inserted_id)) { // 5    2     2        1
            int parent_id = inserted_id / 2;

            Collections.swap(this.HeapArray, inserted_id, parent_id);
            inserted_id = parent_id;
        }
        return false;
    }

    public boolean makeUp(Integer insert) {
        int inserted_id = insert;
        int parent_id = inserted_id / 2;

        if (insert <= 1) {
            return false;
        } else {
            if (this.HeapArray.get(inserted_id) > this.HeapArray.get(parent_id)) {
                return true;
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        int insertData[] = {1, 2, 3, 4, 5};
        System.out.println("insertDataNumber : " + insertData.length);
//      [ 0 , 1, 2, 3, 4, 5  ]   6 개

        MakeHeapBasick testArray = new MakeHeapBasick(insertData[0]);
        System.out.println(testArray.HeapArray + " 추가 : " + insertData[0]);

        for (int i = 1; i < insertData.length; i++) {
            testArray.insertdata(insertData[i]);
            System.out.println(testArray.HeapArray + " 추가 : " + insertData[i]);
        }

        System.out.println("HeapArray Size : " + testArray.HeapArray.size());
    }
}
