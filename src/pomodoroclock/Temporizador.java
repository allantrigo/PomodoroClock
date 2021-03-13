package pomodoroclock;

import java.util.ArrayList;
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
    private int trabalho;
    private int descanso;
    private int descansoLongo;
    private int minutos;
    private int segundos;
    private String tempoMin;
    private String tempoSeg;

    private static int rotinaNumero;
    Arquivo arquivo = new Arquivo();

    Som musica = new Som();

    JLabel relogio = new JLabel();
    JLabel tempoAtual = new JLabel();
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
        contando = 1;
        setarRelogio();
    }

    public void pegarTempo() {
        ArrayList<String> tempos = arquivo.pegaTemposEditados();
        for (int i = 0; i < tempos.size(); i++) {
            switch (i) {
                case 0:
                    trabalho = Integer.parseInt(tempos.get(i));
                    break;
                case 1:
                    descanso = Integer.parseInt(tempos.get(i));
                    break;
                default:
                    descansoLongo = Integer.parseInt(tempos.get(i));
                    break;
            }
        }
    }

    public void rotina() {
        switch (rotinaNumero) {
            case 0:
                tempoAgora = trabalho * 60;
                tempoAtual.setText(("Tempo de Trabalho"));
                break;
            case 1:
                tempoAgora = descanso * 60;
                tempoAtual.setText(("Tempo de Descanso"));
                break;
            case 2:
                tempoAgora = trabalho * 60;
                tempoAtual.setText(("Tempo de Trabalho"));
                break;
            case 3:
                tempoAgora = descanso * 60;
                tempoAtual.setText(("Tempo de Descanso"));
                break;
            case 4:
                tempoAgora = trabalho * 60;
                tempoAtual.setText(("Tempo de Trabalho"));
                break;
            case 5:
                tempoAgora = descanso * 60;
                tempoAtual.setText(("Tempo de Descanso"));
                break;
            case 6:
                tempoAgora = trabalho * 60;
                tempoAtual.setText(("Tempo de Trabalho"));
                break;
            case 7:
                tempoAgora = descansoLongo * 60;
                tempoAtual.setText(("Descanso Longo"));
                break;
            default:
                break;
        }
    }
}
