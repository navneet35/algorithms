package com.algorithms.misc;

import java.util.*;

/**
 * @author - navsinn
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseFinish {
    public static void main(String[] args) {
        int[][] arr = {{1, 0}};
        CourseFinish t = new CourseFinish();
        System.out.println(t.canFinish(3, arr));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        return isCyclicDFS(numCourses, prerequisites);
        return !isCyclicBFS(numCourses, prerequisites);
    }

    private static boolean isCyclicDFS(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> depends = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();
        for(int i=0; i<prerequisites.length; i++) {
            int firstCourse = prerequisites[i][0];
            int secondCourse = prerequisites[i][1];
            if(!depends.containsKey(firstCourse)) {
                depends.put(firstCourse, new ArrayList<Integer>());
            }
            depends.get(firstCourse).add(secondCourse);
        }
        for(Integer c1 : depends.keySet()) {
            if(isCourseCyclic(c1, depends, visited, recStack))
                return false;
        }
        return true;
    }

    private static boolean isCourseCyclic(Integer c, Map<Integer, List<Integer>> depends, Set<Integer> visited, Set<Integer> recStack) {
        if(recStack.contains(c)) {
            return true;
        }
        if(visited.contains(c)){
            return false;
        }
        visited.add(c);
        recStack.add(c);
        if(depends.containsKey(c)) {
            for (Integer c1 : depends.get(c)) {
                if (isCourseCyclic(c1, depends, visited, recStack))
                    return true;
            }
        }
        recStack.remove(c);
        return false;
    }

    private static boolean isCyclicBFS(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> depends = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int visited = 0;
        Arrays.fill(indegree, 0);

        for(int i=0; i<prerequisites.length; i++) {
            int firstCourse = prerequisites[i][0];
            int secondCourse = prerequisites[i][1];
            if(!depends.containsKey(firstCourse)) {
                depends.put(firstCourse, new ArrayList<Integer>());
            }
            depends.get(firstCourse).add(secondCourse);
            indegree[secondCourse]++;
        }

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i); // course with 0 indegree
            }
        }

        while(!queue.isEmpty()) {
            int c = queue.poll();

            if(depends.containsKey(c)) {
                for (Integer dep : depends.get(c)) {
                    if (--indegree[dep] == 0) {
                        queue.add(dep);
                    }
                }
            }
            visited++;
        }

        return (visited != numCourses);
    }

}
