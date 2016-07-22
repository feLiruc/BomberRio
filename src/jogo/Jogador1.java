/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

/**
 *
 * @author 4n0n7m0u5
 */
public class Jogador1 extends Sprite{
    
    private double velocidade = 0.3;
    private int direcao = 3;
    private Keyboard teclado;
    private boolean movendo = false;
    
    public Jogador1(int x, int y) {
        super("src/recursos/sprites/personagem1.png", 12);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
    }
    
    public void mover(Window janela){
        
        if(teclado == null){
            teclado = janela.getKeyboard();
        }
        
        if(teclado.keyDown(Keyboard.LEFT_KEY)){
            if(this.x > 32)
                this.x -= velocidade;
            if(direcao != 1){
                setSequence(3, 5);
                direcao = 1;
            }
            movendo = true;
        }else if(teclado.keyDown(Keyboard.RIGHT_KEY)){
            if(this.x < (janela.getWidth() - 60) )
                this.x += velocidade;
            if(direcao != 2){
                setSequence(6, 8);
                direcao = 2;
            }
            movendo = true;
        }else if(teclado.keyDown(Keyboard.UP_KEY)){
            if(this.y < 33 && this.x > 373 && this.x < 396){
                this.x = 385;
                this.y = 540;
            }
            if(this.y > 32)
                this.y -= velocidade;
            if(direcao != 4){
                setSequence(9, 11);
                direcao = 4  ;
            }
            movendo = true;
        }else if(teclado.keyDown(Keyboard.DOWN_KEY)){
            if(this.y > (janela.getHeight()-71) && this.x > 373 && this.x < 396){
                this.x = 385;
                this.y = 30;
            }
            if(this.y < (janela.getHeight()-70))
                this.y += velocidade;
            if(direcao != 5){
                setSequence(0, 2);
                direcao = 5;
            }
            movendo = true;
        }
        
        if(movendo){
            update();
            movendo = false;
        }
        
    }
    
}
