package algorithm.solveBackjane;

public class MakeFunc {
    public boolean printArrayAll(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("array " + i + " : " + array[i]);
        }
        return true;
    }

    public boolean printArrayNosubscrip(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        return true;
    }

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
}

