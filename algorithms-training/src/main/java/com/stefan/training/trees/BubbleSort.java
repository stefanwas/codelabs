package com.stefan.training.trees;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] in = {5, 8 , 6, 2, 1, 4, 5};


        int[] out = bubbleSort(in);

        System.out.println("OUT=" + Arrays.toString(out));

    }

    public static int[]  bubbleSort(int[] a) {

        if (a.length <= 1) {
            return a;
        }

        for (int s = a.length - 1; s > 0; s--) {

            for (int i = 0; i < s; i++) {
                int l = a[i];
                int r = a[i+1];

                if (l > r) {
                    a[i] = r;
                    a[i+1] = l;
                }
            }

            System.out.println("A" + s + "=" + Arrays.toString(a));

        }

        return a;
    }


}
