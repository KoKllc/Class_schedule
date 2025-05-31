package Tabulation_prototype.Page.controler;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.AccessFlag.Location;
import java.nio.file.Path;
import java.nio.file.Paths;

import Tabulation_prototype.Page.location_function.Location_select;
import Tabulation_prototype.Page.location_function.location.delete_location;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class data_showgraphic_controler {
    @FXML
    Label data_label = new Label();
    @FXML
    Pane data_pane = new Pane();
    @FXML
    ImageView data_image = new ImageView();


    private Location_select delete_location = new delete_location();
    private Path select_dataname_location = null;

    public void set_visible_name(String data_name){
        data_label.setText(data_name);
        data_label.setId(data_name);
        data_pane.setId(data_name);
    }

    public void select_target(){
        if (select_dataname_location == null) {
            select_dataname_location = Paths.get(delete_location.reset_a_Path()).getParent();
            select_dataname_location = Paths.get(select_dataname_location.toString() + "\\Selected_dataname.txt");
        }

        try {
            FileWriter writing_dataname = new FileWriter(select_dataname_location.toString(),false);    //把選擇的資料寫入Selected_dataname
            writing_dataname.write(data_label.getText().toString());
            writing_dataname.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
