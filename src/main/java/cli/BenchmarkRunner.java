package cli;

import algorithms.GapStrategy;
import algorithms.ShellSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        int n = 10000;
        String dist = "random";
        GapStrategy strat = GapStrategy.KNUTH;
        int reps = 5;
        String csv = "docs/performance-plots/run.csv";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--n": n = Integer.parseInt(args[++i]); break;
                case "--dist": dist = args[++i]; break;
                case "--strategy": strat = GapStrategy.valueOf(args[++i].toUpperCase()); break;
                case "--reps": reps = Integer.parseInt(args[++i]); break;
                case "--csv": csv = args[++i]; break;
            }
        }

        warmup();

        try (PrintWriter out = new PrintWriter(new FileWriter(csv, true))) {
            out.println("n,distribution,strategy,time_ns,comparisons,swaps,reads,writes");
            for (int r = 0; r < reps; r++) {
                int[] a = makeArray(n, dist);
                PerformanceTracker t = new PerformanceTracker();
                long t0 = System.nanoTime();
                ShellSort.sort(a, strat, t);
                long t1 = System.nanoTime();
                out.printf(Locale.US, "%d,%s,%s,%d,%d,%d,%d,%d%n",
                        n, dist, strat, (t1 - t0), t.comparisons, t.swaps, t.reads, t.writes);
            }
        }
    }

    private static void warmup() {
        int[] a = makeArray(10_000, "random");
        ShellSort.sort(a, GapStrategy.KNUTH, new PerformanceTracker());
    }

    private static int[] makeArray(int n, String d) {
        Random rnd = new Random(42);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = rnd.nextInt();
        switch (d) {
            case "sorted":   Arrays.sort(a); break;
            case "reversed": Arrays.sort(a); reverse(a); break;
            case "nearly":   Arrays.sort(a); shuffleSome(a, 0.05); break;
            default: break;
        }
        return a;
    }

    private static void reverse(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int t = a[i]; a[i] = a[j]; a[j] = t;
        }
    }

    private static void shuffleSome(int[] a, double frac) {
        Random rnd = new Random(7);
        int m = (int)(a.length * frac);
        for (int k = 0; k < m; k++) {
            int i = rnd.nextInt(a.length), j = rnd.nextInt(a.length);
            int t = a[i]; a[i] = a[j]; a[j] = t;
        }
    }
}
