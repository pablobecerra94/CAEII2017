package overhead.caeii2017.Util;

/**
 * Created by Pablo on 13/03/2017.
 */

public class AlarmCounter {

    private static int count=0;

    public static int getCount(){
        return count;
    }

    public static void add(){
        count++;
    }
}
