import java.io.*;

public class EncryptOutputStream extends OutputStream {

    private OutputStream os;
    private int key;

    public EncryptOutputStream (OutputStream os, int key)
    {
        if (key < 0 || key > 255)
        {
            throw new IllegalArgumentException("Key liegt nicht zwischen 0 und 255");
        }
        this.os = os;
        this.key = key;
    }

    @Override
    public void write (int i) throws IOException
    {
        os.write(i ^ key);
    }

    @Override
    public void close () throws IOException
    {
        os.close();
        super.close();
    }
}
