package poo.model;

public class Funcionario extends Endereco {
    private Double salario;

    public Funcionario(Double salario, Endereco endereco){
        super(endereco.rua, endereco.cidade, endereco.estado);
        this.salario = salario;
    }
}
