package com.visitamaresh.lc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Facebook tagged questions in Leetcode - https://leetcode.com/company/facebook/
 * Task Scheduler - https://leetcode.com/problems/task-scheduler/
 *
 */
public class TaskScheduler {
    static Character maxChar = null;
    public int leastInterval3(char[] tasks, int n) {
        Map<Character, Integer> map = getMap(tasks);
        List<Integer> counts = map.values().stream().collect(Collectors.toList());
        Collections.sort(counts);
        int units = 0;
        int setSize = Integer.MAX_VALUE;
        int setCount = 0;
        for(int i = 0; i < counts.size(); i++) {
            while ((counts.get(i) - setCount) > 0) {
                if(setSize < (n+1)) {
                    int pad = (n+1) - setSize;
                    units += pad;
                }
                units += counts.size() - i;
                setSize = counts.size() - i;
                setCount++;
            }
        }

        return units;
    }

    public int leastInterval4(char[] tasks, int n) {
        Map<Character, Integer> map = getMap(tasks);
        map.put(maxChar, (map.get(maxChar) - 1));
        int pads = 0;
        while (map.get(maxChar) > 0) {
            int otherCharCount = map.keySet().size() - 1;
            if(otherCharCount >= n) {
                takeNCharsOtherThan(map, maxChar, n);
            } else {
                takeNCharsOtherThan(map, maxChar, otherCharCount);
                pads += n - otherCharCount;
            }
            map.put(maxChar, (map.get(maxChar) - 1));
        }
        return (tasks.length + pads);
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = getMap(tasks);
        List<Integer> counts = new ArrayList<>(map.values());
        Collections.sort(counts, Collections.reverseOrder());
        int pads = 0;
        int nextElements = 0;
        counts.set(0, counts.get(0) - 1);
        while (counts.get(0) > 0) {
            if((counts.size() - 1) >= n) {
                nextElements = n;
            } else {
                nextElements = counts.size() - 1;
                pads += n - (counts.size() - 1);
            }
            for(int i = 1; i <= nextElements; i++) {
                counts.set(i, counts.get(i) - 1);
                if(counts.get(i) == 0) {
                    counts.remove(i);
                    i--;
                    nextElements--;
                }
            }
            counts.set(0, counts.get(0) - 1);
        }
        return tasks.length + pads;
    }

    public void takeNCharsOtherThan(Map<Character, Integer> map, Character exclude, int n) {
        Set<Character> others = new HashSet<>(map.keySet());
        others.remove(exclude);
        Iterator<Character> iterator = others.iterator();
        for(int i = 0; i < n; i++) {
            Character c = iterator.next();
            int newVal = map.get(c) - 1;
            if(newVal == 0) {
                map.remove(c);
            } else {
                map.put(c, newVal);
            }
        }
    }

    public Map<Character, Integer> getMap(char[] tasks) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        for(char c : tasks) {
            if(map.containsKey(c)) {
                int val = map.get(c) + 1;
                map.put(c, val);
            } else {
                map.put(c, 1);
            }
            if(map.get(c) > maxCount) {
                maxCount = map.get(c);
                maxChar = c;
            }
        }
        return map;
    }

    public static void testTaskScheduler() {
        TaskScheduler t = new TaskScheduler();
        char[] arr = new char[] {'A', 'A', 'A', 'B', 'B', 'B'};
        int result = t.leastInterval(arr, 2);
        System.out.printf("Steps needed = %d%n", result);

        result = t.leastInterval(arr, 0);
        System.out.printf("Steps needed = %d%n", result);

        arr = new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'};
        result = t.leastInterval(arr, 2);
        System.out.printf("Steps needed = %d%n", result);

    }

}
