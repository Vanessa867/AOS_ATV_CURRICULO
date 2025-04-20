package com.example.curriculo.Repository;

import com.example.curriculo.Model.FormModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<FormModel, Long> {
}
