package heap;

import java.util.ArrayList;
import java.util.Collections;

public class MakeHeapBasick {
    public ArrayList<Integer> heapArray = null;

    public MakeHeapBasick(Integer data) {
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
    public Integer pop() {
        Integer returnde = this.heapArray.get(1);
        Collections.swap(this.heapArray, 1, this.heapArray.size() - 1);
        this.heapArray.remove(this.heapArray.size() - 1);
        Integer pop_id = 1;

        while (move_down(pop_id)) {
            Integer left_id = pop_id * 2;
            Integer right_id = pop_id * 2 + 1;
            // CASE_1 왼쪽 노드가 없다
            if (left_id >= this.heapArray.size()) {
                System.out.printf("case_1");
                return null;
            }
            // CASE_2 오른쪽 노드 자식 노드만 없을때
            else if (right_id >= this.heapArray.size()) {
                System.out.printf("case_2");
                if (this.heapArray.get(left_id) < this.heapArray.get(pop_id)) {
                    Collections.swap(this.heapArray, pop_id, left_id);
                    pop_id = left_id;
                }
            }
            // CASE_3 왼쪽/오른쪽 다있다.
            else {
                System.out.printf("case_3");
                // CASE_3_1 left >>> right
                if (this.heapArray.get(left_id) > this.heapArray.get(right_id)) {
                    // pop_id >>>>> left_id  => true
                    if (this.heapArray.get(pop_id) < this.heapArray.get(left_id)) {
                        Collections.swap(this.heapArray, pop_id, left_id);
                        pop_id = left_id;
                    }
                } else {
                    // pop_id >>>>> right_id  => true
                    if (this.heapArray.get(pop_id) < this.heapArray.get(right_id)) {
                        Collections.swap(this.heapArray, pop_id, right_id);
                        pop_id = right_id;
                    }
                }
            }
        }
        return returnde;
    }

    public boolean move_down(Integer pop_id) {
        Integer left_id = pop_id * 2;
        Integer right_id = pop_id * 2 + 1;

        // CASE_1 왼쪽 노드가 없다
        if (left_id >= this.heapArray.size()) {
            return false;
        }
        // CASE_2 오른쪽 노드 자식 노드만 없을때
        else if ( right_id >= this.heapArray.size()) {
            // CASE_2_1  left_id의 값 >>>> pot_id의 값이
            if (this.heapArray.get(left_id) > this.heapArray.get(pop_id)) {
                return true;
            }
        }
        // CASE_3 왼쪽/오른쪽 다있다.
        else {
            //  CASE_3_1 왼쪽 자식이 오른쪽보다 크다.
            if (this.heapArray.get(left_id) > this.heapArray.get(right_id)) {
                // pop_id <<<< left_id  => true
                if (this.heapArray.get(pop_id) < this.heapArray.get(left_id)) {
                    return true;
                } else {
                    return false;
                }
                //  CASE_3_2 오른쪽 자식이 왼쪽보다 크다.
            } else {
                // pop_id <<<< right_id  => true
                if (this.heapArray.get(pop_id) < this.heapArray.get(right_id)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
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

        MakeHeapBasick testArray = new MakeHeapBasick(insertData[0]);
        System.out.println(testArray.heapArray + " 추가 : " + insertData[0]);

        for (int i = 1; i < insertData.length; i++) {
            testArray.insert(insertData[i]);
            System.out.println(testArray.heapArray + " 추가 : " + insertData[i]);
        }

        System.out.println("최상단 값 : " + testArray.pop());
        System.out.println("최상단 값을 가져간후 : " + testArray.heapArray);
//
//        System.out.println("HeapArray Size : " + testArray.HeapArray.size());
    }
}
