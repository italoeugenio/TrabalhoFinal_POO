package poo.model;

public class Cliente extends Pessoa {
private int numeroDeCompras;

 
 public Cliente(String nome, int idade, String telefone, String cpf, int numeroDeCompras) {
    super(nome, idade, telefone, cpf);
    this.numeroDeCompras = numeroDeCompras;
 }

 public int getNumeroDeCompras() {
    return numeroDeCompras;
 }

 public void setNumeroDeCompras(int numeroDeCompras) {
    this.numeroDeCompras = numeroDeCompras;
 }
}
