package com.example.curriculo.Service;

import com.example.curriculo.Model.FormModel;
import com.example.curriculo.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public FormModel salvarcurriculo(FormModel form) {
        return formRepository.save(form);
    }
    public List<FormModel> getAllForms(){
        return formRepository.findAll();
    }

    public FormModel findById(Long id){
        Optional<FormModel> resultCurriculo = formRepository.findById(id);
        if (resultCurriculo.isPresent()) {
            return resultCurriculo.get();
        }
        return null;
    }
    public void deleteById(Long id) throws Exception{
        if(findById(id) != null){
            formRepository.deleteById(id);
        }else{
            throw new Exception("curriculo with id " +id+ "not found");
        }
    }

    public FormModel update(Long id, FormModel form) throws Exception {
        Optional<FormModel> existente = formRepository.findById(id);

        if (existente.isPresent()) {
            FormModel curriculo = existente.get();
            curriculo.setNome(form.getNome());
            curriculo.setTelefone(form.getTelefone());
            curriculo.setEmail(form.getEmail());
            curriculo.setDescricao(form.getDescricao());
            curriculo.setFormacao(form.getFormacao());
            return formRepository.save(curriculo);
        } else {
            throw new Exception("Curriculo não encontrado com o id " + id);
        }
    }

}
