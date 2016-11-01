package ge.mziuri.library.Dao;

import ge.mziuri.library.model.Author;
import ge.mziuri.library.model.Book;

/**
 *
 * @author User
 */
public interface BookDAO {

    void addBook(Book book);

    void removeBook(String name);

    void getBookWithYear(int year);

    void getPopularBook(Author author);
}
