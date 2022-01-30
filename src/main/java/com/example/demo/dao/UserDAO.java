package com.example.demo.dao;

import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAO implements IUserDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> index() {
        TypedQuery<User> query = em.createNamedQuery("User.getAll", User.class);
        return query.getResultList();
    }

    @Override
    public User show(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(long id, User user) {
        Query query = em.createQuery("update User set name =:n, age =:a, email =:e where id =:id");
        query.setParameter("n", user.getName());
        query.setParameter("a", user.getAge());
        query.setParameter("e", user.getEmail());
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void delete(long id) {
        em.remove(em.find(User.class, id));
    }
}