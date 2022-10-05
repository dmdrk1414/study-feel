{
 "cells": [],
 "metadata": {},
 "nbformat": 4,
 "nbformat_minor": 5
}
package hashTable;

public class MyHashChaining {
        public Slot[] hashTable; // 배열일때 쓸수있다 해쉬테이블은

        // hashTable은 슬롯의 배열이다.!!!
        // 그래서 해쉬테이블의 새로운 슬롯의 배열을 선언한다.
        public MyHashChaining(Integer hashSize) {
            this.hashTable = new Slot[hashSize]; //슬롯의 데이터는 쓰되 배열형으로 사용한다.
        }

        public class Slot {
            String key;
            String value;
            Slot next;

            public Slot(String key , String value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

        public Integer hashFunc(String key) {
            return (int) (key.charAt(0)) % this.hashTable.length;
        }

        public Boolean saveData(String key, String value) {
            Integer adress = hashFunc(key);
            if (this.hashTable[adress] != null) { // adress 에 주소가 있다
                Slot findSlot = this.hashTable[adress];
                Slot prevSlot = this.hashTable[adress];
                while (findSlot != null) {
                    if (findSlot.key == key){ // 키가 같으면 값을 덮어 써라
                        findSlot.value = value;
                        return true;
                    } else { // 어드레스는 값은데 키는 다른것
                        prevSlot = findSlot;
                        findSlot = findSlot.next; //findSlot 이 null이면 나가!
                    }
                }
                prevSlot.next = new Slot(key, value);

            } else {   // adress 에 주소가 없다.
                this.hashTable[adress] = new Slot(key,value);
            }
            return true;
        }

        public String getData(String key) {
            Integer address = this.hashFunc(key);
            if (this.hashTable[address] != null) {
                Slot findSlot = this.hashTable[address];

//                while (findSlot.key != key){
//                    findSlot = findSlot.next;
//                }
//                return findSlot.value;

                while (findSlot != null){
                    if (findSlot.key == key){
                        return findSlot.value;
                    } else {
                        findSlot = findSlot.next;
                    }
                }
                return null;
            } else {
                return null;
            }
        }

        //temp
        public void printAll(String key){
            Integer address = this.hashFunc(key);
            if (this.hashTable[address] != null){
                System.out.println(this.hashTable[address].value);

                Slot hashTable = this.hashTable[address];
                while (hashTable.next != null){
                    hashTable = hashTable.next;
                    System.out.println(hashTable.value);
                }
            }
        }


        public static void main(String[] args) {
            MyHashChaining mainObject = new MyHashChaining(20);
            mainObject.saveData("D첫번째", "D첫번째 값");
            mainObject.saveData("D두번째", "D두번째 값");
            mainObject.saveData("D세번째", "D세번째 값");

            System.out.println(mainObject.getData("D세번째"));

        }
}
