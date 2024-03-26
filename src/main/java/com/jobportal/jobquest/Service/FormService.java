package com.jobportal.jobquest.Service;

import com.jobportal.jobquest.Model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobportal.jobquest.Repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {

    @Autowired
    private FormRepo FormRepo;

    public List<Form> getAllForms() {
        return FormRepo.findAll();
    }

    public Optional<Form> getFormById(Long id) {
        return FormRepo.findById(id);
    }

    public Form createForm(Form Form) {
        return FormRepo.save(Form);
    }

    public Form updateForm(Long id, Form updatedForm) {
        Optional<Form> Form = FormRepo.findById(id);
        if (Form.isPresent()) {
            updatedForm.setId(id);
            return FormRepo.save(updatedForm);
        } else {
            throw new RuntimeException("student not found");
        }
    }

    public void deleteForm(Long id) {
        FormRepo.deleteById(id);
    }
}