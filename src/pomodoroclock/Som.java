/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomodoroclock;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

/**
 *
 * @author Allan
 */
public class Som {
    
    private int vezes = 5;

    /**
     * 
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException 
     * Toca o .wav file no fim da contagem. Pegando o endereço dele no package
     * Ele lê onde está o item e então cria um clip. É necessário o Runnable pra
     * tocar ele até o fim.
     * Mudando o número de vezes pode-se alterar quantos bips tocam.
     * 
     * 
     */
    public void tocarMusica() throws UnsupportedAudioFileException, LineUnavailableException, LineUnavailableException {
        try {
            InputStream somBeep = getClass().getResource("beep-07.wav").openStream();
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(somBeep);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(vezes);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                }
            });
        } catch (IOException e) {
        }
    }
}