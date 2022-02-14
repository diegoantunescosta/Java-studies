
import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class Main {

	private static ArrayList<Aluno> ListadeAlunos = new ArrayList<Aluno>();
	private static ArrayList<Registro> ListadeRegistros = new ArrayList<Registro>();
	private static ArrayList<Curso> ListadeCursos = new ArrayList<Curso>();

	public static void main(String[] args) throws IOException {
		
		Menu();
	}
	
	public static void Menu() throws IOException {		
		
		String tela = "1)Cadastrar aluno" + "\n2)Listar alunos" + "\n3)Sair";
		String opcao = "";
		do{			
			opcao = Entrada(tela);
			
			if (opcao.equals("1")){
				cadastroAluno();
			} else if (opcao.equals("2")) {
				listaAluno();
			}
			}while (!opcao.equals("3"));
		} 
		

	
	private static void cadastroAluno(){
		String nome = Entrada("Nome Completo: ");
		String ra = Entrada("Ra: ");
		String matricula = Entrada("Curso: ");
			
		Aluno aluno = new Aluno(nome);
		ListadeAlunos.add(aluno);
		
		Registro registro = new Registro(ra);
		ListadeRegistros.add(registro);		
		
		Curso curso = new Curso(matricula);
		ListadeCursos.add(curso);		


		

		
	}
	
	private static void listaAluno() throws IOException {
		if (ListadeAlunos.isEmpty()) {
			SaidaDados("Nenhum aluno cadastrado");
			return;
		}
		FileWriter arq = new FileWriter("lista_aluno.txt"); 
		PrintWriter gravarArq = new PrintWriter(arq);
		
		String relatorio = "";
		
		gravarArq.printf("------- LISTA DE ALUNOS ------\r\n");
		
		for(int i = 0; i < ListadeAlunos.size() & i <  ListadeRegistros.size(); i++) {
			Aluno Lista = ListadeAlunos.get(i);
			relatorio += "\nNome: " + Lista.getNome();
			gravarArq.printf("\nNome = " + Lista.getNome());
			Registro ListaRa = ListadeRegistros.get(i);
			gravarArq.printf("\nRA = " + "\n"+ ListaRa.getRa());
			relatorio += "\nRA: " + ListaRa.getRa();
			Curso ListaMatricula = ListadeCursos.get(i);
			gravarArq.printf("\nCurso = " + "\n"+ ListaMatricula.getMatricula());
			relatorio += "\nCurso: " + ListaMatricula.getMatricula() + "\n------------------------------------";
		}
		gravarArq.printf("\n------- FIM ------\r\n");
		gravarArq.close();
		
		JOptionPane.showMessageDialog(null, relatorio);
	}
	
	private static String Entrada(String entrar) {
		return JOptionPane.showInputDialog(entrar);
	}
	
	private static void SaidaDados(String saida) {
		JOptionPane.showMessageDialog(null, saida);
	}
	

}
