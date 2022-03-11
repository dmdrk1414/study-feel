package hashTable;

public class MakeHashTable {
    public Slot[] hashTable; // 배열일때 쓸수있다 해쉬테이블은

    // hashTable은 슬롯의 배열이다.!!!
    // 그래서 해쉬테이블의 새로운 슬롯의 배열을 선언한다.
    public MakeHashTable(Integer hashSize) {
        this.hashTable = new Slot[hashSize]; //슬롯의 데이터는 쓰되 배열형으로 사용한다.
    }

    public class Slot {
        String value;
        String key;

        public Slot(String key, String value) {
            this.value = value;
            this.key = key;
        }
    }

    public Integer hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public Boolean saveData(String key, String value) {
        Integer address = hashFunc(key);

        if (this.hashTable[address] != null) { // 있다.

            if (this.hashTable[address].key != key) {
                Integer currentAddress = address + 1;
                while (this.hashTable[currentAddress] != null) { // 해당 슬롯이 있는지 확인후
                    if (this.hashTable[currentAddress].key == key) {  // 현제 주소가 key가 같으면?
                        this.hashTable[currentAddress].value = value;
                    } else {
                        currentAddress++;
                        if (currentAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currentAddress] = new Slot(key, value);
            } else {   // key 가 같으면 value 가 value
                this.hashTable[address].value = value;
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }

    public void printAll(String key){
        Integer address = hashFunc(key);
        if (this.hashTable[address] != null){
            for (int i = address; i <address +5 ; i++) {
                System.out.println(this.hashTable[i].key);
                System.out.println(this.hashTable[i].value);
                System.out.println(this.hashTable[i]);
                System.out.println("----------------------------------");
            }
        }
    }



    public static void main(String[] args) {
        MakeHashTable mainObject = new MakeHashTable(20);
        mainObject.saveData("Dfirst key", "first value");
        mainObject.saveData("Dsecond key", "second value");
        mainObject.saveData("Dthird key", "third value");
        mainObject.saveData("D4 key", "4 value");
        mainObject.saveData("D5 key", "5 value");

        mainObject.printAll("D");
    }
}