package poo;

import poo.dao.Crud;
import poo.model.Autor;
import poo.model.Faculdade;
import poo.model.Livro;
import java.util.Scanner;

public class Main {
    /*
    Pessoas que participaram da produção do trabalho:
    -Joel Alves dos Santos (UC22102248)
    -Ítalo Cezar Eugênio de Santana (UC22102126)
    -Jairo Pereira de Sousa Júnior (UC22101494)
    -Kauã Miguel Costa Matos (UC22101679)
    -Mirelle Alves Sine (UC22101838)
    */
    public static void main(String[] args) {
        Crud crud = new Crud();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarLivro(scanner, crud);
                    break;
                case 2:
                    consultarLivro(scanner, crud);
                    break;
                case 3:
                    atualizarLivro(scanner, crud);
                    break;
                case 4:
                    excluirLivro(scanner, crud);
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }

        } while (opcao != 0);

        crud.close();
        scanner.close();
    }

    private static void cadastrarLivro(Scanner scanner, Crud crud) {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o nome do autor: ");
        String nomeAutor = scanner.nextLine();

        System.out.print("Digite o nome da faculdade: ");
        String nomeFaculdade = scanner.nextLine();

        System.out.print("Digite o endereço da faculdade: ");
        String enderecoFaculdade = scanner.nextLine();

        Autor autor = new Autor(nomeAutor, nomeFaculdade, enderecoFaculdade);
        Faculdade faculdade = new Faculdade(nomeFaculdade, enderecoFaculdade);
        Livro livro = new Livro(titulo, autor, faculdade);

        crud.salvarLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void consultarLivro(Scanner scanner, Crud crud) {
        System.out.print("Digite o ID do livro a ser consultado: ");
        Long id = scanner.nextLong();

        Livro livroEncontrado = crud.getLivroById(id);

        if (livroEncontrado != null) {
            System.out.println("Livro encontrado: " + livroEncontrado);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private static void atualizarLivro(Scanner scanner, Crud crud) {
        System.out.print("Digite o ID do livro a ser atualizado: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        
        Livro livroEncontrado = crud.getLivroById(id);

        if (livroEncontrado != null) {
            System.out.print("Digite o novo título do livro: ");
            String novoTitulo = scanner.nextLine();
            livroEncontrado.setNome(novoTitulo);

            crud.atualizarLivro(livroEncontrado);
            System.out.println("Livro atualizado com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private static void excluirLivro(Scanner scanner, Crud crud) {
        System.out.print("Digite o ID do livro a ser excluído: ");
        Long id = scanner.nextLong();

        Livro livroEncontrado = crud.getLivroById(id);

        if (livroEncontrado != null) {
            crud.deletarLivro(livroEncontrado);
            System.out.println("Livro excluído com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}
