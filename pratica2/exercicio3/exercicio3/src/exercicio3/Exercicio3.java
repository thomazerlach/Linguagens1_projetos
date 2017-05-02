/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;
import java.util.Scanner;
/**
 *
 * @author thomazerlach
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        
        //perguntar n vendedores
        System.out.println("Quantos vendedores?");
        int nVend = scan.nextInt();
        //perguntar n gerentes
        System.out.println("Quantos Gerentes?");
        int nGer = scan.nextInt();
        
        Concessionaria cons = new Concessionaria(nVend, nGer);
        
        for (int i = 0; i<nVend; i++) { //pedir vendedores e gerentes
            System.out.println("Nome?");
            String nome = scan.next();
            System.out.println("Cpf?");
            String cpf = scan.next();
            System.out.println("Registro?");
            int reg = scan.nextInt();
            System.out.println("Salario?");
            double sal = scan.nextDouble();
            cons.novoVendedor(nome, cpf, reg, sal);
        }
        
        for (int i = 0; i<nGer; i++) { //pedir vendedores e gerentes
            System.out.println("Nome?");
            String nome = scan.next();
            System.out.println("Cpf?");
            String cpf = scan.next();
            System.out.println("Registro?");
            int reg = scan.nextInt();
            System.out.println("Salario?");
            double sal = scan.nextDouble();
            cons.novoGerente(nome, cpf, reg, sal);
        }
    }
    
}
