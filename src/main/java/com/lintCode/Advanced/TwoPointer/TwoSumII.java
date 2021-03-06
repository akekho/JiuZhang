package com.lintCode.Advanced.TwoPointer;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-18.
 */
public class TwoSumII {
    private final static Logger logger = LoggerFactory.getLogger(TwoSumII.class);

    public static void main(String[] arg) {
        new TwoSumII().testTwoSumII();
    }

    private void testTwoSumII() {
        logger.info("{}", twoSum2(new int[]{2, 7, 11, 15}, 24));
    }

    /**
     * @param nums:   an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        // handle extreme cases
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // sort
        Arrays.sort(nums);
        // two pointer
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int counter = 0;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                int tmp = j - i;
                counter += tmp;
                j--;
            } else {
                i++;
            }
        }

        return counter;
    }
}
