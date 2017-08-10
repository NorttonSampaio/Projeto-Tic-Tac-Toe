package principal;

import java.util.Random;
import javax.swing.JOptionPane;

public class Jogo extends javax.swing.JFrame {
    
    /*
        
        0|0|0
        0|0|0  - Essa e a matriz inicial
        0|0|0  
        
        1|1|1  2|2|2
        0|0|0  0|0|0 - são métodos de vitória
        0|0|0  0|0|0
        
        */
    
    public static int[][] mat;
    public static int jogador;
    
    public Jogo() {
        initComponents();
        initDefault();
        iniciarJogo();
    }
    
    public Jogo(int j1, int j2) {
        initComponents();
        initDefault();
        spnJog1.setValue(j1);
        spnJog2.setValue(j2);
        iniciarJogo();
    }
    
    public void iniciarJogo(){
        IniciaMatriz inicia = new IniciaMatriz();
        mat = inicia.retornarMatriz();
        jogador = randomizarVezJogador();
        showVezJogador();
    }
    
    public boolean verificaVitoria(){
        if((mat[0][0]==jogador && mat[0][1]==jogador && mat[0][2]==jogador) || (mat[1][0]==jogador && mat[1][1]==jogador && mat[1][2]==jogador) || (mat[2][0]==jogador && mat[2][1]==jogador && mat[2][2]==jogador)){
            //o jogador venceu de alguma forma na horizontal
            return true;
        }else if((mat[0][0]==jogador && mat[1][0]==jogador && mat[2][0]==jogador) || (mat[0][1]==jogador && mat[1][1]==jogador && mat[2][1]==jogador) || (mat[0][2]==jogador && mat[1][2]==jogador && mat[2][2]==jogador)){
            //o jogador venceu de alguma forma na vertical
            return true;
        }else if((mat[0][0]==jogador && mat[1][1]==jogador && mat[2][2]==jogador) || (mat[2][0]==jogador && mat[1][1]==jogador && mat[0][2]==jogador)){
            //o jogador venceu de alguma forma cruzado
            return true;
        }else{
            //o jogador ainda nao venceu
            return false;
        }
    }
    
    public boolean verificaDraw(){
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                if(mat[x][y]==0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void showVezJogador(){
        if(jogador==1){
            labelVez.setText("X");
            //JOptionPane.showMessageDialog(null, "Jogador 1(X) vai começar!");
        }else if(jogador==2){
            labelVez.setText("O");
            //JOptionPane.showMessageDialog(null, "Jogador 2(O) vai começar!");
        }else{
            JOptionPane.showMessageDialog(null, "Deu erro na Randomização");
        }
    }
    
    public void alternarVezJogador(){
        if(jogador==1){
            //Vez do jogador 2
            jogador=2;
            labelVez.setText("O");
        }else {
            //Vez do jogador 1
            jogador=1;
            labelVez.setText("X");
        }
    }
    
    public void continuarJogo(){
        boolean stop=false;
        if(verificaVitoria()){
            JOptionPane.showMessageDialog(null, "Jogador " + jogador + " Venceu o jogo!");
            adicionaPlacar();
            stop=true;
            dispose();
            Jogo novojogo = new Jogo((int)spnJog1.getValue(), (int)spnJog2.getValue());
        }
        if(verificaDraw()){
            JOptionPane.showMessageDialog(null, "Jogo Terminou em Empate!");
            stop=true;
            dispose();
            Jogo novojogo = new Jogo((int)spnJog1.getValue(), (int)spnJog2.getValue());
        }
        if(!stop){
            alternarVezJogador();
        }
    }
    
    public int randomizarVezJogador(){
        Random rand = new Random();
        return rand.nextInt(2)+1;
    }
    
    public String jogada(int x, int y){
        if(jogador==1){
            mat[x][y]=1;
            return "X";
        }else{
            mat[x][y]=2;
            return "O";
        }
    }
    
    public void initDefault(){
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    public void adicionaPlacar(){
        if(jogador==1){
            int value=(int)spnJog1.getValue();
            value++;
            spnJog1.setValue(value);
        }else{
            int value=(int)spnJog2.getValue();
            value++;
            spnJog2.setValue(value);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn00 = new javax.swing.JButton();
        btn01 = new javax.swing.JButton();
        btn02 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnNovo = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        labelJog1 = new javax.swing.JLabel();
        labelJog2 = new javax.swing.JLabel();
        spnJog1 = new javax.swing.JSpinner();
        spnJog2 = new javax.swing.JSpinner();
        labelVez = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TIC TAC TOE - By Nortton Sampaio");

        btn00.setFont(new java.awt.Font("Felix Titling", 1, 150)); // NOI18N
        btn00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn00ActionPerformed(evt);
            }
        });

        btn01.setFont(new java.awt.Font("Felix Titling", 1, 150)); // NOI18N
        btn01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01ActionPerformed(evt);
            }
        });

        btn02.setFont(new java.awt.Font("Felix Titling", 1, 150)); // NOI18N
        btn02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn02ActionPerformed(evt);
            }
        });

        btn10.setFont(new java.awt.Font("Felix Titling", 1, 150)); // NOI18N
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn11.setFont(new java.awt.Font("Felix Titling", 1, 150)); // NOI18N
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });

        btn12.setFont(new java.awt.Font("Felix Titling", 1, 150)); // NOI18N
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });

        btn20.setFont(new java.awt.Font("Felix Titling", 1, 150)); // NOI18N
        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });

        btn21.setFont(new java.awt.Font("Felix Titling", 1, 150)); // NOI18N
        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });

        btn22.setFont(new java.awt.Font("Felix Titling", 1, 150)); // NOI18N
        btn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn22ActionPerformed(evt);
            }
        });

        btnNovo.setMnemonic('n');
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSair.setMnemonic('s');
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        labelTitulo.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        labelTitulo.setText("TIC TAC TOE!");

        labelJog1.setText("Jogador 1");

        labelJog2.setText("Jogador 2");

        spnJog1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        spnJog1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnJog1.setEnabled(false);

        spnJog2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        spnJog2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnJog2.setEnabled(false);

        labelVez.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        labelVez.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVez.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelJog1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnJog1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelJog2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnJog2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelVez, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(labelVez, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelJog1)
                                    .addComponent(spnJog1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelJog2)
                                    .addComponent(spnJog2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        // TODO add your handling code here:
        btn22.setText(jogada(2, 2));
        btn22.setEnabled(false);
        continuarJogo();
    }//GEN-LAST:event_btn22ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        // TODO add your handling code here:
        btn21.setText(jogada(2, 1));
        btn21.setEnabled(false);
        continuarJogo();
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        // TODO add your handling code here:
        btn20.setText(jogada(2, 0));
        btn20.setEnabled(false);
        continuarJogo();
    }//GEN-LAST:event_btn20ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        // TODO add your handling code here:
        btn12.setText(jogada(1, 2));
        btn12.setEnabled(false);
        continuarJogo();
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        // TODO add your handling code here:
        btn11.setText(jogada(1, 1));
        btn11.setEnabled(false);
        continuarJogo();
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        // TODO add your handling code here:
        btn10.setText(jogada(1, 0));
        btn10.setEnabled(false);
        continuarJogo();
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn02ActionPerformed
        // TODO add your handling code here:
        btn02.setText(jogada(0, 2));
        btn02.setEnabled(false);
        continuarJogo();
    }//GEN-LAST:event_btn02ActionPerformed

    private void btn01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01ActionPerformed
        // TODO add your handling code here:
        btn01.setText(jogada(0, 1));
        btn01.setEnabled(false);
        continuarJogo();
    }//GEN-LAST:event_btn01ActionPerformed

    private void btn00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn00ActionPerformed
        // TODO add your handling code here:
        btn00.setText(jogada(0, 0));
        btn00.setEnabled(false);
        continuarJogo();
    }//GEN-LAST:event_btn00ActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        dispose();
        Jogo novojogo = new Jogo();
    }//GEN-LAST:event_btnNovoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn00;
    private javax.swing.JButton btn01;
    private javax.swing.JButton btn02;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelJog1;
    private javax.swing.JLabel labelJog2;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelVez;
    private javax.swing.JSpinner spnJog1;
    private javax.swing.JSpinner spnJog2;
    // End of variables declaration//GEN-END:variables
}
