package poo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro extends Autor{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
   
    String nomeAutor;
    String nomeFaculdade;
    String enderecoFaculdade;

   public Livro(){
        super("", null, null);
   }

    public Livro(String titulo, Autor autor, Faculdade faculdade) {
        super(autor.nomeAutor, faculdade.nomeFaculdade, faculdade.enderecoFaculdade);
        this.titulo = titulo;
        this.nomeAutor = autor.nomeAutor;
        this.nomeFaculdade = faculdade.nomeFaculdade;
        this.enderecoFaculdade = faculdade.enderecoFaculdade;
    
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.titulo;
    }

    public void setNome(String nome) {
        this.titulo = nome;
    }
    
    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", nomeFaculdade='" + nomeFaculdade + '\'' +
                ", enderecoFaculdade='" + enderecoFaculdade + '\'' +
                '}';
    }

}
