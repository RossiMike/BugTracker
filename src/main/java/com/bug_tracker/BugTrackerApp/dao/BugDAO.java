package com.bug_tracker.BugTrackerApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bug_tracker.BugTrackerApp.entities.Bug;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class BugDAO {

    // define field for entiry manager

    private EntityManager entityManager;

    @Autowired
    public BugDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method

    @Transactional
    public void save(Bug theBug) {
        entityManager.persist(theBug);
    }

    // implement update method

    @Transactional
    public void update(Bug theBug) {
        entityManager.merge(theBug);
    }

    @Transactional
    public void delete(String bug_name) {

        // retrieve the bug

        Bug theBug = entityManager.find(Bug.class, bug_name);

        // delete the bug

        entityManager.remove(theBug);
    }

    public Bug findByName(String bug_name) {
        return entityManager.find(Bug.class, bug_name);
    }

    public List<Bug> findAll() {
        // create query
        TypedQuery<Bug> theQuery = entityManager.createQuery("From Bug", Bug.class);

        // return query results

        return theQuery.getResultList();
    }

    public List<Bug> findByResolved(boolean condition) {
        // create query
        TypedQuery<Bug> theQuery = entityManager.createQuery("FROM Bug WHERE lastName=:theData", Bug.class);

        // set query parameters

        theQuery.setParameter("theData", condition);

        // return query results

        return theQuery.getResultList();

    }

}