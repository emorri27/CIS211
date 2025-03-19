package LAB_07;

public class HashMap<K, V> {
    private final int DEFAULT_CAPACITY = 10;
    private int CAPACITY;
    private K[] keys;
    private V[] values;
    private int count = 0;
    private final int SEED = 31;

    public HashMap() {
        CAPACITY = DEFAULT_CAPACITY;
        keys = (K[])(new Object[DEFAULT_CAPACITY]);
        values = (V[])(new Object[DEFAULT_CAPACITY]);
    }

    public HashMap(int size) {
        CAPACITY = size;
        keys = (K[])(new Object[size]);
        values = (V[])(new Object[size]);
    }

    public void put(K key, V value) {
        int index = hashFunction(key);
        keys[index] = key;
        values[index] = value;
        count++;
    }

    public V get(K key) {
        int index = hashFunction(key);
        return values[index];
    }

    public int hashFunction(K key) {
        int index = 0;

        for (int i = 0; i < key.toString().length(); i++) {
            index += key.toString().charAt(i);
        }

        return midSquare(index) % CAPACITY;
    }

    private static int midSquare(int n) {
        n++;
        n *= n;

        String num = String.valueOf(n);
        num = num.substring(1,4);
        return Integer.parseInt(num);
    }
}
