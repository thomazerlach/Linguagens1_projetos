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
public class ExercicioInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Secretario secretario = new Secretario("Sec", 1, 5200);
        
        Gerente gerente = new Gerente("Ger", 2, 9000, "minha senha é oi");
        
        Diretor diretor = new Diretor("Dir", 3, 18000, "minha senha é oi");
        
        Cliente cliente = new Cliente("Cliente", "000.000.000-00", "minha senha é oi");
        cliente.imprimirResumo();
        
        Sistema sistema = new Sistema();
        
        String senhaTentativaAcessoSistema = "55555";
        
        if (sistema.login(cliente, senhaTentativaAcessoSistema)) {
            //acesso ao sistema
            System.out.println("acessou");
        }
    }
    
    
    
}
