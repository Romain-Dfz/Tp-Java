package org.example;

import org.example.utils.DatabaseConnector;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Demo2GUI extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private DefaultListModel<String> listModel;
    private JList<String> personList;

    public Demo2GUI() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Demo2GUI");
        setSize(400, 300);

        JPanel mainPanel = new JPanel(new BorderLayout());

        listModel = new DefaultListModel<>();
        personList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(personList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addPerson());

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updatePerson());

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deletePerson());

        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel);
        fetchDataFromDatabase();
    }

    private void fetchDataFromDatabase() {
        listModel.clear();

        try (Connection connection = DatabaseConnector.getConnection()) {
            String selectQuery = "SELECT * FROM person";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    listModel.addElement(id + ") " + firstName + " " + lastName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des données.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addPerson() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            connection.setAutoCommit(true);

            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();

            String insertQuery = "INSERT INTO person (first_name, last_name) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.executeUpdate();

                connection.commit();

                JOptionPane.showMessageDialog(this, "Personne ajoutée avec succès.");
            }
            fetchDataFromDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout de la personne.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updatePerson() {
        // Ajoutez ici la logique pour la mise à jour d'une personne
    }

    private void deletePerson() {
        // Ajoutez ici la logique pour la suppression d'une personne
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Demo2GUI().setVisible(true));
    }
}
