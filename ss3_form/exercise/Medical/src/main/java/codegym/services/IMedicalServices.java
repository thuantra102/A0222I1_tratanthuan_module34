package codegym.services;

import codegym.model.Medical;

import java.util.List;

public interface IMedicalServices {
    List<Medical> findAll();
    void update(Medical medical);
}
