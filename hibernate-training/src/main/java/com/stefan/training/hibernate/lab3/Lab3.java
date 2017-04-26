package com.stefan.training.hibernate.lab3;

import com.stefan.training.hibernate.lab1.Lab1;
import com.stefan.training.hibernate.lab1.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Exercise goals:
 *
 * - practice different ways of interacting with Session (saving and retrieving entities)
 *
 * 1. CRUD
 * - get() - always hits db, if no object found returns null
 * - load() - always returns proxy object without hitting db
 * 2. using Query query = session.createQuery(...)
 *
 * 3. HQL
 *
 *
 * ===
 * session.get()
 * session.createCriteria()
 */
public class Lab3 {

  public static void main(String[] args) {
    SessionFactory sessionFactory = Lab1.getDBSessionFactory();

    executeCRUD(sessionFactory);
  }

  private static void executeCRUD(SessionFactory sessionFactory) {

    User user1 = new User("1", "Stefan", "alamakota123");
    User user2 = new User("2", "Bolek", "alamakota123");
    User user3 = new User("3", "Lolek", "alamakota123");

    Session session = null;
    try {
      session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();


      System.out.println("Saving users...");
      String id1 = (String) session.save(user1);
      String id2 = (String) session.save(user2);
      String id3 = (String) session.save(user3);
      System.out.println("Users saved.");

      System.out.println("Getting user...");
      User user1N = (User) session.get(User.class, id1);
      System.out.println("Got user. [" + user1N + "]");

//      session.get()

      transaction.commit();
    } finally {
      session.close();
    }


  }

  public static boolean isPalindrome(String input) {
    for (int i=0; i<input.length(); i++) {
      if (!(input.charAt(i) == input.charAt(input.length() - i - 1))) {
        return false;
      }
    }

    return true;
  }

}
