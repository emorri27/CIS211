package Mergesort;

public class Mergesort {
    public static void main(String[] args) {
        int[] nums = {7, 5, 1, 3, 4, 6, 2};
        for (int i: nums) {
            System.out.print(i + " ");
        }

        int[] sortedNums = Mergesort(nums);

        System.out.println("");
        for (int i: sortedNums) {
            System.out.print(i + " ");
        }
    }

    public static int[] Mergesort(int[] nums) {
        int[] sortedNums = new int[nums.length];
        int splitIdx = nums.length / 2;
        int[] arrayA;
        int countArrayA = 0;
        int[] arrayB;
        int countArrayB = 0;

        arrayA = new int[splitIdx];
        if (nums.length % 2 == 0) {
            arrayB = new int[splitIdx];
        } else {
           arrayB = new int[splitIdx + 1];
        }


        for (int i = 0; i < nums.length; i++) {
            if (i < splitIdx) {
                arrayA[countArrayA++] = nums[i];
            } else {
                arrayB[countArrayB++] = nums[i];
            }
        }
        if (arrayA.length > 1) {
            arrayA = Mergesort(arrayA);
        }
        if (arrayB.length > 1) {
            arrayB = Mergesort(arrayB);
        }

        int itrA = 0;
        int itrB = 0;

        int i = 0;
        while (itrA < arrayA.length && itrB < arrayB.length) {
            if (arrayA[itrA] < arrayB[itrB]) {
                sortedNums[i] = arrayA[itrA];
                itrA++;
            } else {
                sortedNums[i] = arrayB[itrB];
                itrB++;
            }
            i++;
        }

        while (itrA < arrayA.length) {
            sortedNums[i++] = arrayA[itrA++];
        }
        while (itrB < arrayB.length) {
            sortedNums[i++] = arrayB[itrB++];
        }

        return sortedNums;
    }

    public static void addNum(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = value;
                return;
            }
        }
    }
}
