package com.ATemplates_DataStructures.Heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by yanli on 2016-10-02.
 */
public class Heapify {
    private final static Logger logger = LoggerFactory.getLogger(Heapify.class);

    public static void main(String[] arg) {
        new Heapify().testHeapify();
    }

    private void testHeapify() {
        int[] ints = new int[]{3, 2, 1, 4, 5};
        heapify(ints);
        logger.info(Arrays.toString(ints));
        ints = new int[]{45, 39, 32, 11};
        heapify(ints);
        logger.info(Arrays.toString(ints));
    }

    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length < 2) {
            return;
        }

        int n = A.length;
        for (int i = 1; i < n; i++) {
            int current = i;
            while (current > 0) {
                int parent = (current - 1) / 2;
//                if (i == 3) {
//                    System.out.println("3 = " + Arrays.toString(A) + "; current = " + current + "; parent= " + parent);
//                }
                if (A[parent] > A[current]) {
                    swap(A, parent, current);
                    current = parent;
                } else {
                    break;
                }
            }
//            System.out.println(Arrays.toString(A));
        }

        return;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
