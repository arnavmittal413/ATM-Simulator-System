package bank.maangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener {
    JTextField panTextField,aadharTextField;
    JRadioButton yes,no,yes2,no2;
    JButton next;
    JComboBox religion2,category2,income2,education2,occupation2;
    String formno;
    SignupTwo( String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE:2");
        
        
        JLabel additionalDetails=new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,25));
        additionalDetails.setBounds(250,80,400,30);
        add(additionalDetails);
        
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion2=new JComboBox(valReligion);
        religion2.setBackground(Color.WHITE);
        religion2.setBounds(300,140,400,30);
        add(religion2);

        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,22));
        category.setBounds(100,190,200,30);
        add(category);        
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
        category2=new JComboBox(valCategory);
        category2.setBounds(300,190,400,30);
        category2.setBackground(Color.WHITE);
        add(category2);
        
        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100,240,400,30);
        add(income);
        
        
        String valIncome[]={"null","<150000","<250000","500000","Other"};
        income2=new JComboBox(valIncome);
        income2.setBounds(300,240,400,30);
        income2.setBackground(Color.WHITE);
        add(income2);
        
        JLabel education=new JLabel("Educational:");
        education.setFont(new Font("Raleway",Font.BOLD,22));
        education.setBounds(100,290,200,30);
        add(education);
        
        String valEducation[]={"Non-Graduate","Gradution","Post-Graduation","Docrate","Other"};
        education2=new JComboBox(valEducation);
        education2.setBounds(300,290,400,30);
        education2.setBackground(Color.WHITE);
        add(education2);
        
        
        
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100,340,200,30);
        add(occupation);   
        
        String valOccupation[]={"Salaried","Self-Employed","Businessman","Student","Other"};
        occupation2=new JComboBox(valOccupation);
        occupation2.setBounds(300,340,400,30);
        occupation2.setBackground(Color.WHITE);
        add(occupation2);

        
        
        JLabel panNo=new JLabel("PAN NUMBER:");
        panNo.setFont(new Font("Raleway",Font.BOLD,22));
        panNo.setBounds(100,390,200,30);
        add(panNo); 
        panTextField=new JTextField();
        panTextField.setBounds(300,390,400,30);
        add(panTextField);
        
        
        
        
        JLabel aadhar=new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,22));
        aadhar.setBounds(100,440,200,30);
        add(aadhar);
        
        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,440,400,30);
        add(aadharTextField);
        
        JLabel senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,22));
        senior.setBounds(100,490,200,30);
        add(senior);
        
        yes=new JRadioButton("Yes");
        yes.setBounds(300,490,60,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        no=new JRadioButton("No");
        no.setBounds(450,490,120,30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup seniorGroup=new ButtonGroup();
        seniorGroup.add(yes);
        seniorGroup.add(no);
        
        
        JLabel Exisiting=new JLabel("Exisiting Account:");
        Exisiting.setFont(new Font("Raleway",Font.BOLD,22));
        Exisiting.setBounds(100,540,200,30);
        add(Exisiting);
        
        yes2=new JRadioButton("Yes");
        yes2.setBounds(300,540,60,30);
        yes2.setBackground(Color.WHITE);
        add(yes2);
        no2=new JRadioButton("No");
        no2.setBounds(450,540,60,30);
        no2.setBackground(Color.WHITE);
        add(no2);
        ButtonGroup marriedGroup=new ButtonGroup();
        marriedGroup.add(yes2);
        marriedGroup.add(no2);


        next=new JButton("NEXT");
        next.setBounds(620,630,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
        
    }
    
    public void actionPerformed(ActionEvent ac){
        String sreligion=(String)religion2.getSelectedItem();
        String category=(String)category2.getSelectedItem();
        String income=(String)income2.getSelectedItem();
        String education=(String)education2.getSelectedItem();
        String occupation=(String)occupation2.getSelectedItem();
        String panNo=panTextField.getText();
        String aadhar=aadharTextField.getText();
        String senior="null";
        if(yes.isSelected()){
            senior="Yes";
        }else{
            senior="No";
        }
        String acc="null";
        if(yes2.isSelected()){
            acc="Yes";
        }else{
            acc="No";
        }
        
        try{
            if(panNo.equals("")){
                JOptionPane.showMessageDialog(null, "name is required");
            }else{
                Cone c=new Cone();
                String query="insert into signupTwo value('"+formno+"','"+sreligion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+panNo+"','"+aadhar+"','"+senior+"','"+acc+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
}
