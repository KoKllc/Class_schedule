package Tabulation_prototype.Page.controler;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Tabulation_prototype.Page.location_function.Location_select;
import Tabulation_prototype.Page.location_function.location.savepoint_location;
import Tabulation_prototype.Page.model.DatanameALL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class Savedata_uicontroler implements Initializable {
    @FXML
    TextField dataname_textfield = new TextField();
    @FXML
    Button sava_button = new Button();
    @FXML
    Button load_button = new Button();
    @FXML
    FlowPane data_flowpane = new FlowPane();
    @FXML
    Pane savedata_pane = new Pane();

    Location_select savedata_location = new savepoint_location();
    Location_select savedata_location01 = new savepoint_location();


    private Path Savedata_location = null;
    private Path Buffferdata_location = null;
    private Path Data_namelist_location = null;
    private Path Select_dataname_location = null;


    private ArrayList<String> Gpane_context_list = new ArrayList<>();

    private ArrayList<String> Data_labelname = new ArrayList<>();

    private ArrayList<String> Selected_dataname = new ArrayList<>();

    public String select_dataname = new String();
    private String adjust_select_dataname = new String();

    
    @Override
    public void initialize(URL agr0, ResourceBundle agr1) {    
        if (Savedata_location == null) {
            Savedata_location = Paths.get(savedata_location01.reset_a_Path());

        }
        try {
            Files.walkFileTree(Savedata_location, new DatanameALL());       //尋找檔名

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (Data_namelist_location == null) {
            Data_namelist_location = Paths.get(Savedata_location.getParent().toString() + "\\Data_save\\Data_namelist.txt");

        }

        try {               //讀取Data_namelist的資料並存入arraylist中
            FileReader read_dataname = new FileReader(Data_namelist_location.toString());
            BufferedReader read_dataname_list = new BufferedReader(read_dataname);
            String A_dataname;

            while ((A_dataname = read_dataname_list.readLine()) != null) {
                Data_labelname.add(A_dataname); 

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (Select_dataname_location == null) {
            Select_dataname_location = Paths.get(Savedata_location.getParent().toString() + "\\Data_save\\Selected_dataname.txt");
        }

        


        for (int j = 0; j < Data_labelname.size(); j++) {
            try {
                FXMLLoader visible_datafile = new FXMLLoader();
                visible_datafile.setLocation(getClass().getResource("data_showgraphic.fxml"));
                Pane data_pane = visible_datafile.load();
                data_showgraphic_controler name_visible_controler = visible_datafile.getController();
    
                
                name_visible_controler.set_visible_name(Data_labelname.get(j));      //令文件名隨著讀進的資料更改
                //System.out.println(Data_labelname.get(j));
    
                data_flowpane.getChildren().add(data_pane);
    
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }

    }

    
    public void save_dataname(){                                //儲存檔案
        if (Buffferdata_location == null) {                     //獲得Buffer_data.txt的位置
            Buffferdata_location = Paths.get(savedata_location.reset_a_Path()).getParent();
            Buffferdata_location = Paths.get(Buffferdata_location + "\\Data_save\\Buffer_data.txt");
            
        }

        if (dataname_textfield.getText().isEmpty() == true) {
            System.out.println("plz input somthing");

        }
        else{               //新增一個檔案到Save_point裡並為它命一個你取的名字
            Savedata_location = Paths.get(Savedata_location.toString() + "\\" + dataname_textfield.getText().toString() + ".txt");

        }

        try {
            FileReader reading_bufferdata = new FileReader(Buffferdata_location.toString());    //讀取Buffer_data.txt
            BufferedReader line = new BufferedReader(reading_bufferdata);
            String Gpane_context;

            while ((Gpane_context = line.readLine()) != null) {
                Gpane_context_list.add(Gpane_context);

            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            FileWriter writing_Gpanecontext = new FileWriter(Savedata_location.toString());    //寫入新的檔案到Save_point裡面            
            writing_Gpanecontext.write(Gpane_context_list.get(0));
            writing_Gpanecontext.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       
    }

    public void load_dataname(){
        if (dataname_textfield.getText().toString().isEmpty() == false) {
            for (int i = 0; i < Data_labelname.size(); i++) {
                //System.out.println(Data_labelname.get(0));
    
                if (Data_labelname.get(i).equals(dataname_textfield.getText().toString())) {    //如果textfield的字串與所讀取的其中一個檔名相同的話
                    //System.out.println(Data_labelname.get(i));
                    select_dataname = Data_labelname.get(i);

                    System.out.println(select_dataname+"<<<<<<<");    
                }
            }
        }
        
    }
   
    public void set_textField(){
        try {
            FileReader reader_selected_dataname = new FileReader(Select_dataname_location.toString());
            BufferedReader reader_selected_dataname_list = new BufferedReader(reader_selected_dataname);
            String A_selected_dataname;

            while ((A_selected_dataname = reader_selected_dataname_list.readLine()) != null) {
                Selected_dataname.clear();                                  //把arraylist的資料清空
                Selected_dataname.add(A_selected_dataname);                 //添加從文字檔讀取到的資料
                
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        adjust_select_dataname = Selected_dataname.get(0).toString().replace(".txt","");
        dataname_textfield.setText(adjust_select_dataname);       //獲取第一個資料,作為textfield顯示的text
        
        //System.out.println(Selected_dataname.size());
    }
    
}
