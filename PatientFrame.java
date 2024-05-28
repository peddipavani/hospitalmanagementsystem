package gui;

import database.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientFrame extends JFrame {

    private final JTextField nameField;
    private final JTextField ageField;
    private final JTextField genderField;
    private final JButton addButton;
    private final JButton viewButton;
    private final JButton updateButton;
    private final JButton deleteButton;

    public PatientFrame() {
        setTitle("Patient Module");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Gender:"));
        genderField = new JTextField();
        add(genderField);

        addButton = new JButton("Add Patient");
        add(addButton);

        viewButton = new JButton("View Patients");
        add(viewButton);

        updateButton = new JButton("Update Patient");
        add(updateButton);

        deleteButton = new JButton("Delete Patient");
        add(deleteButton);
        addButton.addActionListener((ActionEvent e) -> {
            addPatient();
        });

        viewButton.addActionListener((ActionEvent e) -> {
            viewPatients();
        });

        updateButton.addActionListener((ActionEvent e) -> {
            updatePatient();
        });

        deleteButton.addActionListener((ActionEvent e) -> {
            deletePatient();
        });
    }
    private void addPatient() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String gender = genderField.getText();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO patients (name, age, gender) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Patient added successfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding patient.");
        }
    }

    // Method to view all patients
    private void viewPatients() {
        // Implement view functionality here
    }

    // Method to update patient information
    private void updatePatient() {
        // Implement update functionality here
    }

    // Method to delete a patient
    private void deletePatient() {
        // Implement delete functionality here
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

        patientButton.addActionListener((ActionEvent e) -> {
            PatientFrame patientFrame = new PatientFrame();
            patientFrame.setVisible(true);
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