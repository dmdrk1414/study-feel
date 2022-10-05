package algorithm.space;

public class space {
    // 기본 팩토리얼 함수
    // log(1)
    public Integer Fatorial(Integer n) {
        int number = 1;

        for (int i = 1; i <= n; i++) {
            number = number * i;
        }
        return number;
    }

    // 재귀함수적인 팩토리얼 함수
    // log(n)
    public int factorialFunc(int n) {
        if (n > 1) {
            return n * factorialFunc(n - 1); // 3 * 2 * 1
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        space test = new space();
//        System.out.println(test.Fatorial(3));

        System.out.println(test.factorialFunc(3));

    }
}
