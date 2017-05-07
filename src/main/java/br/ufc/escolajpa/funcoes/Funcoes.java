package br.ufc.escolajpa.funcoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

import br.ufc.escolajpa.entidades.Aluno;
import br.ufc.escolajpa.entidades.Disciplina;
import br.ufc.escolajpa.entidades.MatriculaDisciplina;
import br.ufc.escolajpa.entidades.Professor;

public class Funcoes {

	public Professor cadastroProfessor(){
		
		Professor p = new Professor();
		String nome = JOptionPane.showInputDialog("Insira o nome do professor");
		String titulacao = JOptionPane.showInputDialog("Insira a titulacao do professor");
		p.setNome(nome);
		p.setTitulacao(titulacao);

		return p;
	}
	
	
	public Aluno cadastraAluno(){
		
		Aluno a = new Aluno();
		
		String nome = JOptionPane.showInputDialog("Insira o nome do aluno");
		String email = JOptionPane.showInputDialog("Insira o email do aluno");
		a.setName(nome);
		a.setEmail(email);
		
		return a;
	}
	
	
	public static void InsertAluno(EntityManagerFactory emf, Aluno aluno) {
		
		
		EntityManager em = emf.createEntityManager();

		
		em.getTransaction().begin();
		em.persist(aluno);
		em.flush();
		em.getTransaction().commit();
		
		em.close();
	}
	

	public void InsertDisciplina(EntityManagerFactory emf, Professor professor) {
		EntityManager em = emf.createEntityManager();
	
		
		Disciplina d = new Disciplina();
		String nome = JOptionPane.showInputDialog("Insira o nome da disciplina");
		String ch = JOptionPane.showInputDialog("Insira a carga horaria");
		d.setProfessor(professor);
		d.setName(nome);
		d.setWorkload(Integer.parseInt(ch));
		em.getTransaction().begin();
		em.persist(d);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	public void insertProfessor(EntityManagerFactory emf, Professor professor) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(professor);
		em.flush();
		em.getTransaction().commit();
		
		em.close();
	}

	public static void searchMatricula(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
	

		em.getTransaction().begin();
		            
		List<MatriculaDisciplina> students = em.createQuery("select di from MatriculaDisciplina di",MatriculaDisciplina.class).getResultList();
		em.getTransaction().commit();
		
		for (MatriculaDisciplina matriculaDisciplina : students) {
			System.out.println(matriculaDisciplina.getAluno().getName() + " | " + matriculaDisciplina.getAluno().getEmail());
			System.out.println(matriculaDisciplina.getDisciplina().getName() + " | " + matriculaDisciplina.getDisciplina().getWorkload());
			System.out.println(matriculaDisciplina.getYear());
		}		
		em.close();
	}

	public static Professor searchProfessor(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		            
	Professor professor = em.createQuery("select p from professor p id=33",Professor.class).getSingleResult();
		em.getTransaction().commit();
		
		em.close();
		return professor;
	}
	
	public static void insertMatricula(EntityManagerFactory emf, Aluno aluno, Disciplina disciplina) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		        
		
		
		MatriculaDisciplina disciplineInscription = new MatriculaDisciplina();
		disciplineInscription.setAluno(aluno);
		disciplineInscription.setDisciplina(disciplina);
		disciplineInscription.setYear(2014);
		disciplineInscription.setNota(2);
		        
		em.persist(disciplineInscription);
		        
		em.getTransaction().commit();
		em.close();
	}

	public static Disciplina searchDisciplina(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Disciplina disciplina = em.createQuery("select d from Disciplina d where id = 0",Disciplina.class).getSingleResult();
		em.getTransaction().commit();
		System.out.println(disciplina.getId() + " | " + disciplina.getName() + " | "+disciplina.getWorkload());
		
		em.close();
		
		return disciplina;
	}


	public static Aluno SearchAluno(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Aluno a = em.createQuery("select a from Aluno a where id = 1",Aluno.class).getSingleResult();
		em.getTransaction().commit();
		
		System.out.println(a.getId() + " | " + a.getName() + " | "+a.getEmail() );
		em.close();
		
		return a;
	}

	public List<Professor> searchTitu(EntityManagerFactory emf){
		
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		List<Professor> p = em.createQuery("select p from Professor p where titulacao = 'phd'", Professor.class).getResultList();
		em.getTransaction().commit();
		em.close();
		
		return p;
		
	}
	
public List<Disciplina> searchDisci(EntityManagerFactory emf){
		
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		List<Disciplina> d = em.createQuery("select d from Disciplina d where professor.nome = 'jose'", Disciplina.class).getResultList();
		em.getTransaction().commit();
		em.close();
		
		return d;
		
	}
public List<MatriculaDisciplina> searchAlunos(EntityManagerFactory emf){
	
	
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	
	List<MatriculaDisciplina> a = em.createQuery("select m from MatriculaDisciplina m where aluno_id = aluno.id and disciplina_id = disciplina.id and nota<6 and year=2014", MatriculaDisciplina.class).getResultList();
	em.getTransaction().commit();
	em.close();
	
	return a;
	
}
}

