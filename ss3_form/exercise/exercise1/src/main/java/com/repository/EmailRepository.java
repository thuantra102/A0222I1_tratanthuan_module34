package com.repository;

import com.model.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class EmailRepository {
    @PersistenceContext
    EntityManager entityManager;
    public void save(EmailModel email) {
        entityManager.persist(email);
    }
}
