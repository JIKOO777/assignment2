import metrics.PerformanceTracker;

public class ShellSort {
    public static void sort(int[] a, GapStrategy strategy, PerformanceTracker t) {
        if (a == null) throw new IllegalArgumentException("array is null");
        if (t == null) t = new PerformanceTracker();
        t.reset();

        int n = a.length;
        int[] gaps = switch (strategy) {
            case SHELL -> Gaps.shell(n);
            case KNUTH -> Gaps.knuth(n);
            case SEDGEWICK -> Gaps.sedgewick(n);
        };
        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                int temp = a[i]; t.reads++;
                int j = i;
                while (j >= gap && t.cmp(a[j - gap], temp) > 0) {
                    a[j] = a[j - gap]; t.writes++;
                    j -= gap;
                }
                a[j] = temp; t.writes++;
            }
        }
    }
}
