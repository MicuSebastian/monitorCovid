/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alladeenPC
 */
public class AdminPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private static Connection instance;
    
    public static Connection getInstance(){
        return instance;
    }
    
    @FXML
    private TextField unameCreate;
     
    @FXML
    private TextField passwCreate;
    
    @FXML
    private TextField unameDelete;
    
    @FXML
    private TextField passwDelete;
    
    @FXML
    private CheckBox moderator;
    
    @FXML
    private CheckBox user;
    
    
    @FXML
    private void addAccountAsAdmin () throws ClassNotFoundException{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            instance = DriverManager.getConnection("jdbc:derby://localhost:1527/covidTracker", "admin1", "1234");
            Statement stmt = instance.createStatement();
            
            String usernameCreate = unameCreate.getText();
            String passwordCreate = passwCreate.getText();
            
            String sql;
            
            if(!usernameCreate.equals("") && !passwordCreate.equals("")){
                sql = "insert into accounts (username, password) values ('"+usernameCreate+"', '"+passwordCreate+"')";
            
                stmt.executeUpdate(sql);
                //NewFXMain.set_pane(0);
            }else{
                System.out.println("Nereusit");
            }

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
   @FXML
    private void deleteAccountAsAdmin () throws ClassNotFoundException{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            instance = DriverManager.getConnection("jdbc:derby://localhost:1527/covidTracker", "admin1", "1234");
            Statement stmt = instance.createStatement();
            
            String usernameDelete = unameDelete.getText();
            String passwordDelete = passwDelete.getText();
            String sql;
            
            if(!usernameDelete.equals("") && !passwordDelete.equals("")){
                if(moderator.isSelected()){
                    user.setSelected(false);
                    sql = "delete from accounts where username = '"+usernameDelete+"' AND password = '"+passwordDelete+"'";
                    stmt.executeUpdate(sql);
                }else if(user.isSelected()){
                    moderator.setSelected(false);
                    sql = "delete from clientaccounts where username = '"+usernameDelete+"' AND password = '"+passwordDelete+"'";
                    stmt.executeUpdate(sql);
                }
            }else{
                System.out.println("Nereusit");
            }

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void logout(ActionEvent event){
        NewFXMain.set_pane(0);
        unameCreate.setText("");
        passwCreate.setText("");
        unameDelete.setText("");
        passwDelete.setText("");
        moderator.setSelected(false);
        user.setSelected(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
