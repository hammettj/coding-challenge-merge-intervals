package com.github.hammettj.codingchallenge.mergeintervals.cli;

import com.github.hammettj.codingchallenge.mergeintervals.data.Interval;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArgumentParserTest {

    private final ArgumentParser argumentParser = new ArgumentParser();

    @Test
    void parseArgumentsRequiresNonNullArguments() {
        assertThatThrownBy(() -> argumentParser.parseArguments(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void parseArgumentsRequiresNonEmptyArguments() {
        assertThatThrownBy(() -> argumentParser.parseArguments(new String[0]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("no arguments provided");
    }

    @Test
    void parseArgumentsRequiresCorrectFormat() {
        assertThatThrownBy(() -> argumentParser.parseArguments(new String[]{"[4,10]", "[begin,end]", "[1,7]"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[begin,end] does not match required format [int,int]");
    }

    @Test
    void parseArgumentsConvertsGivenArgumentToIntervals() {
        assertThat(argumentParser.parseArguments(new String[]{"[15, 36]", "[-10, -5]", "[0, 17]"}))
                .containsExactly(
                        new Interval(15, 36),
                        new Interval(-10, -5),
                        new Interval(0, 17)
                );
    }
}