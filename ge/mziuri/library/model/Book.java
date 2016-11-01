package ge.mziuri.library.model;

/**
 *
 * @author G.sHack
 */
public class Book {

    private int id;
    private String name;
    private int year;
    private int rating;
    private String comment;

    public Book() {
    }

    public Book(int id, String name, int year, int rating, String comment) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Book- name: " + name + ", year: " + year + ", Rating: " + rating + ", comment:" + comment + ";";
    }
}
