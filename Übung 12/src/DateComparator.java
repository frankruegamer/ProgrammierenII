import java.util.Comparator;

public class DateComparator implements Comparator<Birthday> {

    @Override
    public int compare (Birthday b1, Birthday b2)
    {
        int result = new Integer(b1.getMonth()).compareTo(b2.getMonth());
        if (result == 0)
            result = new Integer(b1.getDay()).compareTo(b2.getDay());
        if (result == 0)
            result = new Integer(b1.getYear()).compareTo(b2.getYear());
        return result;
    }
}
