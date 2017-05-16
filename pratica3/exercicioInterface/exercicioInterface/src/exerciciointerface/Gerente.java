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
public class Gerente extends Funcionario implements IAutenticavel {
    
    private String psw;
    
    public Gerente(String nome, int registro, double salario, String senha) {
        this.setNome(nome);
        this.setRegistro(registro);
        this.setSalarioBase(salario);
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
    
    @Override
    public boolean autenticar(String senha) {
        return true;
    }
    
}
