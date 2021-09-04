package br.com.zup;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        //Variáveis
        int dados;
        String email;
        String nome = "";
        String telefone;
        String cpf;
        String menuFuncionario = "";


        //Criando a Lista
        Map<String, String> funcionario = new HashMap<>();


        //Condicional para o menu ser apresentado ao usuário
        while (menuFuncionario.equalsIgnoreCase("")) {
            System.out.println("Digite o que deseja pelo numero abaixo");
            System.out.println("1 - Adicionar funcionários");
            System.out.println("2 - Remover funcionários");
            System.out.println("3 - Exibir a lista de funcionários");
            System.out.println("4 - Para encerrar interação com o programa.");
            dados = leitor.nextInt();
            leitor.nextLine();


            //Condicional para coletar e armazenar dados inseridos pelo usuário
            switch (dados) {
                case 1:
                    System.out.println("Por favor, digite o nome  completo do funcionário: ");
                    nome = leitor.nextLine();

                    System.out.println("Agora digite o telefone: ");
                    telefone = leitor.nextLine();

                    System.out.println("Digite o e-mail do funcionário: ");
                    email = leitor.nextLine();

                    System.out.println("CPF do funcionário: ");
                    cpf = leitor.nextLine();

                    //Criado uma condicional para que o cpf não seja repetido pelo usuário
                    if (funcionario.containsKey(cpf)) {
                        System.out.println("Esse CPF já consta no sistema!");
                        System.out.println("Digite um CPF válido:");
                        cpf = leitor.nextLine();
                    }

                    funcionario.put(cpf, " Nome: " + nome + " Telefone: " + telefone + " Email: " + email);

                    break;

                case 2:
                    // Condicional para o usuário remover um funcionário
                    System.out.println("Digite o CPF do funcionário que você deseja remover");
                    cpf = leitor.next();

                    // Condicional pra verificar se esse usuário está cadastrado
                    if (funcionario.containsKey(cpf)) {
                        System.out.println("Funcionário removido: \n" + funcionario.get(cpf));
                        funcionario.remove(cpf);
                    } else {
                        System.out.println("Este funcionário não se encontra cadatrado, por favor insira novamente");
                    }
                    break;

                case 3:
                    //Irá ser apresentado todos os funcionários cadastrados
                    for (String referencia : funcionario.values()) {
                        System.out.println(referencia);
                    }
                    break;
                default:
                    //Possibilidade de o usuário não inserir uma valor valido a ser apresentado
                    System.out.println("É necessário que informe uma opção valida");

                case 4:
                    //Programa a ser encerrado pelo usuário
                    System.out.println("Programa encerrado!");
                    System.exit(0);
                    break;
            }
        }

    }
}
