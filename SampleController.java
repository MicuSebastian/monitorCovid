/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
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

public class SampleController {
    
    private static Connection instance;
    
    public static Connection getInstance(){
        return instance;
    }

    @FXML
    private TextField uname;
     
    @FXML
    private PasswordField passw;
    
    @FXML
    private ImageView logo;
     
    @FXML
    private URL location;
     
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private Button login;
     
    public SampleController() 
    {
    }
     
    @FXML
    private void initialize() throws ClassNotFoundException 
    {
        Image image = new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/logo.png");
        logo.setImage(image);
    }
    
    public static String username;
    
    @FXML
    private void checkLogin() throws ClassNotFoundException{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            instance = DriverManager.getConnection("jdbc:derby://localhost:1527/covidTracker", "admin1", "1234");
            Statement stmt = instance.createStatement();
            
            username = uname.getText();
            String password = passw.getText();
            String sql = "";
            
            if(username.equals("admin") && password.equals("admin")){
                sql = "select * from admin where username = '"+username+"' AND password = '"+password+"'";
                NewFXMain.set_pane(3);
            }
            else if(username.equals("ionut") || username.equals("zebi")){
                sql = "select * from accounts where username = '"+username+"' AND password = '"+password+"'";
            }else{
                sql = "select * from clientaccounts where username = '"+username+"' AND password = '"+password+"'";
            }

            ResultSet rset = stmt.executeQuery(sql);

            while(rset.next()){
                String name = rset.getString("username");
                String pass = rset.getString("password");
                NewFXMain.set_pane(1);
            }
            
            uname.setText("");
            passw.setText("");
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void register(){
        NewFXMain.set_pane(2);
    }
    
    @FXML
    private void forgotPassword(){
        NewFXMain.set_pane(5);
    }
    
    @FXML
    public String getMod() throws ClassNotFoundException{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            instance = DriverManager.getConnection("jdbc:derby://localhost:1527/covidTracker", "admin1", "1234");
            Statement stmt = instance.createStatement();
            
            String sql = "select * from accounts";
            ResultSet rset = stmt.executeQuery(sql);
            
            String name = null;
            while(rset.next()){
                name = rset.getString("username");
            }
            return name;
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @FXML
    public boolean checkClients() throws ClassNotFoundException{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            instance = DriverManager.getConnection("jdbc:derby://localhost:1527/covidTracker", "admin1", "1234");
            Statement stmt = instance.createStatement();
            
            String sql = "select * from clientaccounts";
            ResultSet rset = stmt.executeQuery(sql);
            
            while(rset.next()){
                return true;
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean checkApi(String country) throws MalformedURLException, ProtocolException, IOException{
        URL urlForGetRequest = new URL("https://api.covid19api.com/total/country/" + country.toLowerCase());
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("Confirmed", "1");
        int responseCode = conection.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return true;
        }
        return false;
    }
}
