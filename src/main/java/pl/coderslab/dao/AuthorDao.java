package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public Author saveAuthor(Author author) {
        entityManager.persist(author);
        return author;
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.contains(findById(id)) ?
                findById(id) : entityManager.merge(findById(id)));
    }

    public List<Author> findAll(){
        return entityManager.createQuery("select b from Author b").getResultList();
    }

}
