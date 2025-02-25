package LAB_05;

public class TestCircularArray {
    public static void main(String[] args) {
        DTCC_CircularArray list = new DTCC_CircularArray(5);

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("List: " + list.toString()); // Output: [10, 20, 30, 40, 50]

        list.remove(2); // Removes element 30 and shifts accordingly
        System.out.println("After removing index 2: " + list.toString()); // Output: [10, 20, 40, 50]

        list.add(60);
        System.out.println("After adding 60: " + list.toString()); // Output: [10, 20, 40, 50, 60]

        list.add(70); // Should throw an IllegalStateException
    }
}