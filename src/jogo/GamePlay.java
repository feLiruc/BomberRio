/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

/**
 *
 * @author 4n0n7m0u5
 */
public class GamePlay {
    
    private Window janela;
    private Scene cena;
    
    private Jogador1 jogador;
    
    private String nome, ip;
    
    private static List<String> mensagens = new LinkedList<String>();
    
    public GamePlay(Window window, String nome, String ip){
        janela = window;
        cena = new Scene();
        cena.loadFromFile("src/recursos/scn/Cenario1.scn");
        
        jogador = new Jogador1(640, 350);
        
        this.nome = nome;
        this.ip = ip;
        
        Keyboard teclado = janela.getKeyboard();
        
        teclado.addKey(KeyEvent.VK_Y);
        
        run(teclado);
    }
    
    public static void newMessage(String usuario, String mensagem){
        if(mensagens.size()==5){
            mensagens.remove(0);
        }
        mensagens.add(usuario+":"+mensagem);
    }
    
    private void run(Keyboard teclado){
        while(true){
            cena.draw();
            jogador.draw();
            int altura = 570;
            janela.drawText("Nome do jogador: "+nome+" - IP Servidor: "+ip, 0, 20, Color.red, new Font("Arial", Font.TRUETYPE_FONT, 18));
            for(int i = 0; i < mensagens.size(); i++){
                janela.drawText(">> "+mensagens.get(i).split(":")[0]+" disse: "+mensagens.get(i).split(":")[1], 35, altura=altura-20, Color.yellow, new Font("Arial", Font.TRUETYPE_FONT, 18));
            }
            
            jogador.mover(janela);
            janela.update();
            if ( teclado.keyDown(KeyEvent.VK_Y) == true ){
                String message = JOptionPane.showInputDialog(null, "Digite a mensagem:");
                Socket s = null;
                message = "mensagem:"+message+";usuario:"+nome;
                //Declaro a Stream de saida de dados
                PrintStream ps = null;
                try {
                    //Cria o socket com o recurso desejado na porta especificada!
                    s = new Socket(ip, 7000);
                    //Cria a Stream de saida de dados
                    ps = new PrintStream(s.getOutputStream());
                    //Imprime uma linha para a stream de saída de dados
                    ps.println(message);
                } catch (IOException e) {
                    System.out.println("Algum problema ocorreu ao criar ou enviar dados pelo Socket.");
                    e.printStackTrace();
                } finally {
                    try {
                        //Encerra o socket cliente
                        s.close();
                    } catch (Exception e) {
                        System.out.println("Algum problema ocorreu ao finalizar o socket");
                    }
                }

            }
        }
        
    }
    
}
