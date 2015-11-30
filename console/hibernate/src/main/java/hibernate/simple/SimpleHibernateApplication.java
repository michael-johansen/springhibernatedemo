package hibernate.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleHibernateApplication {
    private static Logger logger = LoggerFactory.getLogger(SimpleHibernateApplication.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleHibernateConfiguration.class);
        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<City> cities = entityManager.createQuery("select c from City as c", City.class).getResultList();
        cities.forEach(city -> logger.info(city.toString()));

        logger.info("CountBefore: " + entityManager.createQuery("select count(c) from City as c", Long.class).getSingleResult());

        entityManager.getTransaction().begin();

        Set<City> citySet = new HashSet<>(); // Pitfall 1: Identity
        citySet.add(new City("TEST", "TS1", "ts1", 123456));
        citySet.add(new City("TEST2", "TS2", "ts2", 234567));
        citySet.forEach(entityManager::persist);

        entityManager.getTransaction().commit();

        logger.info("CountAfter: " + entityManager.createQuery("select count(c) from City as c", Long.class).getSingleResult());

        entityManager.close();
    }
}
