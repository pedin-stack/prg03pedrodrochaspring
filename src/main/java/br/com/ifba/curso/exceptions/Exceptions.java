/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.exceptions;



import java.util.List;

import br.com.ifba.curso.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Casa
 */

public class Exceptions {
    
    //CursoDao dao = new CursoDao();
    Curso curso = new Curso();
    /*
    public boolean idisEqual(Long id){
    
     List<Curso> listaCapsula = dao.findAll();
    
     for(Curso cursos : listaCapsula){
     
         if(curso.getId().equals(cursos.getId())){
         
           
             return true;
             
         }
     
     }
    
     return false;
     
    }*/
    
    public boolean capsuleisNull(Curso curso){
    
    if(curso == null){
    
    return true;
    
    } else {
    
    return false;
    
    }
    
    }
    
    public boolean dbisEmpty(List lista){
    
    if(lista.isEmpty()){
    
        return true;
    
    } else{
    
    return false;
    
    }
    
    }
    
    public boolean cursoIsSelected(int itemSelecionado){
    
    if(itemSelecionado == -1){
    
    return false;
        
    } else {
    
    return true;
    
    }
    
    
    
    }
    
    public boolean listIsEmpty(List lista){
    
    if(lista.isEmpty()){
    
        return true;
        
    } else {
    
    return false;
    
    }
    
    }
}
