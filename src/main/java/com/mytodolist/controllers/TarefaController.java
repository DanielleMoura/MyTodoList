package com.mytodolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mytodolist.models.SubTarefa;
import com.mytodolist.models.Tarefa;
import com.mytodolist.repository.SubTarefaRepository;
import com.mytodolist.repository.TarefaRepository;


@Controller
public class TarefaController {
	
	@Autowired
	private TarefaRepository tr;
	
	@Autowired
	private SubTarefaRepository str;
		
		@RequestMapping(value="/cadastrarTarefa", method=RequestMethod.GET)
		public String form() {
			return "tarefa/formTarefa";
			}
		
		@RequestMapping(value="/cadastrarTarefa", method=RequestMethod.POST)
		public String form(Tarefa tarefa) {
			tr.save(tarefa);
			return "redirect:/cadastrarTarefa";
			}
		
		@RequestMapping("/tarefa")
		public ModelAndView listaTarefas(){
			ModelAndView mv = new ModelAndView("index");
			Iterable<Tarefa> tarefa = tr.findAll();
			mv.addObject("tarefa", tarefa);
			return mv;
		}
		

		@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
		public ModelAndView detalhesTarefa(@PathVariable("codigo") long codigo){
			Tarefa tarefa = tr.findByCodigo(codigo);
			ModelAndView mv = new ModelAndView("tarefa/detalhesTarefa");
			mv.addObject("tarefa", tarefa);
			Iterable<SubTarefa> subtarefa = str.findByTarefa(tarefa);
			mv.addObject("subtarefa", subtarefa);
			return mv;
		}
		
		@RequestMapping("/deletarTarefa")
		public String deletarTarefa(long codigo) {
			Tarefa tarefa = tr.findByCodigo(codigo);
			tr.delete(tarefa);
			return "redirect:/tarefa";
		}

		@RequestMapping("/deletarSubTarefa")
		public String deletarSubTarefa(long codigosub) {
			SubTarefa subtarefa = str.findByCodigosub(codigosub);
			str.delete(subtarefa);
			
			Tarefa tarefa = subtarefa.getTarefa();
			long codigolong = tarefa.getCodigo();
			String codigo = "" + codigolong;
			return "redirect:/" + codigo;
		}

		
		@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
		public String detalhesTarefaPost(@PathVariable("codigo") long codigo, SubTarefa subtarefa){
			Tarefa tarefa = tr.findByCodigo(codigo);
			subtarefa.setTarefa(tarefa);
			str.save(subtarefa);			
			return "redirect:/{codigo}";
		}

}
