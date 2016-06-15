package com.stefan.hibernate.training.lab2;

import com.stefan.hibernate.training.lab1.Lab1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Exercise goals:
 * - deal with entity states (new, save, read, update, delete, ...)
 * - explore hibernate Session
 *
 * --------------------------
 * Entity states (hibernate persistence lifecycle):
 * https://howtoprogramwithjava.com/hibernate-life-cycle/
 *
 * 1. Transient:
 *  A transient object is one that Hibernate has no awareness of whatsoever.
 *  The object was never persistent, not associated with any Session.
 *  Hibernate does not track transient objects.
 *
 * 2. Persistent (aka. attached):
 *  When an object is in a persistent state, Hibernate is totally aware of it and can keep the database synchronized with it’s values.
 *  There are two main ways to change object state from transient to a persistent - load it or save it.
 *  Persistent object is  associated with a unique Session
 *
 *
 * 3. Detached: previously persistent, not associated with any Session
 *
 *
 * 4. Removed.
 */
public class Lab2 {


  public static void main(String[] args) {
    SessionFactory sessionFactory = Lab1.getDBSessionFactory();

    Session session = sessionFactory.openSession();
  }

}
