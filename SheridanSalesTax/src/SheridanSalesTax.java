/*
 * Zachary Sheridan
 * SheridanSalesTax
 * This program is designed to use GUI applications to allow the user to calculate tax based on static rates. 
 * Dr Reco Knowles
 * 22 October 2023
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SheridanSalesTax {

    private static JTextField monthlySalesField;
    private static JButton calcCountyTaxButton, calcSalesTaxButton, calcTotalTaxButton;
    private static final double COUNTY_TAX_RATE = 0.06;
    private static final double SALES_TAX_RATE = 0.075;

    public static void main(String[] args) {
        
        JFrame mainFrame = new JFrame("Monthly Sales Tax");
        
        GridLayout mainGrid = new GridLayout(2, 1);
        
        mainGrid.setVgap(10);
        
        JPanel mainPanel = new JPanel(mainGrid);
        
        GridLayout grid1 = new GridLayout(1, 2);
        
        mainGrid.setHgap(10);
        
        JPanel p1 = new JPanel(grid1);
        
        p1.setLayout(new GridBagLayout());
        
        JLabel salesLabel = new JLabel("Enter the total sales for the month: ");
        
        monthlySalesField = new JTextField(20);
        
        p1.add(salesLabel);
        p1.add(monthlySalesField);

       
        GridLayout grid2 = new GridLayout(1, 3);
        
        mainGrid.setHgap(5);
        
        JPanel p2 = new JPanel(grid2);
        
        p2.setLayout(new GridBagLayout());
        
        calcCountyTaxButton = new JButton("Calculate County Tax");
        calcSalesTaxButton = new JButton("Calculate Sales Tax");
        calcTotalTaxButton = new JButton("Calculate Total Sales Tax");
       
        p2.add(calcCountyTaxButton);
        p2.add(calcSalesTaxButton);
        p2.add(calcTotalTaxButton);
        
        mainPanel.add(p1);
        mainPanel.add(p2);

       
        mainFrame.add(mainPanel);
        mainFrame.setSize(600, 150);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        calcCountyTaxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(monthlySalesField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a monthly sales figure!");
                    return;
                }
               
                String input = monthlySalesField.getText().trim();
               
                if(!isDouble(input))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid monthly sales value(only numbers)!");
                    return;
                }
               
                double monthlySales = Double.parseDouble(input);
                
                double countyTaxAmount = getCountyTax(monthlySales);
                
                JOptionPane.showMessageDialog(null, "The county tax amount is: $" + String.format("%.2f", countyTaxAmount));
            }
        });

        calcSalesTaxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                if(monthlySalesField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a monthly sales figure!");
                    return;
                }
                
                String input = monthlySalesField.getText().trim();
               
                if(!isDouble(input))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid monthly sales value");
                    return;
                }
                
                double monthlySales = Double.parseDouble(input);
               
                double salesTaxAmount = getSalesTax(monthlySales);
                
                JOptionPane.showMessageDialog(null, "The state sales tax amount is: $" + String.format("%.2f", salesTaxAmount));
            }
        });

        calcTotalTaxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(monthlySalesField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a monthly sales figure!");
                    return;
                }
                
                String input = monthlySalesField.getText().trim();
               
                if(!isDouble(input))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid monthly sales value(only numbers)!");
                    return;
                }
               
                double monthlySales = Double.parseDouble(input);
                
                double countyTaxAmount = getCountyTax(monthlySales);
               
                double salesTaxAmount = getSalesTax(monthlySales);
               
                double totalSalesAmount = (countyTaxAmount + salesTaxAmount);
               
                JOptionPane.showMessageDialog(null, "The total sales tax amount is: $" + String.format("%.2f", totalSalesAmount));
            }
        });
    }

    public static double getCountyTax(double monthlySales)
    {
        return(monthlySales * COUNTY_TAX_RATE);
    }

    public static double getSalesTax(double monthlySales)
    {
        return(monthlySales * SALES_TAX_RATE);
    }

    public static boolean isDouble(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }
}