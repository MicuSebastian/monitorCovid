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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author alladeenPC
 */
public class RegisterController implements Initializable {
    
    private static Connection instance;
    
    public static Connection getInstance(){
        return instance;
    }
    
    @FXML
    private TextField uname;
     
    @FXML
    private PasswordField passw;
    
    @FXML
    private Button login;
    
    @FXML
    private ImageView logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/logo.png");
        logo.setImage(image);
    }   
    
    @FXML
    private void login(){
        NewFXMain.set_pane(0);
    }
    
    @FXML
    private void registerAccount() throws ClassNotFoundException{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            instance = DriverManager.getConnection("jdbc:derby://localhost:1527/covidTracker", "admin1", "1234");
            Statement stmt = instance.createStatement();
            
            String username = uname.getText();
            String password = passw.getText();
            
            if(!username.equals("") && !password.equals("")){
                String sql = "insert into clientaccounts (username, password) values ('"+username+"', '"+password+"')";
            
                stmt.executeUpdate(sql);
                NewFXMain.set_pane(0);
            }else{
                System.out.println("Nereusit");
            }

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
