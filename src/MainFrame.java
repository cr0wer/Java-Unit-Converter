
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class MainFrame extends javax.swing.JFrame {

    // uchovava seznam jednotek a stara se o prevod
    private Converter converter = new Converter();

    public MainFrame() {
        initComponents();
        setLocationRelativeTo(getRootPane()); // vycentruje form
        converter = new Config().returnConfig(); // nastavi vsechny jednotky

        // vypise text s poctem vsech jednotek
        lbTotalUnits.setText("total units: " + Integer.toString(converter.getTotalUnits()));

        // ziska pouze jmena jednotek a vlozi je do ComboBoxu
        String allItems[] = converter.getAllUnitNames();
        conFrom.setModel(new DefaultComboBoxModel(allItems));
        conTo.setModel(new DefaultComboBoxModel(allItems));

        // nastavi vychozi hodnoty ConboBoxu pro prevod
        conFrom.setSelectedItem("m");
        conTo.setSelectedItem("cm");
        lbUnitName.setText(conTo.getSelectedItem().toString());
        lbConvTo.setText(converter.getUnitComment(conTo.getSelectedItem().toString()));
    }

    // nastavuje text pro vypis vysledku a jednotku
    private void setResultText(String text, boolean isErrMsg) {
        lbConverted.setText(text);
        if (!isErrMsg) {
            lbUnitName.setText(conTo.getSelectedItem().toString());
        } else {
            lbUnitName.setText(null);
        }
    }

    // osetruje vstup a vypisuje vysledny prevod
    private void convertAndShow() {
        Double inputVal = 0.0;
        try {
            // pokud nebude zadny vstup
            if (boxInput.getText().length() < 1) {
                setResultText("Musíte zadat nějakou hodnotu.", true);
                return;
            }
            inputVal = Double.parseDouble(boxInput.getText());
        } catch (Exception e) {
            // pokud na vstupu budou nejake znaky (krom "f")
            setResultText("Převést lze pouze číslo!", true);
            return;
        }
        // zkusi ziskat prevedenou hodnotu podle nastaveni
        inputVal = converter.getConvertResult(inputVal,
                conFrom.getSelectedItem().toString(),
                conTo.getSelectedItem().toString());

        // v pripade, ze vysledek bude vetsi nez je double (nE303+)
        if (inputVal.isInfinite()) {
            setResultText("Výsledek je \"nekonečný\" na zobrazení :(", true);
            return;
        }

        // v pripade, ze nastane chyba pri prevodu (nepravdepodobne)
        if (inputVal.isNaN()) {
            setResultText("Někde nastala chyba! Zkusto to znovu.", true);
            return;
        }
        setResultText(Double.toString(inputVal), false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        conFrom = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        conTo = new javax.swing.JComboBox();
        lbConverted = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        boxInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbTotalUnits = new javax.swing.JLabel();
        lbUnitName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbConvTo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Převody jednotek délky");
        setBackground(new java.awt.Color(204, 204, 204));
        setIconImages(null);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel1.setText("Převod:");

        conFrom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        conFrom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                conFromItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel2.setText("do");

        conTo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        conTo.setMinimumSize(new java.awt.Dimension(57, 22));
        conTo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                conToItemStateChanged(evt);
            }
        });

        lbConverted.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbConverted.setForeground(new java.awt.Color(0, 51, 102));
        lbConverted.setText("0.0");
        lbConverted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbConvertedMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Výsledek:");

        btnClose.setText("Konec");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel3.setText("Hodnota:");

        boxInput.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxInput.setText("0");
        boxInput.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                boxInputCaretUpdate(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("created by Jiří Vik | 2011");

        lbTotalUnits.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        lbTotalUnits.setText("total units: 0");

        lbUnitName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbUnitName.setForeground(new java.awt.Color(102, 0, 0));
        lbUnitName.setText("NULL");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setText("Převod do:");

        lbConvTo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbConvTo.setText("NULL");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxInput, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conTo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbConverted)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUnitName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbConvTo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lbTotalUnits))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(boxInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(conFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(conTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbConverted)
                            .addComponent(lbUnitName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbConvTo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(lbTotalUnits)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // tlacitko pro ukonceni
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    // zmena jednotky v ComboBoxu (DO jake jednotky)
    private void conToItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_conToItemStateChanged
        convertAndShow();
        if (boxInput.getText().length() > 0) {
            lbUnitName.setText(conTo.getSelectedItem().toString());
        }
        lbConvTo.setText(converter.getUnitComment(conTo.getSelectedItem().toString()));
    }//GEN-LAST:event_conToItemStateChanged

    // zmena jednotky v ComboBoxu (Z jake jednotky)
    private void conFromItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_conFromItemStateChanged
        convertAndShow();
    }//GEN-LAST:event_conFromItemStateChanged

    // zmena hodnoty
    private void boxInputCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_boxInputCaretUpdate
        convertAndShow();
    }//GEN-LAST:event_boxInputCaretUpdate

    // pokud mysi klikneme druhym tlacitkem (koleckem) na vysledny prevod,
    // tak se vysledek napise do zadavane hodnoty
    private void lbConvertedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConvertedMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON2) {
            String temp = lbConverted.getText();
            boxInput.setText(lbConverted.getText());
            lbConverted.setText(temp);
        }
    }//GEN-LAST:event_lbConvertedMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField boxInput;
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox conFrom;
    private javax.swing.JComboBox conTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbConvTo;
    private javax.swing.JLabel lbConverted;
    private javax.swing.JLabel lbTotalUnits;
    private javax.swing.JLabel lbUnitName;
    // End of variables declaration//GEN-END:variables
}
