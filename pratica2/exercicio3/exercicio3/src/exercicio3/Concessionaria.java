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
public class Concessionaria {
    
    public static int totalFuncionarios;
    public static double totalVendas;
    private static final double taxaBonus = 0.05;
    public static double bonusIndividual;
    
    public void bonificacaoConcessionaria() {
        this.bonusIndividual = (this.totalVendas/this.totalFuncionarios)*this.taxaBonus;
    }
}
