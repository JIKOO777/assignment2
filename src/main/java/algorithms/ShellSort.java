package algorithms;

public class ShellSort {
    public static void sort(int[] a, GapStrategy strategy) {
        if (a == null) throw new IllegalArgumentException("array is null");
        int n = a.length;
        int[] gaps = switch (strategy) {
            case SHELL -> Gaps.shell(n);
            case KNUTH -> Gaps.knuth(n);
            case SEDGEWICK -> Gaps.sedgewick(n);
        };
        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                int temp = a[i];
                int j = i;
                while (j >= gap && a[j - gap] > temp) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = temp;
            }
        }
    }
}
