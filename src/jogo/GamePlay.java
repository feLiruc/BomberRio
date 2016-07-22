/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

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
    
    public GamePlay(Window window){
        janela = window;
        cena = new Scene();
        cena.loadFromFile("src/recursos/scn/Cenario1.scn");
        
        jogador = new Jogador1(640, 350);
        
        run();
    }
    
    private void run(){
        while(true){
            cena.draw();
            jogador.draw();
            jogador.mover(janela);
            janela.update();
        }
    }
    
}
