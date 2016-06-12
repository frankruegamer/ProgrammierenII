import java.io.*;

public class CartCalculator extends AbstractCartCalculator {

    public static void main (String[] args)
    {
        new CartCalculator().test();
    }

    @Override
    public double totalPrice (InputStream in)
    {
        if (in == null) return 0.0;

        DataInputStream dis = new DataInputStream(in);
        double totalPrice = 0;

        try
        {
            while (dis.available() > 0)
            {
                //noinspection unused
                int _artnr = dis.readInt();
                int anz = dis.readInt();
                double price = dis.readDouble();

                totalPrice += anz * price;
            }

            dis.close();
        }
        catch (IOException ignored) { }

        return totalPrice;
    }
}
