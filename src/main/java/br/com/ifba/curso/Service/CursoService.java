/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.Service;
import br.com.ifba.curso.exceptions.Exceptions;
import java.util.List;
import br.com.ifba.curso.dao.CursoDaoI;
import br.com.ifba.curso.entity.Curso;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Casa
 */
@Service
public class CursoService implements CursoServiceI {
    @Autowired
      private CursoDaoI cursoDao;
    
      Exceptions excecoes = new Exceptions();// injeção da clsse criada para uso de exceções

      @Autowired
    public CursoService(CursoDaoI cursoDao) {
        this.cursoDao = cursoDao;
    }
      
    @Override
    @Transactional//indicar ao spring que isso deve ser admnistrado como uma transação de bd
    public Curso save(Curso curso)throws RuntimeException {
        
        if(excecoes.capsuleisNull(curso)){
        
            throw new RuntimeException ("Dados do curso não preenchidos");  
        
        } else {
        
         return cursoDao.save(curso);
        }
    }

    @Override
    @Transactional
    public Curso update(Curso curso)throws RuntimeException {
         if(excecoes.capsuleisNull(curso)){
        
            throw new RuntimeException ("Dados do curso não preenchidos");  
        
        }  else{
        
        return cursoDao.update(curso);
        }
    }

    @Override
    @Transactional
    public void delete(Curso curso)throws RuntimeException {
        
        if(excecoes.capsuleisNull(curso)){
        
            throw new RuntimeException ("Dados do curso não preenchidos");  
        
        } else{
        
            cursoDao.delete(curso);
        
        }
        
    }

    @Override
  
    public List<Curso> findAll()throws RuntimeException {
        return cursoDao.findAll();
    }

    @Override
    public Curso findById(Long id)throws RuntimeException{
  
        return cursoDao.findById(id);
    }

    @Override
    public List<Curso> findbyName(String name)throws RuntimeException{
        return cursoDao.findByName(name);
    }
}
