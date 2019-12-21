package cn.itxdl.test;

import java.util.Random;

public class SortTest {

    public static void main(String[] args) {
        try {
            Random random = new Random();
            int[] arr1 = new int[100000];
            for (int i = 0; i < 100000; i++) {
                arr1[i] = random.nextInt(100000);
            }
            long t1 = System.currentTimeMillis();
            quickSort(arr1, 0, arr1.length - 1);
            System.out.println(arr1);
            System.out.println("快速排序耗时：" + (System.currentTimeMillis() - t1));

            int[] arr2 = new int[100000];
            for (int i = 0; i < 100000; i++) {
                arr2[i] = random.nextInt(100000);
            }
            long t2 = System.currentTimeMillis();
            sort(arr2);
            System.out.println(arr2);
            System.out.println("冒泡排序耗时：" + (System.currentTimeMillis() - t2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if(flag) break;
        }
    }

    public static void quickSort(int[] arr,int left,int right) {
        int p = (left + right) / 2;
        int pivot = arr[p];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < p && arr[i] < pivot) {
                i++;
            }
            if (i < p) {
                arr[p] = arr[i];
                p = i;
            }
            while (p<j && arr[j]>= pivot){
                j--;
            }
            if(p < j){
                arr[p] = arr[j];
                p = j;
            }
            arr[p] = pivot;
            if (p - left > 1) {
                quickSort(arr, left, p - 1);
            }
            if (right - p > 1) {
                quickSort(arr, p + 1, right);
            }
        }
    }
}
