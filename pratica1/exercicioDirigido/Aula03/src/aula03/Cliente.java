package aula03;

public class Cliente {
    
    String nome;
    String sobrenome;
    String cpf;
    
    void visualizarDados() {
        System.out.println("Nome : " + this.nome + " " + this.sobrenome);
        System.out.println("CPF: " + this.cpf);
    }
    
}
