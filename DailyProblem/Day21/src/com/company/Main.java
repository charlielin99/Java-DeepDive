package com.company;

/*
This problem was asked by Snapchat.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

*/

import java.util.*;

public class Main {

    public static class Meeting {
        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }


    public static int roomsRequired(List<Meeting> meetings) {
        Collections.sort(meetings, new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2) {
                return m1.getEndTime() - m2.getStartTime();
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(meetings.get(0).getEndTime());
        int count = 1;

        for (int i = 1; i < meetings.size(); i++) {
            if (meetings.get(i).getStartTime() < minHeap.peek()) {
                count++;
            } else {
                minHeap.poll();
            }
            minHeap.offer(meetings.get(i).getEndTime());
        }

        return count;
    }

    public static void main(String[] args) {
        List<Meeting> myList = new ArrayList<>();
        myList.add(new Meeting(30, 75));
        myList.add(new Meeting(0, 50));
        myList.add(new Meeting(60, 150));

        System.out.println(roomsRequired(myList));
    }
}
