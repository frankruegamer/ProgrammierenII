import java.io.*;

public class DecryptInputStream extends InputStream {

    private InputStream is;
    private int key;

    public DecryptInputStream(InputStream is, int key) {
        if (key < 0 || key > 255) {
            throw new IllegalArgumentException("Key liegt nicht zwischen 0 und 255");
        }
        this.is = is;
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        return is.available() > 0 ? (is.read() ^ key) : -1;
    }

    @Override
    public void close() throws IOException {
        is.close();
        super.close();
    }
}
