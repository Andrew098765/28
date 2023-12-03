package ru.tinkoff.qa.dbtests;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.tinkoff.qa.dbmodels.Animal;
import ru.tinkoff.qa.hibernate.BeforeCreator;
import ru.tinkoff.qa.hibernate.HibernateSessionFactoryCreator;


public class ZooHibernateTests {

    @BeforeAll
    static void init() {
        BeforeCreator.createData();
    }

    /**
     * В таблице public.animal ровно 10 записей
     */
    @Test
    public void countRowAnimal() {

        Session session = HibernateSessionFactoryCreator.createSessionFactory().openSession();
        CriteriaBuilder qb = session.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Animal.class)));
        Long singleResult = session.createQuery(cq).getSingleResult();
        session.close();
        Assertions.assertEquals(singleResult, 10);
    }

    /**
     * В таблицу public.animal нельзя добавить строку с индексом от 1 до 10 включительно
     */
    @Test
    public void insertIndexAnimal() {
        assert false;
    }

    /**
     * В таблицу public.workman нельзя добавить строку с name = null
     */
    @Test
    public void insertNullToWorkman() {
        assert false;
    }

    /**
     * Если в таблицу public.places добавить еще одну строку, то в ней будет 6 строк
     */
    @Test
    public void insertPlacesCountRow() {
        assert false;
    }

    /**
     * В таблице public.zoo всего три записи с name 'Центральный', 'Северный', 'Западный'
     */
    @Test
    public void countRowZoo() {
        assert false;
    }
}
