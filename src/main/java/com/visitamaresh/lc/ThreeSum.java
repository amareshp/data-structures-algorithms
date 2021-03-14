package com.visitamaresh.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/3sum/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = getMap(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> twoIds = getTwoSum(map, nums, (0-nums[i]), i+1, nums.length-2);
            for(List<Integer> pair : twoIds) {
                List<Integer> three = new ArrayList<>();
                three.add(i);
                three.addAll(pair);
                result.add(three);
            }
        }
        return result;
    }


    public List<List<Integer>> getTwoSum(Map<Integer, List<Integer>> map, int[] nums, int sum, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            if(map.containsKey(sum - nums[i])) {
                List<Integer> ids = new ArrayList<>();
                ids.add(i);
                int otherId = map.get(sum - nums[i]).get(0);
                ids.add(otherId);
                result.add(ids);
            }
        }
        return result;
    }

    public Map<Integer, List<Integer>> getMap(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> ids = new ArrayList<>();
                ids.add(i);
                map.put(nums[i], ids);
            }
        }
        return map;
    }
}
