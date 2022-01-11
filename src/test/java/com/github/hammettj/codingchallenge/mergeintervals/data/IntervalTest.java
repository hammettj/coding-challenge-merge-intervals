package com.github.hammettj.codingchallenge.mergeintervals.data;

import org.junit.jupiter.api.Test;

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
}
