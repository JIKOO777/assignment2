package metrics;

public class PerformanceTracker {
    public long comparisons = 0;
    public long swaps = 0;
    public long reads = 0;
    public long writes = 0;

    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }
    public void incReads() { reads++; }
    public void incWrites() { writes++; }

    @Override
    public String toString() {
        return String.format("comparisons=%d, swaps=%d, reads=%d, writes=%d",
                comparisons, swaps, reads, writes);
    }
}
