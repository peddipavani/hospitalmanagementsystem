package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private JButton doctorButton, adminButton, patientButton, receptionistButton, appointmentButton;
    private JButton registerButton;

    /**
     *
     */
    public MainFrame() {
        initComponents();
        // Call the auto-generated method
        customInit(); // Call your custom initialization method
    }

    // Custom initialization method
    private void customInit() {
        // Add your custom components and event listeners here
        setTitle("Hospital Management System");
        setSize(400, 300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 1));

        doctorButton = new JButton("Doctor Module");
        adminButton = new JButton("Admin Module");
        patientButton = new JButton("Patient Module");
        receptionistButton = new JButton("Receptionist Module");
        appointmentButton = new JButton("Appointment Module");
        registerButton = new JButton("User Registration");

        add(doctorButton);
        add(adminButton);
        add(patientButton);
        add(receptionistButton);
        add(appointmentButton);
        add(registerButton);
        doctorButton.addActionListener((ActionEvent e) -> {
            new DoctorFrame().setVisible(true);
        });

        adminButton.addActionListener((ActionEvent e) -> {
            new AdminFrame().setVisible(true);
        });

        patientButton.addActionListener((ActionEvent e) -> {
            new PatientFrame().setVisible(true);
        });

        receptionistButton.addActionListener((ActionEvent e) -> {
            new ReceptionistFrame().setVisible(true);
        });

        appointmentButton.addActionListener((ActionEvent e) -> {
            new AppointmentFrame().setVisible(true);
        });

        // Add action listeners to buttons
        registerButton.addActionListener((ActionEvent e) -> {
            new RegistrationFrame().setVisible(true);
        });

        // Add action listeners to other buttons...
    }
            // <editor-fold defaultstate="collapsed" desc="Generated Code">
            // </editor-fold>
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}

