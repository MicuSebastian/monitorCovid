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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author alladeenPC
 */
public class ForgotPasswordController implements Initializable {
    
    private static Connection instance;
    
    public static Connection getInstance(){
        return instance;
    }
    
    @FXML
    private TextField uname;
    
    @FXML
    private PasswordField firstPass;
    
    @FXML
    private PasswordField secondPass;
    
    @FXML
    private ImageView logo;
    
    public void resetPass() throws ClassNotFoundException{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            instance = DriverManager.getConnection("jdbc:derby://localhost:1527/covidTracker", "admin1", "1234");
            Statement stmt = instance.createStatement();
            
            String username = uname.getText();
            String firstPassword = firstPass.getText();
            String secondPassword = secondPass.getText();
            
            if(!username.equals("") && !firstPassword.equals("") && !secondPassword.equals("")){
                if(firstPassword.equals(secondPassword)){
                    String sql = "update clientaccounts set password = '"+secondPassword+"' where username = '"+username+"'";
                    stmt.executeUpdate(sql);
                    NewFXMain.set_pane(0);
                }
            }
            
            
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void goToLogin(){
        NewFXMain.set_pane(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/logo.png");
        logo.setImage(image);
    }    
    
}
