package aula03;

public class Conta {

    int numero;
    String titular;
    String cpf;
    double saldo;

    void visualizarSaldo() {
        System.out.println("Saldo = " + this.saldo);
    }

    void depositar(double valor) {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
        }
    }

    void sacar(double value) {
        if (value <= this.saldo) {
            this.saldo = this.saldo - value;
        } else {
            System.out.println("Quer um empréstimo?");
        }
    }

    void transferirDinheiro() {

    }

}
