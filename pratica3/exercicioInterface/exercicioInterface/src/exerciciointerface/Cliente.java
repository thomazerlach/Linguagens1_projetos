/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciointerface;

/**
 *
 * @author thomazerlach
 */
public class Cliente implements IAutenticavel, IImprimivel {
    
    private String psw;
    private String cpf;
    private String nome;
    
    public Cliente(String nome, String cpf, String senha) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.psw = senha;
    }
    
    public boolean alterarSenha(String senhaNova, String senhaAntiga) {
        boolean retorno = false;
        
        if (this.autenticar(senhaAntiga)) {
            this.psw = senhaNova;
            retorno = true;
        }
        return retorno;
    }
    
    public String getNome () {
        return this.nome;
    }
    
    public void setNome (String nomeNovo) {
        this.nome = nomeNovo;
    }
    
    public String getCpf () {
        return this.cpf;
    }
    
    public void setCpf (String cpfNovo) {
        this.cpf = cpfNovo;
    }
    
    @Override
    public boolean autenticar(String senha) {
        return true;
    }
    
    @Override
    public void exibirResumo() {
        System.out.println("Resumo");
    }
    
    @Override
    public void imprimirResumo() {
        System.out.println("enviando...");
        this.exibirResumo();
        System.out.println("para a impressora");
    }
    
}
