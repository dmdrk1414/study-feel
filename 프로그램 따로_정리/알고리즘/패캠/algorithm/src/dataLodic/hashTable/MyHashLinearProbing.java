package hashTable;

public class MyHashLinearProbing {
    public Slot[] hashTable;

    public MyHashLinearProbing(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public Integer hashFunc(String key) {
        return (int) key.charAt(0) / this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1;
                while (this.hashTable[currAddress] != null) {

                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }

                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable != null) {
                Integer currAddress = address;
                while (this.hashTable[currAddress].key != key){
                    if (this.hashTable[currAddress].key == key){
                        return this.hashTable[currAddress].value;
                    } else {
                        currAddress++;
                    }
                }
                return this.hashTable[currAddress].value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHashLinearProbing test = new MyHashLinearProbing(20);
        Integer adress = (int) "D".charAt(0) / test.hashTable.length;
        test.saveData("D첫번째", "D첫번째 값");
        test.saveData("D두번째", "D두번째 값");
        test.saveData("D세번째", "D세번째 값");

        System.out.println(test.hashTable[adress].value);
        System.out.println(test.hashTable[adress + 1].value);
        System.out.println(test.hashTable[adress + 2].value);

        System.out.println(test.getData("D두번째"));
    }
}
