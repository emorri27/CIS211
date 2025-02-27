/*
This program is just for practicing.
 */

package PRACTICE;

public class Main {
    public static void main(String[] args) {
        MyMap<String, Integer> phoneBook = new MyMap<>();
        phoneBook.put("me", 123456789);
        phoneBook.put("police", 911);

        System.out.println(phoneBook.get("me"));
        System.out.println(phoneBook.get("police"));
    }
}