package ru.itis.web.repositories.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.web.models.User;
import ru.itis.web.repositories.UsersRepository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Component(value = "users.repository.jpa.impl")
public class UsersRepositoryJpaImpl implements UsersRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<User> findOneByLogin(String login) {
        Session session = sessionFactory.openSession();
        try {
            Query<User> userQuery = session.createQuery("from User where login = :login", User.class)
                    .setParameter("login", login);
            User user = userQuery.getSingleResult();
            return Optional.ofNullable(user);
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<User> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User model) {
        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        session.persist(model);
//        transaction.commit();
        return model;
    }

    @Override
    public void update(User model) {
        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        session.merge(model);
//        transaction.commit();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User", User.class);
        List<User> users = userQuery.getResultList();
        return users;
    }
}
