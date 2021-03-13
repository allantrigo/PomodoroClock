package pomodoroclock;

import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class InterfaceClk extends javax.swing.JFrame {

    static int correndoOuPausado = 0;
    static int timerSetado = 0;
    private int editar = 0;
    private int trabalho;
    private int pausado = 0;
    private int descanso;
    private int descansoLongo;
    Temporizador timer;
    Arquivo arquivo = new Arquivo();

    public InterfaceClk() {
        initComponents();
        lblTrabalhoEditar.setVisible(false);
        lblDescansoEditar.setVisible(false);
        lblDescansoLongoEditar.setVisible(false);
        iptTrabalhoEditar.setVisible(false);
        iptDescansoEditar.setVisible(false);
        iptDescansoLongoEditar.setVisible(false);
        pegarTempo();
        if (trabalho == 0 || descanso == 0 || descansoLongo == 0) {
            pegarTempo();
        }
        setarRelogio();
    }

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

        jPanel1 = new javax.swing.JPanel();
        btnInfo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTempoTrabalho = new javax.swing.JLabel();
        btnIniciarPausar = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblTempo = new javax.swing.JLabel();
        lblTempoAtual = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTempoDescanso = new javax.swing.JLabel();
        lblTrabalhoEditar = new javax.swing.JLabel();
        lblDescansoEditar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        lblDescansoLongoEditar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTempoDescansoLongo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        iptTrabalhoEditar = new javax.swing.JTextField();
        iptDescansoEditar = new javax.swing.JTextField();
        iptDescansoLongoEditar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnInfo.setText("Info");

        jLabel1.setText("Tempo de Trabalho:");

        lblTempoTrabalho.setText("25");

        btnIniciarPausar.setText("Iniciar");
        btnIniciarPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPausarActionPerformed(evt);
            }
        });

        btnParar.setText("Parar");
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lblTempo.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        lblTempo.setText("00:00");

        lblTempoAtual.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        lblTempoAtual.setText("TEMPO DE TRABALHO");

        jLabel3.setText("Tempo de Descanso:");

        lblTempoDescanso.setText("5");

        lblTrabalhoEditar.setText("Trabalho:");

        lblDescansoEditar.setText("Descanso:");

        jLabel2.setText("Minutos");

        jLabel4.setText("Minutos");

        jLabel5.setText("Turno:");

        lblTurno.setText("1");

        lblDescansoLongoEditar.setText("Descanso Longo:");

        jLabel6.setText("Tempo de Descanso Longo:");

        lblTempoDescansoLongo.setText("30");

        jLabel7.setText("Minutos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTempoAtual)
                            .addComponent(btnInfo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(lblDescansoEditar)
                                        .addGap(22, 22, 22))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblDescansoLongoEditar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(iptDescansoEditar)
                                    .addComponent(iptTrabalhoEditar)
                                    .addComponent(iptDescansoLongoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIniciarPausar)
                                    .addComponent(btnEditar))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblTrabalhoEditar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnReiniciar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTempo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblTempoDescanso, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblTempoTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(lblTempoDescansoLongo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel7))))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(45, 45, 45))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTempoAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTempoTrabalho)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTempoDescanso, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTempoDescansoLongo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarPausar)
                    .addComponent(btnParar)
                    .addComponent(btnReiniciar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditar)
                        .addComponent(lblTrabalhoEditar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(iptTrabalhoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iptDescansoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescansoEditar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iptDescansoLongoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescansoLongoEditar))))
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPausarActionPerformed
        btnIniciarPausar.setText("Pausar");
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
            btnIniciarPausar.setText("Iniciar");
            correndoOuPausado = 0;
            pausado = 1;
        }
    }//GEN-LAST:event_btnIniciarPausarActionPerformed

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        if (timer != null) {
            Temporizador.contando = 1;
            timerSetado = 0;
            btnIniciarPausar.setText("Iniciar");
            Temporizador.rodando = 0;
            Temporizador.threadKill = true;
            pausado = 0;
            correndoOuPausado = 0;
            Temporizador.rotinaNumero = 0;
        }
    }//GEN-LAST:event_btnPararActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        if (timer != null) {
            Temporizador.contando = 1;
            timerSetado = 0;
            btnIniciarPausar.setText("Iniciar");
            Temporizador.rodando = 0;
            Temporizador.threadKill = true;
            timer.resetarRelogio();
            pausado = 0;
            correndoOuPausado = 0;
            Temporizador.rotinaNumero = 0;
        }
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String trabalhoEditar;
        String descansoEditar;
        String descansoLongoEditar;
        ArrayList<String> tempoEditado = new ArrayList();
        if (editar == 0) {
            lblTrabalhoEditar.setVisible(true);
            lblDescansoEditar.setVisible(true);
            lblDescansoLongoEditar.setVisible(true);
            iptTrabalhoEditar.setVisible(true);
            iptDescansoEditar.setVisible(true);
            iptDescansoLongoEditar.setVisible(true);
            btnEditar.setText("Salvar");
            editar = 1;
        } else if (editar == 1) {
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
            lblTrabalhoEditar.setVisible(false);
            lblDescansoEditar.setVisible(false);
            lblDescansoLongoEditar.setVisible(false);
            iptTrabalhoEditar.setVisible(false);
            iptDescansoEditar.setVisible(false);
            iptDescansoLongoEditar.setVisible(false);
            iptTrabalhoEditar.setText("");
            iptDescansoEditar.setText("");
            iptDescansoLongoEditar.setText("");
            btnEditar.setText("Editar");
            if (timer != null) {
                Temporizador.contando = 1;
                timerSetado = 0;
                btnIniciarPausar.setText("Iniciar");
                Temporizador.rodando = 0;
                Temporizador.threadKill = true;
                timer.resetarRelogio();
                pausado = 0;
                correndoOuPausado = 0;
                Temporizador.rotinaNumero = 0;
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
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnIniciarPausar;
    private javax.swing.JButton btnParar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JTextField iptDescansoEditar;
    private javax.swing.JTextField iptDescansoLongoEditar;
    private javax.swing.JTextField iptTrabalhoEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDescansoEditar;
    private javax.swing.JLabel lblDescansoLongoEditar;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JLabel lblTempoAtual;
    private javax.swing.JLabel lblTempoDescanso;
    private javax.swing.JLabel lblTempoDescansoLongo;
    private javax.swing.JLabel lblTempoTrabalho;
    private javax.swing.JLabel lblTrabalhoEditar;
    private javax.swing.JLabel lblTurno;
    // End of variables declaration//GEN-END:variables
}
