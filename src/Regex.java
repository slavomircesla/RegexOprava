import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex {



        public static void main(String [] args) {

            // Zdroj.
            String fileName = "C:\\rawText.txt";

            Pattern SPZ = Pattern.compile("[A-Z]{2}[0-9]{3}[A-Z]{2}");
            Pattern MAC = Pattern.compile("([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})");
            Pattern RC = Pattern.compile("\\d{2}([05][1-9]|[16][0-2])[0-3][0-9]/?[0-9]{4}");

            try {


                // buffered citanie
                BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\rawText.txt"));
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    // For each match in the line, extract and print it.
                    Matcher spz = SPZ.matcher(line);
                    Matcher  mac= MAC.matcher(line);
                    Matcher rc= RC.matcher(line);
                    while (spz.find()) {

                        // Zaciatok textu
                        int start = spz.start(0);
                        // Koniec textu
                        int end = spz.end(0);



                        System.out.println(line.substring(start, end));
                    }
                    while (mac.find()) {


                        // Zaciatok textu
                        int start = mac.start(0);
                        // Koniec textu
                        int end = mac.end(0);



                        System.out.println(line.substring(start, end));
                    }
                    while (rc.find()) {


                        // Zaciatok textu
                        int start = rc.start(0);
                        // Koniec textu
                        int end = rc.end(0);


                        System.out.println(line.substring(start, end));
                    }
                }

                bufferedReader.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                fileName + "'");
            }
            catch(IOException ex) {
                System.out.println(
                        "Error reading file '"
                                + fileName + "'");

            }
        }
    }
