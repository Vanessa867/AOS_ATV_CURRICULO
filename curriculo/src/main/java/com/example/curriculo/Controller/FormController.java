package com.example.curriculo.Controller;

import com.example.curriculo.Model.FormModel;
import com.example.curriculo.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Curriculos")
@RestController
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping("/novocurriculo")
    public FormModel criarcurriculo(@RequestBody FormModel form){
        return formService.salvarcurriculo(form);
    }
    @GetMapping("/curriculo/{id}")
    public FormModel curriculoId(@PathVariable Long id){
        return formService.findById(id);
    }
    @GetMapping("/todoscurriculos")
    public List<FormModel> getAllForms() {
        return formService.getAllForms();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FormModel> updateForm(@PathVariable Long id, @RequestBody FormModel form) throws Exception {
        FormModel updatedForm = formService.update(id, form);
        return ResponseEntity.ok(updatedForm);
    }

    @DeleteMapping("/deletarcurriculo/{id}")
    public void deletar(Long id){
        try{
            formService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
