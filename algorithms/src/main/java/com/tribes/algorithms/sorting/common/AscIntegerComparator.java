package com.tribes.algorithms.sorting.common;

import java.util.Comparator;
import java.util.Objects;

public class AscIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2)
            return -1;
        else if (Objects.equals(o1, o2))
            return 0;
        else
            return 1;
    }
}
