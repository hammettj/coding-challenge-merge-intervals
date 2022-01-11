package com.github.hammettj.codingchallenge.mergeintervals.data;

import static java.lang.Integer.compare;

/**
 * Representation of an interval.
 *
 * <p>An interval is composed of {@link Interval#begin} and {@link Interval#end} where {@link Interval#end}
 * must be greater than {@link Interval#begin}.</p>
 */
public record Interval(int begin, int end) implements Comparable<Interval> {
    /**
     * Creates a new instance of this class.
     *
     * @param begin the beginning of the interval.
     * @param end the end of the interval.
     * @throws IllegalArgumentException if end is not greater than begin.
     */
    public Interval {
        if (begin == end) {
            throw new IllegalArgumentException("begin and end must not be equal");
        }
        if (begin > end) {
            throw new IllegalArgumentException("begin must be less than end");
        }
    }

    @Override
    public int compareTo(final Interval interval) {
        final int res = compare(begin, interval.begin);
        return (res != 0) ? res : compare(end, interval.end);
    }

    @Override
    public String toString() {
        return "[" + begin + "," + end + "]";
    }
}
