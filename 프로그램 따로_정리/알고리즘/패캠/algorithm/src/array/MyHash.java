package array;

public class MyHash {
    public Slot[] hashTable; // 배열일때 쓸수있다 해쉬테이블은

    // hashTable은 슬롯의 배열이다.!!!
    // 그래서 해쉬테이블의 새로운 슬롯의 배열을 선언한다.
    public MyHash(Integer hashSize) {
        this.hashTable = new Slot[hashSize]; //슬롯의 데이터는 쓰되 배열형으로 사용한다.
    }

    public class Slot {
        String value;

        public Slot(String value) {
            this.value = value;
        }
    }

    public Integer hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public void saveValue(String key, String value) {
        Integer adress = hashFunc(key);
        if (this.hashTable[adress] != null) {
            this.hashTable[adress].value = value;
        } else {
            this.hashTable[adress] = new Slot(value);
        }
    }


    public static void main(String[] args) {
        MyHash asdf = new MyHash(23);
        MyHash test = new MyHash(20);
        test.saveValue("D", "01023836578");
        for (int i = 0; i < test.hashTable.length; i++) {
            System.out.println(i + "번째 " + test.hashTable[i]);
        }
//        String[] testArray = {"A", "B", "C", "D", "E","F"};
//        System.out.println((int) ("D".charAt(0)));

//        System.out.println(test.getData("D"));
    }
}