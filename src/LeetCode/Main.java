package LeetCode;

import java.util.Arrays;

// LEETCODE
public class Main {
    public static void main(String[] args) {
        // TWO SUM TEST
        int[] nums = {2, 3, 3, 4, 1};
        System.out.println(Arrays.toString(TwoSum(nums, 4)));


    }

    public static int[] TwoSum(int[] nums, int target) {
        int size = nums.length;

        for (int i = 0; i < size; i++) {
                for (int j = i+1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


}