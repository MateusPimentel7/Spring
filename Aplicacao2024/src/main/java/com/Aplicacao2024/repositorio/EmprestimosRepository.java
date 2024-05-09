package com.Aplicacao2024.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Aplicacao2024.entidades.Emprestimos;

@Repository
public interface EmprestimosRepository extends JpaRepository<Emprestimos, Long> {

    List<Emprestimos> findByidUserAndEntregaRealizadaFalse(Long idUsuario);

    Emprestimos findByidUserAndIdLivroAndEntregaRealizadaFalse(Long idUser, Long idLivro);

}
