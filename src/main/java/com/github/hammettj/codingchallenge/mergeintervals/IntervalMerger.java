package com.github.hammettj.codingchallenge.mergeintervals;

import com.github.hammettj.codingchallenge.mergeintervals.data.Interval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;

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
        if (requireNonNull(intervals).isEmpty()) {
            return emptyList();
        }

        final List<Interval> merged = new ArrayList<>();
        // hint: use a SortedSet as this does not only sort elements but also removes duplicates
        final SortedSet<Interval> sorted = new TreeSet<>(intervals);

        final Iterator<Interval> iterator = sorted.iterator();
        Interval minInterval = iterator.next();
        while (iterator.hasNext()) {
            final Interval current = iterator.next();
            // hint: does the current interval overlaps with the current lowest interval...?
            if (current.overlaps(minInterval)) {
                // hint: yes - expand end to the current interval
                minInterval = minInterval.expandEndTo(current);
            } else {
                // hint: no - add to result list and set the current interval to the lowest interval
                merged.add(minInterval);
                minInterval = current;
            }
        }
        merged.add(minInterval);

        return unmodifiableList(merged);
    }
}
