package week12.exercises;

import java.io.*;
import java.util.Date;

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
}

