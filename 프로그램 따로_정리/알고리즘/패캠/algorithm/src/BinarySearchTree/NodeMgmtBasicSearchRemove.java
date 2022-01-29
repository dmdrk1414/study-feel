package BinarySearchTree;

import com.sun.security.jgss.GSSUtil;

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
            // Case3 현제의 Node의 자식이 2개가 있으면?
            // Case3_1 value > parents.value
//                    Case3_1_1 child Node 중에 작은것을 current Node에 붙인다.
            // Case3_2 value < parents.value
//                    Case3_2_1 child Node 중에 작은것을 current Node에 붙인다.
            else if (currNode.left != null && currNode.right != null) {
                System.out.println("CASE_3");
                Node leftNode = currNode;

                if (value > currParentNode.value) {
                    while (leftNode.left != null) {
                        leftNode = leftNode.left;
                    }
//                    System.out.println("leftNode: " + leftNode.value);
                    Node tempNode = currNode;
                    currNode = leftNode;
                    currParentNode.right = currNode;
                    leftNode = null;
                } else { // value < ParentNode.value
                    while (leftNode.left != null) {
                        leftNode = leftNode.left;
                    }
                    Node tempNode = currNode;
                    currNode = leftNode;
                    currParentNode.left = currNode;
                     leftNode = null;
                }
            }
        }
        return true;
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

    }
}
