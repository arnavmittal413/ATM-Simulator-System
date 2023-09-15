package bank.maangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposite extends JFrame implements ActionListener {
    JTextField amountTextField;
    JButton deposite,back;
    String pinno;
    Deposite(String pinno){
        this.pinno=pinno;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text=new JLabel("Please enter your Amount");
        text.setBounds(180,220,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Sytem",Font.BOLD,16));
        image.add(text);
        
        amountTextField=new JTextField();
        amountTextField.setBounds(125,320,270,26);
        amountTextField.setFont(new Font("Sytem",Font.BOLD,16));
        image.add(amountTextField);
        
        back=new JButton("Back");
        back.setBounds(300,370,100,26);
        back.addActionListener(this);
        image.add(back);
        
        deposite=new JButton("Deposite");
        deposite.setBounds(300,400,100,26);
        deposite.addActionListener(this);
        image.add(deposite);
        
        
        
        
        setSize(700,700);
        setLocation(350,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }else if(ae.getSource()==deposite){
            String number=amountTextField.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Amount is Empty");
            }else{
                try{
                Cone con=new Cone();
                String query="insert into bank value('"+pinno+"','"+date+"','Deposite','"+number+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs '"+number +"' Deposited successfully");
                    setVisible(false);
                new Transaction(pinno).setVisible(true);
            }catch(Exception e){
                System.out.print(e);
            }
            }
        }
        
    }
    
    public static void main(String args[]){
        new Deposite("");
    }
}
