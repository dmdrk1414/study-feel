package heap;

import java.util.ArrayList;
import java.util.Collections;

public class HeapBasick {
    public ArrayList<Integer> heapArray = null;

    public HeapBasick(Integer data) {
        heapArray = new ArrayList<Integer>();

        heapArray.add(null);
        heapArray.add(data);
    }

    // move_up 은 처음에 들어간 inserted_idx로 비교를한다
    public boolean move_up(Integer inserted_idx) {
        if (inserted_idx <= 1) { // inserted_idx == 1 이면 root 라는 뜻이다.
            return false;
        } else {
            Integer parent_idx = inserted_idx / 2;
            if (this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean insert(Integer data) {
        // inserted_idx 비교할 배열의 덱스값
        Integer inserted_idx, parent_idx; // 부모와 자식의 index을 알기위한 변수

        //만약에 headArray 가 제어가 되서어 없어지는 경우도 있다.
        if (this.heapArray == null) {
            this.heapArray = new ArrayList<Integer>();

            this.heapArray.add(null);
            this.heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);
        inserted_idx = this.heapArray.size() - 1;

        // move_up 은 처음에 들어간 inserted_idx로 비교를한다
        while (this.move_up(inserted_idx)) {
            parent_idx = inserted_idx / 2;  // 계속순환에서 부모와 인서트를 스왑한다. 부모는 무조건 나누기 2
            Collections.swap(heapArray, inserted_idx, parent_idx);

            // 인서트와 부모의 자리를 순환으로 봐꾸기 위해서;
            inserted_idx = parent_idx;
        }

        return true;
    }

//    public boolean delete() {
//        if (this.heapArray == null) {
//            return false;
//        } else {
//            Integer inserted_idx = this.heapArray.size() - 1;
//            System.out.println("insert_id : " + inserted_idx);
//            Collections.swap(this.heapArray, 1, inserted_idx);
//            this.heapArray.remove((int) inserted_idx);
//
//            while (true) {
//                Integer parentes_idx = inserted_idx / 2;
//
//
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        HeapBasick test = new HeapBasick(20);
        test.insert(10);
        test.insert(15);
        test.insert(5);
        test.insert(4);
        test.insert(8);
        System.out.println(test.heapArray);
//        System.out.println(test.delete());
//        System.out.println(test.heapArray);

//        HeapBasick test = new HeapBasick(1);
//        test.insert(2);
//        test.insert(3);
//        test.insert(4);
//        test.insert(5);
//
//        for (int i = 0; i < 8; i++) {
//            System.out.println(test.heapArray.get(i));
//        }

//        ArrayList<Integer> testSwap = new  ArrayList<Integer>();
//        testSwap.add(1);
//        testSwap.add(2);
//        testSwap.add(3);
//        testSwap.add(4);
//        testSwap.add(5);
//        System.out.println(testSwap);
//
//        Collections.swap(testSwap, 1,2);
//        System.out.println(testSwap);


    }
}
