package gui;


import database.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;



public class ReceptionistFrame extends JFrame {
    private final JTextField nameField;
    private final JTextField contactField;
    private final JButton addButton;
    private final JButton viewButton;
    private final JButton updateButton;
    private final JButton deleteButton;

    public ReceptionistFrame() {
        setTitle("Receptionist Module");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Contact:"));
        contactField = new JTextField();
        add(contactField);

        addButton = new JButton("Add Receptionist");
        add(addButton);

        viewButton = new JButton("View Receptionists");
        add(viewButton);

        updateButton = new JButton("Update Receptionist");
        add(updateButton);

        deleteButton = new JButton("Delete Receptionist");
        add(deleteButton);
        addButton.addActionListener((ActionEvent e) -> {
            addReceptionist();
        });

        viewButton.addActionListener((ActionEvent e) -> {
            viewReceptionists();
        });

        updateButton.addActionListener((ActionEvent e) -> {
            updateReceptionist();
        });

        deleteButton.addActionListener((ActionEvent e) -> {
            deleteReceptionist();
        });
    }
    private void addReceptionist() {
        String name = nameField.getText();
        String contact = contactField.getText();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO receptionists (name, contact) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, contact);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Receptionist added successfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding receptionist.");
        }
    }

    // Method to view all receptionists
    private void viewReceptionists() {
        // Implement view functionality here
    }

    // Method to update receptionist information
    private void updateReceptionist() {
        // Implement update functionality here
    }

    // Method to delete a receptionist
    private void deleteReceptionist() {
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

        receptionistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReceptionistFrame receptionistFrame = new ReceptionistFrame();
                receptionistFrame.setVisible(true);
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
