package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public Book saveBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.contains(findById(id)) ?
                findById(id) : entityManager.merge(findById(id)));
    }

    public Publisher getById(Long id){
       return entityManager.find(Publisher.class, id);
    }

    public List<Book> findAll(){
        return entityManager.createQuery("select b from Book b").getResultList();
    }

    public List<Book> findAllByRating(int rating){
        Query query = entityManager.createQuery("select b from Book b where b.rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Book> findBookWithPublisher(){
        return entityManager
                .createQuery("SELECT b FROM Book b JOIN b.publisher")
                .getResultList();
    }

    public List<Book> findBooksWithPublishers(Publisher publisher) {
        return entityManager
                .createQuery("SELECT b FROM Book b WHERE b.publisher = :publisher")
                .setParameter("publisher", publisher)
                .getResultList();
    }

    public List<Book> findBooksWithAuthor(Author author) {
        return entityManager
                .createQuery("SELECT distinct b FROM Book b join FETCH b.authors WHERE :author member of b.authors")
                .setParameter("author", author)
                .getResultList();
    }


}
