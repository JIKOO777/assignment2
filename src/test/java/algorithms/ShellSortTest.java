@"
        package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {
    private void assertSorts(int[] input) {
        for (GapStrategy g : GapStrategy.values()) {
            int[] a = input.clone();
            int[] b = input.clone();
            Arrays.sort(b);
            ShellSort.sort(a, g, new PerformanceTracker());
            assertArrayEquals(b, a, "Failed for " + g);
        }
    }
    @Test void edge() { assertSorts(new int[]{}); assertSorts(new int[]{1}); assertSorts(new int[]{2,2,2}); }
    @Test void typical() {
        assertSorts(new int[]{5,1,4,2,8,0,2});
        assertSorts(new int[]{9,8,7,6,5,4,3,2,1,0});
        assertSorts(new int[]{0,1,2,3,4,5,6,7,8,9});
    }
    @Test void randomized() {
        int n = 1000; java.util.Random r = new java.util.Random(123);
        int[] a = new int[n]; for (int i=0;i<n;i++) a[i]=r.nextInt();
        assertSorts(a);
    }
    @Test void nullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> ShellSort.sort(null, GapStrategy.KNUTH, new PerformanceTracker()));
    }
}
"@ | Set-Content src/test/java/algorithms/ShellSortTest.java -Encoding UTF8
