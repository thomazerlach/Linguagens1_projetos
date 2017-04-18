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
public class Gerente extends Funcionario {
    
    protected static double taxaComissao = 0.05;
    protected static double taxaExtra = 0.25;
    
    public Gerente (String n, String cpf, int reg, double salario) {
        super(n, cpf, reg, salario);
    }
    
}
