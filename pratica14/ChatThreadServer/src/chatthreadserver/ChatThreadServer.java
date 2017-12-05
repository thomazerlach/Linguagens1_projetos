/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatthreadserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author thomazerlach
 */
public class ChatThreadServer implements Runnable{

    static Socket cliente;
    static Boolean fechou = false;
    
    public static void main(String[] args) {
        
        ServerSocket servidor;
        
        try {
            //Instancia o ServerSocket
            servidor = new ServerSocket(9000);
            System.out.println("Servidor ouvindo a porta 4699");
            System.out.println("Esperando um cliente...");
            
            cliente = servidor.accept();
            System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
            
            Thread thr_entrada = new Thread(new ChatThreadServer());
            thr_entrada.start();
               
            try ( 
                    //entradaRede = new Scanner(cliente.getInputStream());
                    Scanner teclado = new Scanner(System.in);
                    PrintStream saidaRede = new PrintStream(cliente.getOutputStream());
                ) 
            {
                saidaRede.println("Bem vindo ao chat!");
                //System.out.println(entradaRede.nextLine());
                String msg = "";
                while (!fechou && !msg.equalsIgnoreCase("tchau!")) {
                    msg = teclado.nextLine();
                    saidaRede.println(msg);
                    //msg = entradaRede.nextLine();
                    //System.out.println(msg);
                }
                System.out.println("Aplicação finalizada. Pressione ENTER");
                fechou = true;
                //teclado.nextLine();
                servidor.close();
                cliente.close();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.exit(0);
    }

    @Override
    public void run() {
        try (
                Scanner entradaRede = new Scanner(cliente.getInputStream());
            )
        {
            String msg = "";
            while (!fechou && !msg.equalsIgnoreCase("tchau!")) {
                    msg = entradaRede.nextLine();
                    System.out.println("Cliente: " + msg);
            }
            System.out.println("Cliente fechou a conexão, pressione enter");
            fechou = true;
            
        } catch (IOException ex) {
            Logger.getLogger(ChatThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
