package flight;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Flight extends JFrame{

    
    JLabel citiesLabel = new JLabel();
    JList citiesList = new JList();
    JScrollPane citiesScrollPane = new JScrollPane();
    JLabel seatLabel = new JLabel();
    JComboBox seatComboBox = new JComboBox();
    JLabel mealLabel = new JLabel();
    JComboBox mealComboBox = new JComboBox();
    JButton assignButton = new JButton();
    JButton exitButton = new JButton();
    
    public static void main(String[] args) {

        new Flight().show();
    }

    public Flight() throws HeadlessException {
        setTitle("Flight Planer");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitForm(e);
            }
            
           });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;
        citiesLabel.setText("Cities");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(citiesLabel, gridConstraints);
        citiesScrollPane.setPreferredSize(new Dimension(150, 100));
        citiesScrollPane.setViewportView(citiesList);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(citiesScrollPane, gridConstraints);
        seatLabel.setText("Seat Location");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(seatLabel, gridConstraints);
        seatComboBox.setBackground(Color.white);
        seatComboBox.setPreferredSize(new Dimension(100, 25));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        gridConstraints.anchor = GridBagConstraints.NORTH;
        getContentPane().add(seatComboBox, gridConstraints);
        mealLabel.setText("Meal Preference");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(mealLabel, gridConstraints);
        mealComboBox.setEditable(true);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        gridConstraints.anchor = GridBagConstraints.NORTH;
        getContentPane().add(mealComboBox, gridConstraints);
        assignButton.setText("Assign");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(0, 0, 10, 0);
        getContentPane().add(assignButton, gridConstraints);
        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignButtonActionPerformed(e);
            }
        });
        exitButton.setText("Exit");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(0, 0, 10, 0);
        getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButtonActionPerformed(e);
            }
        });
        
        
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)0.5*(screenSize.width - getWidth()), (int)0.5 *(screenSize.height - getHeight()), getWidth(), getHeight());
        DefaultListModel citiesListModel = new DefaultListModel();
        citiesListModel.addElement("Sarajevo");
        citiesListModel.addElement("Munchen");
        citiesListModel.addElement("Paris");
        citiesListModel.addElement("Berlin");
        citiesListModel.addElement("Bern");
        citiesListModel.addElement("Bratislava");
        citiesListModel.addElement("Abu Dhabi");
        citiesListModel.addElement("Istanbul");
        citiesListModel.addElement("Peking");
        citiesList.setModel(citiesListModel);
        citiesList.setSelectedIndex(0);
        
        seatComboBox.addItem("Aisle");
        seatComboBox.addItem("Middle");
        seatComboBox.addItem("Window");
        seatComboBox.setSelectedIndex(0);
        
        mealComboBox.addItem("Chicken");
        mealComboBox.addItem("Mystery meat");
        mealComboBox.addItem("Kosher");
        mealComboBox.addItem("Vegetarian");
        mealComboBox.addItem("Fruit Plate");
        mealComboBox.addItem("No preference");
        mealComboBox.setSelectedItem("No Preference");
           
    }
    private void assignButtonActionPerformed(ActionEvent e){
        String message;
        message = "Destination: " + citiesList.getSelectedValue() + "\n";
        message += "Seat Location: " + seatComboBox.getSelectedItem() + "\n";
        message += "Meal: " + mealComboBox.getSelectedItem() + "\n";
        JOptionPane.showConfirmDialog(null, message, "Your Assgnemnt", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
    }
    private void exitButtonActionPerformed(ActionEvent e){
        System.exit(0);
        
    }
    
    private void exitForm(WindowEvent e){
        System.exit(0);
    }
    
}
