package br.unipar.programacaointernet.taskmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 200)
  private String descricao;

  @Column(length = 120)
  private String observacao;

  @Column(length = 10)
  private String dataPrevisao;

  @Column(length = 20)
  private String prioridade;

  @Column(length = 30)
  private String status;

  @Column(length = 10)
  private String dataInicio;

  @Column(length = 10)
  private String dataTermino;

  @Column()
  private Integer idUsuario;
}
