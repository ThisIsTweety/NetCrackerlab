package util;

import entity.BaseContract;

import java.util.Comparator;

public class SelectionSort implements ISorter {
    @Override
    public void sort(BaseContract[] contracts, Comparator a) {
        for (int left = 0; left < contracts.length; left++) {
            int minInd = left;
            for (int i = left; i < contracts.length; i++) {
                if (contracts[i] != null && contracts[minInd] != null)
                    if (a.compare(contracts[i], contracts[minInd]) < 0) {
                        minInd = i;
                    }
            }
            BaseContract b = contracts[left];
            contracts[left] = contracts[minInd];
            contracts[minInd] = b;
        }
    }
}
