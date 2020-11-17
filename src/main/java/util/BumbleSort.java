package util;

import dao.BaseContractComparator;
import entity.BaseContract;

import java.util.Comparator;

public class BumbleSort implements ISorter {

    @Override
    public void sort(BaseContract[] contracts, Comparator a) {
        for(int i=0;i<contracts.length;i++)
            for(int j = 0; j<contracts.length-1-i;j++)
                if(contracts[j+1] != null)
                    if(a.compare(contracts[j],contracts[j+1])>0 ){
                        BaseContract b = contracts[j];
                        contracts[j] = contracts[j+1];
                        contracts[j+1] = b;
                    }
    }
}
