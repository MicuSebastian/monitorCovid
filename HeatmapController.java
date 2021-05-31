/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author alladeenPC
 */
public class HeatmapController implements Initializable {

    @FXML
    private ImageView countryPhoto;
    
    @FXML
    private ImageView legenda;
    
    public void goBack(){
        NewFXMain.set_pane(1);
        legenda.setImage(null);
        countryPhoto.setImage(null);
    }
    
    @FXML
    public void showMap(){
        
        Image legend = new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/res/legenda.png");
        legenda.setImage(legend);
        
        HashMap<String, Image> hashPhotos = new HashMap<String, Image>();
        
        hashPhotos.put("romania", new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/res/romania.jpg"));
        hashPhotos.put("france", new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/res/france.jpg"));
        hashPhotos.put("spain", new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/res/spain.jpg"));
        hashPhotos.put("germany", new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/res/germany.jpg"));
        hashPhotos.put("italy", new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/res/italy.jpg"));
        hashPhotos.put("poland", new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/res/poland.png"));
        hashPhotos.put("greece", new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/res/greece.png"));
        hashPhotos.put("canada", new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/res/canada.jpg"));
        hashPhotos.put("egypt", new Image("file:e:/Facultate/MTDL(Methodes_et_techniques_de_developpement_des_logiciels)/Proiect/Test2/Proiect/res/egypt.jpg"));
        
        countryPhoto.setImage(hashPhotos.get(MainController.country));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
