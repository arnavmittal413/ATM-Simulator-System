package bank.maangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
    public class Pinchange extends JFrame implements ActionListener {
        String pinno;
        JPasswordField pinTextField,repinTextField;
        JButton back,change;
        
        
        Pinchange(String pinno){
        this.pinno=pinno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(180,220,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Sytem",Font.BOLD,16));
        image.add(text);
        
        JLabel pin=new JLabel("NEW PIN:");
        pin.setBounds(120,250,100,35);
        pin.setForeground(Color.white);
        pin.setFont(new Font("Sytem",Font.BOLD,16));
        image.add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(270,255,100,25);
        pinTextField.setFont(new Font("System",Font.BOLD,16));
        image.add(pinTextField);
        
        
        JLabel repin=new JLabel("Re-Enter NEW PIN:");
        repin.setBounds(120,290,150,35);
        repin.setForeground(Color.white);
        repin.setFont(new Font("Sytem",Font.BOLD,16));
        image.add(repin);
        
        
        repinTextField=new JPasswordField();
        repinTextField.setBounds(270,295,100,25);
        repinTextField.setFont(new Font("System",Font.BOLD,16));
        image.add(repinTextField);
        
        back=new JButton("Back");
        back.setBounds(300,370,100,26);
        back.addActionListener(this);
        image.add(back);
        
        change=new JButton("Change");
        change.setBounds(300,400,100,26);
        change.addActionListener(this);
        image.add(change);
        
        
        
        
        
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setSize(700,700);
        setLocation(300,0);
        }
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==back){
                setVisible(false);
                new Transaction(pinno).setVisible(true);
            }else{
                try{
                    String pin=pinTextField.getText();
                    String repin=repinTextField.getText();
                    if(!pin.equals(repin)){
                        JOptionPane.showMessageDialog(null,"Please Enter same PIN");
                        return;
                    }
                    if(pin.equals("")){
                        JOptionPane.showMessageDialog(null,"Please Enter NEW PIN");
                    }
                    if(repin.equals("")){
                        JOptionPane.showMessageDialog(null,"Please Re-Enter NEW PIN");
                    }
                    Cone c=new Cone();
                    String query1="update bank set pinno ='"+pin+"' where pinno='"+pinno+"'";
                    String query2="update login set pinnumber ='"+pin+"' where pinnumber='"+pinno+"'";
                    String query3="update signupThree set pinnumber ='"+pin+"' where pinnumber='"+pinno+"'";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null,"PIN updated Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        
        public static void main(String args[]){
            new Pinchange("");
        }
}
