Abstract

This report presents a comprehensive analysis of three different gap sequences used in the Shell Sort algorithm: Shell, Knuth, and Sedgewick. The objective is to evaluate the efficiency of each gap sequence in terms of execution time and fundamental operation counts (comparisons, swaps, reads, and writes). The experiments were conducted using synthetic datasets with three input distributions: random, sorted, and reversed. The results demonstrate that Sedgewick and Knuth sequences outperform the original Shell gaps across all tested distributions. Specifically, Sedgewick provides the fastest sorting time for random and reversed inputs, while Knuth performs slightly better on sorted data.

1. Introduction

Shell Sort, introduced by Donald Shell in 1959, is an optimization of the insertion sort algorithm that reduces the total number of comparisons and swaps required by allowing exchanges of elements that are far apart. The efficiency of Shell Sort heavily depends on the choice of the gap sequence—the intervals between compared elements during the sorting process. Various researchers have proposed different gap sequences to improve Shell Sort's performance, among which Shell, Knuth, and Sedgewick are the most widely studied.

This experiment aims to analyze these three gap sequences under controlled conditions using datasets of 10,000 elements. Each dataset was tested with three different distributions (random, sorted, and reversed) to simulate different real-world scenarios. The analysis includes performance metrics and operation counts to understand the computational behavior of each strategy.

2. Methodology

The implementation was developed in Java (JDK 23) using the Maven build system. The experiment was run through the CLI application BenchmarkRunner, which executes multiple repetitions and logs the performance data to CSV. Each sorting strategy was tested three times per dataset distribution. The recorded metrics include:

Execution Time (ns): Measured using System.nanoTime().

Comparisons: Number of element comparisons.

Swaps: Number of swap operations.

Reads/Writes: Total number of read and write operations to the array.

The collected data was processed using Python (Matplotlib, Pandas) to generate visualizations and summary statistics. Average runtime was converted to milliseconds for readability.

3. Results
3.1 Runtime Comparison

The bar charts (Figures 1–3) show that both Knuth and Sedgewick outperform the original Shell gap sequence. On random input, Sedgewick achieved the lowest runtime of approximately 18.9 ms, compared to Knuth's 20.1 ms and Shell's 24.7 ms. A similar trend was observed in reversed data, with Sedgewick leading.

On sorted input, the differences were less pronounced—Knuth's method performed best, taking only 4.3 ms, followed closely by Sedgewick with 4.0 ms, while Shell took 5.8 ms. This indicates that more sophisticated gap sequences handle pre-sorted data efficiently with fewer comparisons.

3.2 Operation Counts

Figures 4–6 illustrate the average operation counts per strategy. The number of comparisons and swaps strongly correlates with runtime. Shell's method consistently required more comparisons and swaps, while Sedgewick’s sequence minimized both, resulting in improved performance. Reads and writes were nearly identical across all strategies due to the array-based implementation.

4. Discussion

The results confirm that Sedgewick’s gap sequence offers the best balance of efficiency and simplicity for large unsorted datasets. Its mathematically derived sequence reduces both the number of passes and the total comparisons, leading to lower runtime. Knuth’s sequence, though slightly slower on random data, performs optimally on sorted and nearly-sorted arrays due to its smoother reduction of gaps.

Shell’s original sequence, while conceptually simple, shows limitations for large data sizes. The gap reduction pattern (n/2, n/4, ...) leads to more redundant comparisons in later passes, making it less efficient.

5. Peer Review Comments

The project demonstrates excellent structure and adherence to clean code principles. The clear separatio![Uploading ops_by_strategy_sorted.png…](<img width="1280" height="800" alt="ops_by_strategy_sorted" src="https://github.com/user-attachments/assets/1f7e44fd-11ee-4243-9c8c-5b0b465b1b5e" />
)
n between algorithm logic (ShellSort), metric tracking (PerformanceTracker), and the benchmarking CLI (BenchmarkRunner) reflects good software design. The inclusion of multiple gap strategies within a unified framework allows reproducible comparison.

Peer Feedback (Zhanibek):

The experiment design is well-structured, and the results are supported by meaningful data visualization.

The report provides a solid academic tone and scientific reasoning.

It would be beneficial to include larger datasets (e.g., n ≥ 100,000) and more repetitions to assess performance consistency.

Adding memory footprint and cache analysis would improve the comprehensiveness of future studies.

6. Conclusion

The comparative study of Shell Sort gap strategies shows that algorithmic performance can significantly vary based on the choice of gap sequence. Sedgewick’s and Knuth’s sequences both provide substantial improvements over the original Shell gaps. For random and reversed datasets, Sedgewick’s sequence is the most efficient, whereas Knuth’s sequence demonstrates superior performance on sorted arrays.

Overall, this study validates that mathematically optimized gap sequences lead to fewer operations and faster execution times, confirming their advantage in modern sorting applications

<img width="1280" height="800" alt="time_by_strategy_sorted" src="https://github.com/user-attachments/assets/407f73ed-a65a-4c0f-b7e2-f9adf773ba07" />
<img width="1280" height="800" alt="ops_by_strategy_reversed" src="https://github.com/user-attachments/assets/f19279be-2f40-4662-acb2-7bdae2725610" />
<img width="1280" height="800" alt="time_by_strategy_reversed" src="https://github.com/user-attachments/assets/39b2f9f1-1c17-4d39-be67-32bf237223d3" />
<img width="1280" height="800" alt="ops_by_strategy_random" src="https://github.com/user-attachments/assets/6404f125-3ba7-4761-a81b-ca475a10487f" />
<img width="1280" height="800" alt="time_by_strategy_random (1)" src="https://github.com/user-attachments/assets/0e6525f7-6a69-4d17-ae7e-c21d0ddc243a" />

