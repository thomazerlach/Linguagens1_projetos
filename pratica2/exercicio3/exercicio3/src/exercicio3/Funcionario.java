/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;

/**
 *
 * @author thomazerlach
 */
public class Funcionario {
    protected String nomeCompleto;
    protected String cpf;
    protected int registro;
    protected double salarioBase;
    
    public Funcionario (String n, String cpf, int reg, double sal) {
        this.setNome(n);
        this.setCpf(cpf);
        this.setRegistro(reg);
        this.setSalarioBase(sal);
    }
    
    public String getNome () {
        return this.nomeCompleto;
    }
    
    public final void setNome (String nomeNovo) {
        this.nomeCompleto = nomeNovo;
    }
    
    public String getCpf () {
        return this.cpf;
    }
    
    public final void setCpf (String cpfNovo) {
        this.cpf = cpfNovo;
    }
    
    public int getRegistro () {
        return this.registro;
    }
    
    public final void setRegistro (int registroNovo) {
        this.registro = registroNovo;
    }
    
    public double getSalarioBase () {
        return this.salarioBase;
    }
    
    public final void setSalarioBase (double salarioNovo) {
        this.salarioBase = salarioNovo;
    }
    
    public void exibirResumo () {
        System.out.println("Nome: " + this.nomeCompleto);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Registro: " + this.registro);
        System.out.println("Salário base: " + this.salarioBase);
    }
}
