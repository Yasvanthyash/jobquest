package com.jobportal.jobquest.Controller;

import com.jobportal.jobquest.Model.*;
import com.jobportal.jobquest.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forms")
@CrossOrigin(origins ="http://localhost:5173/",allowedHeaders = "*")
public class FormController {

    @Autowired
    private FormService FormService;

    @GetMapping("/alll")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Form> getAllForms() {
        return FormService.getAllForms();
    }

    @PostMapping("/addd")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public Form createForm(@RequestBody Form Form) {
        return FormService.createForm(Form);
    }

    @PutMapping("/updatee/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public Form updateForm(@PathVariable Long id,@RequestBody Form updatedstudentrReg) {
        return FormService.updateForm(id,updatedstudentrReg);
    }

    @DeleteMapping("/deletee/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public void deleteForm(@PathVariable Long id) {
        FormService.deleteForm(id);
    }
}