package ASGN_04;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestLinkedToDoList {
    public static void main(String[] args) {
        LinkedToDoList toDoList = new LinkedToDoList();
        String menuString = "\nTO DO List App Menu:\n1. Add Item\n2. Remove Item\n3. View List\n4. Clear List\n5. Exit";
        Scanner keys = new Scanner(System.in);
        String task;
        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println(menuString);
            switch (keys.nextInt()) {
                case 1:
                    keys.nextLine();
                    System.out.println("What task would you like to add?");
                    task = keys.nextLine();
                    toDoList.addTask(task);
                    System.out.println(task + " added to To Do List.");

                    break;
                case 2:
                    keys.nextLine();
                    System.out.println("What task would you like to remove?");
                    task = keys.nextLine();
                    try {
                        toDoList.removeTask(task);
                    } catch (NoSuchElementException e) {
                        System.out.println(e);
                    }

                    break;
                case 3:
                    keys.nextLine();
                    System.out.println(toDoList.toString());
                    break;
                case 4:
                    toDoList.clearAllTasks();
                    break;
                case 5:
                    continueMenu = false;
                    break;
            }
        }
    }
}
