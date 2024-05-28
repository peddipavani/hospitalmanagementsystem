package gui;

import database.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DoctorFrame extends JFrame {
    private final JTextField nameField;
    private final JTextField specializationField;
    private final JButton addButton;
    private final JButton viewButton;
    private final JButton updateButton;
    private final JButton deleteButton;

    public DoctorFrame() {
        setTitle("Doctor Module");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Specialization:"));
        specializationField = new JTextField();
        add(specializationField);

        addButton = new JButton("Add Doctor");
        add(addButton);

        viewButton = new JButton("View Doctors");
        add(viewButton);

        updateButton = new JButton("Update Doctor");
        add(updateButton);

        deleteButton = new JButton("Delete Doctor");
        add(deleteButton);
        addButton.addActionListener((ActionEvent e) -> {
            String name1 = nameField.getText();
            String specialization = specializationField.getText();
            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO doctors (name, specialization) VALUES (?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name1);
                pstmt.setString(2, specialization);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Doctor added successfully!");
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error adding doctor.");
            }
        });
    }
}


// Auto-generated code starts here
// <editor-fold defaultstate="collapsed" desc="Generated Code">
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

        doctorButton.addActionListener((ActionEvent e) -> {
            DoctorFrame doctorFrame = new DoctorFrame();
            doctorFrame.setVisible(true);
        });


        // Add action listeners to other buttons...
    }

    
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
public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

