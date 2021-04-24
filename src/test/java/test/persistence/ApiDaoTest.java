package test.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.AuthorsItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import persistence.ApiDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    void getBookTitle() throws JsonProcessingException {
        ApiDao dao = new ApiDao();
        String ISBN = "9781599906959";
        assertEquals("Throne of glass", dao.getBook(ISBN).getTitle());
    }

    @Test
    void getBookAuthor() throws JsonProcessingException {
        ApiDao dao = new ApiDao();
        String ISBN = "9781599906959";
        List<AuthorsItem> author = dao.getBook(ISBN).getAuthors();
        String key = author.get(0).getKey();

        assertEquals("Sarah J. Maas", dao.getAuthor(key));
    }

}
