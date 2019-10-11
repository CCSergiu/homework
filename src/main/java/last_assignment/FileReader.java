package last_assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FileReader {

    public void readFile(String path, List<Package> packages) {

        BufferedReader bufferedReader = null;
        String line = "";

        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(path));
            while ((line = bufferedReader.readLine()) != null) {
                packages.add(parseLine(line));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (IOException e) {
            System.err.println("Unable to read the file");
        }
    }

    public Package parseLine(String line) {

        String[] parse = line.split(",");
        Package aPackage = new Package(parse[0], Integer.valueOf(parse[1]), Integer.valueOf(parse[2]), LocalDate.parse(parse[3]));

        return aPackage;
    }
}
