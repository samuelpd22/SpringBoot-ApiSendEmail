package com.ApiEnviodeEmail.repository;

import com.ApiEnviodeEmail.entity.CadastrarUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<CadastrarUser,Long> {
}
