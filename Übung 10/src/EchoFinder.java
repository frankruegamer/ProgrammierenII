import java.io.*;

public class EchoFinder implements EchoFinderInterface {

    public static void main (String[] args)
    {
        EchoFinder echoFinder = new EchoFinder();
        String echo = echoFinder.getPair(echoFinder.getSystemInAsBufferedReader());
        System.out.printf("Echo: \"%s\"", echo);
    }

    @Override
    public String getPair (BufferedReader buffer)
    {
        String returnValue = null;

        try
        {
            String lastLine;
            String line = buffer.readLine();
            do
            {
                lastLine = line;
                line = buffer.readLine();
            }
            while (!lastLine.equals(line));

            returnValue = line;
        }
        catch (IOException ignored) {}

        return returnValue;
    }

    @Override
    public BufferedReader getSystemInAsBufferedReader ()
    {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
