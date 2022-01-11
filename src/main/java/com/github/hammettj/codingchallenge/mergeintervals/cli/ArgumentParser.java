package com.github.hammettj.codingchallenge.mergeintervals.cli;

import com.github.hammettj.codingchallenge.mergeintervals.data.Interval;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;

/**
 * Simple parser which converts {@link String}s to a list of {@link Interval}s.
 */
public final class ArgumentParser {

    private static final Pattern INTERVAL_PATTERN = Pattern.compile("\\[(-?\\d+), ?(-?\\d+)]");

    /**
     * Parses the given array of strings, returning a list of intervals.
     *
     * <p>Each string in the given array needs to have the format {@code "[int,int]" (e.g. "[12,24]"}</p>
     *
     * @param args the array to convert.
     * @return the list of intervals.
     * @throws IllegalArgumentException if args is empty or any element does not match format [int,int]
     */
    List<Interval> parseArguments(final String[] args) {
        if (requireNonNull(args).length == 0) {
            throw new IllegalArgumentException("no arguments provided");
        }

        return stream(args)
                .map(arg -> {
                    final Matcher matcher = INTERVAL_PATTERN.matcher(arg);
                    if (!matcher.matches()) {
                        throw new IllegalArgumentException(arg + " does not match required format [int,int]");
                    }
                    return new Interval(parseInt(matcher.group(1)), parseInt(matcher.group(2)));
                })
                .toList();
    }
}
