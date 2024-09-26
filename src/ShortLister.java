import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args)
    {
        // instantiate at top instead of inside loop
        ShortWordFilter shortWord = new ShortWordFilter();

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec;

        try
        {
            // uses a fixed known path:
            //  Path file = Paths.get("c:\\My Documents\\data.txt");
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 1;
                while(reader.ready())
                {
                    rec = reader.readLine();

                    // Turn string (rec) into an array of individual words
                    String [] words = rec.split(" ");

                    System.out.println("Words less than 5 characters from line: " + line);
                    for (String word: words) {
                        // print if "accept" evaluates to true (word is > 5 characters)
                        if (shortWord.accept(word)) {
                            System.out.print(word + " ");
                        }
                    }
                    System.out.println();
                    line++;
                }
                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
