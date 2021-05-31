/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author alladeenPC
 */

// click dreapta Proiect -> Properties -> Run
// pentru teste: -Xms40m -Xmx512m -XX:MaxPermSize=256M
// pentru app: --add-modules javafx.controls,javafx.fxml

public class NewFXMain extends Application {
    
    static AnchorPane root;
    static List<AnchorPane> grid = new ArrayList<AnchorPane>();
    private static int idx_cur = 0;
    
    
    @Override
    public void start(Stage stage) throws FileNotFoundException, IOException {
        root = (AnchorPane)FXMLLoader.load(getClass().getResource("test.fxml"));
        
        grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml")));
        grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml")));
        grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("Register.fxml")));
        grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("AdminPage.fxml")));
        grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("Heatmap.fxml")));
        grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("ForgotPassword.fxml")));
        grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("Favourites.fxml")));
        
        root.getChildren().add(grid.get(0));
        
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/res/icon.png"));
        stage.setScene(scene);
        stage.setTitle("Covid Monitor");
        stage.show();
        
    }
    
    public static void set_pane(int idx){
        root.getChildren().remove(grid.get(idx_cur));
        root.getChildren().add(grid.get(idx));
        idx_cur = idx;
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
