package algorithm.recursive;

import java.util.ArrayList;

public class Recursive {

    // factorial(n) 은 n - 1 번의 factorial()함수를 호출해서, 곱셈을 함
    //일종의 n-1번 반복문을 호출한 것과 동일
    //factorial() 함수를 호출할 때마다, 지역변수 n 이 생성됨
    // 시간 복잡도/공간 복잡도는 O(n -1) 이므로 결국, 둘 다 O(n)
    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // 모든 배열의 합을 구한다.
    // subList을 이용한다.
    public int factorialFuncArray(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            ArrayList<Integer> test = new ArrayList<Integer>();
            return 0;
        }
        return dataList.get(0) + this.factorialFuncArray(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
    }

    public int FactorialFunc(int data) {
        if (data == 1) {
            return 1;
        } else if (data == 2) {
            return 2;
        } else if (data == 3) {
            return 4;
        } else {
            return FactorialFunc(data - 1) + FactorialFunc(data - 2) + FactorialFunc(data - 3);
        }
    }

    public int fibonacciRecursive(int data) {
//        if (data == 0) {
//            return 0;
//        } else if (data == 1) {
//            return 1;
//        }
//        else if (data == 2) {
//            return 1;
//        }
        if (data <= 1){
            return data;
        }
        else {
            return fibonacciRecursive(data - 1) + fibonacciRecursive(data - 2);
        }
    }

    public int dynamicFibonacci (int data){
        Integer[]cache = new Integer[data + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int index = 2; index < data + 1; index++) {
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[data];
    }

    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 5; i > 0; i--) {
            testList.add(i);
        }

        Recursive test = new Recursive();
        System.out.println(test.dynamicFibonacci(10));

    }
}
