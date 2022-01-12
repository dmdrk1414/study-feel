package array;

public class MakeHashTable {
    Slot[] hashTable = null;

    public MakeHashTable(Integer slotSize) {
        this.hashTable = new Slot[slotSize];
    }

    class Slot {
        String value = null;

        public Slot(String value) {
            this.value = value;
        }
    }

    public Integer makeKey(String key) {
        return (int) key.charAt(0) % this.hashTable.length;
    }

    public void addHashTableValue(String key, String value) {
        Integer address = makeKey(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else { // this.hashTable[address] == null
            this.hashTable[address] = new Slot(value);
        }
    }

    public static void main(String[] args) {
        MakeHashTable testTable = new MakeHashTable(20);
        testTable.addHashTableValue("Dmdrk1414", "010-2383-6578");
//        for (int i = 0; i < testTable.hashTable.length; i++) {
//            System.out.println(testTable.hashTable[i]);
//        }
        System.out.println(testTable.hashTable[8]);
    }


}
