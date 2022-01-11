# coding-challenge-merge-intervals

## Description
This small project takes an arbitrary number of intervals passed as program arguments in the form of `[begin,end]`, merges them and prints them to stdout.
Non-overlapping intervals are kept as is.

### Example
Given an input of

```[25, 30] [2, 19] [14, 23] [4, 8]```

the program will output

```[2, 23] [25, 30]```

as ```[2, 19]```, ```[4, 8]``` and ```[14, 23]``` overlap resulting in the interval ```[2, 23]```.
The interval ```[25, 30]``` does not overlap with any other interval, so it is kept as is.

### Assumption
  * `begin` and `end` can only be integers
  * `begin` and `end` can both be negative and positive
  * the length of an interval must not be zero or negative
    * thus `end` must be greater than `begin`

## Notes
  * To keep the final binary as small as possible, the use of external libraries were deliberately omitted 
