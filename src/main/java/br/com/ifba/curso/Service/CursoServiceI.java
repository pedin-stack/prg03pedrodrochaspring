/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.Service;
import br.com.ifba.curso.entity.Curso;
import java.util.List;
/**
 *
 * @author Casa
 */
public interface CursoServiceI {
    Curso save(Curso curso);
    Curso update(Curso curso);
    void delete(Curso curso);
    List<Curso>findAll();
    Curso findById(Long id);
    List<Curso> findbyName(String name);
}
