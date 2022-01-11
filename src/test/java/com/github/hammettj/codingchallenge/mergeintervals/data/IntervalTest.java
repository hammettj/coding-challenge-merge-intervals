package com.github.hammettj.codingchallenge.mergeintervals.data;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntervalTest {

    @Test
    void newIntervalMustNotHaveEqualBeginAndEnd() {
        assertThatThrownBy(() -> new Interval(11, 11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("begin and end must not be equal");
    }

    @Test
    void newIntervalMustNotHaveBeginGreaterThanEnd() {
        assertThatThrownBy(() -> new Interval(30, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("begin must be less than end");
    }

    @Test
    void comparingIntervalsSortsAscendingByBeginAndEnd() {
        final Interval interval1 = new Interval(7, 11);
        final Interval interval2 = new Interval(1, 5);
        final Interval interval3 = new Interval(2, 6);
        final Interval interval4 = new Interval(2, 4);
        final List<Interval> intervals = List.of(interval1, interval2, interval3, interval4);

        assertThat(intervals.stream().sorted())
            .containsExactly(interval2, interval4, interval3, interval1);
    }
}
