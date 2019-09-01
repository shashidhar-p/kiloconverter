
package kmtomiles;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class KmToMiles {


    public static void main(String[] args) {
        JFrame window = new KmToMilesGUI();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    
}
class KmToMilesGUI extends JFrame {
    private JTextField milesTf      = new JTextField(10);
    private JTextField kilometersTf = new JTextField(10);
    private JButton    convertBtn   = new JButton("Convert");


   
    public KmToMilesGUI() {
        
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout()); 
        content.add(new JLabel("Kilometers"));
        content.add(kilometersTf);          
        content.add(convertBtn);            
        content.add(new JLabel("Miles"));      
        content.add(milesTf);                
        this.setContentPane(content); 
        this.pack();
        
        
        convertBtn.addActionListener(new ConvertBtnListener());
        
        
        this.setTitle("Kilometers to Miles");
    }
    
    class ConvertBtnListener implements ActionListener {  
        public void actionPerformed(ActionEvent e) {
           
            //String kmStr = m_kilometersTf.getText();
            //String mlStr=m_milesTf.getText();
            
            if(kilometersTf.getText().trim().equals(""))
            {
                String mlStr=milesTf.getText();
                double mi =Double.parseDouble(mlStr);
                
                double km = convertMiToKm(mi);
               

                kilometersTf.setText(String.format("%.4f",km));

            }
            if (milesTf.getText().trim().equals(""))
            {
                String kmStr = kilometersTf.getText();
                double km = Double.parseDouble(kmStr);
                
                double mi = convertKmToMi(km);               
           
                milesTf.setText(String.format("%.4f",mi));  

            }
        }
    }
    
    public static double convertKmToMi(double kilometers) {
       
        double miles = kilometers * 0.621;
        return miles;
    }
    
    public static double convertMiToKm(double miles) {
       
        double kilometers = miles/0.621;
        return kilometers;
    }
}
