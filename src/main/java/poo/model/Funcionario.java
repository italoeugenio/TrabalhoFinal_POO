package poo.model;
public class Funcionario extends Pessoa {
private double salario;

public Funcionario(String nome, int idade, String telefone, String cpf, double salario) {
    super(nome, idade, telefone, cpf);
    this.salario = salario;
    
 }

public double getSalario() {
    return salario;
 }

public void setSalario(double salario) {
    this.salario = salario;
 }

 
}
