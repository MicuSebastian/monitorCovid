/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author alladeenPC
 */
public class FavouritesController implements Initializable {

    @FXML
    private Label slot1;
    
    @FXML
    private Label slot2;
    
    @FXML
    private Label slot3;
    
    @FXML
    public void showList(){
        
        String user = SampleController.username;
        ArrayList<String> list = new ArrayList<String>();
        
        list = MainController.favList.get(user);
        if(list.size() == 1){
            String text1 = list.get(0);
            text1 = text1.substring(0, 1).toUpperCase() + text1.substring(1);
            slot1.setText(text1);
        }
        if(list.size() == 2){
            String text1 = list.get(0);
            text1 = text1.substring(0, 1).toUpperCase() + text1.substring(1);
            String text2 = list.get(1);
            text2 = text2.substring(0, 1).toUpperCase() + text2.substring(1);
            slot1.setText(text1);
            slot2.setText(text2);
        }
        if(list.size() == 3){
            String text1 = list.get(0);
            text1 = text1.substring(0, 1).toUpperCase() + text1.substring(1);
            String text2 = list.get(1);
            text2 = text2.substring(0, 1).toUpperCase() + text2.substring(1);
            String text3 = list.get(2);
            text3 = text3.substring(0, 1).toUpperCase() + text3.substring(1);
            slot1.setText(text1);
            slot2.setText(text2);
            slot3.setText(text3);
        }
        
    }
    
    @FXML
    public void goBack(){
        NewFXMain.set_pane(1);
        slot1.setText("Slot 1");
        slot2.setText("Slot 2");
        slot3.setText("Slot 3");
    }
    
    @FXML
    public void delete1(){
        slot1.setText("Press Back to CONFIRM");
        String user = SampleController.username;
        ArrayList<String> list = new ArrayList<String>();
        
        list = MainController.favList.get(user);
        list.remove(0);
        MainController.favList.put(user, list);
    }
    
    @FXML
    public void delete2(){
        slot2.setText("Press Back to CONFIRM");
        String user = SampleController.username;
        ArrayList<String> list = new ArrayList<String>();
        
        list = MainController.favList.get(user);
        list.remove(1);
        MainController.favList.put(user, list);
    }
    
    @FXML
    public void delete3(){
        slot3.setText("Press Back to CONFIRM");
        String user = SampleController.username;
        ArrayList<String> list = new ArrayList<String>();
        
        list = MainController.favList.get(user);
        list.remove(2);
        MainController.favList.put(user, list);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
