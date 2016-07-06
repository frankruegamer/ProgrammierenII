import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BirthdayManager extends AbstractBirthdayManager {

    @Override
    public void addBirthday (Birthday b)
    {
        map.put(b.getName(), b);
    }

    @Override
    public Birthday getBirthday (String name)
    {
        return map.get(name);
    }

    @Override
    public String[] getNamesOfPeopleWithPartyOnSameDayAs (String name)
    {
        Birthday birthday = map.get(name);
        List<String> list = new ArrayList<>();
        if (birthday != null) map.forEach((n, b) -> {if (b.sameDay(birthday)) list.add(n);});
        return list.toArray(new String[list.size()]);
    }

    @Override
    public Birthday[] allBirthdaysSortedByDay ()
    {
        List<Birthday> list = new ArrayList<>(map.values());
        list.sort(new DateComparator());
        return list.toArray(new Birthday[list.size()]);
    }

    public static void main (String[] args)
    {
        BirthdayManager bm = new BirthdayManager();

        bm.addBirthday(new Birthday("Peter", 1, 1, 2001));
        bm.addBirthday(new Birthday("Hans", 2, 2, 2002));
        bm.addBirthday(new Birthday("Franz", 3, 3, 2003));
        bm.addBirthday(new Birthday("Günther", 4, 4, 2004));
        bm.addBirthday(new Birthday("Martin", 5, 5, 2005));
        bm.addBirthday(new Birthday("Alfred", 6, 6, 2006));
        bm.addBirthday(new Birthday("Rudolf", 7, 7, 2007));
        bm.addBirthday(new Birthday("Rudolf", 7, 7, 2007));
        bm.addBirthday(new Birthday("Erich", 8, 8, 2008));
        bm.addBirthday(new Birthday("Victor", 9, 9, 2009));
        bm.addBirthday(new Birthday("Manfred", 10, 10, 2010));
        bm.addBirthday(new Birthday("Martin2", 5, 5, 2005));

        System.out.println(bm.getBirthday("Alfred"));
        System.out.println(bm.getBirthday("Victor"));

        Arrays.asList(bm.getNamesOfPeopleWithPartyOnSameDayAs("Martin")).forEach(System.out::println);
        Arrays.asList(bm.allBirthdaysSortedByDay()).forEach(System.out::println);
    }
}
