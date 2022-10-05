package linkedList;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    //노드 생성
    public class Node<T> {
        Node<T> next = null;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) {             // head 가없으면 새로운 node(data)을 head에 넣는다.
            head = new Node<T>(data);
        } else {                        // head 가 있으면
            Node<T> node = this.head;   // 데이터가 들어가있는 head가 node안에 들어간다. , this는 인스턴스
            while (node.next != null) { // node 다음이 있으면 다음으로
                node = node.next;
            }
            node.next = new Node<T>(data);  // next가 없으면 새로운 노드 생성.
        }
    }

    public void printAll() {
        if (head != null) { // head가 있다는 말이다.
            Node<T> node = this.head;  // Node의 data와 next을 사용할려면. 객체 Node을 사용한다.
            System.out.println(node.data);
            while (node.next != null) {// this.head.next가 있으면
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {       // node가 있으면
                if (node.data == data) {        // 찾고자하는 data와 this.head.data 값이 같으면?
                    return node;                // 바로 node = this.head 을 반환
                } else {
                    node = node.next;           // 앞 this.head.data.next을 찾는다.
                }
            }
            return null;
        }
    }

    public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = this.search(isData);    // this.search(idData) 로인해 원하는 노드를 찾은것을.

        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            searchedNode.next.next = nextNode;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<Integer>();
//        MyLinkedList.addNode(1);
//        MyLinkedList.addNode(2);
//        MyLinkedList.addNode(3);
//
//        MyLinkedList.addNodeInside(5,2);
//        MyLinkedList.printAll();

        int[] test = new int[5];
        for (int i = 0; i < test.length; i++) {
            System.out.println(test);
        }
    }
}