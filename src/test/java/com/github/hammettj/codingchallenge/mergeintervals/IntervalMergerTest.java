package com.github.hammettj.codingchallenge.mergeintervals;

import com.github.hammettj.codingchallenge.mergeintervals.data.Interval;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptySet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntervalMergerTest {

    private final IntervalMerger intervalMerger = new IntervalMerger();

    @Test
    void mergeRequiresNonNullCollection() {
        assertThatThrownBy(() -> intervalMerger.merge(null))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    void mergeReturnsEmptyListWhenPassedAnEmptyCollection() {
        assertThat(intervalMerger.merge(emptySet()))
            .isEmpty();
    }

    @Test
    void mergeReturnsCombinesOverlappingIntervals() {
        assertThat(
                intervalMerger.merge(List.of(
                    new Interval(25, 30),
                    new Interval(2, 19),
                    new Interval(14, 23),
                    new Interval(4, 8)
                ))
        ).containsExactly(
                new Interval(2, 23),
                new Interval(25, 30)
            );
    }
}