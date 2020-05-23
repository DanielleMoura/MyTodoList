package com.mytodolist.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="subtarefa")
public class SubTarefa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigosub;
	private String horario;
	private String nomeSubTarefa;
	
	
	@ManyToOne
	private Tarefa tarefa;

	public long getCodigosub() {
		return codigosub;
	}
	public void setCodigosub(long codigosub) {
		this.codigosub = codigosub;
	}
	public String getNomeSubTarefa() {
		return nomeSubTarefa;
	}
	public void setNomeSubTarefa(String nomeSubTarefa) {
		this.nomeSubTarefa = nomeSubTarefa;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Tarefa getTarefa() {
		return tarefa;
	}
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	
}
