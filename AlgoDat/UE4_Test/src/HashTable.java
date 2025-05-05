import java.util.Arrays;

public class HashTable {
    public static void main(String[] args) {
        int[] h = new int[7];
        int[] c = new int[h.length];
        add(8, h, c);
        add(1, h, c);
        add(13, h, c);
        add(6, h, c);
        add(3, h, c);

        System.out.println(Arrays.toString(h));
        System.out.println(Arrays.toString(c));
        System.out.println(find1(3, h, c));

        int f1Steps = 0, f2Steps = 0;
        for (int i = 0; i < 100; i++) {
            f1Steps += find1(i, h, c);
        }

        for (int i = 0; i < 100; i++) {
            f2Steps += find2(i, h, c);
        }
        System.out.println(f1Steps + " Flo vs. Sammy " + f2Steps);
    }

    public static int h1(int key) {
        return (key + 7) % 7;
    }

    public static int h2(int key) {
        return ((key + 6) % 6) + 1;
    }

    public static void add(int key, int[] h, int[] c) {
        c[h1(key)]++;
        for (int i = 0; i < h.length; i++) {
            int pos = (h1(key) + i * h2(key)) % 7;
            if (h[pos] == 0) {
                h[pos] = key;
                return;
            }
        }
    }

    public static int find1(int key, int[] h, int[] c) {
        int j = h1(key);
        int n = c[j];
        int steps = 1;
        for (int i = 0; i < n && n < h.length; i++) {
            int pos = (h1(key) + i * h2(key)) % 7;
            if (h[pos] == key) {
                System.out.println("Found key " + key + " in " + (i + 1) + " steps");
                return i;
            } else if (i == n - 1) {
                n += c[pos];
            }
            steps++;
        }
        System.out.println(key + " not there. checked " + (steps) + " times");
        return steps;
    }

    public static int find2(int key, int[] h, int[] c) {
        int j = h1(key);
        Y lol = (Y)null;
        if (c[j] == 0) {
            return 0;
        }
        int steps = 0;
        int count = c[j];
        for (int i = 0; i < h.length; i++) {
            int pos = (h1(key) + i * h2(key)) % 7;
            if (h[pos] == key) {
                System.out.println("Found key " + key + " in " + (i + 1) + " steps");
                return i;
            }
            if (h1(h[pos]) == j) {
                count--;
            }
            if (count < 0) {
                System.out.println(key + " not there. checked " + (i + 1) + " times");
                return i;
            }
            steps++;
        }
        return steps;
    }


}