package leetcode.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int array[] = {7 , 6, 5, 8, 9 ,3 ,9};
        new QuickSort().quickSort(array, 0, array.length -1);
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int key = array[i];
        while(i < j) {
            while (i < j && array[j] > key) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }
            while (i < j && array[i] < key) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }

        array[i] = key;
        if (left < (i -1)) {
            quickSort(array, left, i -1);
        }
        if ((i + 1) < right) {
            quickSort(array, i + 1, right);
        }
    }
}
