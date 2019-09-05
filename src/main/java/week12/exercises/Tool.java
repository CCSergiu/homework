package week12.exercises;

import java.io.*;
import java.util.*;

public class Tool {

    public void one(String path) {

        File file = new File(path);
        String[] fileList = file.list();
        for (String name : fileList) {
            System.out.println(name);
        }
    }

    public void two(String path, String extension) {

        File file = new File(path);
        String[] fileList = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                if (name.toLowerCase().endsWith(extension.toLowerCase())) {
                    return true;
                } else {
                    return false;
                }

            }
        });

        for (String f : fileList) {
            System.out.println(f);
        }
    }

    public void three(String path) {

        File file = new File(path);
        if (file.exists()) {
            System.out.println("The file or directory exists");
        } else {
            System.out.println("The file or directory does not exists");
        }
    }

    public void four(String path) {

        File file = new File(path);
        if (file.canRead()) {
            System.out.println(file.getAbsolutePath() + " can read.");
        } else {
            System.out.println(file.getAbsolutePath() + " can't read.");
        }
        if (file.canWrite()) {
            System.out.println(file.getAbsolutePath() + " can write.");
        } else {
            System.out.println(file.getAbsolutePath() + " can't write.");
        }
    }

    public void five(String path) {

        File file = new File(path);

        if (file.isDirectory()) {
            System.out.println(file.getAbsolutePath() + " is a directory.");
        } else {
            System.out.println(file.getAbsolutePath() + " is not a directory.");
        }
        if (file.isFile()) {
            System.out.println(file.getAbsolutePath() + " is a file.");
        } else {
            System.out.println(file.getAbsolutePath() + " is not a file.");
        }

    }

    public void six(String path1, String path2) {

        int compare = path1.compareTo(path2);
        System.out.println("comparison : " + compare);
    }

    public void seven(String path) {

        File file = new File(path);
        Date date = new Date(file.lastModified());
        System.out.println("The file was last modified on : " + date);
    }

    public void eight() throws IOException {

        System.out.print("Type something: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        System.out.println("What you typed is :" + name);

    }

    public void nine(String path) {

        File file = new File(path);

        if (file.exists()) {
            System.out.println("Size in bytes is : " + file.length());
            System.out.println("Size in kilobytes is : " + file.length() / 1024 + " kb");
            System.out.println("Size in megabytes is : " + file.length() / (1024 * 1024) + " mb");
        } else {
            System.out.println("File doesn't exist");
        }
    }

    public void ten(String path) {

        InputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(path);
            byte file_content[] = new byte[2 * 1024];
            int read_count = 0;
            while ((read_count = fileInputStream.read(file_content)) > 0) {
                System.out.println(new String(file_content, 0, read_count - 1));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception ex) {

            }
        }
    }

    public void eleven(String path) {

        BufferedReader bufferedReader = null;
        String line = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (IOException e) {
            System.err.println("Unable to read the file");
        }
    }

    public void tweleve(String path) {

        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file");
        }
    }

    public void thirteen(String path) {

        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        String all_lines = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while (line != null) {
                if (line == null) {
                    break;
                }
                all_lines += line;
                line = bufferedReader.readLine();
            }
            System.out.println(all_lines);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file");
        }
    }

    public void fourteen(String path) {

        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        List<String> stringList = new ArrayList<String>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while (line != null) {
                line = bufferedReader.readLine();
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                if (line == null) {
                    break;
                }
                stringList.add(line);
            }
            System.out.println(Arrays.toString(stringList.toArray()));
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file");
        }

    }

    public void fifteen(String path) {

        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        try {
            FileWriter fileWriter = new FileWriter(path, false);

            fileWriter.write("IO, 15 exercise output");
            fileWriter.close();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public void sixteen(String path) {

        StringBuilder stringBuilder = new StringBuilder();
        String line = "";

        try {
            FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.write("\nIO, 16 exercise\n");
            fileWriter.close();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public void seventeen(String path) {

        BufferedReader bufferedReader = null;
        String line = "";
        try {
            LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
            while (((line = reader.readLine()) != null) && reader.getLineNumber() <= 3) {
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFound");
        } catch (IOException e) {
            System.err.println("Unable to read the file");
        }
    }

    public void eighteen(String path) throws FileNotFoundException {

        String max = "";
        String current_word;
        Scanner scanner = new Scanner(new File(path));

        while (scanner.hasNext()) {
            current_word = scanner.next();
            if (current_word.length() > max.length()) {
                max = current_word;
            }
        }

        System.out.println(max);
    }
}
