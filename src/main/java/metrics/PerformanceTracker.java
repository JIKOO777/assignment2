@"
        package metrics;
public class PerformanceTracker {
    public long comparisons, swaps, reads, writes;
    public void reset() { comparisons = swaps = reads = writes = 0; }
    public int cmp(int a, int b) { comparisons++; return Integer.compare(a, b); }
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; reads++;
        arr[i] = arr[j]; writes++; reads++;
        arr[j] = tmp;    writes++;
        swaps++;
    }
}
"@ | Set-Content src/main/java/metrics/PerformanceTracker.java -Encoding UTF8
