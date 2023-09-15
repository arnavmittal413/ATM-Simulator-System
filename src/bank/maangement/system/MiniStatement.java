package bank.maangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

    public class MiniStatement extends JFrame implements ActionListener  {
        
        JButton b1;
        
        MiniStatement(String pinno){
            setTitle("Mini-Statement");
            
            setLayout(null);
            
            JLabel text=new JLabel();
            text.setBounds(20, 140, 400, 200);
            add(text);
            
            JLabel bank=new JLabel("Indian Bank");
            bank.setBounds(150,20,100,20);
            add(bank);
            
            JLabel card=new JLabel();
            card.setBounds(20,80,300,20);
            add(card);
            
            JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
            
        b1 = new JButton("Exit");
        b1.setBounds(20, 500, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        
            try{
                Cone c=new Cone();
                ResultSet rs=c.s.executeQuery("select * from login where pinnumber ='"+pinno+"'");
                while(rs.next()){
                    card.setText("Card Number " + rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString(12));
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
            try{
            int balance = 0;
            Cone c1  = new Cone();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pinno = '"+pinno+"'");
            while(rs.next()){
                text.setText(text.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
            
            
            
            setVisible(true);
            getContentPane().setBackground(Color.WHITE);            
            setSize(400,600);
            setLocation(20,20);

        }
        
        public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
        
        public static void main(String args[]){
            new MiniStatement("");
        }
}
