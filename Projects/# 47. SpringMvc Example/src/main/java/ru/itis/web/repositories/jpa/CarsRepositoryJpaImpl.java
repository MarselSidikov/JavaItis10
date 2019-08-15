package ru.itis.web.repositories.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.web.models.Car;
import ru.itis.web.repositories.CarsRepository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component(value = "cars.repository.jpa.impl")
public class CarsRepositoryJpaImpl implements CarsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Car> findAllByUser_Id(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Query<Car> carQuery = session.createQuery("from Car car where car.owner.id = :userId", Car.class)
                    .setParameter("userId", userId);
            return carQuery.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<Car> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public Car save(Car model) {
        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        session.persist(model);
//        transaction.commit();
        return model;
    }

    @Override
    public void update(Car model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Car> findAll() {
        return null;
    }
}
