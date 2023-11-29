package poo.model;

public class Autor extends Faculdade {
     String nomeAutor;

  

    public Autor(String nomeAutor, String nomeFaculdade, String enderecoFaculdade){
        super(nomeFaculdade, enderecoFaculdade);
        this.nomeAutor = nomeAutor;
    }
}