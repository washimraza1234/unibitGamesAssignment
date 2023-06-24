package com.unibitGames;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayCombination {
    public static int[][] findCombinations(int[] nums, int target) {
        List<int[]> combinations = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] pair = {nums[i], nums[j]};
                    combinations.add(pair);
                }
            }
        }

        int[][] result = new int[combinations.size()][2];
        for (int i = 0; i < combinations.size(); i++) {
            result[i] = combinations.get(i);
        }
        return result;
    }

    public static int[][] findCombinationsForDoubleTarget(int[] nums, int target) {
        int doubleTarget = target * 2;
        List<int[]> combinations = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == doubleTarget) {
                            int[] quad = {nums[i], nums[j], nums[k], nums[l]};
                            combinations.add(quad);
                        }
                    }
                }
            }
        }

        int[][] result = new int[combinations.size()][4];
        for (int i = 0; i < combinations.size(); i++) {
            result[i] = combinations.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;

        int[][] combinations = findCombinations(nums, target);
        System.out.println("First Combination for \"" + target + "\": ");
        for (int[] combination : combinations) {
            System.out.println(Arrays.toString(combination));
        }

        int[] mergedArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(mergedArray);
        System.out.println("\nMerge Into a single Array: ");
        System.out.println(Arrays.toString(mergedArray));

        int[][] combinationsForDoubleTarget = findCombinationsForDoubleTarget(mergedArray, target);
        int doubleTarget = target * 2;
        System.out.println("\nSecond Combination for \"" + doubleTarget + "\": ");
        for (int[] combination : combinationsForDoubleTarget) {
            System.out.println(Arrays.toString(combination));
        }
    }
}
