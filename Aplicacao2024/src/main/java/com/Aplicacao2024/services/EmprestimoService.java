package com.Aplicacao2024.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimosRepository emprestimosRepository;

    public String emprestarLivro(Long idUser, Long idLivro, LocalDate dataDeEntrega) {
        if (!userService.verificarPossibilidadeDeEmprestimo(idUser)) {
            return "Você atingiu o limite máximo de empréstimos não devolvidos.";
        }

        if (!userService.verificarLivroJaEmprestado(idUser, idLivro)) {
            return "Você já possui este livro emprestado e não devolvido.";
        }

        Emprestimos emprestimos = new Emprestimos();
        emprestimoLivro.setIdUser(idUsuario);
        emprestimoLivro.setIdLivro(idLivro);
        emprestimoLivro.setDataDeEntrega(dataDeEntrega);
        emprestimoLivro.setEntregaRealizada(false);
        emprestimoLivroRepository.save(emprestimos);

        return "Empréstimo realizado com sucesso!";
    }

    public String entregarLivro(Long idEmprestimos) {
        Emprestimos emprestimos = emprestimoLivroRepository.findById(idEmprestimo).orElse(null);

        if (emprestimos == null) {
            return "Empréstimo não encontrado.";
        }

        if (emprestimos.isEntregaRealizada()) {
            return "O livro já foi entregue anteriormente.";
        }

        emprestimos.setEntregaRealizada(true);
        emprestimosRepository.save(emprestimos);

        return "Livro entregue com sucesso!";
    }
}
