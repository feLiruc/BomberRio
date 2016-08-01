/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

/**
 *
 * @author 4n0n7m0u5
 */
import jplay.Window;
import jplay.GameImage;
import jplay.Keyboard;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;


public class Main {

    public static void main(String args[]) throws UnknownHostException{

        Window janela = new Window(800, 600);
        GameImage plano = new GameImage("src/recursos/sprites/menu.png");
        Keyboard teclado = janela.getKeyboard();
        
        teclado.addKey(KeyEvent.VK_1);
        teclado.addKey(KeyEvent.VK_2);
        
        while(true){
            plano.draw();
            janela.update();           
            
            if( teclado.keyDown(KeyEvent.VK_1) == true ){
                String ip = JOptionPane.showInputDialog("Digite o IP do Servidor:", "EX: 192.168.1.5");
                JOptionPane.showMessageDialog(null, ip);
                String nome = JOptionPane.showInputDialog("Digite um nome de usuário:");
                new GamePlay(janela, nome,ip);
            }

            if ( teclado.keyDown(KeyEvent.VK_2) == true ){
                String ip = InetAddress.getLocalHost().getHostAddress().toString();
                JOptionPane.showMessageDialog(null, "IP do seu servidor: "+ip);
                String nome = JOptionPane.showInputDialog("Digite um nome de usuário:");
                Server sv = new Server();
                Thread ts = new Thread(sv);
                ts.start();
                new GamePlay(janela, nome, ip);

            }

            if ( teclado.keyDown(Keyboard.ESCAPE_KEY)== true ){
                janela.exit();
            }
        }
    }
}