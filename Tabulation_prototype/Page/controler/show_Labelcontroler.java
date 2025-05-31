package Tabulation_prototype.Page.controler;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Tabulation_prototype.Page.location_function.Location_select;
import Tabulation_prototype.Page.location_function.location.delete_location;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class show_Labelcontroler {
    @FXML
    Pane pane_of_Label = new Pane();
    @FXML
    Label time_in_Gpane = new Label();

    public String inside_Name = new String();
    private String arrange_words = new String();
    private String[] arranging_words;
    public ArrayList<String> arranged_words = new ArrayList<String>();

    
    private Location_select select_location = new delete_location();
    private Path Adjust_location = null;

    public void set_a_Name(String inside_Name){
        this.inside_Name = inside_Name;
        arrange_words = inside_Name.replace("|", ",");
        arranging_words = arrange_words.split(",");
        for (String word : arranging_words) {
            arranged_words.add(word);

        }
        time_in_Gpane.setText(arranged_words.get(0).toString());
        time_in_Gpane.setId(inside_Name + "_NEW_");
        
        pane_of_Label.setId(inside_Name);

    }

    @FXML
    public void releace_getname(){        
        if (Adjust_location == null) {
            Adjust_location = Paths.get(select_location.reset_a_Path()).getParent();
            Adjust_location = Paths.get(Adjust_location + "\\Target_in_Gpane_for_delete.txt");
        }

        try {
            FileWriter Delete_write = new FileWriter(Adjust_location.toString());

            Delete_write.write(time_in_Gpane.getId());
            Delete_write.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
