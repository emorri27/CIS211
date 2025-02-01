/*
This program is just for practicing.
 */

package PRACTICE;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(7));
        System.out.println(fizzBuzz(150));
        System.out.println(fizzBuzz(70));
    }

    public static String fizzBuzz(int num) {
        String[] output = new String[num];

        for (int i = 0; i < num; i++) {
            output[i] = String.valueOf(i+1);
        }

        if (num % 3 == 0 && num % 5 == 0) {
            for (int i = 2; i < num; i = i+3) {
                output[i] = "Fizz";
            }
            for (int i = 2; i < num; i = i+5) {
                output[i] = "Buzz";
            }
        } else if (num % 5 == 0) {
            for (int i = 2; i < num; i = i+5) {
                output[i] = "Buzz";
            }
        } if (num % 3 == 0) {
            for (int i = 2; i < num; i = i+3) {
                output[i] = "Fizz";
            }
        }
        return Arrays.toString(output);
    }
}
