package bank.maangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener {
    JButton deposite,withdraw,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinno;
    Transaction(String pinno){
        this.pinno=pinno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text=new JLabel("Please select Your Transaction");
        text.setBounds(180,220,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Sytem",Font.BOLD,16));
        image.add(text);
        
        deposite=new JButton("Deposite");
        deposite.setBounds(125,320,100,26);
        deposite.addActionListener(this);
        image.add(deposite);
        
        withdraw=new JButton("Cash Withdrawl");
        withdraw.setBounds(235,320,150,26);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(125,350,100,26);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini-Statement");
        ministatement.setBounds(235,350,150,26);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("PIN Change");
        pinchange.setBounds(125,380,100,26);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
        balanceenquiry=new JButton("Balance-Enquiry");
        balanceenquiry.setBounds(235,380,150,26);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit=new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()==deposite){
            setVisible(false);
            new Deposite(pinno).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdrawl(pinno).setVisible(true);
                    
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinno).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new Pinchange(pinno).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinno).setVisible(true);
        }else if(ae.getSource()==ministatement){
            new MiniStatement(pinno).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transaction("");
    }
}
