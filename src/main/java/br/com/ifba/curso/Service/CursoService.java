/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.Service;

import br.com.ifba.curso.exceptions.Exceptions;
import java.util.List;
import br.com.ifba.curso.entity.Curso;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import br.com.ifba.curso.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Casa
 */
@Slf4j
@Service
@RequiredArgsConstructor// injeção de dependencias FEITA DE forma automatica pelo lombook
public class CursoService implements CursoServiceI {

    private final CursoRepository Cr;

    Exceptions excecoes = new Exceptions();

    @Override
    @Transactional
    public void save(Curso curso) throws RuntimeException {
        if (excecoes.capsuleisNull(curso)) {
            throw new RuntimeException("Dados do curso não preenchidos");
        } else {
            Cr.save(curso);

            log.info("Salvando curso");
        }

    }

    @Override
    @Transactional
    public void update(Curso curso) throws RuntimeException {
        if (excecoes.capsuleisNull(curso)) {
            throw new RuntimeException("Dados do curso não preenchidos");
        } else {

            Cr.save(curso);
            log.info("Curso" + curso + "teve suas informações alteradas");
        }
    }

    @Override
    @Transactional
    public void delete(Curso curso) throws RuntimeException {
        if (excecoes.capsuleisNull(curso)) {
            throw new RuntimeException("Dados do curso não preenchidos");
        } else {

            Cr.delete(curso);
            log.info("Curso" + curso + "foi excluído");
        }

    }

    @Override
    public List findAll() throws RuntimeException {
        return Cr.findAll();
    }

    @Override
    public Curso findById(Long id) throws RuntimeException {

        return Cr.findById(id).orElseThrow(() -> new IllegalArgumentException("Curso com ID " + id + " não encontrado."));
    }

    @Override
    public List<Curso> findbyName(String name) throws RuntimeException {
        return Cr.findByNomeContainingIgnoreCase(name);
    }
}
