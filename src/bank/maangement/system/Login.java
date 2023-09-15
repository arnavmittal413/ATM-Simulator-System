package bank.maangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel Welcome=new JLabel("WELCOME TO ATM");
        Welcome.setFont(new Font("Osward",Font.BOLD,38));
        Welcome.setBounds(200,40,400,40);
        add(Welcome);
        
        JLabel cardNo=new JLabel("Card NO:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120,150,250,30);
        add(cardNo);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login=new JButton("LOGIN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(420,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGNUP");
        signup.setBounds(300,350,220,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,450);
        setVisible(true);
        setLocation(350,200);
        setTitle("AUTOMATED TELLER MACHINE");
        
        
        
    }
    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ac.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }else if(ac.getSource()==login){
            Cone a=new Cone();
            String cardno=cardTextField.getText();
            String pinno=pinTextField.getText();
            String query="Select * from login where cardnumber='"+cardno+"'and pinnumber='"+pinno+"'";
            try{
                ResultSet rs=a.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinno).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incoorect cardNumber and PIN");
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }
        
    }
    public static void main(String args[]){
        new Login();
    }
}
