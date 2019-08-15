package ru.itis.web.repositories.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.web.models.CookieValue;
import ru.itis.web.repositories.CookieValuesRepository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Component(value = "cookie.values.repository.jpa.impl")
public class CookieValuesRepositoryJpaImpl implements CookieValuesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<CookieValue> findOneByValue(String value) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Query<CookieValue> cookieValueQuery = session.createQuery("from CookieValue where value = :value", CookieValue.class)
                    .setParameter("value", value);
            CookieValue cookieValue = cookieValueQuery.getSingleResult();
            return Optional.ofNullable(cookieValue);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<CookieValue> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public CookieValue save(CookieValue model) {
        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        session.persist(model);
//        transaction.commit();
        return model;
    }

    @Override
    public void update(CookieValue model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<CookieValue> findAll() {
        return null;
    }
}
