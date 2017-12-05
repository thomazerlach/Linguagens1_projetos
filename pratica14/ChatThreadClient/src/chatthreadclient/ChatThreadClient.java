/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatthreadclient;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author thomazerlach
 */
public class ChatThreadClient implements Runnable {

    static Socket server;
    static Boolean fechou = false;
    
    public static void main(String[] args) {
        // TODO code application logic here
        String serverAddress = JOptionPane.showInputDialog(
                "Informe o IP do servidor que está\n" 
                + "executando o serviço de chat na porta 4699");
        
        try {
            server = new Socket(serverAddress, 4699);
            
            Thread thr_entrada = new Thread(new ChatThreadClient());
            thr_entrada.start();
            
            try (
                    //Scanner entradaRede = new Scanner(server.getInputStream());
                    Scanner teclado = new Scanner(System.in);
                    PrintStream saidaRede = new PrintStream(server.getOutputStream());
                ) 
            {
                //System.out.println(entradaRede.nextLine());
                String msg = "";
                while(!fechou && !msg.equalsIgnoreCase("tchau!")) {
                    msg = teclado.nextLine();
                    saidaRede.println(msg);
                    //msg = entradaRede.nextLine();
                    //System.out.println(msg);
                }
                System.out.println("Aplicação finalizada. Pressione ENTER para fechar o programa.");
                fechou = true;
                //teclado.nextLine();
                server.close();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.exit(0);
    }
    
    @Override
    public void run() {
        try (
                Scanner entradaRede = new Scanner(server.getInputStream());
            )
        {
            String msg = "";
            while (!fechou && !msg.equalsIgnoreCase("tchau!")) {
                    msg = entradaRede.nextLine();
                    System.out.println("Server: " + msg);
            }
            System.out.println("Server fechou a conexão, pressione enter");
            fechou = true;
            
        } catch (IOException ex) {
            Logger.getLogger(ChatThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
