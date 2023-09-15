package bank.maangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {
    JButton deposite,withdraw,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinno;
    FastCash(String pinno){
        this.pinno=pinno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text=new JLabel("Please select Amount Withdrwal");
        text.setBounds(180,220,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Sytem",Font.BOLD,16));
        image.add(text);
        
        deposite=new JButton("Rs 100");
        deposite.setBounds(125,320,100,26);
        deposite.addActionListener(this);
        image.add(deposite);
        
        withdraw=new JButton("Rs 200");
        withdraw.setBounds(235,320,150,26);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash=new JButton("Rs 500");
        fastcash.setBounds(125,350,100,26);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Rs 1000");
        ministatement.setBounds(235,350,150,26);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(125,380,100,26);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
        balanceenquiry=new JButton("Rs 10000");
        balanceenquiry.setBounds(235,380,150,26);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit=new JButton("Back");
        exit.setBounds(235,410,150,20);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setSize(700,700);
        setLocation(300,0);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Cone c=new Cone();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pinno = '"+pinno+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposite")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffecient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinno+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeQuery(query);
                JOptionPane.showMessageDialog(null, "Rs '"+amount+"' succesfully withdrawl");
                setVisible(false);
                new Transaction(pinno).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
}
