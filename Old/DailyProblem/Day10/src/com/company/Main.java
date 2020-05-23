package com.company;

/*
This problem was asked by Apple.

Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
*/


/*
1) calculate absolute times when a task get's added
2) push it into a priority queue with smallest absolute on top (binary heap)
3) have a runner that polls the queue once in a time interval (e.g. second)
and checks if top task is to be executed, pop items from the heap that need to be executed.
4) now, the question is, how long does the run take? can I execute it synchronously or
will this delay the scheduler? I could as well span into a thread pool to call run there.

a more sophisticated edge case is, if two items receive the same absolute time, is it
required to maintain order of insertion when running?
*/

import java.util.PriorityQueue;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static class Task implements Comparable<Task> {

        private String taskName;
        private int time;
        private int scheduledTime;

        public Task(String taskName, int time) {
            this.taskName = taskName;
            this.time = time;
        }

        public String getTaskName() {
            return taskName;
        }

        public int getTime() {
            return time;
        }

        public void setScheduledTime(int scheduledTime){
            this.scheduledTime = scheduledTime;
        }

        public int getScheduledTime(){
            return scheduledTime;
        }

        @Override
        public int compareTo(Task input) {
            return this.getTaskName().compareTo(input.getTaskName());
        }
    }


    private static PriorityQueue<Task> minHeap = new PriorityQueue<>();
    static long startTime;
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        initialize();

        while (true){
            System.out.println("Enter Task Name:");
            String taskName = myScanner.next();
            System.out.println("Enter Task Time (in milliseconds):");
            int taskTime = myScanner.nextInt();
            jobScheduler(new Task(taskName, taskTime));
        }
    }

    private static long getCurrentTime(){
        return new Date().getTime() - startTime;
    }

    private static void initialize(){
        Timer timer = new Timer();
        timer.schedule(new checkAndRun(), 0, 1);
        startTime = new Date().getTime();
    }

    private static void jobScheduler(Task task){
        int absoluteTime = (int)(getCurrentTime()) + task.getTime();
        //System.out.println(absoluteTime);
        task.setScheduledTime(absoluteTime);
        minHeap.add(task);
    }


    static class checkAndRun extends TimerTask {
        public void run() {
            if (!minHeap.isEmpty() && getCurrentTime() == minHeap.peek().getScheduledTime()){
                System.out.println("Executing: " + minHeap.poll().getTaskName());
            }
        }
    }
}