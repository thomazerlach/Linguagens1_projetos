package aula03;

public class Aula03 {

    public static void main(String[] args) {

        Conta c1 = new Conta();
        c1.titular = new Cliente();
        Conta minhaConta = new Conta();
        minhaConta.titular = new Cliente();
        
        c1.titular.nome = "Pedro";
        c1.titular.sobrenome = "Cattel";
        c1.titular.cpf = "263.363.865-23";
        
        c1.titular.visualizarDados();

        c1.saldo = 1000;
        c1.visualizarSaldo();

        c1.sacar(200);
        c1.visualizarSaldo();

        minhaConta.saldo = 1800;
        minhaConta.visualizarSaldo();

        minhaConta.transferirPara(c1, 200);

        c1.visualizarSaldo();
        minhaConta.visualizarSaldo();
    }

}
