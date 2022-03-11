package dataLodic.BinarySearchTree;

public class makeNodeMgmt {
    Node head = null;

    public class Node {
        int value;
        Node right;
        Node left;

        public Node(int data) {
            this.value = data;
            this.right = null;
            this.left = null;
        }
    }

    public boolean insertData(int value) {
        // head가 없는 경우
        if (this.head == null) {
            this.head = new Node(value);
            return true;
            // head가 있는경우
        } else {
            Node currNode = this.head;
            Node currPrentNode = this.head;

            while (currNode != null) {
                if (value < currNode.value) {
                    currPrentNode = currNode;
                    currNode = currNode.left;
                } else if (value > currNode.value) {
                    currPrentNode = currNode;
                    currNode = currNode.right;
                }
            }
            if (value < currPrentNode.value) {
                currPrentNode.left = new Node(value);
            } else {
                currPrentNode.right = new Node(value);
            }
            return true;
        }
    }

    public Node search(int value) {
        if (this.head == null) {
            return null;
        } else {
            Node currNode = this.head;
            Node currParentNode = this.head;
            while (currNode != null) {
                if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else if (value > currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.right;
                } else if (value == currNode.value) {
                    // --------------------------------------------------------------
                    System.out.println("currParentNode.value : " + currParentNode.value);
                    return currNode;
                }
            }
            return null;
        }
    }

    public boolean deleteData(int value) {
        // CASE_1 this.head == null
        if (this.head == null) {
            return false;
            // CASE_2 this.head != null
        } else {
            // CASE_2_Exception Only one thie.head   this.head don't hava left & right
            if (this.head.left == null && this.head.right == null) {
                this.head = null;
            }
            // Make currNode and currParentNode
            Node currNode = this.head;
            Node currParentNode = this.head;

            // currNode, currParentNode 을 순환해서 찾기
            while (currNode != null) {
                if (value == currNode.value) {
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            // CASE_2_1 don't have child of currNode
            if (currNode.left == null && currNode.right == null) {
                System.out.println("CASE_2_1");
                if (value < currParentNode.value) {
                    currParentNode.left = null;
                } else {
                    currParentNode.right = null;
                }
                // CASE_2_2 Only one child of currNode  left or right
            } else if (currNode.left != null && currNode.right == null) {
                System.out.println("CASE_2_2_1");
                // 현제의 노드의 값이 < 부모의 값보다 작다면
                if (currNode.value < currParentNode.value) {
                    currParentNode.left = currNode.left;
                    // 현제의 노드의 값이 > 부모의 값보다 크다면
                } else {
                    currParentNode.right = currNode.left;
                }
            } else if (currNode.left == null && currNode.right != null) {
                System.out.println("CASE_2_2_2");
                // currNode.value > currParentNode.value
                if (currNode.value < currParentNode.value) {
                    currParentNode.left = currNode.right;
                } else {
                    currParentNode.right = currNode.right;
                }
                // CASE_2_3 현제의 Node의 child가 2개가 있다.
            } else {
                System.out.println("CASE_2_3");
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
//                System.out.println("Befor changeParentNode : " + changeParentNode.value);
//                System.out.println("Befor changeNode : " + changeNode.value);
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                if (changeNode.right != null) {
                    changeParentNode.left = changeNode.right;
                }


                // 현제의 값이 < 현제의 부모보다  작다
                if (currNode.value < currParentNode.value) {
                    currParentNode.left = changeNode;
                    changeNode.left = currNode.left;
                    changeNode.right = currNode.right;
                    currNode = null;
                } else {
                    // 현제의 값이 > 현제의 부모보다 크다.
                    currParentNode.right = changeNode;
                    changeNode.left = currNode.left;
                    changeNode.right = currNode.right;
                    currNode = null;
                }
            }
            return true;
        }
    }

    public void deleteTest(int value) {
        System.out.println("Want delete Number : " + this.search(value).value);
        this.deleteData(value);
        System.out.println("After deleteDAta");
        System.out.println("currNode : " + this.search(value));
        System.out.println("-----------------------------------------------------");
    }

    public static void main(String[] args) {
        makeNodeMgmt testNode = new makeNodeMgmt();
        testNode.insertData(10);
        testNode.insertData(5);
        testNode.insertData(7);
        testNode.insertData(3);
        testNode.insertData(4);
        testNode.insertData(2);
        testNode.insertData(1);
        testNode.insertData(6);
        testNode.insertData(8);
        testNode.insertData(9);
        testNode.insertData(15);
        testNode.insertData(13);
        testNode.insertData(17);
        testNode.insertData(11);
        testNode.insertData(12);
        testNode.insertData(16);
        testNode.insertData(14);

//        System.out.println(testNode.head.left.value);
//        System.out.println(testNode.head.left.left.value);
//        System.out.println(testNode.head.left.right.value);


//        testNode.deleteData(5);
//        testNode.deleteData(7);
//        testNode.deleteData(15);
//        testNode.deleteData(13);
//        testNode.deleteData(10);

        // CASE_2_2
//        testNode.deleteTest(2);
//        testNode.deleteTest(8);
//        testNode.deleteTest(11);
//        testNode.deleteTest(17);
        testNode.deleteData(13);

        System.out.println("10 : " + testNode.head.value); // 10
        System.out.println("05 : " + testNode.head.left.value); // 5
        System.out.println("07 : " + testNode.head.left.right.value); // 7
        System.out.println("06 : " + testNode.head.left.right.left.value); // 6
        System.out.println("08 : " + testNode.head.left.right.right.value); // 8
        System.out.println("09 : " + testNode.head.left.right.right.right.value); // 9
        System.out.println("03 : " + testNode.head.left.left.value); // 3
        System.out.println("04 : " + testNode.head.left.left.right.value); // 4
        System.out.println("02 : " + testNode.head.left.left.left.value); // 2
        System.out.println("01 : " + testNode.head.left.left.left.left.value); // 1
        System.out.println("15 : " + testNode.head.right.value); // 15
        System.out.println("13 : " + testNode.head.right.left.value); // 13
        System.out.println("11 : " + testNode.head.right.left.left.value); // 11
        System.out.println("12 : " + testNode.head.right.left.left.right.value); // 12
        System.out.println("17 : " + testNode.head.right.right.value); // 17
        System.out.println("16 : " + testNode.head.right.right.left.value); // 16


        /*
        try {
            for (int i = 1; i <= 16; i++) {
                System.out.println(testNode.search(i).value);
            }
        } catch (Exception e){
            System.out.println(e);
        }
         */

    }
}
