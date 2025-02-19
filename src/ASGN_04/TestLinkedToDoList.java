/*
Course: CIS211-400
Author: Elliott Morris
Assignment: Module 2-4, Assignment: To Do List App
Date: 2/18/2025
Description: This program implements a To Do List using linked nodes.
Users can add, remove, view, and clear tasks.

I wrote all the code submitted, and I have provided citations and references where appropriate.
 */

package ASGN_04;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestLinkedToDoList {
    public static void main(String[] args) {
        LinkedToDoList toDoList = new LinkedToDoList();
        String menuString = "\nTo Do List App Menu:\n1. Add Item\n2. Remove Item\n3. View List\n4. Clear List\n5. Exit";
        Scanner keys = new Scanner(System.in);
        int choice;
        String task;
        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println(menuString);
            try {
                choice = keys.nextInt();
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid input. Please enter a number 1-5.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number 1-5.");
                keys.nextLine();
                continue;
            }
            switch (choice) {
                case 1:
                    keys.nextLine();
                    System.out.println("What task would you like to add?");
                    task = keys.nextLine();
                    toDoList.addTask(task);
                    System.out.println("'" + task + "' added to To Do List.");
                    break;
                case 2:
                    keys.nextLine();
                    System.out.println("What task would you like to remove?");
                    task = keys.nextLine();
                    try {
                        toDoList.removeTask(task);
                        System.out.println("\n'" + task + "' removed from the To Do List.");
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    keys.nextLine();
                    System.out.println(toDoList.toString());
                    break;
                case 4:
                    toDoList.clearAllTasks();
                    System.out.println("\nAll tasks have been cleared.");
                    break;
                case 5:
                    continueMenu = false;
                    break;
            }
        }
    }
}
