// Source: LeetCode
// https://leetcode.com/problems/course-schedule-ii/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create the adjacency list and the indegree array
        HashMap<Integer, LinkedList<Integer>> prereqMap = new HashMap<Integer, LinkedList<Integer>>();
        int[] indegree = new int[numCourses];

        // create result array
        int[] result = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            // update the prereq list for the specified task
            int sourceTask = prerequisites[i][0];
            int prereqTask = prerequisites[i][1];
            LinkedList<Integer> prereqs = prereqMap.getOrDefault(prereqTask, new LinkedList<Integer>());
            prereqs.add(sourceTask);
            prereqMap.put(prereqTask, prereqs);

            // update the indegree for the specified task
            indegree[sourceTask] += 1;
        }

        // create a queue for topological sort
        Queue<Integer> taskQueue = new LinkedList<Integer>();

        // queue tasks with zero indegree to start topological sort
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                taskQueue.offer(i);
            }
        }

        int i = 0;
        // topologically sort
        while (!taskQueue.isEmpty()) {
            // get the current task and its prereqs
            int task = taskQueue.remove();

            // add the current task to the result
            result[i] = task;

            // reduce the indegree of the prerequisite task
            if (prereqMap.containsKey(task)) {
                for (int prereq : prereqMap.get(task)) {
                    indegree[prereq] -= 1;

                    // enqueue the task when its indegree reaches zero (we've already processes all
                    // its prereqs)
                    if (indegree[prereq] == 0) {
                        taskQueue.offer(prereq);
                    }
                }
            }
            i++;
        }

        // it was not possible to sort topologically (a cycle exists)
        if (i != numCourses)
            return new int[0];

        return result;
    }
}