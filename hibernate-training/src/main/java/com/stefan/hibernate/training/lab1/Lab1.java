package com.stefan.hibernate.training.lab1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Exercise 1 goals:
 * 1. Set up in-memory database using HSQLDB.
 * 2. Configure hibernate to use hsql db.
 * 3. Get acquainted with SessionFactory, Session, Transaction, EntityManager & Connection
 * 4. Save and read single entity.
 *
 * --------------------------------------------
 * >SessionFactory is Hibernates concept of a single datastore and is threadsafe so that many threads can access it concurrently
 * and request for sessions and immutable cache of compiled mappings for a single database. A SessionFactory is usually only built once at startup
 *
 * >Session - the integral part of the Hibernate ORM that provides CRUD interactions with persistent entities.
 * A Session is used to get a physical connection with a database.
 * The Session object is lightweight and designed to be instantiated each time an interaction is needed with the database.
 * Persistent objects are saved and retrieved through a Session object.
 * The lifecycle of a Session is bounded by the beginning and end of a logical transaction.
 * (Long transactions might span several database transactions.)
 * Session is not designed to be used by multiple threads.
 *
 * >EntityManager - part of the Java Persistence API (JPA) standard.
 *
 * >Connection - an equivalent of Session. SQL statements are executed and results are returned within the context of a connection.
 * Attributes as auto-commit, transaction isolation are defined on the Connection level.
 * Connection might be thread safe but is shouldn't be shared between multiple threads. Use ConnectionPool instead.
 *
 * Transaction
 *
 */
public class Lab1 {

  public static void main(String[] args) {
    SessionFactory factory = getDBSessionFactory();
    test(factory);
    factory.close();
  }

  public static SessionFactory getDBSessionFactory() {
    // the configure() method loads config from default file hibernate.cfg.xml
    // it can be overridden by providing different file name
    System.out.println("Creating session factory...");
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    System.out.println("Session factory created.");
    return sessionFactory;
  }

  private static void test(SessionFactory sessionFactory) {
    Session session = null;
    try {
      session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();

      User user1 = new User("1", "Stefan", "alamakota123");

      System.out.println("Saving user...");
      String id = (String) session.save(user1);
      System.out.println("User saved. [" + user1 + "]");

      System.out.println("Getting user...");
      User user2 = (User) session.get(User.class, id);
      System.out.println("Got user. [" + user2 + "]");

      transaction.commit();
    } finally {
      session.close();
    }
  }

}
