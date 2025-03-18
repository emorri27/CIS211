package ASGN_06;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        DequeDoublyLinkedList DDLL = new DequeDoublyLinkedList();

        Scanner keys = new Scanner(System.in);
        boolean continueMenu = true;
        while (continueMenu) {
            System.out.println("===Palindrome Checker===");
            System.out.println("Note: This palindrome checker is case sensitive.");
            System.out.println("Enter word: ");
            String word = keys.nextLine();
            String[] chars = word.split("");
            for (int i = 0; i < chars.length; i++) {
                DDLL.addBack(chars[i]);
            }
            System.out.println("Is palindrome: " + isPalindrome(DDLL));
        }
    }

    public static boolean isPalindrome(DequeDoublyLinkedList wordSplit) {
        if (wordSplit.length() == 0 || wordSplit.length() == 1) return true;
        if (!wordSplit.getFront().equals(wordSplit.getBack())) return false;
        return isPalindrome(wordSplit);
    }
}
