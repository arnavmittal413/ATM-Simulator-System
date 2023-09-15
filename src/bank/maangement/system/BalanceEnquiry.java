package bank.maangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

    public class BalanceEnquiry extends JFrame implements ActionListener{
        String pinno;
        JButton back;
        BalanceEnquiry(String pinno){
            this.pinno=pinno;
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(0,0,700,700);
            add(image);
            
            JLabel text=new JLabel("YOUR BALANCE IS");
            text.setBounds(180,220,700,35);
            text.setForeground(Color.white);
            text.setFont(new Font("Sytem",Font.BOLD,16));
            image.add(text);
            int balance=0;
            try{
                Cone c=new Cone();
                ResultSet rs=c.s.executeQuery("select * from bank where pinno='"+pinno+"'");
                while(rs.next()){
                    if(rs.getString("type").equals("Deposite")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    if(rs.getString("type").equals("Withdrawal")){
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
            JLabel b=new JLabel("Your Account Balance is Rs " + balance);
            b.setForeground(Color.WHITE);
            b.setBounds(160,300,400,30);
            image.add(b);
            
            back=new JButton("Back");
            back.setBounds(300,400,100,26);
            back.addActionListener(this);
            image.add(back);
            
            setLayout(null);
            setUndecorated(true);
            setVisible(true);
            setSize(700,700);
            setLocation(300,0);
        }
        
        public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }
        
        public static void main(String args[]){
            new BalanceEnquiry("");
        }
}
