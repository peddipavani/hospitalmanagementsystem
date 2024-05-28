package gui;

import database.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AppointmentFrame extends JFrame {

    private final JTextField patientField;
    private final JTextField doctorField;
    private final JTextField dateField;
    private final JTextField timeField;
    private final JButton bookButton;
    private final JButton cancelButton;
    private final JButton viewButton;

    public AppointmentFrame() {
        setTitle("Appointment Module");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2));

        add(new JLabel("Patient ID:"));
        patientField = new JTextField();
        add(patientField);

        add(new JLabel("Doctor ID:"));
        doctorField = new JTextField();
        add(doctorField);

        add(new JLabel("Date:"));
        dateField = new JTextField();
        add(dateField);

        add(new JLabel("Time:"));
        timeField = new JTextField();
        add(timeField);

        bookButton = new JButton("Book Appointment");
        add(bookButton);

        cancelButton = new JButton("Cancel Appointment");
        add(cancelButton);

        viewButton = new JButton("View Appointments");
        add(viewButton);
        createButton.addActionListener((ActionEvent e) -> {
            String patientName = patientNameField.getText();
            String doctorName = doctorNameField.getText();
            String appointmentDate = appointmentDateField.getText();
            
            // Implement your CRUD operations here
            // Example: Create a new appointment in the database
            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO appointments (patient_name, doctor_name, appointment_date) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, patientName);
                pstmt.setString(2, doctorName);
                pstmt.setString(3, appointmentDate);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Appointment created successfully!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error creating appointment.");
            }
        });
       
        
    }

    private static class doctorNameField {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public doctorNameField() {
        }
    }

    private static class appointmentDateField {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public appointmentDateField() {
        }
    }

    private static class createButton {

        private static void addActionListener(ActionListener actionListener) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }


        public createButton() {
        }
    }


}

class MainFrame extends JFrame {
    private JButton doctorButton, adminButton, patientButton, receptionistButton, appointmentButton;

    public MainFrame() {
        initComponents(); // Call the auto-generated method
        customInit(); // Call your custom initialization method
    }

    // Custom initialization method
    private void customInit() {
        setTitle("Hospital Management System");
        setSize(400, 300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 1));

        doctorButton = new JButton("Doctor Module");
        adminButton = new JButton("Admin Module");
        patientButton = new JButton("Patient Module");
        receptionistButton = new JButton("Receptionist Module");
        appointmentButton = new JButton("Appointment Module");

        add(doctorButton);
        add(adminButton);
        add(patientButton);
        add(receptionistButton);
        add(appointmentButton);

        appointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppointmentFrame appointmentFrame = new AppointmentFrame();
                appointmentFrame.setVisible(true);
            }
        });

        // Add action listeners to other buttons...
    }
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