package com.algorithms.misc;

/**
 * @author - navsinn
 * Find Intersection of all Intervals - https://www.geeksforgeeks.org/find-intersection-of-all-intervals/
 */
public class IntervalsIntersection {
    public static void main(String[] args) {
        int[][] intervals = {{1, 6}, {2, 8}, {3, 10}, {5, 8}};
        int min = intervals[0][0], max = intervals[0][1];
        for(int i=1; i< intervals.length; i++) {
            //no intersection
            if(max < intervals[i][0] || min > intervals[i][1]) {
                System.out.println("No common interval");
                System.exit(0);
            }
            min = Math.max(min, intervals[i][0]);
            max = Math.min(max, intervals[i][1]);
        }

        System.out.println("common interval:[" + min + ", " + max + "]");
    }
}
