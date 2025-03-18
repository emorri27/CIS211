/*
Course: CIS211-400
Author: Elliott Morris
Assignment: Module 6, Assignment: DLL Deque
Date: 3/8/2025
Description: This program implements a doubly linked list based deque (DequeDoublyLinkedList) and uses it to check for palindromes.
The PalindromeChecker program reads user input, stores characters in the deque, and determines if the word is a palindrome by comparing elements from both ends.

I wrote all the code submitted, and I have provided citations and references where appropriate.
*/


package ASGN_06;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {

        Scanner keys = new Scanner(System.in);
        boolean continueMenu = true;
        while (continueMenu) {
            System.out.println("\n===Palindrome Checker===");
            System.out.println("Note: This palindrome checker is case sensitive.");
            System.out.println("Enter word: ");

            String word = keys.nextLine();
            DequeDoublyLinkedList<String> DDLL = new DequeDoublyLinkedList<>();
            String[] chars = word.split("");
            for (int i = 0; i < chars.length; i++) {
                DDLL.addBack(chars[i]);
            }
            System.out.println("Is palindrome: " + isPalindrome(DDLL));
        }
    }

    public static boolean isPalindrome(DequeDoublyLinkedList<String> wordSplit) {
        while (wordSplit.length() > 1) {
            if (!wordSplit.removeFront().equals(wordSplit.removeBack())) return false;
        }
        return true;
    }
}
