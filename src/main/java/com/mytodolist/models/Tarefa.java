package com.mytodolist.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="tarefa")	
public class Tarefa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;
	
	private String nomeDaTarefa;
	private String descricao;
	private String prazo;
	
	
	@OneToMany
	private List<SubTarefa> subtarefa;
			
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNomeDaTarefa() {
		return nomeDaTarefa;
	}
	public void setNomeDaTarefa(String nomeDaTarefa) {
		this.nomeDaTarefa = nomeDaTarefa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPrazo() {
		return prazo;
	}
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}
	
}
