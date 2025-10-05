package algorithms;

import metrics.PerformanceTracker;

public class ShellSort {

    public static void sort(int[] a, GapStrategy strategy, PerformanceTracker tracker) {
        if (a == null) throw new IllegalArgumentException("array is null");
        int n = a.length;
        int[] gaps = switch (strategy) {
            case SHELL -> Gaps.shell(n);
            case KNUTH -> Gaps.knuth(n);
            case SEDGEWICK -> Gaps.sedgewick(n);
        };

        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                tracker.incReads();
                int temp = a[i];
                int j = i;
                while (j >= gap && a[j - gap] > temp) {
                    tracker.incComparisons();
                    tracker.incWrites();
                    a[j] = a[j - gap];
                    j -= gap;
                    tracker.incSwaps();
                }
                tracker.incWrites();
                a[j] = temp;
            }
        }
    }
}
