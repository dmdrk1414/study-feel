package dataLodic.BinarySearchTree;

public class NodeMgmtBasicSearch {
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


    public static void main(String[] args) {
        NodeMgmtBasicSearch testNode = new NodeMgmtBasicSearch();
        testNode.insertNode(5);
        testNode.insertNode(4);
        testNode.insertNode(6);
        testNode.insertNode(3);
        testNode.insertNode(10);
        testNode.insertNode(7);
        testNode.insertNode(11);
        testNode.insertNode(2);
        testNode.insertNode(1);

        NodeMgmtBasicSearch test = new NodeMgmtBasicSearch();
        test.insertNode(2);
        test.insertNode(3);
        test.insertNode(4);
        test.insertNode(6);

        System.out.println(test.search(3).right.value);
        /*
        System.out.println(testNode.head.value);

        System.out.println(testNode.head.right.value); // 6
        System.out.println(testNode.head.right.right.value); // 10
        System.out.println(testNode.head.right.right.left.value); // 7
        System.out.println(testNode.head.right.right.right.value); // 11

        System.out.println(testNode.head.left.value);   // 4
        System.out.println(testNode.head.left.left.value);  // 3
        System.out.println(testNode.head.left.left.left.value);  // 2
        System.out.println(testNode.head.left.left.left.left.value);  // 1
        */

    }
}
