/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.Controller;
import br.com.ifba.curso.entity.Curso;
import java.util.List;
import br.com.ifba.curso.Service.CursoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 *
 * @author Casa
 */
@Controller
public class CursoController implements CursoControllerI {
    @Autowired
    private final CursoServiceI cursoService;

     @Autowired
    public CursoController(CursoServiceI cursoService) {
        this.cursoService = cursoService;
    }
    
    @Override
    public void save(Curso curso)throws RuntimeException {// nome,codigo,status e quantidades nao vazios e nao nulos 
           cursoService.save(curso);
    }

    @Override
    public void update(Curso curso)throws RuntimeException {//manterrei no controler como update para meros fins de organização
        cursoService.update(curso);
    }

    @Override
    public void delete(Curso curso)throws RuntimeException {
        cursoService.delete(curso);
    }

    @Override
    public List findAll()throws RuntimeException {
        return cursoService.findAll();
    }

    @Override
    public Curso findById(Long id)throws RuntimeException {
        return cursoService.findById(id);
    }

    @Override
    public List<Curso> findByName(String name)throws RuntimeException {
        return cursoService.findbyName(name);
    }
    
}
