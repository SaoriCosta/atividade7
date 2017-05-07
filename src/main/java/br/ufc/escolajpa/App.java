package br.ufc.escolajpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.escolajpa.entidades.Aluno;
import br.ufc.escolajpa.entidades.Disciplina;
import br.ufc.escolajpa.entidades.MatriculaDisciplina;
import br.ufc.escolajpa.entidades.Professor;
import br.ufc.escolajpa.funcoes.Funcoes;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("escola");
		EntityManager em = emf.createEntityManager();
		
		Funcoes funcoes = new Funcoes();
		//Professor p = funcoes.cadastroProfessor();
		
		//funcoes.insertProfessor(emf,p);
		//Aluno a = em.createQuery("select a from Aluno a where id = 98",Aluno.class).getSingleResult();
	//	Professor p = em.createQuery("select p from Professor p where id = 33", Professor.class).getSingleResult();
		//Disciplina d = em.createQuery("select d from Disciplina d where id = 449",Disciplina.class).getSingleResult();
	//	em.getTransaction().commit();
		
		//funcoes.InsertAluno(emf, funcoes.cadastraAluno());
		//SearchAluno(emf);
		
		//for (Disciplina d : funcoes.searchDisci(emf)) {
			//System.out.println(d.getName());
			
		//}
				for (MatriculaDisciplina a : funcoes.searchAlunos(emf)) {
			System.out.println(a.getAluno().getName());
			
		}
	
		//funcoes.insertMatricula(emf, a, d);;
	/*	List<Professor> p = em.createQuery("select p from Professor p", Professor.class).getResultList();
		
		for (Professor professor : p) {
			InsertDisciplina(emf, professor);
		}*/
		
		//searchDisciplina(emf);
		
	/*	List<Aluno> a = em.createQuery("select p from Aluno p", Aluno.class).getResultList();
		List<Disciplina> d = em.createQuery("select d from Disciplina d",Disciplina.class).getResultList();
		for (Aluno aluno : a) {
			for (Disciplina disciplina : d) {
				insertMatricula(emf,aluno,disciplina);
			}
		
		}
		*/
		
		//searchMatricula(emf);
		
		
	
	//	for (Professor pr : funcoes.searchTitu(emf )) {
			//System.out.println(pr.getNome());
			
		}
		
		//System.out.println(funcoes.searchTitu(emf));
		
		//}

}
