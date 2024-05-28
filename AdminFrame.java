package gui;

import database.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class AdminFrame extends JFrame {
    private final JTextField usernameField;
    private final JTextField passwordField;
    private final JButton loginButton;
    private final JButton backButton;

    /**
     *
     */
    public AdminFrame() {
        setTitle("Admin Module");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField(); // Use JPasswordField for password input
        add(passwordField);

        loginButton = new JButton("Login");
        add(loginButton);
        backButton = new JButton("Back");
        add(backButton);
        
        loginButton.addActionListener((var e) -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            
            // Implement your CRUD operations here
            // Example: Perform authentication by checking username and password in the database
            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                java.sql.ResultSet rs = pstmt.executeQuery();

                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    // Proceed with other operations or open new frames
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while logging in.");
            }
        });
        backButton.addActionListener((var e) -> {
            // Handle back button action, for example, dispose this frame
            dispose();
        });
        
    }

    private static class ResultSet {

        public ResultSet() {
        }

        private boolean next() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

        adminButton.addActionListener((ActionEvent e) -> {
            AdminFrame adminFrame = new AdminFrame();
            adminFrame.setVisible(true);
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
