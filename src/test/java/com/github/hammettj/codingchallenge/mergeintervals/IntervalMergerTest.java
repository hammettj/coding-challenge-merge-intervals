package com.github.hammettj.codingchallenge.mergeintervals;

import com.github.hammettj.codingchallenge.mergeintervals.data.Interval;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IntervalMergerTest {

    private final IntervalMerger intervalMerger = new IntervalMerger();

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