package util;

import entity.BaseContract;

import java.util.Comparator;

public interface ISorter {
    public void sort(BaseContract[]contracts, Comparator a);
}
