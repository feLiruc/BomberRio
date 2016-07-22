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
import javax.swing.JOptionPane;


public class Main {

    public static void main(String args[]){

        Window janela = new Window(800, 600);
        GameImage plano = new GameImage("src/recursos/sprites/menu.png");
        Keyboard teclado = janela.getKeyboard();
        
        teclado.addKey(KeyEvent.VK_1);
        teclado.addKey(KeyEvent.VK_2);
        
        while(true){
            plano.draw();
            janela.update();           
            
            if( teclado.keyDown(KeyEvent.VK_1) == true ){
                JOptionPane.showMessageDialog(null,"Oi, eu sou a Dory");
                new GamePlay(janela);
            }

            if ( teclado.keyDown(KeyEvent.VK_2) == true ){
                
            }

            if ( teclado.keyDown(Keyboard.ESCAPE_KEY)== true ){
                janela.exit();
            }
        }
    }
}