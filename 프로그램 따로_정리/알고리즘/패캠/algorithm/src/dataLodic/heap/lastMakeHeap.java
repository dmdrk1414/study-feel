package heap;

import java.util.ArrayList;
import java.util.Collections;

public class lastMakeHeap {
    ArrayList<Integer> lastHeap;

    public lastMakeHeap(Integer data) {
        lastHeap = new ArrayList<>();
        lastHeap.add(null);
        lastHeap.add(data);
    }

    public boolean insertData(Integer data) {
        if (this.lastHeap == null) {
            // CASE_1 배열이 없다면?
            // CASE_1_1 배열에 추가 " 0, 1"
            this.lastHeap = new ArrayList<>();
            this.lastHeap.add(null);
            this.lastHeap.add(data);
        } else {
            // CASE_2 배열이 있다.
            this.lastHeap.add(data);
            Integer insert_number = this.lastHeap.size() - 1;
            // move_up의 함수는 insert_number 값이 부모보다 크면?  => true
            while (move_up(insert_number)) {
                Integer parent_number = insert_number / 2;

                // CASE_2_1 insertData > 부모의 값  swap한다.
                if (this.lastHeap.get(insert_number) > this.lastHeap.get(parent_number)) {
                    Collections.swap(this.lastHeap, insert_number, parent_number);
                }
                insert_number = parent_number;
            }
        }
        return false;
    }

    public boolean move_up(Integer insert_number) {
        Integer parent_number = insert_number / 2;
        if (insert_number <= 1) {
            return false;
        }

        if (this.lastHeap.get(insert_number) > this.lastHeap.get(parent_number)) {
            return true;
        }
        return true;
    }

    public Integer lastPop() {
        Integer return_number = this.lastHeap.get(1);
        Collections.swap(this.lastHeap, 1, this.lastHeap.size() - 1);
        this.lastHeap.remove(this.lastHeap.size() - 1);
        Integer pop_number = 1;

        while (move_down(pop_number)) {
            Integer left_number = pop_number * 2;
            Integer right_number = pop_number * 2 + 1;
            if (this.lastHeap == null) {
                return null;
            } else {
                // this.lastHeap != null


                // CASE_1 왼쪽 자식 노드 x
                if (left_number >= this.lastHeap.size()) {
                    return null;
                }
                // CASE_2 오른쪽 자식 노드만 없을때
                else if (right_number >= this.lastHeap.size()) {
                    // left >>> pop
                    if (this.lastHeap.get(left_number) > this.lastHeap.get(pop_number)) {
                        Collections.swap(this.lastHeap, left_number, pop_number);
                        pop_number = left_number;
                    }
                } else {
                    // CASE_3 왼쪽/오른쪽 다있다?
                    if (this.lastHeap.get(left_number) > this.lastHeap.get(right_number)) {
                        //left >>> pop
                        if (this.lastHeap.get(left_number) > this.lastHeap.get(pop_number)) {
                            Collections.swap(this.lastHeap, left_number, pop_number);
                            pop_number = left_number;
                        }
                    } else {
                        // right >>> pop
                        if (this.lastHeap.get(right_number) > this.lastHeap.get(pop_number)) {
                            Collections.swap(this.lastHeap, right_number, pop_number);
                            pop_number = right_number;
                        }
                    }
                }
            }
        }
        return return_number;
    }

    public boolean move_down(Integer pop_number) {
        Integer left_number = pop_number * 2;
        Integer right_number = pop_number * 2 + 1;

        // CASE_1 왼쪽 자식 노드 x
        if (left_number >= this.lastHeap.size()) {
            return false;
        }
        // CASE_2 오른쪽 자식 노드만 없을때
        else if (right_number >= this.lastHeap.size()) {
            // left >>> pop
            if (this.lastHeap.get(left_number) > this.lastHeap.get(pop_number)) {
                return true;
            }
        } else {
            // CASE_3 왼쪽/오른쪽 다있다?
            // CASE_3_1 왼쪽이 더크다면?
            if (this.lastHeap.get(left_number) > this.lastHeap.get(right_number)) {
                //left >>> pop
                if (this.lastHeap.get(left_number) > this.lastHeap.get(pop_number)) {
                    return true;
                } else {
                    return false;
                }
                // CASE_3_2 오른쪽이 더크다면?
            } else {
                // right >>> pop
                if (this.lastHeap.get(right_number) > this.lastHeap.get(pop_number)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {

        int insertData[] = {1, 2, 3, 4, 5};
        System.out.println("insertDataNumber : " + insertData.length);
//      [ 0 , 1, 2, 3, 4, 5  ]   6 개

        lastMakeHeap testArray = new lastMakeHeap(insertData[0]);
        System.out.println(testArray.lastHeap + " 추가 : " + insertData[0]);

        for (int i = 1; i < insertData.length; i++) {
            testArray.insertData(insertData[i]);
            System.out.println(testArray.lastHeap + " 추가 : " + insertData[i]);
        }

        System.out.println("최상단 값 : " + testArray.lastPop());
        System.out.println(testArray.lastHeap);
        System.out.println("HeapArray Size : " + testArray.lastHeap.size());
    }
}
