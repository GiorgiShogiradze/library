package ge.mziuri.library.Dao;

import ge.mziuri.library.model.Author;
import ge.mziuri.library.model.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class BookImpl implements BookDAO {

    @Override
    public void addBook(Book book) {
        try {
            int id = book.getId();
            String name = book.getName();
            int year = book.getYear();
            int rating = book.getRating();

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "rame");
            java.sql.Statement stmt = con.createStatement();
            stmt.execute("CREATE TABLE book(id INT PRIMARY KEY NOT NULL, name VARCHAR(30) NOT NULL , year INT , rating int);");
            stmt.executeUpdate("INSERT INTO book VALUES(" + id + "," + name + " , " + year + " , " + rating + ");");
            stmt.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void removeBook(String name) {
        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "rame");
            java.sql.Statement stmt = con.createStatement();
            stmt.execute("REMOVE TABLE " + name + ";");
            stmt.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void getBookWithYear(int year) {
        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "rame");
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM book");
            while (rs.next()) {
                int Year = rs.getInt("year");
                String Name = rs.getString("name");
                if (Year == year) {
                    System.out.println(Name);
                }

            }
            stmt.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void getPopularBook(Author author) {

        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "rame");
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM book");
            String MaxName = null;

            while (rs.next()) {
                int Rating = rs.getInt("rating");
                String Name = rs.getString("name");
                int RatingMax = 0;
                if (Rating > RatingMax) {
                    RatingMax = Rating;
                    MaxName = Name;
                }
            }

            System.out.println(MaxName);
            stmt.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
