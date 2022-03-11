package dataLodic.BinarySearchTree;

/**
 * 6. 이진 탐색 트리의 시간 복잡도와 단점
     * 6.1. 시간 복잡도 (탐색시)
         * depth (트리의 높이) 를 h라고 표기한다면, O(h)
         * n개의 노드를 가진다면,  ℎ=𝑙𝑜𝑔2𝑛  에 가까우므로, 시간 복잡도는  𝑂(𝑙𝑜𝑔𝑛)
             * 참고: 빅오 표기법에서  𝑙𝑜𝑔𝑛  에서의 log의 밑은 10이 아니라, 2입니다.
         * 한번 실행시마다, 50%의 실행할 수도 있는 명령을 제거한다는 의미. 즉 50%의 실행시간을 단축시킬 수 있다는 것을 의미함
 * 6.2. 이진 탐색 트리 단점
     * 평균 시간 복잡도는  𝑂(𝑙𝑜𝑔𝑛)  이지만,
         * 이는 트리가 균형잡혀 있을 때의 평균 시간복잡도이며,
     * 다음 예와 같이 구성되어 있을 경우, 최악의 경우는 링크드 리스트등과 동일한 성능을 보여줌 (  𝑂(𝑛)  )
 *
 * 2개로 분할해서 탐색을 하는 점은 매력적이다.
 * 하지만 큰것부터 작은거 작은거부터 큰것을 순서대로 삽입이되면 doubleLinkedList 와 비슷한것같다.
 */


public class NodeMgmtBasicSearchRemove {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
//         CASE_1 Node가 하나도 없을때
/*
        CASE_1 Node 가 하나도 없을때
        CASE_2 Node 가 하나 이상 들어가 있을때 {
            CASE_2_1 현제의 Node 보다작을때  => left
                CASE_2_1_1 Node.left의 노드가 있을때  => 재귀적 순환
                CASE_2_1_2 Node.left의 노드가 없을때  => Node 생성
            CASE_2_2 현제의 Node 보다클때   => right
                CASE_2_2_1 Node.right의 노드가 있을때  => 재귀적 순환
                CASE_2_2_2 Node.right의 노드가 없을때  => Node 생성
            CASE_2_3 현제의 Node 같을때? 는  => 멈춘다?
        }
 */
        if (this.head == null) {
            this.head = new Node(data);
        } else {
//             CASE_2 Node 가 하나 이상 들어가 있을때
            Node findNode = this.head;
//             순환
            while (true) {
//                CASE_2_1 현제의 Node 보다작을때  => left
                if (data < findNode.value) {
//                      CASE_2_1_1 현제의 Node 읜 left가 있을때
                    if (findNode.left != null) {
                        findNode = findNode.left;   // 재귀적 순환
                    } else {
                        findNode.left = new Node(data);  // 현제의 Node의 left가 없으면
                        break;
                    }
                }
//                CASE_2_2 현제의 Node 보다클때   => right
                else {
//                      CASE_2_2_1 현제의 Node 읜 right 있을때
                    if (findNode.right != null) {
                        findNode = findNode.right;   // 재귀적 순환
                    } else {
                        findNode.right = new Node(data);  // 현제의 Node의 right가 없으면
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int data) {
        /*
        CASE_1 head Node가 없을때.
        CASE_2 head Node가 있을때.
        -------------------------------------------------- 순환
                CASE_2.1 현제의 Node의 data < data
                CASE_2.2 현제의 Node의 data > data
         */

        if (this.head == null) {
            return null;
        } else {
            // this.head != null
            Node findNode = this.head;
            // 순환
            while (findNode != null) {
//                현제의 node의 value이 == data 이면 현제의 node return
                if (data == findNode.value) {
                    return findNode;
                } else if (data > findNode.value) {
                    findNode = findNode.right;
                } else {
                    findNode = findNode.left;
                }
            }
        }
        return null;
    }

    public boolean delete(int value) {
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        // 코너 케이스_1 Node 가 하나도 없을 때
        if (this.head == null) {
            return false;
        } else {
            // 코너 케이스_2 Node 가 한개 일때 -> 그리고 해당 Node가 삭제할 Node일때
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            // 순환. 현제의 노드와 value(찾고자 하는 값)을 찾는 과정
            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }
            // 순환이후 찾고자 하는 것이 없으면
            if (searched == false) {
                return false;
            }

            // 여기까지 실행이 되면,
            // currNode 에는 해당 데이터를 가지고 있는 Node,
            // currParentNode 에는 해당 데이터를 가지고 있는 Node 의 부모 Node,

            // 현재의 노드가 left, regit가 없을때
            if (currNode.left == null && currNode.right == null) {
                System.out.println("CASE_1");
//                System.out.println(currParentNode.left);
//                System.out.println(currParentNode.left.value);
//                System.out.println(currParentNode.left = null);
//                System.out.println(currParentNode.left);
//                System.out.println(currParentNode.left.value);

//                왜 currNode 을 null로 만들었을때는 안된는 것인가
//                System.out.println(currNode);
//                System.out.println(currNode.value);
//                System.out.println(currNode = null);

                if (value > currParentNode.value) {
                    currParentNode.right = null;
                } else {
                    currParentNode.left = null;
                }

                return true;
            }
            // Case2-1: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (left에 Child Node 가 있을 경우)
            else if (currNode.left != null && currNode.right == null) {
                System.out.println("Case_2-1");
                if (value < currParentNode.value) {
                    currParentNode.left = currNode.left;
                    currNode = null;
                } else {
                    currParentNode.right = currNode.left;
                    currNode = null;
                }
                return true;
            }
            // Case2-2: 삭제할 Node가 Child Node를 한개를 기지고 있을경우 (right에 Child Node가 있을경우)
            else if (currNode.left == null && currNode.right != null) {
                System.out.println("Case_2-2");
                if (value < currParentNode.value) {
                    currParentNode.left = currNode.right;
                    currNode = null;
                } else {
                    currParentNode.right = currNode.right;
                    currNode = null;
                }
                return true;
            }

            // Case3-1 : 삭제할 Node 가 child Node를 두개 가지고 있고,
            // 삭제할 Node 가 부모 Node 의 왼쪽에 있는 경우
            else{
                System.out.println("CASE_3");
                // 삭제할 node가 parentNode의 왼쪽에 있을때
                if (value < currParentNode.value) {
                    // 현제노드의 right의 가장 작은 값을 가져야되다.
                    // 가장작은 값의 자식노드를 가지고있을 케이스가 있으니 연결해줄수있는 changeParentNode가 있어야된다.
                    Node changeNode = currNode.right;
                    Node changeParentNode = currNode.right;

                    if (changeNode.left == null && changeNode.right == null){
                        currParentNode.right = changeNode;
                        changeNode.left = currNode.left;
                        currNode = null;
                        return true;
                    }

                    while (changeNode.left != null) {
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }
                    // 여기 까지 실행 되면 changeNode 에는 삭제할 Node이 오른쪽 Node중에서
                    // 가장 작은 값을 가진 Node가 있음

                    // Case 3-1-1: changeNode 의 Child Node가 없을 떼
                    // Case 3-1-2: changeNode 의 오른쪽 Child Node 가 있을 때

                    if (changeNode.right != null) {
                        //Case 3-1-2 : changeNode 의 child Node가 있을때 changeNode.right가 있을때
                        changeParentNode.left = changeNode.right;
                    } else {
                        // Case 3-1-1 : changeNode 의 Child Node 가 없을때때
                        changeParentNode.left = null;
                    }

                    // currParentNode 의 왼쪽(left) child Node 에 , 삭제할 Node (currNode) 의 오른쪽 자식중에,
                    // 가장 작은 값을 가진 changeNode 를 currParentNode.left 에 연결한다.
                    currParentNode.left = changeNode;

                    // currParentNode 의 왼쪽 Child Node 가 현재, changeNode 이고,
                    // changeNode 의 왼쪽/오른쪽 Child Node 를 모두, 삭제할 currNode 의
                    // 기존 왼쪽/오른쪽 Node 로 변경
                    changeNode.right = currNode.right;
                    changeNode.left = currNode.left;

                    currNode = null;
                }
                // Case 3-2 : 삭제할 Node 가 Child Node 를 두개 가지고 있고,
                // (삭제할 Node 가 부모 Node 의 오른쪽) currNode.value > currParentNode.value
                else {
                    Node changeNode = currNode.right;
                    Node changeParentNode = changeNode.right;

                    if (changeNode.left == null && changeNode.right == null){
                        currParentNode.right = changeNode;
                        changeNode.left = currNode.left;
                        currNode = null;
                        return true;
                    }

                    while (changeNode.left != null ){
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }
                    // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 Node 중에서,
                    // 가장 작은 값을 가진 Node 가 들어있음

                    if (changeNode.right != null) {
                        // Case 3-2-2 : changeNode 의 오른쪽 Child Node 가 있을 때
                        changeParentNode.left = changeNode.right;
                    } else {
                        // Case 3-2-1: changeNode 의 Child Node 가 없을때
                        changeParentNode.left = null;
                    }

                    // currParentNode 의 오른쪽 Child Node 에, 삭제할 Node 의 오른쪽 자식중,
                    // 가장 작은 값을 가진 changeNode 를 연결
                    currParentNode.right = changeNode;

                    // parentNode 의 왼쪽 Child Node 가 현재, changeNode 이고,
                    // changeNode 의 왼쪽/오른쪽 Child Node 를 모두, 삭제할 currNode 의
                    // 기존 왼쪽/오른쪽 Node 로 변경
                    changeNode.right = currNode.right;
                    changeNode.left = currNode.left;

                    currNode = null;
                }
                return  true;
            }
        }
    }


    public static void main(String[] args) {

        /*
        NodeMgmtBasicSearchRemove testNode = new NodeMgmtBasicSearchRemove();
        testNode.insertNode(5);
        testNode.insertNode(4);
        testNode.insertNode(6);
        testNode.insertNode(3);
        testNode.insertNode(10);
        testNode.insertNode(7);
        testNode.insertNode(11);
        testNode.insertNode(2);
        testNode.insertNode(1);

        /*
        NodeMgmtBasicSearchRemove test = new NodeMgmtBasicSearchRemove();
        test.insertNode(2);
        test.insertNode(3);
        test.insertNode(4);
        test.insertNode(6);
        System.out.println(test.search(3).right.value);
        */
        /*
        testNode.delete(10);
        System.out.println(testNode.head.value); // 5
        System.out.println(testNode.head.right.value); // 6
        System.out.println("현제노드: " + testNode.head.right.right.value); // 10
        System.out.println("현제노드.left: " + testNode.head.right.right.left.value); // 7
        System.out.println("현제노드.right: " + testNode.head.right.right.right.value); // 11
        System.out.println(testNode.head.left.value);   // 4
        System.out.println(testNode.head.left.left.value);  // 3
        System.out.println(testNode.head.left.left.left.value);  // 2
        System.out.println(testNode.head.left.left.left.left.value);  // 1
         */

        /*
        NodeMgmtBasicSearchRemove testTwo = new NodeMgmtBasicSearchRemove();
        testTwo.insertNode(50);
        testTwo.insertNode(40);
        testTwo.insertNode(35);
        testTwo.insertNode(33);
        testTwo.insertNode(37);
        testTwo.insertNode(36);
        testTwo.insertNode(38);
        testTwo.insertNode(45);
        testTwo.insertNode(43);
        testTwo.insertNode(42);
        testTwo.insertNode(44);
        testTwo.insertNode(47);
        testTwo.insertNode(46);
        testTwo.insertNode(48);
        testTwo.insertNode(49);

        testTwo.delete(45);
        System.out.println("현제 노드 : " + testTwo.head.left.right.value);
        System.out.println("현제 노드 left : " + testTwo.head.left.right.left.value);
//        System.out.println("마지막 left : "+ testTwo.head.left.right.left.left.value);
*/

        NodeMgmtBasicSearchRemove test = new NodeMgmtBasicSearchRemove();
        test.insertNode(10);
        test.insertNode(15);
        test.insertNode(13);
        test.insertNode(11);
        test.insertNode(14);
        test.insertNode(18);
        test.insertNode(16);
        test.insertNode(19);
        test.insertNode(17);
        test.insertNode(7);
        test.insertNode(8);
        test.insertNode(6);

        test.delete(18);
        System.out.println(test.head.right.right.right.value);
    }
}
