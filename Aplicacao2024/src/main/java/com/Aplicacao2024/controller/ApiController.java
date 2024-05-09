package com.Aplicacao2024.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Aplicacao2024.entidades.Emprestimos;
import com.Aplicacao2024.repositorio.EmprestimosRepository;
import com.Aplicacao2024.services.EmprestimoService;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private EmprestimosRepository emprestimosRepository;

    @GetMapping("/emprestimos")
    public List<Emprestimos> listarEmprestimos() {
        return emprestimosRepository.findAll();
    }

    @GetMapping("/emprestimos/{id}")
    public Emprestimos getEmprestimo(@PathVariable Long id) {
        return emprestimosRepository.findById(id).orElse(null);
    }

    @PostMapping("/emprestimos")
    public String emprestarLivro(@RequestParam Long idUsuario, @RequestParam Long idLivro,
            @RequestParam LocalDate dataDeEntrega) {
        return emprestimoService.emprestarLivro(idUsuario, idLivro, dataDeEntrega);
    }

    @PostMapping("/emprestimos/{id}/devolver")
    public String devolverLivro(@PathVariable Long id) {
        return emprestimoService.entregarLivro(id);
    }
}
