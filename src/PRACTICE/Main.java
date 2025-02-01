/*
This program is just for practicing.
 */

package PRACTICE;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(141));
    }

    public static boolean isPalindrome(int num) {
        String[] digits = String.valueOf(num).split("");
        int size = digits.length;

        switch (size % 2) {
            case 0:
                for (int i = 0; i < size; i++) {
                    for (int j = i + 1; j < size; j++) {
                        if (digits[i] != digits[j]) {
                            return false;
                        }
                    }
                }
            case 1:
                int middle = (size - 1) / 2;
                for (int i = 0; i < middle; i++) {
                    for (int j = size; j > middle; j--) {
                            if (digits[i] != digits[j]) {
                                return false;
                            }
                    }
                }
        }
        return true;
    }
}
