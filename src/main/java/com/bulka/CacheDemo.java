//package com.bulka;
//
//import org.hibernate.Cache;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.stat.Statistics;
//
//public class CacheDemo {
//    public static void main(String[] args) {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        System.out.println("Создаем нового пользователя...");
//        User user = new User();
//        user.setName("John");
//        session.save(user);
//
//        System.out.println("Пользователь сохранен в базе данных...");
//        System.out.println("Проверяем, есть ли объект в кэше первого уровня...");
//        if (session.contains(user)) {
//            System.out.println("Объект находится в кэше первого уровня");
//        }
//
//        System.out.println("Закрываем транзакцию и сессию...");
//        session.getTransaction().commit();
//        session.close();
//
//        System.out.println("Открываем новую сессию...");
//        session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        System.out.println("Получаем пользователя из базы данных...");
//        User user2 = session.get(User.class, 1L);
//        System.out.println("Имя пользователя: " + user2.getName());
//
//        System.out.println("Проверяем, есть ли объект в кэше первого уровня...");
//        if (session.contains(user2)) {
//            System.out.println("Объект находится в кэше первого уровня");
//        }
//
//        System.out.println("Закрываем транзакцию и сессию...");
//        session.getTransaction().commit();
//        session.close();
//    }
//}
package com.bulka;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

public class CacheDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("Создаем нового пользователя...");
        User user = new User();
        user.setName("John");
        session.save(user);

        System.out.println("Пользователь сохранен в базе данных...");
        System.out.println("Проверяем, есть ли объект в кэше первого уровня...");
        if (session.contains(user)) {
            System.out.println("Объект находится в кэше первого уровня");
        }

        System.out.println("Закрываем транзакцию и сессию...");
        session.getTransaction().commit();
        session.close();

        System.out.println("Открываем новую сессию...");
        session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("Получаем пользователя из базы данных...");
        User user2 = session.get(User.class, 1L);
        System.out.println("Имя пользователя: " + user2.getName());

        System.out.println("Проверяем, есть ли объект в кэше первого уровня...");
        if (session.contains(user2)) {
            System.out.println("Объект находится в кэше первого уровня");
        }

//        Statistics stats = sessionFactory.getStatistics();
//        System.out.println("Проверяем кэш 2 уровня...");
//        System.out.println("  - Количество попаданий в кэш: " + stats.getSecondLevelCacheHitCount());
//        System.out.println("  - Количество промахов в кэш: " + stats.getSecondLevelCacheMissCount());
//        System.out.println("  - Количество элементов в кэше: " + stats.getSecondLevelCachePutCount());

        Statistics stats = sessionFactory.getStatistics();
        System.out.println("Проверяем кэш 2 уровня...");
        System.out.println("  - Количество попаданий в кэш: " + stats.getSecondLevelCacheHitCount());
        System.out.println("  - Количество промахов в кэш: " + stats.getSecondLevelCacheMissCount());
        System.out.println("  - Количество элементов в кэше: " + stats.getSecondLevelCachePutCount());

        System.out.println("Закрываем транзакцию и сессию...");
        session.getTransaction().commit();
        session.close();
    }
}