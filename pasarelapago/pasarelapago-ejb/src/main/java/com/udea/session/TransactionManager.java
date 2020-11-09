/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.modelo.Transactions;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author deivid
 */
@Stateless
public class TransactionManager implements TransactionManagerLocal {

    @PersistenceContext(unitName="com.udea_pasarelapago-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

  

    @Override
    public List<Transactions> getAllTransactions() {
         Query  query = em.createNamedQuery("Transactions.findAll");
        return query.getResultList();
 
    }

    @Override
    public Transactions update(Transactions transactions) {
        return em.merge(transactions);
    }

    



   
}
