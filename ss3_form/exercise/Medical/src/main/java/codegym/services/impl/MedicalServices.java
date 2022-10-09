package codegym.services.impl;

import codegym.model.Medical;
import codegym.repository.IMedicalRepository;
import codegym.services.IMedicalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicalServices implements IMedicalServices {
    @Autowired
    private IMedicalRepository iMedicalRepository;
    @Override
    public List<Medical> findAll() {
        return iMedicalRepository.findAll();
    }

    @Override
    public void update(Medical medical) {
        iMedicalRepository.update(medical);
    }
}
