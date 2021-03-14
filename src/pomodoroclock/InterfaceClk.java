package pomodoroclock;

import java.util.ArrayList;

/**
 * A classe com a Interface do Clock.
 *
 * @author Allan
 */
public class InterfaceClk extends javax.swing.JFrame {

    public static int correndoOuPausado = 0;
    public static int pausado = 0;

    private int editar = 0;
    private int trabalho;
    private int descanso;
    private int descansoLongo;

    Temporizador timer;
    Arquivo arquivo;

    /**
     * Metodo para iniciar a interface.
     *
     * Ela deixa algumas coisas invisíveis, assim como lê o arquivo para ver
     * quais são os tempos de trabalho, descanso e descanso longo.
     */
    public InterfaceClk() {
        initComponents();
        iptTrabalhoEditar.setVisible(false);
        iptDescansoEditar.setVisible(false);
        iptDescansoLongoEditar.setVisible(false);
        arquivo = new Arquivo();
        pegarTempo();
        if (trabalho == 0 || descanso == 0 || descansoLongo == 0) {
            pegarTempo();
        }
        setarRelogio();
    }

    /**
     * Uma função para pegar os tempos do arquivo e salvá-los em variáveis.
     *
     * Ela também coloca os números já escritos na tela.
     */
    private void pegarTempo() {
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
        lblTempoTrabalho.setText(String.valueOf(trabalho));
        lblTempoDescanso.setText(String.valueOf(descanso));
        lblTempoDescansoLongo.setText(String.valueOf(descansoLongo));
    }

    /**
     * Uma função simples para setar o relogio para o tempo inicial.
     */
    public void setarRelogio() {
        int minutos = trabalho;
        String tempoMin;
        if (minutos <= 9) {
            tempoMin = "0" + String.valueOf(minutos);
        } else {
            tempoMin = String.valueOf(minutos);
        }
        lblTempo.setText(tempoMin + ":00");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTempo = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        btnIniciarPausar = new javax.swing.JButton();
        iptDescansoLongoEditar = new javax.swing.JTextField();
        iptDescansoEditar = new javax.swing.JTextField();
        iptTrabalhoEditar = new javax.swing.JTextField();
        lblTempoDescanso = new javax.swing.JLabel();
        lblTempoDescansoLongo = new javax.swing.JLabel();
        lblTempoTrabalho = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTempoAtual = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pomodoro Clock");
        setMinimumSize(new java.awt.Dimension(515, 825));
        setPreferredSize(new java.awt.Dimension(320, 640));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTempo.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        lblTempo.setText("00:00");
        getContentPane().add(lblTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 270, -1, -1));

        lblTurno.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lblTurno.setText("1");
        getContentPane().add(lblTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 370, 40, -1));

        btnReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Reiniciar.png"))); // NOI18N
        btnReiniciar.setBorder(null);
        btnReiniciar.setBorderPainted(false);
        btnReiniciar.setContentAreaFilled(false);
        btnReiniciar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ReiniciarPressed.png"))); // NOI18N
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 491, 148, 68));

        btnParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Parar.png"))); // NOI18N
        btnParar.setBorderPainted(false);
        btnParar.setContentAreaFilled(false);
        btnParar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PararPressed.png"))); // NOI18N
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });
        getContentPane().add(btnParar, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 491, 148, 68));

        btnIniciarPausar.setBackground(new java.awt.Color(255, 255, 255));
        btnIniciarPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Iniciar.png"))); // NOI18N
        btnIniciarPausar.setBorder(null);
        btnIniciarPausar.setBorderPainted(false);
        btnIniciarPausar.setContentAreaFilled(false);
        btnIniciarPausar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/IniciarPressed.png"))); // NOI18N
        btnIniciarPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPausarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciarPausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 491, 148, 68));

        iptDescansoLongoEditar.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        iptDescansoLongoEditar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(iptDescansoLongoEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 630, 70, 70));

        iptDescansoEditar.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        iptDescansoEditar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(iptDescansoEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 630, 70, 70));

        iptTrabalhoEditar.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        iptTrabalhoEditar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(iptTrabalhoEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 630, 70, 70));

        lblTempoDescanso.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        lblTempoDescanso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTempoDescanso.setText("5");
        lblTempoDescanso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblTempoDescanso, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 630, 70, 70));

        lblTempoDescansoLongo.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        lblTempoDescansoLongo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTempoDescansoLongo.setText("30");
        getContentPane().add(lblTempoDescansoLongo, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 630, 70, 70));

        lblTempoTrabalho.setFont(new java.awt.Font("Times New Roman", 1, 50)); // NOI18N
        lblTempoTrabalho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTempoTrabalho.setText("25");
        getContentPane().add(lblTempoTrabalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 630, 70, 70));

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Editar.png"))); // NOI18N
        btnEditar.setBorder(null);
        btnEditar.setOpaque(false);
        btnEditar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EditarPressed.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 722, -1, -1));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        lblTempoAtual.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblTempoAtual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTempoAtual.setText("TRABALHO");
        lblTempoAtual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblTempoAtual);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 300, 80));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundo.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * O botão para iniciar e pausar a contagem de tempo.
     *
     * Ela muda sua imagem para pausar ou para iniciar. Ela também para ou faz o
     * contador andar do temporizador ao setar a variável rodando para 1 ou para
     * 0;
     *
     * @param evt
     */
    private void btnIniciarPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPausarActionPerformed
        btnIniciarPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pausar.png")));
        btnIniciarPausar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PausarPressed.png")));

        if (correndoOuPausado == 0) {
            if (pausado == 0) {
                timer = new Temporizador();
                timer.relogio = lblTempo;
                timer.pausar = btnIniciarPausar;
                timer.turno = lblTurno;
                timer.tempoAtual = lblTempoAtual;
                Temporizador.rodando = 1;
                timer.start();
                correndoOuPausado = 1;
            } else if (pausado == 1) {
                Temporizador.rodando = 1;
                correndoOuPausado = 1;
            }
        } else if (correndoOuPausado == 1) {
            Temporizador.rodando = 0;
            btnIniciarPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Iniciar.png")));
            btnIniciarPausar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/IniciarPressed.png")));
            correndoOuPausado = 0;
            pausado = 1;
        }
    }//GEN-LAST:event_btnIniciarPausarActionPerformed

    /**
     * O botão para parar o contador sem mudar seu número.
     *
     * Uma função simples para parar o contador e não alterar o número no
     * relógio. Ela também seta o botão para inciar caso não esteja pausado.
     *
     * @param evt
     */
    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        if (timer != null) {
            btnIniciarPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Iniciar.png")));
            btnIniciarPausar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/IniciarPressed.png")));
            Temporizador.rodando = 0;
            Temporizador.threadKill = true;
            pausado = 0;
            timer = null;
            correndoOuPausado = 0;
            Temporizador.rotinaNumero = 0;
        }
    }//GEN-LAST:event_btnPararActionPerformed

    /**
     * Uma função para reiniciar o relógio.
     *
     * Ela reinicia o tempo e o mostra na tela. Isso permite que se mostre o
     * tempo inicial e resete os turnos na tela.
     *
     * @param evt
     */
    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        setarRelogio();
        if (timer != null) {
            btnIniciarPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Iniciar.png")));
            btnIniciarPausar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/IniciarPressed.png")));
            Temporizador.rodando = 0;
            Temporizador.threadKill = true;
            lblTempoAtual.setText("TRABALHO");
            timer.resetarRelogio();
            pausado = 0;
            timer = null;
            correndoOuPausado = 0;
            Temporizador.rotinaNumero = 0;
        }
    }//GEN-LAST:event_btnReiniciarActionPerformed

    /**
     * A função para editar os tempos.
     *
     * Ela basicamente reseta os tempos do usuário após ter os tempos novos
     * setados. Ela também esconde ou mostra os campos para editar os tempos de
     * Trabalho, Descanso ou Descanso Longo, que só serão editados se houver
     * números.
     *
     * @param evt
     */
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String trabalhoEditar;
        String descansoEditar;
        String descansoLongoEditar;
        ArrayList<String> tempoEditado = new ArrayList();
        if (editar == 0) {
            btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Salvar.png")));
            btnEditar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SalvarPressed.png")));
            iptTrabalhoEditar.setVisible(true);
            iptDescansoEditar.setVisible(true);
            iptDescansoLongoEditar.setVisible(true);
            iptTrabalhoEditar.setText(String.valueOf(trabalho));
            iptDescansoEditar.setText(String.valueOf(descanso));
            iptDescansoLongoEditar.setText(String.valueOf(descansoLongo));
            editar = 1;
        } else if (editar == 1) {
            btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Editar.png")));
            btnEditar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EditarPressed.png")));
            trabalhoEditar = iptTrabalhoEditar.getText();
            descansoEditar = iptDescansoEditar.getText();
            descansoLongoEditar = iptDescansoLongoEditar.getText();
            if (trabalhoEditar.matches("[0-9]*") && !trabalhoEditar.isBlank()) {
                tempoEditado.add(trabalhoEditar);
            } else {
                tempoEditado.add(String.valueOf(trabalho));
            }
            if (descansoEditar.matches("[0-9]*") && !descansoEditar.isBlank()) {
                tempoEditado.add(descansoEditar);
            } else {
                tempoEditado.add(String.valueOf(descanso));
            }
            if (descansoLongoEditar.matches("[0-9]*") && !descansoLongoEditar.isBlank()) {
                tempoEditado.add(descansoLongoEditar);
            } else {
                tempoEditado.add(String.valueOf(descansoLongo));
            }
            arquivo.SalvaTemposEditados(tempoEditado);
            pegarTempo();
            editar = 0;
            iptTrabalhoEditar.setVisible(false);
            iptDescansoEditar.setVisible(false);
            iptDescansoLongoEditar.setVisible(false);
            if (timer != null) {
                btnIniciarPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Iniciar.png")));
                btnIniciarPausar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/IniciarPressed.png")));
                Temporizador.rodando = 0;
                Temporizador.threadKill = true;
                timer.resetarRelogio();
                pausado = 0;
                correndoOuPausado = 0;
                Temporizador.rotinaNumero = 0;
                timer = null;
            }
            setarRelogio();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceClk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceClk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceClk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceClk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceClk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnIniciarPausar;
    private javax.swing.JButton btnParar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JTextField iptDescansoEditar;
    private javax.swing.JTextField iptDescansoLongoEditar;
    private javax.swing.JTextField iptTrabalhoEditar;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JLabel lblTempoAtual;
    private javax.swing.JLabel lblTempoDescanso;
    private javax.swing.JLabel lblTempoDescansoLongo;
    private javax.swing.JLabel lblTempoTrabalho;
    private javax.swing.JLabel lblTurno;
    // End of variables declaration//GEN-END:variables
}
