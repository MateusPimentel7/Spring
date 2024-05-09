package com.Aplicacao2024.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aplicacao2024.entidades.Emprestimos;
import com.Aplicacao2024.entidades.User;
import com.Aplicacao2024.repositorio.EmprestimosRepository;
import com.Aplicacao2024.repositorio.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmprestimosRepository emprestimosRepository;

    public List<User> listarUser() {
        return userRepository.findAll();
    }

    public User cadastrarUsuario(User user) {
        return userRepository.save(user);
    }

    public boolean verificarPossibilidadeDeEmprestimo(Long idUsuario) {
        List<Emprestimos> emprestimosNaoEntregues = emprestimosRepository
                .findByidUserAndEntregaRealizadaFalse(idUsuario);
        return emprestimosNaoEntregues.size() <= 3;
    }

    public boolean verificarLivroJaEmprestado(Long idUser, Long idLivro) {
        Emprestimos emprestimoExistente = emprestimosRepository
                .findByidUserAndIdLivroAndEntregaRealizadaFalse(idUser, idLivro);
        return emprestimoExistente == null;
    }
}
