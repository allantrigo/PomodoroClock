/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomodoroclock;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Allan
 */
public class Timer extends Thread {
    
    private static int tempoAgora;
    
    @Override
    public void run(){
        tempoAgora--;
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
