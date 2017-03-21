package aula03;

public class Aula03 {

    public static void main(String[] args) {

        Conta c1 = new Conta();
        Conta minhaConta = new Conta();
        
        c1.titular.visualizarDados();
        
        c1.depositar(1000);

        c1.visualizarSaldo();

        c1.sacar(200);
        c1.visualizarSaldo();
        
        minhaConta.visualizarSaldo();

        minhaConta.transferirPara(c1, 200);

        c1.visualizarSaldo();
        minhaConta.visualizarSaldo();
    }

}
