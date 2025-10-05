@"
        package algorithms;
public enum GapStrategy { SHELL, KNUTH, SEDGEWICK }
"@ | Set-Content src/main/java/algorithms/GapStrategy.java -Encoding UTF8