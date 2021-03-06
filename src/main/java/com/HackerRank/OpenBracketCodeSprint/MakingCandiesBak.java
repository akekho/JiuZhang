package com.HackerRank.OpenBracketCodeSprint;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-15.
 */
public class MakingCandiesBak {
    private final static Logger logger = LoggerFactory.getLogger(MakingCandiesBak.class);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // input
        Scanner scan = new Scanner(System.in);
        new MakingCandiesBak().makeCandies(scan);
    }

    private void makeCandies(Scanner scan) {
        long m = scan.nextLong();
        long w = scan.nextLong();
        long p = scan.nextLong();
        long needToMake = scan.nextLong();
        long passCounter = 0;

        // compute
        long leftOver = 0;
        if (m < w) {
            long tmp = m;
            m = w;
            w = tmp;
        }
        while (leftOver < needToMake) {
//            long candy = m * w + leftOver;
            long delta = (m * w) / p + leftOver / p + ((m % p * (w % p)) % p + leftOver % p) / p;
//            leftOver = candy % p;
            leftOver = ((m % p * (w % p)) % p + leftOver % p) % p;
            if (delta <= m - w) {
                w += delta;
            } else {
                delta -= m - w;
                w = m;
                long less = delta / 2;
                long more = delta - less;
                m += more;
                w += less;
            }
            if (p > delta) {
                for (long i = 0; i < delta; i++) {
                    needToMake -= p;
                }
            } else {
                for (long i = 0; i < p; i++) {
                    needToMake -= delta;
                }
            }

            passCounter++;
        }

        // return ans
        System.out.println(passCounter);
    }
}
