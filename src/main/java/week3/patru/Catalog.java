package week3.patru;

public class Catalog {

    private Book[] bookArray = new Book[10];
    private int i = 0;

    public void addNovel(String name, int numberOfPages, String type) {
        if (i < 10) {
            bookArray[i] = new Novel(name, numberOfPages, type);
            i++;
            System.out.println("Novel " + name + " added!");
        } else {
            System.out.println("Novel " + name + " was not added because there is no more space available!");
        }
    }

    public void addAlbum(String name, int numberOfPages, String paperQuality) {
        if (i < 10) {
            bookArray[i] = new Album(name, numberOfPages, paperQuality);
            i++;
            System.out.println("Album " + name + " added!");
        } else {
            System.out.println("Album " + name + " was not added because there is no more space available!");
        }
    }

    public void listBooks() {
        for (int j = 0; j < i; j++) {
            System.out.println(bookArray[j].toString());
        }
    }

}

