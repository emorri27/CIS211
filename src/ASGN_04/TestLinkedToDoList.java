package ASGN_04;

public class TestLinkedToDoList {
    public static void main(String[] args) {
        LinkedToDoList myToDoList = new LinkedToDoList();
        myToDoList.addTask("Clean room");
        myToDoList.addTask("Make dinner");
        myToDoList.addTask("Go shopping");
        myToDoList.addTask("Go to work");
        System.out.println(myToDoList.toString());

        myToDoList.removeTask("Clean room");
        System.out.println(myToDoList.toString());
        myToDoList.removeTask("Go to work");
        System.out.println(myToDoList.toString());
        myToDoList.removeTask("Go shopping");
//        myToDoList.removeTask("Make dinner");
        System.out.println(myToDoList.toString());


    }
}
