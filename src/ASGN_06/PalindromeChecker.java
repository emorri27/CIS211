package ASGN_06;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        DequeDoublyLinkedList DDLL = new DequeDoublyLinkedList();
        DDLL.addFront("apple");
        DDLL.addBack("banana");
        DDLL.addFront("orange");

        Scanner keys = new Scanner(System.in);
        boolean continueMenu = true;
        while (continueMenu) {
            System.out.println("===Palindrome Checker===");
            System.out.println("Note: This palindrome checker is case sensitive.");
            System.out.println("Enter word: ");
            String word = keys.nextLine();
            System.out.println("Is palindrome: " + isPalindrome(word));
        }
    }

    public static boolean isPalindrome(String word) {

        return true;
    }
}
