package com.github.hammettj.codingchallenge.mergeintervals.data;

import static java.lang.Integer.compare;
import static java.lang.Math.max;
import static java.util.Objects.requireNonNull;

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

    /**
     * Checks if this interval overlaps with the given interval.
     *
     * @param interval the interval to check for an intersection.
     * @return true if the both intervals overlap, false otherwise
     */
    public boolean overlaps(final Interval interval) {
        return begin <= requireNonNull(interval).end;
    }

    /**
     * Expands the end of this interval if necessary and returns a new instance, leaving this interval unchanged.
     *
     * @param interval the interval up to which to expand (if necessary)
     * @return a new instance with the end probably expanded
     */
    public Interval expandEndTo(final Interval interval) {
        requireNonNull(interval);
        return new Interval(begin, max(end, interval.end()));
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
