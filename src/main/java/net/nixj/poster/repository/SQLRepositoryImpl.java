package net.nixj.poster.repository;

import net.nixj.poster.utils.HibernateUtils;

import javax.persistence.EntityManager;

/**
 * Created by fantsay on 10/20/15.
 */
public class SQLRepositoryImpl  {
    public EntityManager getEManager()
    {
    return HibernateUtils.getEm();

    }}
