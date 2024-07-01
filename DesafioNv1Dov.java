package DesafioDov;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/*
 * Desafio Surpresa do DOV - Nível 1 Um programa que pode ser usado para
 * cadastrar usuários Opção para digitar S para sair, C para cadastrar e L para
 * listar as pessoas cadastradas Solicitar: Nome completo Gênero Data de
 * nascimento no formato dd/mm/aaaa Nome da rua Número da casa Pode ser feita em
 * Qualquer Língua
 */

public class DesafioNv1Dov {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		List<Pessoa> pessoas = new ArrayList<>();

		System.out.printf("+ --------------------- +");
		System.out.printf("\n+ DESAFIO DOV - Nível 1 +");
		System.out.printf("\n+                       +");
		System.out.printf("\n+  Fefinhas             +");
		System.out.printf("\n+ --------------------- +\n\n");

		// Menu de opções
		char opcao;

		do {
			System.out.printf("Escolha uma opção: \n");
			System.out.printf("s - Sair\n");
			System.out.printf("c - Cadastrar usuário\n");
			System.out.printf("L - Listar usuários\n");
			System.out.printf("Opção: \n");
			opcao = entrada.next().charAt(0);
			entrada.nextLine(); // Limpar Buffer

			switch (opcao) {
			case 'S':
			case 's':
				System.out.printf("Saindo...");
				break;
			case 'C':
			case 'c':
				cadastrarUsuario(entrada, pessoas);
				break;
			case 'L':
			case 'l':
				listarPessoas(pessoas);
				break;
			default:
				System.out.printf("Opção inválida! Escolha S, C ou L");
			}
		} while (opcao != 'S' && opcao != 's');

		entrada.close();
	}

	public static void cadastrarUsuario(Scanner entrada, List<Pessoa> pessoas) {

		// Variaveis
		String nomeCompleto;
		String rua;
		String genero;
		int dia = 0, mes = 0, ano = 0, numero = 0;
		boolean entradanumero;

		// Cadastro do nome completo e validação de caracteres
		do {
			System.out.printf("Digite o seu nome completo: ");
			nomeCompleto = entrada.nextLine();

			if (!nomeValido(nomeCompleto)) {
				System.out.printf("Digite um nome válido!\n");
			}

		} while (!nomeValido(nomeCompleto));

		System.out.printf("Nome cadastrado!!\n");
		System.out.printf("%s\n", nomeCompleto);

		// Cadastro do genero completo e validação de caracteres
		do {
			System.out.printf("Digite seu gênero 'M' ou 'F': ");
			genero = entrada.next();

			if (!genero.equalsIgnoreCase("M") && !genero.equalsIgnoreCase("F")) {
				System.out.printf("Digite um gênero válido!!\n");
			}

		} while (!genero.equalsIgnoreCase("M") && !genero.equalsIgnoreCase("F"));

		System.out.printf("Gênero cadastrado!!\n");
		System.out.printf("%s\n", genero);

		// Cadastro de Data de nascimento no formato dd/mm/aa

		do {
			System.out.printf("Digite o dia do seu nascimento: ");
			dia = entrada.nextInt();
			System.out.printf("Digite o mês do seu nascimento: ");
			mes = entrada.nextInt();
			System.out.printf("Digite o ano do seu nascimento: ");
			ano = entrada.nextInt();

			if (dia > 31 || mes > 12 || ano > 2018) {
				System.out.printf("Digite uma data válida! (DD MM AA)\n");
			}

		} while (dia > 31 || mes > 12 || ano > 2018);

		System.out.printf("Data cadastrada!\n");
		System.out.printf("%d/%d/%d\n", dia, mes, ano);

		// Limpar Buffer
		entrada.nextLine();

		// Cadastro nome da rua

		System.out.printf("Digite o nome da rua: ");
		rua = entrada.nextLine();
		System.out.printf("Rua cadastrada!!\n");
		System.out.printf("%s\n", rua);

		// Cadastro número casa
		do {
			System.out.println("Digite o número da casa: ");
			// Verifica se é um número
			if (entrada.hasNextInt()) {
				numero = entrada.nextInt();
				entradanumero = true;
			} else {
				System.out.println("Número inválido!");
				entrada.next(); // Limpar o buffer
				entradanumero = false;
			}
		} while (!entradanumero);

		System.out.printf("Número cadastrado!\n");
		System.out.printf("%d\n", numero);

		// Adicionar usuario na lista
		pessoas.add(new Pessoa(nomeCompleto, genero, dia, mes, ano, rua, numero));

		entrada.nextLine();// Limpar o buffer

	}

	public static void listarPessoas(List<Pessoa> pessoas) {
		if (pessoas.isEmpty()) {
			System.out.printf("Não existe usuário cadastrado.");
		} else {
			System.out.printf("Usuários cadastrados: ");
			for (Pessoa pessoa : pessoas) {
				System.out.printf("%s", pessoa);
			}
		}
	}

	public static boolean nomeValido(String nome) {

		return nome.matches("[A-Za-zÀ-ÿ]+( [A-Za-zÀ-ÿ]+)*");
	}

}

class Pessoa {
	private String nomeCompleto;
	private String genero;
	private int diaNascimento;
	private int mesNascimento;
	private int anoNascimento;
	private String rua;
	private int numero;

	public Pessoa(String nomeCompleto, String genero, int diaNascimento, int mesNascimento, int anoNascimento,
			String rua, int numero) {
		this.nomeCompleto = nomeCompleto;
		this.genero = genero;
		this.diaNascimento = diaNascimento;
		this.mesNascimento = mesNascimento;
		this.anoNascimento = anoNascimento;
		this.rua = rua;
		this.numero = numero;

	}

	@Override
	public String toString() {
		return "Nome: \n" + nomeCompleto + ", Gênero: \n" + genero + ", Data de Nascimento: \n" + diaNascimento + "/"
				+ mesNascimento + "/" + anoNascimento + ", Endereço: \n" + rua + ", \n" + numero;
	}
}