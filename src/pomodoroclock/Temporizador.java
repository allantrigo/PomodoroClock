package pomodoroclock;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.sound.sampled.*;
import javax.swing.JButton;

/**
 * Classe que faz todo o trabalho do Pomodoro Clock.
 *
 * @author Allan
 */
public class Temporizador extends Thread {

    public static int tempoAgora;
    public static int rodando;
    public static int rotinaNumero;

    public static boolean threadKill;

    private int minutos;
    private int segundos;
    private int trabalho;
    private int descanso;
    private int descansoLongo;

    private boolean threadKill2;

    private String tempoMin;
    private String tempoSeg;

    JLabel tempoAtual;
    JLabel relogio;
    JLabel turno;

    JButton pausar;

    Arquivo arquivo;

    Som musica;

    public Temporizador() {
        threadKill2 = false;
        tempoAtual = new JLabel();
        relogio = new JLabel();
        turno = new JLabel();
        pausar = new JButton();
        arquivo = new Arquivo();
        musica = new Som();
    }

    /**
     * Função run para fazer com que o tempo diminua segundo por segundo.
     *
     * É necessário um Thread Killer, que é o threadKill2. A int Fim também
     * server para indicar que o tempo total acabou. E a Rotina serve para ler o
     * caminho todo.
     */
    @Override
    public void run() {
        int fim = 0;
        pegarTempo();
        for (;;) {
            if (threadKill2) {
                break;
            }
            switch (rotinaNumero) {
                case 0:
                    tempoAgora = trabalho * 60;
                    turno.setText(("1"));
                    tempoAtual.setText("TRABALHO");
                    pomodoro();
                    break;
                case 1:
                    tempoAgora = descanso * 60;
                    tempoAtual.setText("DESCANSO");
                    pomodoro();
                    break;
                case 2:
                    tempoAgora = trabalho * 60;
                    turno.setText(("2"));
                    tempoAtual.setText(("TRABALHO"));
                    pomodoro();
                    break;
                case 3:
                    tempoAgora = descanso * 60;
                    tempoAtual.setText(("DESCANSO"));
                    pomodoro();
                    break;
                case 4:
                    tempoAgora = trabalho * 60;
                    turno.setText(("3"));
                    tempoAtual.setText(("TRABALHO"));
                    pomodoro();
                    break;
                case 5:
                    tempoAgora = descanso * 60;
                    tempoAtual.setText(("DESCANSO"));
                    pomodoro();
                    break;
                case 6:
                    tempoAgora = trabalho * 60;
                    turno.setText(("4"));
                    tempoAtual.setText(("TRABALHO"));
                    pomodoro();
                    break;
                case 7:
                    tempoAgora = descansoLongo * 60;
                    tempoAtual.setText(("DESCANSO LONGO"));
                    pomodoro();
                    break;
                default:
                    Temporizador.rodando = 0;
                    Temporizador.threadKill = true;
                    resetarRelogio();
                    pausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Iniciar.png")));
                    pausar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/IniciarPressed.png")));
                    InterfaceClk.pausado = 0;
                    InterfaceClk.correndoOuPausado = 0;
                    Temporizador.rotinaNumero = 0;
                    break;
            }
            if (fim == 1) {
                InterfaceClk.correndoOuPausado = 0;
                break;
            }
        }
    }

    /**
     * função para setar o relógio. Ela pega o tempo chamado tempoAgora e divide
     * ele em minutos e segundos. É chamada sempre que há a necessidade de se
     * atualizar o relógio.
     */
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

    /**
     * Uma função simples para resetar o relógio.
     *
     * Coloca os turnos em 1 e retorna o tempo para o do primeiro turno.
     */
    public void resetarRelogio() {
        tempoAgora = trabalho * 60;
        turno.setText(("1"));
        pegarTempo();
        setarRelogio();
    }

    /**
     * Função que roda o relógio dentro da rotina.
     *
     * Pega o tempo e a int estática para fazer o tempo rodar. caso esteja
     * rodando, ela passa direto, e reduz o tempo atual. caso esteja pausado ou
     * parado ela soma 1 no contador sempre que reduz. Isso mantem a função
     * rodando e permite que o sleep também impeça que o a função acabe
     * consumindo muita memória. Toda vez que chega no fim da contagem ela toca
     * a função música.
     */
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

    /**
     * Uma função para pegar o tempo do arquivo.
     *
     * Lê linha por linha dela e então seta os tempos de trabalho, descanso e
     * descanso longo.
     */
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
