package ru.tinkoff.qa.dbtests;

import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.tinkoff.qa.hibernate.BeforeCreator;
import ru.tinkoff.qa.hibernate.HibernateSessionFactoryCreator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ZooHibernateTests {
    private static Session session;

    @BeforeAll
    static void init() {
        BeforeCreator.createData();
        session = HibernateSessionFactoryCreator.createSessionFactory().openSession();
    }

    /**
     * В таблице public.animal ровно 10 записей
     */
    @Test
    @DisplayName("Проверка на кол-во записей = 10 в таблице animal")
    public void countRowAnimal() {
        Query<Integer> query = session.createQuery("SELECT id FROM Animal", Integer.class);
        assertEquals(query.getResultList().size(), 10);
    }

    /**
     * В таблицу public.animal нельзя добавить строку с индексом от 1 до 10 включительно
     */
    @Test
    @DisplayName("Проверка на ошибку при добавлении строки с индексом от 1 по 10 в таблицу animal")
    @SuppressWarnings("all")
    public void insertIndexAnimal() {
        assertThrows(PersistenceException.class,
                () -> {
                    Transaction transaction = null;
                    try (Session session = HibernateSessionFactoryCreator.createSessionFactory().openSession()) {
                        transaction = session.beginTransaction();
                        session.createQuery("insert Animal(id, name) values (1, 'wwf')")
                                .executeUpdate();
                        transaction.commit();
                    } catch (IllegalStateException e) {
                        if (transaction != null) {
                            transaction.rollback();
                        }
                        e.printStackTrace();
                    }

                }
        );
    }

    /**
     * В таблицу public.workman нельзя добавить строку с name = null
     */
    @Test
    @DisplayName("Проверка на ошибку при добавлении строки с name = null в таблицу workman")
    @SuppressWarnings("all")
    public void insertNullToWorkman() {
        assertThrows(PersistenceException.class,
                () -> {
                    Transaction transaction = null;
                    try (Session session = HibernateSessionFactoryCreator.createSessionFactory().openSession()) {
                        transaction = session.beginTransaction();
                        session.createQuery("insert Workman(id, name) values (15, null)")
                                .executeUpdate();
                        transaction.commit();
                    } catch (IllegalStateException e) {
                        if (transaction != null) {
                            transaction.rollback();
                        }
                        e.printStackTrace();
                    }
                }
        );
    }

    /**
     * Если в таблицу public.places добавить еще одну строку, то в ней будет 6 строк
     */
    @Test
    @DisplayName("Проверка, что при добавлении строки в таблицу places будет 6 строк")
    @SuppressWarnings("all")
    public void insertPlacesCountRow() {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryCreator.createSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("insert Places(id, name) values (6, 'wwf')")
                    .executeUpdate();
            transaction.commit();
        } catch (IllegalStateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        Query<Integer> query = session.createQuery("SELECT id FROM Places", Integer.class);
        assertEquals(query.getResultList().size(), 6);
    }

    /**
     * В таблице public.zoo всего три записи с name 'Центральный', 'Северный', 'Западный'
     */
    @Test
    @DisplayName("Проверка на кол-во записей = 3 в таблице c name 'Центральный', 'Северный', 'Западный'")
    public void countRowZoo() {
        Query<String> query = session.createQuery("SELECT name FROM Zoo", String.class);
        List<String> result = query.getResultList();
        assertAll(
                () -> assertTrue(result.contains("Центральный")),
                () -> assertTrue(result.contains("Северный")),
                () -> assertTrue(result.contains("Западный")),
                () -> assertEquals(result.size(), 3)
        );
    }

    @AfterAll
    public static void closeSession() {
        session.close();
    }
}
