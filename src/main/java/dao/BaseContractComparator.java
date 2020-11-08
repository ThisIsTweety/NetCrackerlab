package dao;

import entity.BaseContract;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

public class BaseContractComparator {

  public static class CompId implements Comparator<BaseContract>{

       @Override
       public int compare(BaseContract o1, BaseContract o2) {
           return Integer.compare(o1.getId(),o2.getId());
       }
   }
    public static class CompNumber implements Comparator<BaseContract>{

        @Override
        public int compare(BaseContract o1, BaseContract o2) {
            return Integer.compare(o1.getNumber(),o2.getNumber());
        }
    }
    public static class CompDateStart implements Comparator<BaseContract>{

        @Override
        public int compare(BaseContract o1, BaseContract o2) {
            return o1.getStart().compareTo(o2.getStart());
        }
    }
    public static class CompDateEnd implements Comparator<BaseContract>{

        @Override
        public int compare(BaseContract o1, BaseContract o2) {
            return o1.getEnd().compareTo(o2.getEnd());
        }
    }
}
