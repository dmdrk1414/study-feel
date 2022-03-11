package hashTable;

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

    public Boolean saveData(String key, String value) {
        Integer adress = hashFunc(key);
        if (this.hashTable[adress] != null) {
            this.hashTable[adress].value = value;
        } else {
            this.hashTable[adress] = new Slot(value);
        }
        return true;
    }

    public  String getData(String key){
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null){
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        // 같은 키가 겹쳐서 오류 발생위험 -> Chaining 이 나온다.
        MyHash mainObject = new MyHash(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        System.out.println(mainObject.getData("fun-coding"));
    }
}