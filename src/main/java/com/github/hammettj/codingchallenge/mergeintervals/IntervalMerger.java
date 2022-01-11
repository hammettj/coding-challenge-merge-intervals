package com.github.hammettj.codingchallenge.mergeintervals;

import com.github.hammettj.codingchallenge.mergeintervals.data.Interval;

import java.util.Collection;
import java.util.List;

/**
 * Instances of this class are capable of merging overlapping and non-overlapping intervals.
 */
public final class IntervalMerger {

    /**
     * Merges the given collection of intervals and returns them.
     *
     * @param intervals the list of intervals to merge.
     * @return an immutable list of the merged intervals.
     */
    public List<Interval> merge(final Collection<Interval> intervals) {
        // todo: implement merge algorithm
        return List.copyOf(intervals);
    }
}
