package hashTable;

public class TestHashTable {
    Slot[] hashTable;

    public TestHashTable(Integer tableSize) {
        hashTable = new Slot[tableSize];
    }

    public class Slot {
        String value;
        String key;
        Slot next = null;
        Slot prev = null;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public Integer funkc(String key) {
        return (int) key.charAt(0) / this.hashTable.length;
    }

    public Boolean addData(String key, String value) {
        Integer address = funkc(key);
        if (this.hashTable[address] != null) { // address 가있으면?


            Integer currentAddress = address + 1;  //next
            while (this.hashTable[currentAddress] != null) {
                if (this.hashTable[currentAddress].key == key) {
                    this.hashTable[currentAddress].value = value;
                } else {
                    // key가 다르다.
                    currentAddress++;
                    if (currentAddress >= hashTable.length) {
                        return false;
                    }
                }
            }
            this.hashTable[currentAddress] = new Slot(key, value);
            return true;
        } else {
            this.hashTable[address] = new Slot(key, value);
            return true;
        }
    }

    public String getData(String key) {
        Integer address = funkc(key);
        if (this.hashTable[address] != null) {

            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Slot table = this.hashTable[address];
                while (table != null) {
                    if (table.key == key) {
                        return table.value;
                    } else {
                        table = table.next;
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        TestHashTable test = new TestHashTable(20);
        String key = "Dmdrk1414";
        Integer address = test.funkc("Dmdrk1414");

        System.out.println(address);

        test.addData("D 첫번째 key", "D 첫번째 value");
        test.addData("D 두번째 key", "D 두번째 value");
        test.addData("D 세번째 key", "D 세번째 value");

        System.out.println(test.hashTable[test.funkc("D 첫번째 key")].value);
        System.out.println(test.hashTable[test.funkc("D 두번째 key") + 1].value);
        System.out.println(test.hashTable[test.funkc("D 세번째 key") + 2].value);
    }
}
