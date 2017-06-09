package mylogic;

import java.util.Comparator;

/**
 * Created by LG-2 on 6/9/2017.
 */
public class VolumeComparator implements Comparator<Cuboid>{
    @Override
    public int compare(Cuboid o1, Cuboid o2) {
        int volume1=o1.length*o1.breadth*o1.height,volume2=o2.length*o2.breadth*o2.height;
        if(volume1>volume2)
            return -1;
        else if(volume1<volume2)
            return 1;
        else
            return 0;
    }
}
