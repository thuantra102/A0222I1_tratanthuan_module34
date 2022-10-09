package com.service;

import com.model.EmailModel;
import com.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;
    public void save(EmailModel email) {
        emailRepository.save(email);
    }

}
