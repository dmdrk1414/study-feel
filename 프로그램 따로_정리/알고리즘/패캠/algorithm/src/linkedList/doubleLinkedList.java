//package array;
//
//class doubleLinkedList<T> {
//    public Node<T> head = null;
//    public Node<T> tail = null;
//
//    public class Node<T> {
//        Node<T> next = null;
//        Node<T> prev = null;
//        T data;
//
//        public Node(T data) {
//            this.data = data;
//        }
//    }
//
//    public void addData(T data) {
//        if (this.head == null) {
//            this.head = new Node<T>(data);  // 만약에 없으면 머리 생성밑 데이터 넣기
//            this.tail = this.head;  // 해드 == 꼬리
//        } else {        // 해드가 데이터가 있으면
//            Node<T> node = this.head;   // Node<T> node 에 지금 해드 주소 담기
//            while (node.next != null) {
//                node = node.next;       // node 위 순환 탐색
//            }
////            System.out.println(node);
//            // 노드는 추가하고싶은 네스트 이전
//            node.next = new Node<T>(data);
//            node.next.prev = node;
//            this.tail = node.next;   //  꼬리를 마지막 노드에 생성
//        }
//    }
//
//    public void printAll() {
//        if (this.head != null) {
//            Node<T> node = this.head;
//            System.out.println(node.data);
//            while (node.next != null) {
//                node = node.next;
//                System.out.println(node.data);
//            }
//        }
//    }
//
//    public Node<T> searchHead(T isData) {
//        if (this.head != null) {
//            Node<T> node = this.head;
//            while (node.data != isData) {
//                node = node.next;
//            }
//            return node;
//        } else {
//            return null;
//        }
//    }
//
//    public Node<T> searchtail(T isData) {
//        if (this.head != null) {
//            Node<T> node = this.tail;
//            while (node.data != isData) {
//                node = node.prev;
//            }
//            return node;
//        } else {
//            return null;
//        }
//    }
//
//    public boolean insertAddData(T data, T isData) {
//        if (this.head == null){
//            this.head = new Node<T>(data);
//            this.tail = this.head;
//            return true;
//        } else if (this.head.data == isData){
//            Node<T> newHead = new Node<T>(data);
//            newHead.next = this.head;
//            this.head = newHead;
//            this.head.next.prev = this.head; // 이걸까먹네
//            return true;
//        } else {
//            Node<T> node = this.head;
//            while (node != null){
//                if (node.data == isData){
//                    Node<T> prevNode = node.prev;
//                    prevNode.next = new Node<>(data);
//                    prevNode.next.next = node;
//                    prevNode.next.prev = prevNode;
//                    node.prev = prevNode.next;
//                    return true;
//                }else {
//                    node = node.next;
//                }
////
//            }
//            return false;
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//        doubleLinkedLids<Integer> test = new doubleLinkedLids<Integer>();
//        test.addData(1);
//        test.addData(2);
//        test.addData(3);
//        test.addData(4);
//        test.addData(5);
//
//        for (int i = 1; i < 6; i++) {
//            test.insertAddData(100, i);}
//        test.printAll();
//    }
//}

package linkedList;

class doubleLinkedList<T> {
    Node<T> head = null;
    Node<T> tail = null;

    public class Node<T> {
        Node<T> next = null;
        Node<T> prev = null;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addData(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
            this.tail.prev = node;
        }
    }

    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    public T searchHeadData(T isData) {
        Node<T> node = this.head;

        while (node != null) {
            if (node.data == isData) {
                return node.data;
            } else {
                node = node.next;
            }
        }
        return null;
    }

    public Boolean addToFrontData(T isData, T data) {
        if (this.head == null) {
            return false;
        } else if (this.head.data == isData) {
            Node<T> newHead = new Node<T>(data);
            newHead.next = this.head;
            this.head = newHead;
            newHead.next.prev =this.head;
            return true;
        } else {
            Node<T> node = this.head;
            while (node != null){
                if ( node.data == isData){
                    Node<T> prevNode = node.prev;
                    prevNode.next = new Node<>(data);
                    prevNode.next.prev = prevNode;
                    prevNode.next.next = node;
                    node.prev = prevNode.next;
                    return true;
                } else {
                    node = node.next;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        doubleLinkedList<Integer> test = new doubleLinkedList<Integer>();
        for (int i = 1; i <= 5; i++) {
            test.addData(i);
        }
//        System.out.println(test.head);
//        System.out.println(test.head.next);
//        System.out.println(test.head.next.next);
//        System.out.println(test.head.next.next.next);
//        System.out.println(test.head.next.next.next.next);


        for (int i = 1; i <= 5  ; i++) {
            test.addToFrontData(i, 99999);
        }
        test.printAll();
//        test.addToFrontData(1, 999);
//        System.out.println(test.head.data);
//        test.printAll();
//        System.out.println("");

//        System.out.println(test.tail.prev);
//        System.out.println(test.head.next.next.next.next.prev);
    }
}