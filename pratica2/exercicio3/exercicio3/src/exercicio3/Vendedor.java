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
public class Vendedor extends Funcionario {
    
    protected static double taxaComissao = 0.03;
    
    public Vendedor (String n, String cpf, int reg, double salario) {
        super(n, cpf, reg, salario);
    }
    
    /**
     *
     * @param bIndividual
     * @return
     */
    @Override
    public final double calcularBonus(double bIndividual) {
        return this.totalVendas*Vendedor.taxaComissao + bIndividual;
    }
    
    public double getSalarioTotal() {
        return this.salarioBase + this.calcularBonus(Concessionaria.bonusIndividual);
    }
}
