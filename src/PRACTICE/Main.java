/*
This program is just for practicing.
 */

package PRACTICE;

import javax.lang.model.type.NullType;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        System.out.println(array.toString());

//        String braces = "[()]{}";
//        ArrayList<Character> chars = new ArrayList<Character>();
//
//        for (int i = 0; i < braces.length(); i++) {
//            chars.add(braces.charAt(i));
//        }
//
//        for (int i = 0; i < chars.size(); i++) {
//            checkBrace(chars.get(i));
//        }
    }

    public static boolean checkBrace(char brace) {
        switch (brace) {
            case ']':
                System.out.println("CLOSED.");
                return false;
            case ')':
                System.out.println("CLOSED.");
                return false;
            case '}':
                System.out.println("CLOSED.");
                return false;
            case '[':
                System.out.println("OPEN BRACE");
                return true;
            case '(':
                System.out.println("OPEN BRACE");
                return true;
            case '{':
                System.out.println("OPEN BRACE");
                return true;
            default:
                return true;
        }
    }
}

