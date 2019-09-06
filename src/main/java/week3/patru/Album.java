package week3.patru;

public class Album extends Book {

    private String paperQuality;

    public Album(String name, int numberOfPages, String paperQuality) {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    public String getPaperQuality() {
        return paperQuality;
    }

    @Override
    public String toString() {
        return "Album{" +
                "paperQuality='" + paperQuality + '\'' +
                ", name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
