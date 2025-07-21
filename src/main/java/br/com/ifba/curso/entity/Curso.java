/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data// Construtor padrão (obrigatório para JPA)
@Entity
@Table(name = "curso")
public class Curso extends PersistenceEntity {

    @Column(name = "nome", nullable = false)
    @Getter @Setter private String nome;

    @Column(name = "status",nullable = false)
    private Boolean ativo = true; // Valor padrão

    @Column(name = "alunos_matriculados", nullable = false)
     private int alunosMatriculados;

}
