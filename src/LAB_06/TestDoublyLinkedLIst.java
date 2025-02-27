package LAB_06;

public class TestDoublyLinkedLIst {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add("A");
        dll.add("B");
        dll.add("C");
        dll.add("D");
        dll.add("E");

        dll.remove(1);
    }
}
