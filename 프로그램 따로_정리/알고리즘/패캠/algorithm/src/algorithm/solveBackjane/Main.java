package algorithm.solveBackjane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public boolean swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return true;
    }


    public int[] bubbleSort(int[] array) {
        for (int index_1 = 0; index_1 < array.length - 1; index_1++) {
            for (int index_2 = 0; index_2 < array.length - 1 - index_1; index_2++) {
                if (array[index_2] > array[index_2 + 1]) {
                    this.swap(array, index_2, index_2 + 1);
                }
            }
        }
        return array;
    }

    public int[] selectionSort(int[] array) {
        int lowest;
        for (int stand = 0; stand < array.length - 1; stand++) {
            lowest = stand;
            for (int index = stand + 1; index < array.length; index++) {
                if (array[lowest] > array[index]) {
                    lowest = index;
                }
            }
            this.swap(array, lowest, stand);
        }
        return array;
    }

    public int[] insertionSort(int[] array) {
        for (int index = 0; index < array.length - 1; index++) {
            for (int index_2 = index + 1; index_2 > 0; index_2--) {
                if (array[index_2] < array[index_2 - 1]) {
                    this.swap(array, index_2, index_2 - 1);
                } else {
                    break;
                }
            }
        }
        return array;
    }

    static int partition(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];
        while (start <= end) {
            while (array[start] < pivot) start++;
            while (array[end] > pivot) end--;
            if (start <= end) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
                start++;
                end--;
            }
        }
        return start;
    }

    static int[] quickSort(int[] array, int start, int end) {
        int p = partition(array, start, end);
        if (start < p - 1) quickSort(array, start, p - 1);
        if (p < end) quickSort(array, p, end);
        return array;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input.readLine());
        }
        Main test = new Main();
        quickSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
