package heap;

import java.util.ArrayList;
import java.util.Collections;

public class HeapBasick {
    public ArrayList<Integer> heapArray = null;

    public HeapBasick(Integer data) {
        heapArray = new ArrayList<Integer>();

        heapArray.add(null); // 배열의 "0" 가 null 이니 조심
        heapArray.add(data);
    }

    // move_up 은 처음에 들어간 inserted_idx로 비교를한다
    public boolean insert(Integer data) {
        // inserted_idx 비교할 배열의 덱스값
        Integer inserted_idx, parent_idx; // 부모와 자식의 index을 알기위한 변수

        //만약에 headArray 가 null 되서어 없어지는 경우도 있다.
        // CASE_1 배열이 없다면
        if (this.heapArray == null) {
            this.heapArray = new ArrayList<Integer>();

            this.heapArray.add(null);
            this.heapArray.add(data);
            return true;
        }

        // CASE_2 배열이 있는 경우
        this.heapArray.add(data);
        inserted_idx = this.heapArray.size() - 1;

        // CASE_2_1
        // move_up 은 처음에 들어간 inserted_idx로 비교를한다
        while (this.move_up(inserted_idx)) {
            parent_idx = inserted_idx / 2;  // 계속순환에서 부모와 인서트를 스왑한다. 부모는 무조건 나누기 2
            Collections.swap(heapArray, inserted_idx, parent_idx);

            // 인서트와 부모의 자리를 순환으로 봐꾸기 위해서;
            inserted_idx = parent_idx;
        }

        return true;
    }

    public boolean move_up(Integer inserted_idx) {
        // 만약에 inserted_idx 가 1이면   parented_idx가 0이라는 뜻인데 그건 null이다.
        if (inserted_idx <= 1) { // inserted_idx == 1 이면 root 라는 뜻이다.
            return false;
        } else {
            Integer parent_idx = inserted_idx / 2;
            // 삽입 값이   > 부모값보다 크면?   =>  return true
            if (this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {
                return true;
            } else {
                return false;
            }
        }
    }

    // 현제 노드를 제거를 한후에
    // 현제 노드와 자식노드의 비교를 한후 높은것을 위로 올린다.

    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        // CASE_1: 왼쪽 자식 노드도 없을 때 (자식 노드가 하나도 없을 때)
        // 왼쪽 자식이 없다는 이야기는 완전 인진트리에 위배되는 말이다.
        if (left_child_popped_idx >= this.heapArray.size()) {
            return false;
        }
        // CASE_2: 오른쪽 자식 노드만 없을 때
        else if (right_child_popped_idx >= this.heapArray.size()) {
            if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                return true;
            } else {
                return false;
            }
        } else {
            // CASE_3: 왼쪽/오른쪽 자식 노드가 모두 있을 때;
            //  CASE_3_1 왼쪽 자식이 오른쪽보다 크다면?
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                // CASE_3_2 오른쪽 자식이 > 왼쪽보다 크다면?
                if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public Integer pop() {
        Integer returned_data, popped_idx, left_child_popped_idx,right_child_popped_idx ;

        if (this.heapArray == null) {
            return null;
        } else {
            returned_data = this.heapArray.get(1); // 최상단 값이 들어간다.
            Collections.swap(this.heapArray, 1 , this.heapArray.size() - 1);
            this.heapArray.remove(this.heapArray.size() - 1);
            popped_idx = 1;

            while (this.move_down(popped_idx)){
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx= popped_idx * 2 + 1;

                // CASE_2: 오른쪽 자식 노드만 없을때?
                if (right_child_popped_idx >= this.heapArray.size()){
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)){
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                    // CASE_3: 왼쪽/ 오른쪽 자식 노드가 모두 있을때?
                } else{
                    // CASE_3: 왼쪽/오른쪽 자식 노드가 모두 있을 때;
                    // 왼쪽 자식이 오른쪽보다 크다면?
                    if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                        // 왼쪽이 더크다면?
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                            Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                            popped_idx = left_child_popped_idx;
                        }
                    } else {
                        // 오른쪽 자식이 > 왼쪽보다 크다면?
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                            Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);
                            popped_idx = right_child_popped_idx;
                        }
                    }
                }
            }

            return returned_data;
        }
    }

    public static void main(String[] args) {
//        HeapBasick testArray = new HeapBasick(20);
//        test.insert(10);
//        test.insert(15);
//        test.insert(5);
//        test.insert(4);
//        test.insert(8);
//        System.out.println(test.heapArray);

        int insertData[] = {1, 2, 3, 4, 5};
        System.out.println("insertDataNumber : " + insertData.length);
//      [ 0 , 1, 2, 3, 4, 5  ]   6 개

        HeapBasick testArray = new HeapBasick(insertData[0]);
        System.out.println(testArray.heapArray + " 추가 : " + insertData[0]);

        for (int i = 1; i < insertData.length; i++) {
            testArray.insert(insertData[i]);
            System.out.println(testArray.heapArray + " 추가 : " + insertData[i]);
        }

        System.out.println( "최상단 값 : " + testArray.pop());
        System.out.println("최상단 값을 가져간후 : " + testArray.heapArray);
//
//        System.out.println("HeapArray Size : " + testArray.HeapArray.size());
    }
}
