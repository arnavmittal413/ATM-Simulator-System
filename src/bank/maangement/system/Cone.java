package bank.maangement.system;

import java.sql.*;

public class Cone {
    Connection c;
    Statement s;
    public Cone(){
        try{
        c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","12345676");
        s=c.createStatement();
    }catch(Exception e){
        System.out.print(e);
    }
        }
}
