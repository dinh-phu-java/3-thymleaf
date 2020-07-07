package com.dinhphu.services;

import org.hibernate.SessionFactory;

public interface IDatabaseConnection<T> {
    public SessionFactory getSessionFactory();
}
