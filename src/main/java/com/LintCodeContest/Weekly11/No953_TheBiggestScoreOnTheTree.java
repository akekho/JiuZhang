package com.LintCodeContest.Weekly11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.function.BiConsumer;

public class No953_TheBiggestScoreOnTheTree {
    private final static Logger logger = LoggerFactory.getLogger(No953_TheBiggestScoreOnTheTree.class);

    public static void main(String[] args) {
        No953_TheBiggestScoreOnTheTree No953_TheBiggestScoreOnTheTree = new No953_TheBiggestScoreOnTheTree();
        No953_TheBiggestScoreOnTheTree.testNo953_TheBiggestScoreOnTheTree();
    }

    private void testNo953_TheBiggestScoreOnTheTree() {
        MyLogger.info("result 3 v.s. " + getMaxScore(new int[]{0, 0, 0}, new int[]{1, 2, 3}, new int[]{1, 1, 1}, new int[]{1, 1, 2, 3}));
        MyLogger.info("result 4 v.s. " + getMaxScore(new int[]{0, 0}, new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2, 5}));
        MyLogger.info("result 3 v.s. " + getMaxScore(new int[]{0, 0, 0, 0}, new int[]{1, 2, 3, 4}, new int[]{2, 2, 1, 1}, new int[]{1, 4, 4, 3, 3}));
        MyLogger.info("result 104 v.s. " + getMaxScore(new int[]{0, 1, 2, 3, 3, 3, 1, 7, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{47, 48, 44, 95, 84, 61, 51, 86, 43}, new int[]{77, 41, 27, 19, 71, 17, 35, 84, 61, 2}));
    }

    int getMaxScore(int[] x, int[] y, int[] cost, int[] profit) {
//         filter abnormal cases
        if (x == null || x.length == 0) {
            return 0;
        }

        HashMap<Integer, TreeNode> nodeMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < x.length; i++) {
            if (!nodeMap.containsKey(x[i])) {
                nodeMap.put(x[i], new TreeNode(x[i]));
            }
            if (!nodeMap.containsKey(y[i])) {
                nodeMap.put(y[i], new TreeNode(y[i]));
            }
            nodeMap.get(x[i]).next.put(nodeMap.get(y[i]), cost[i]);
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> sumQueue = new ArrayDeque<>();
        queue.add(nodeMap.get(0));
        sumQueue.add(profit[0]);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int currentSum = sumQueue.poll();
            System.out.println(node.index + ": " + currentSum);
            max = Math.max(max, currentSum);
            node.next.forEach(new BiConsumer<TreeNode, Integer>() {
                @Override
                public void accept(TreeNode treeNode, Integer cost) {
                    queue.add(treeNode);
                    sumQueue.add(currentSum + profit[treeNode.index] - cost);
                }
            });
        }

        // return the final result
        return max;
    }

    class TreeNode {
        int index;
        HashMap<TreeNode, Integer> next;

        public TreeNode(int index) {
            this.index = index;
            this.next = new HashMap<>();
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "index=" + index +
                    ", next=" + next +
                    '}';
        }
    }

//    int getMaxScore(int[] x, int[] y, int[] cost, int[] profit) {
////         filter abnormal cases
//        if (x == null || x.length == 0) {
//            return 0;
//        }
//
//        int max = profit[1] - cost[0];
//        for (int i = 1; i < y.length; i++) {
//            max = Math.max(max, profit[i + 1] - cost[i]);
//        }
//        max += profit[0];
//
//        // return the final result
//        return max;
//    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
