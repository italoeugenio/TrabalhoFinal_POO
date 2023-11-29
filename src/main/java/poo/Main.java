package poo;

import poo.dao.Crud;
import poo.model.Autor;
import poo.model.Faculdade;
import poo.model.Livro;

public class Main {
    
    public static void main(String[] args) {
        Crud Crud = new Crud();

        // Criando e salvando um usuário
        Autor autor = new Autor("", "", "");
        Faculdade faculdade = new Faculdade("", "");
        Livro livro = new Livro("", autor, faculdade);

        Crud.salvarLivro(livro);

        // Recuperando e atualizando o usuário
        Livro LivroEncontrada = Crud.getLivroById(livro.getId());
        System.out.println("Livro encontrada: " + LivroEncontrada);

        Crud.atualizarLivro(LivroEncontrada);

        // Deletando o usuário
        Crud.deletarLivro(LivroEncontrada);

        Livro LivroEncontrada2 = Crud.getLivroById(livro.getId());
        System.out.println("Livro: " + LivroEncontrada2);

        // Fechando a sessão do Hibernate
        Crud.close();
    }

}
