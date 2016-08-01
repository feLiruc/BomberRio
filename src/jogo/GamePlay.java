/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
    
    public String nome, ip;
    
    public GamePlay(Window window, String nome, String ip){
        janela = window;
        cena = new Scene();
        cena.loadFromFile("src/recursos/scn/Cenario1.scn");
        
        jogador = new Jogador1(640, 350);
        
        janela.setFullScreen();
        
        this.nome = nome;
        this.ip = ip;
        
        run();
    }
    
    private void run(){
        while(true){
            cena.draw();
            jogador.draw();
            janela.drawText("Nome do jogador: "+nome+" - IP Servidor: "+ip, 0, 20, Color.red, new Font("Arial", Font.TRUETYPE_FONT, 18));
            janela.drawText(">> Mensagem 1", 35, 570, Color.yellow, new Font("Arial", Font.TRUETYPE_FONT, 18));
            janela.drawText(">> Mensagem 2", 35, 550, Color.yellow, new Font("Arial", Font.TRUETYPE_FONT, 18));
            janela.drawText(">> Mensagem 3", 35, 530, Color.yellow, new Font("Arial", Font.TRUETYPE_FONT, 18));
            janela.drawText(">> Mensagem 4", 35, 510, Color.yellow, new Font("Arial", Font.TRUETYPE_FONT, 18));
            janela.drawText(">> Mensagem 5", 35, 490, Color.yellow, new Font("Arial", Font.TRUETYPE_FONT, 18));
            jogador.mover(janela);
            janela.update();
        }
        
    }
    
}
