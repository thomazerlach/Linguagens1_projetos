package aula03;

public class Cliente {
    
    private String nome;
    private String endereco;
    private String cpf;
    private int idade;
    
    void visualizarDados() {
        System.out.println("Nome : " + this.nome);
        System.out.println("CPF: " + this.cpf);
    }
    
    public void mudarCPF(String cpf) {
        if (ValidarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("Não foi possivel alterar o CPF.");
        }
    }
    
    private boolean ValidarCPF(String cpf) {
        // serie de regras
        return true;
    }
    
}
