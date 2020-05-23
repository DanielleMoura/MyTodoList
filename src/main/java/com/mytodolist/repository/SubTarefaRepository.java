package com.mytodolist.repository;

import org.springframework.data.repository.CrudRepository;

import com.mytodolist.models.SubTarefa;
import com.mytodolist.models.Tarefa;

public interface SubTarefaRepository extends CrudRepository <SubTarefa, String>{
	Iterable<SubTarefa> findByTarefa(Tarefa tarefa);
	SubTarefa findByCodigosub(long codigosub);
	
}
