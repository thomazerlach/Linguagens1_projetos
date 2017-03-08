package aula03;

public class Aula03 {
    
    public static void main(String[] args) {
        
        Conta c1 = new Conta();
        Conta minhaConta = new Conta();
        
        c1.saldo = 1000;
        c1.visualizarSaldo();
        
        c1.sacar(200);
        c1.visualizarSaldo();
        
//        minhaConta.saldo = 1800;
//        minhaConta.visualizarSaldo();
        
    }
    
}
