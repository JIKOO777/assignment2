@"
        package algorithms;
import java.util.*;

public final class Gaps {
    private Gaps() {}

    // Shell: n/2, n/4, ..., 1
    public static int[] shell(int n) {
        List<Integer> g = new ArrayList<>();
        for (int h = n / 2; h > 0; h /= 2) g.add(h);
        return g.stream().mapToInt(Integer::intValue).toArray();
    }

    // Knuth: 1, 4, 13, 40, ... (используем в убывающем порядке)
    public static int[] knuth(int n) {
        List<Integer> g = new ArrayList<>();
        int h = 1;
        while (h < n) { g.add(h); h = 3*h + 1; }
        Collections.reverse(g);
        return g.stream().mapToInt(Integer::intValue).toArray();
    }

    // Sedgewick 1986: объединяем две формулы, убираем дубликаты, убывание
    public static int[] sedgewick(int n) {
        java.util.TreeSet<Integer> set = new java.util.TreeSet<>();
        for (int k = 0; ; k++) {
            long f1 = (long)(9 * Math.pow(4, k) - 9 * Math.pow(2, k) + 1);
            long f2 = (long)(Math.pow(4, k) - 3 * Math.pow(2, k) + 1);
            boolean added = false;
            if (f1 > 0 && f1 < n) { set.add((int)f1); added = true; }
            if (f2 > 0 && f2 < n) { set.add((int)f2); added = true; }
            if (!added) break;
        }
        var g = new ArrayList<>(set);
        Collections.reverse(g);
        return g.stream().mapToInt(Integer::intValue).toArray();
    }
}
"@ | Set-Content src/main/java/algorithms/Gaps.java -Encoding UTF8
