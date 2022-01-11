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

    @Test
    void expandingRequiresNonNullInterval() {
        final Interval interval = new Interval(3, 7);
        assertThatThrownBy(() -> interval.expandEndTo(null))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    void expandingReturnsNewExpandedInterval() {
        final Interval left = new Interval(3, 7);
        final Interval right = new Interval(5, 11);

        assertThat(left.expandEndTo(right))
            .isEqualTo(new Interval(3, 11));
    }

    @Test
    void checkingOverlapRequiresNonNullInterval() {
        final Interval interval = new Interval(3, 7);
        assertThatThrownBy(() -> interval.overlaps(null))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    void intervalsOverlapWhenTheyIntersect() {
        final Interval left = new Interval(3, 7);
        final Interval right = new Interval(6, 10);

        assertThat(right.overlaps(left))
            .isTrue();
    }

    @Test
    void intervalsOverlapWhenTheyTouch() {
        final Interval left = new Interval(1, 5);
        final Interval right = new Interval(5, 10);

        assertThat(right.overlaps(left))
            .isTrue();
    }

    @Test
    void intervalsDoNotOverlapWhenTheyDontIntersect() {
        final Interval left = new Interval(1, 5);
        final Interval right = new Interval(10, 15);

        assertThat(right.overlaps(left))
            .isFalse();
    }
}
