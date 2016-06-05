// Mit Hilfe dieser Klassen sollen verschluesselte Dateien
// auf der Konsole ausgegeben werden. Dazu ist die Datei zu
// oeffnen, mit einem Decryptor-Decorator zu versehen und
// einzulesen. Jedes eingelesene und entschluesselte Zeichen
// soll unmittelbar auf der Konsole ausgegeben werden.

import java.io.*;

public class FileDecryptor {

    public static void decryptFile (String filename)
    {
        try
        {
            FileInputStream file = new FileInputStream(filename);
            DecryptInputStream stream = new DecryptInputStream(file, 100);

            int decrypted;
            do
            {
                decrypted = stream.read();
                System.out.print((char) decrypted);
            }
            while (decrypted != -1);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Datei nicht gefunden");
        }
        catch (IOException ignored) { }
    }

    // Diese main-Methode zeigt die Verwednung der zu
    // implementierenden Methode. An der Ausgabe koennen Sie
    // erkennen, ob Ihre Implementierung funktioniert.
    public static void main (String[] args)
    {
        decryptFile("Übung 8/src/data.crypt");
    }
}
