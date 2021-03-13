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
 * enviado para o jLabel. Instância da função que toca som, e o jLabel.
 */
public class Temporizador extends Thread {

    public static int tempoAgora;
    public static int tempoInicial = tempoAgora;
    public static int contando = 0;
    public static int rodando;
    public boolean threadKill2 = false;
    public static boolean threadKill;
    private int minutos;
    private int segundos;
    private String tempoMin;
    private String tempoSeg;

    private int trabalho;
    private int descanso;
    private int descansoLongo;
    public static int rotinaNumero;

    JLabel tempoAtual = new JLabel();
    Arquivo arquivo = new Arquivo();
    Som musica = new Som();

    JLabel relogio = new JLabel();
    JLabel turno = new JLabel();
    JButton pausar = new JButton();

    /**
     * Função run para fazer com que o tempo diminua segundo por segundo.
     */
    @Override
    public void run() {
        pegarTempo();
        for (;;) {
            if (threadKill2) {
                break;
            }
            switch (rotinaNumero) {
                case 0:
                    tempoAgora = trabalho * 60;
                    turno.setText(("1"));
                    tempoAtual.setText(("Tempo de Trabalho"));
                    pomodoro();
                    break;
                case 1:
                    tempoAgora = descanso * 60;
                    tempoAtual.setText(("Tempo de Descanso"));
                    pomodoro();
                    break;
                case 2:
                    tempoAgora = trabalho * 60;
                    turno.setText(("2"));
                    tempoAtual.setText(("Tempo de Trabalho"));
                    pomodoro();
                    break;
                case 3:
                    tempoAgora = descanso * 60;
                    tempoAtual.setText(("Tempo de Descanso"));
                    pomodoro();
                    break;
                case 4:
                    tempoAgora = trabalho * 60;
                    turno.setText(("3"));
                    tempoAtual.setText(("Tempo de Trabalho"));
                    pomodoro();
                    break;
                case 5:
                    tempoAgora = descanso * 60;
                    tempoAtual.setText(("Tempo de Descanso"));
                    pomodoro();
                    break;
                case 6:
                    tempoAgora = trabalho * 60;
                    turno.setText(("4"));
                    tempoAtual.setText(("Tempo de Trabalho"));
                    pomodoro();
                    break;
                case 7:
                    tempoAgora = descansoLongo * 60;
                    tempoAtual.setText(("Descanso Longo"));
                    pomodoro();
                    break;
                default:
                    tempoAtual.setText(("Tempo de Trabalho"));
                    tempoAgora = trabalho * 60;
                    setarRelogio();
                    break;
            }
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
        tempoAgora = trabalho * 60;
        turno.setText(("1"));
        pegarTempo();
        setarRelogio();
    }

    public void pomodoro() {
        threadKill2 = false;
        rodando = 1;
        for (;;) {
            for (int i = tempoAgora; i >= 0; i--) {
                if (rodando == 0) {
                    i++;
                }
                tempoAgora = i;
                setarRelogio();
                if (i > 0 && !threadKill2) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Temporizador.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (threadKill) {
                    threadKill = false;
                    threadKill2 = true;
                    interrupt();
                    break;
                }
            }
            if (tempoAgora == 0) {
                try {
                    musica.tocarMusica();
                } catch (UnsupportedAudioFileException | LineUnavailableException ex) {
                    Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
                }
                rotinaNumero++;
                break;
            }
            if (threadKill2) {
                break;
            }
        }
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
}
