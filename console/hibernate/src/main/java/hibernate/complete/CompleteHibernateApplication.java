package hibernate.complete;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CompleteHibernateApplication {
    private static Logger logger = LoggerFactory.getLogger(CompleteHibernateApplication.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CompleteHibernateConfiguration.class);
        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // This query is very inefficient
        List<City> cities = entityManager.createQuery("select c from City as c", City.class).getResultList();
        //  Inefficient query: Possible fix 1
        //List<City> cities = entityManager.createQuery("select c from City as c join fetch c.country", City.class).getResultList();
        cities.forEach(city -> logger.info(city.toString()));



        entityManager.close();
    }
}
