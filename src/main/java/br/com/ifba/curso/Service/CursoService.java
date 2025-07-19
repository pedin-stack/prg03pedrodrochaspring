/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.Service;

import br.com.ifba.curso.exceptions.Exceptions;
import java.util.List;
import br.com.ifba.curso.entity.Curso;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ifba.curso.repository.CursoRepository;
import java.util.Optional;


/**
 *
 * @author Casa
 */
@Service
public class CursoService implements CursoServiceI {

    @Autowired
    private final CursoRepository Cr; 

    Exceptions excecoes = new Exceptions();

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.Cr = cursoRepository;
    }

    @Override
    @Transactional
    public void save(Curso curso) throws RuntimeException {
        if (excecoes.capsuleisNull(curso)) {
            throw new RuntimeException("Dados do curso não preenchidos");
        }
        Cr.save(curso);
    }

    @Override
    @Transactional
    public void update(Curso curso) throws RuntimeException {
        if (excecoes.capsuleisNull(curso)) {
            throw new RuntimeException("Dados do curso não preenchidos");
        }
        Cr.save(curso);
    }

    @Override
    @Transactional
    public void delete(Curso curso) throws RuntimeException {
        if (excecoes.capsuleisNull(curso)) {
            throw new RuntimeException("Dados do curso não preenchidos");
        }
        Cr.delete(curso);
    }

    @Override
    public List findAll() throws RuntimeException {
        return Cr.findAll();
    }
@Override
    public Curso findById(Long id) throws RuntimeException {
        
        return Cr.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso com ID " + id + " não encontrado."));
    }
    

    @Override
    public List<Curso> findbyName(String name) throws RuntimeException {
        return Cr.findByNomeContainingIgnoreCase(name);
    }
}
