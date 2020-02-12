package com.algorithms.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author - navsinn
 */
public class MergeKSortedArrays {
    class Element implements Comparable<Element> {
        int value;
        int index;
        int arrIndex;
        Element(int value, int index, int arrIndex) {
            this.value = value;
            this.index = index;
            this.arrIndex = arrIndex;
        }

        @Override
        public int compareTo(Element o) {
            return (this.value - o.value) > 0 ? 1 : -1;
        }
    }

    PriorityQueue<Element> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        int[][] arr= {{2, 6, 12},
                      {1, 9},
                      {23, 34, 90, 2000, }};
        MergeKSortedArrays mergeArrays = new MergeKSortedArrays();
        mergeArrays.mergeOutput(arr);
    }

    private Integer[] mergeOutput(int[][] arrays) {
        int numArray = arrays.length;
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<numArray; i++) {
            queue.add(new Element(arrays[i][0], 0, i));
        }

        while(!queue.isEmpty()) {
            Element elm = queue.remove();
            result.add(elm.value);
            if(elm.index < arrays[elm.arrIndex].length-1) {
                queue.add(new Element(arrays[elm.arrIndex][elm.index+1], elm.index + 1, elm.arrIndex));
            }
        }

        return result.toArray(new Integer[result.size()]);
    }
}
