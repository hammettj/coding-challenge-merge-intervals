package com.github.hammettj.codingchallenge.mergeintervals.cli;

import com.github.hammettj.codingchallenge.mergeintervals.IntervalMerger;
import com.github.hammettj.codingchallenge.mergeintervals.data.Interval;

import java.util.List;

/**
 * This class is used as an entry-point for the command line interface.
 */
public final class App {

    /**
     * Reads the given number of {@link Interval}s from {@code args}, merges them
     * and prints the result to the standard output.
     *
     * @param args the arguments passed to the command line.
     */
    public static void main(final String[] args) {
        try {
            final List<Interval> intervals = new ArgumentParser().parseArguments(args);

            final List<Interval> mergedIntervals = new IntervalMerger().merge(intervals);
            System.out.println(
                    String.join(" ",
                            mergedIntervals.stream()
                                    .map(Interval::toString)
                                    .toList()
                    )
            );
        } catch (final IllegalArgumentException e) {
            System.err.println(e.getMessage());

            printUsage();
            System.exit(1);
        }
    }

    /**
     * Prints the usage of this application.
     */
    private static void printUsage() {
        System.err.println("""
                
                USAGE: java -jar merge-intervals-1.0-SNAPSHOT.jar [begin,end]...
                
                EXAMPLE:
                    java -jar merge-intervals-1.0-SNAPSHOT.jar [15,29] [42,50] [13,37]
                """);
    }
}
