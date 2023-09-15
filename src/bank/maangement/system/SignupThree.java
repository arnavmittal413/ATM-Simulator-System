package bank.maangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2=new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);

        r4=new JRadioButton("Reccuring Deposite Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4); 
        
        ButtonGroup accountGroup=new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);
        
        JLabel cardno=new JLabel("Card No. :");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(100,280,200,30);
        add(cardno);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4148");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,280,300,30);
        add(number);
        
        JLabel carddetail=new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,310,300,20);
        add(carddetail);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,350,200,30);
        add(pin);
        
        
        JLabel pindetail=new JLabel("Your 4 Digit PIN Number");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,380,300,20);
        add(pindetail);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,350,300,30);
        add(pnumber);
        
        JLabel service=new JLabel("Services Required");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,420,300,30);
        add(service);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,460,200,30);
        add(c1);
        
        c2=new JCheckBox("INTERNET BACNKING");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,460,200,30);
        add(c2);
        c3=new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,500,200,30);
        add(c3);
        c4=new JCheckBox("EMAIL & SMS ALERT");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,500,200,30);
        add(c4);
        c5=new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,540,200,30);
        add(c5);
        c6=new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,540,200,30);
        add(c6);
        c7=new JCheckBox("I heaeby declare that above details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,580,600,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250, 630,100,30);
        submit.addActionListener(this);
        add(submit); 
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420, 630,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setVisible(true);
        setLocation(350,10);
        
    }
    
    public  void actionPerformed(ActionEvent ae){
         if(ae.getSource()==cancel){
             setVisible(false);
             new Login().setVisible(true);
             
         }else if(ae.getSource()==submit){
                String accounttype="null";
                if(r1.isSelected()){
                    accounttype="Saving Account";
                }else if(r2.isSelected()){
                    accounttype="Fixed Deposite Account";
                }else if(r3.isSelected()){
                    accounttype="Current Account";
                }else if(r4.isSelected()){
                    accounttype="Reccuring Deposite Account";
                }
                Random random=new Random();
                String cardnumber=""+Math.abs((random.nextLong() %90000000L)+5040936000000000L);
                String pinno=""+Math.abs((random.nextLong()%9000L)+1000L);
                String facility="";
                if(c1.isSelected()){
                    facility= facility +" ATM CARD";
                }else if(c2.isSelected()){
                    facility=facility+" Internet Banking";
                }else if(c3.isSelected()){
                    facility=facility+" Mobile Banking";
                }else if(c4.isSelected()){
                    facility=facility+" Email & SMS Alert";
                }else if(c5.isSelected()){
                    facility=facility+" Cheque Book";
                }else if(c6.isSelected()){
                    facility=facility+" E-Statement";
                }
                
                try{
                    if(accounttype.equals("")){
                        JOptionPane.showMessageDialog(null,"Account Type is Required");
                    }else{
                        Cone con=new Cone();
                        String query2="insert into signupThree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinno+"','"+facility+"')";
                        String query3="insert into login values('"+formno+"','"+cardnumber+"','"+pinno+"')";
                        con.s.executeUpdate(query2);
                        con.s.executeUpdate(query3);
                        JOptionPane.showMessageDialog(null, "Card Number "+ cardnumber+"\n"+"PIN: "+pinno);
                        setVisible(false);
                        new Deposite(pinno).setVisible(true);
                    }
                    
                }catch(Exception e){
                    System.out.println(e);
                }
                
               
                
         }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
}
