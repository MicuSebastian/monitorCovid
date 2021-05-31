/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.*;
import org.json.simple.parser.ParseException;


/**
 * FXML Controller class
 *
 * @author alladeenPC
 */
public class MainController implements Initializable {

    @FXML
    private Label confirmed;
    
    @FXML
    private Label deaths;
    
    @FXML
    private Label recovered;
    
    @FXML
    private Label active;
    
    @FXML
    private TextField searchBar;
    
    @FXML
    private ImageView photo;
    
    @FXML
    public void logout(ActionEvent event){
        NewFXMain.set_pane(0);
        confirmed.setText("");
        deaths.setText("");
        recovered.setText("");
        active.setText("");
        searchBar.setText("");
        photo.setImage(null);
    }
    
    @FXML
    public void heatmap(ActionEvent event){
        NewFXMain.set_pane(4);
    }
    
    @FXML
    public void favourites(ActionEvent event){
        NewFXMain.set_pane(6);
    }
    
    public static String country;
    
    @FXML
    public void apiTest() throws IOException, JSONException, ParseException {
        
        country = searchBar.getText();
        if(country == ""){
            confirmed.setText("");
            deaths.setText("");
            recovered.setText("");
            active.setText("");
            photo.setImage(null);
        }

        URL urlForGetRequest = new URL("https://api.covid19api.com/total/country/" + country.toLowerCase());
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("Confirmed", "1");
        int responseCode = conection.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            while ((readLine = in.readLine()) != null) {

                String[] arrOfStr = readLine.split(",");
                
                String confirmedCases = arrOfStr[arrOfStr.length - 5];
                confirmedCases = confirmedCases.replaceAll("[\"]*", "");
                confirmed.setText(confirmedCases);
                
                String deathCases = arrOfStr[arrOfStr.length - 4];
                deathCases = deathCases.replaceAll("[\"]*", "");
                deaths.setText(deathCases);
                
                String recoverCases = arrOfStr[arrOfStr.length - 3];
                recoverCases = recoverCases.replaceAll("[\"]*", "");
                recovered.setText(recoverCases);
                
                String activeCases = arrOfStr[arrOfStr.length - 2];
                activeCases = activeCases.replaceAll("[\"]*", "");
                active.setText(activeCases);
                
            } 
            in.close();
        } 
       
        
        URL urlForMiddleRequest = new URL("https://restcountries.eu/rest/v2/name/" + country.toLowerCase());
        String readLine2 = null;
        HttpURLConnection conection2 = (HttpURLConnection) urlForMiddleRequest.openConnection();
        conection2.setRequestMethod("GET");
        int responseCodeMiddle = conection2.getResponseCode();
        String capital = "";
        
        if (responseCodeMiddle == HttpURLConnection.HTTP_OK) {
            BufferedReader inMiddle = new BufferedReader(new InputStreamReader(conection2.getInputStream()));
            while ((readLine2 = inMiddle.readLine()) != null) {
                
                String[] arrOfStrMiddle = readLine2.split(",");
                capital = arrOfStrMiddle[5];
                capital = capital.replaceAll("(capital)", "");
                capital = capital.replaceAll("[\":]", "");
                
            }
            inMiddle.close();
        }
        
        URL urlForEndRequest = new URL("https://api.teleport.org/api/urban_areas/slug:" + capital.toLowerCase() + "/images/");
        String readLine3 = null;
        HttpURLConnection conection3 = (HttpURLConnection) urlForEndRequest.openConnection();
        conection3.setRequestMethod("GET");
        int responseCodeEnd = conection3.getResponseCode();
        String photoLink;
        
        if (responseCodeEnd == HttpURLConnection.HTTP_OK) {
            BufferedReader inEnd = new BufferedReader(new InputStreamReader(conection3.getInputStream()));
            while ((readLine3 = inEnd.readLine()) != null) {
                
                String[] arrOfStrEnd = readLine3.split(",");
                photoLink = arrOfStrEnd[arrOfStrEnd.length - 2];
                photoLink = photoLink.substring(19);
                photoLink = photoLink.replaceAll("\"", "");
                Image image = new Image(photoLink);
                photo.setImage(image);
                
            }
            inEnd.close();
        }
        
        else {
            System.out.println("GET NOT WORKED");
        }
}
    
    @FXML
    public static HashMap<String, ArrayList> favList = new HashMap<String, ArrayList>();
    
    @FXML
    public void addToFavourites(){
        if(favList.containsKey(SampleController.username) == false){
            ArrayList<String> favs = new ArrayList<String>();
            favs.add(country);
            favList.put(SampleController.username, favs);
        }
        else if(favList.get(SampleController.username).size() < 3){
                favList.get(SampleController.username).add(country);
            }else{
                System.out.println("Maximum possible favourites is 3.");
            }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    
}
