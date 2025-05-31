package Tabulation_prototype.Page.controler;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Rest_labelcontroler {
    @FXML
    Pane Rest_labelname = new Pane();
    @FXML
    Label Rest_label = new Label();

    String replace_restname = new String();
    
    public void replace_the_labelname(String replace_restname){
        this.replace_restname = replace_restname;

        Rest_label.setText("休假");
        Rest_label.setId("休假");
        Rest_labelname.setId("休假");
        
        //Rest_label.setId(replace_restname);
        //Rest_labelname.setId(replace_restname);
        
    }

}
