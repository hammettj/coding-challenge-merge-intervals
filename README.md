# coding-challenge-merge-intervals

## Description
This small project takes an arbitrary number of intervals passed as program arguments in the form of `[begin,end]`,
merges them and prints them to stdout. Non-overlapping intervals are kept as is.

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

### Solution
First we need to sort the input list in ascending order by `begin` (we do also remove duplicates to be a faster).
This way we don't have to loop through the list twice as we know the previous interval's `begin` is always
less than or equal to the current one's. The next step is to iterate over the sorted list after storing the first
interval as the `current lowest interval`. Inside the loop we can then check if the current interval's `begin` is less
than or equal to the `current lowest interval`'s end, meaning they overlap.

If they overlap we expand the `end` of the `current lowest interval` if necessary (if the current's `end` is greater
than `current lowest interval`'s).

If they do not overlap we add the `current lowest interval` to our result list and storing the current interval as our
new `current lowest interval`.

After iterating over all intervals we have to add the `current lowest interval` and return our merged list of intervals.

## Building From Source
### Requirements
* JDK 17

You don't necessarily need to install Maven as a copy of the Maven Wrapper is distributed with this project.

To build the project you simply need to run the following command in the project directory.
  ```shell
  ./mvnw clean verify
  ```

## Running
After building the project you can run the program by executing

  ```shell
  java -jar target/merge-intervals-1.0-SNAPSHOT.jar "[25,30]" "[2,19]" "[14,23]" "[4,8]"
  ```

## Performance
Since we are sorting the given list of intervals we have an overall time complexity of the `merge()` function of
`O(n log(n))`. This ensures a decent fast runtime of the application even when passing a lot of intervals (1.000.000+).
The memory usage of the function `merge()` is `O(n)` as we are creating a copy of the intervals.

The runtime and memory footprint could easily be reduced by e.g. sorting the given list of intervals in-place and/or by
updating the current lowest interval's end. But since I wanted to keep this project a bit more DDD'ish I decided to use
immutable objects whenever possible.

## Notes
  * as readability and stability is the main focus of this project this might not be the most performant implemention
    in terms of speed and memory usage (although it's quite fast)
  * To keep the final binary as small as possible, the use of external libraries were deliberately omitted 
