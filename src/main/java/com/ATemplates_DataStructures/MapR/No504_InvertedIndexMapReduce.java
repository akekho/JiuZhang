package com.ATemplates_DataStructures.MapR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class No504_InvertedIndexMapReduce {
    private final static Logger logger = LoggerFactory.getLogger(No504_InvertedIndexMapReduce.class);

    public static void main(String[] args) {
        No504_InvertedIndexMapReduce No504_InvertedIndexMapReduce = new No504_InvertedIndexMapReduce();
        No504_InvertedIndexMapReduce.testNo504_InvertedIndexMapReduce();
    }

    private void testNo504_InvertedIndexMapReduce() {
//        MyLogger.info("result 2 v.s. " + functionName("12"));
    }

    class OutputCollector<K, V> {
        public void collect(K key, V value);
        // Adds a key/value pair to the output buffer
    }

    class Document {
        public int id;
        public String content;
    }

    public class InvertedIndex {
        public static class Map {
            public void map(String _, Document value,
                            OutputCollector<String, Integer> output) {
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, int value);
                String[] words = value.content.split(" ", -1);
                for (String word : words) {
                    if (word != null && !word.isEmpty()) {
                        output.collect(word, value.id);
                    }
                }
            }
        }

        public static class Reduce {
            public void reduce(String key, Iterator<Integer> values,
                               OutputCollector<String, List<Integer>> output) {
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, List<Integer> value);
                HashSet<Integer> ids = new HashSet<>();
                while (values.hasNext()) {
                    ids.add(values.next());
                }
                output.collect(key, new ArrayList<>(ids));
            }
        }
    }

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
