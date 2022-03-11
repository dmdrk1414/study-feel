import java.util.ArrayList;

public class testClass {
    public int[] sort(int[] array) {

        for (int stand = 0; stand < array.length - 1; stand++) {
            int temp = stand;
            for (int index = stand + 1; index < array.length; index++) {
                if (array[temp] > array[index]) {
                    temp = index;
                }
                this.swap(array, stand, temp);
            }
        }
        return array;
    }

    public int[] swap(int[] array, int stand, int index) {
        int temp = array[stand];
        array[stand] = array[index];
        array[index] = temp;

        return array;
    }

    public void printAll(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int arraySize = 5;
        int[] test = new int[arraySize];

        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 100);
        }

        testClass testArray = new testClass();
        testArray.printAll(test);

        System.out.println("---------------");

        testArray.printAll(testArray.sort(test));
    }
}
