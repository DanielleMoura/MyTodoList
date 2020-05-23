package com.mytodolist.repository;

import org.springframework.data.repository.CrudRepository;
import com.mytodolist.models.Tarefa;

public interface TarefaRepository extends CrudRepository <Tarefa, String>{
	Tarefa findByCodigo(long codigo);
}
