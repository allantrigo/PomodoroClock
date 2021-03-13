package pomodoroclock;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.sound.sampled.*;
import javax.swing.JButton;

/**
 *
 * @author Allan Temporizador Estático para o tempo total. Contador para parar o
 * run. ints para os minutos e segundos. Strings para o tempo que vai ser
 * envaido para o jLabel. Instância da função que toca som, e o jLabel.
 */
public class Temporizador extends Thread {

    public static int tempoAgora;
    public static int tempoInicial = tempoAgora;
    public static int contando = 0;
    public int minutos;
    public int segundos;
    public String tempoMin;
    public String tempoSeg;

    Som musica = new Som();

    JLabel relogio = new JLabel();
    JButton pausar = new JButton();

    /**
     * Função run para fazer com que o tempo diminua segundo por segundo.
     */
    @Override
    public void run() {
        for (int i = tempoAgora; i >= 0; i--) {
            setarRelogio();
            if (i > 0) {
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Temporizador.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            tempoAgora--;
            if (contando == 1) {
                interrupt();
                contando = 0;
                break;
            }
        }
        if (tempoAgora == -1) {
            try {
                musica.tocarMusica();
            } catch (UnsupportedAudioFileException | LineUnavailableException ex) {
                Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
            }
            InterfaceClk.correndoOuPausado = 0;
            InterfaceClk.timerSetado = 0;
            pausar.setText("Iniciar");
        }
    }

    public void setarRelogio() {
        minutos = tempoAgora / 60;
        segundos = tempoAgora % 60;
        if (minutos <= 9) {
            tempoMin = "0" + String.valueOf(minutos);
        } else {
            tempoMin = String.valueOf(minutos);
        }
        if (segundos <= 9) {
            tempoSeg = "0" + String.valueOf(segundos);
        } else {
            tempoSeg = String.valueOf(segundos);
        }
        relogio.setText(tempoMin + ":" + tempoSeg);
    }

    public void resetarRelogio() {
        setarRelogio();
    }
}
