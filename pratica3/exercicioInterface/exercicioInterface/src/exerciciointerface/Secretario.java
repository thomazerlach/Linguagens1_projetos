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
public class Secretario extends Funcionario implements IExibicao {
    
    public Secretario(String nome, int registro, double salario) {
        this.setNome(nome);
        this.setRegistro(registro);
        this.setSalarioBase(salario);
    }
    
    public boolean atenderTelefone(boolean ocupado) {
        return !ocupado;
    }
    
    @Override
    public void exibirResumo() {
        System.out.println("Resumo aqui");
    }
    
}
