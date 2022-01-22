public class testClass {

    public static void main(String[] args) {
        int testNumber = 0;
        int testLargeNumber = 3;
        for (int i = 0; i < 5; i++) {
            if (testNumber > testLargeNumber){
                continue;
            }
            testNumber++;
        }

        System.out.println(testNumber);
    }
}
