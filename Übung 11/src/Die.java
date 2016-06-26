import java.util.Iterator;

public class Die extends AbstractDie {

    public static void main (String[] args)
    {
        test(new Die());
    }

    @Override
    public Iterator<Integer> iterator ()
    {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext ()
            {
                return true;
            }

            @Override
            public Integer next ()
            {
                return (int) (Math.random() * 6 + 1);
            }
        };
    }
}
