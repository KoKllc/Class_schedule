package Tabulation_prototype;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import Tabulation_prototype.Page.location_function.Location_select;
import Tabulation_prototype.Page.location_function.location.delete_location;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Start_controler{
    private Stage stage;
    private Scene scene;
    private Parent root;
    

    private FileWriter remove_old_data; 
    private FileWriter remove_old_data01; 
    
    private String Old_Store_m_location = null;              //Store_member_sheet的檔案位置
    private String Old_Target_for_delete_location = null;    //Target_for_delete的檔案位置
    private String Old_Schedule_data_location = null;        //Schedule_data的檔案位置
    private String Old_A_name_location = null;               //A_name的檔案位置

    private ArrayList<String> Old_D_target_list = new ArrayList<>();
    private ArrayList<String> Old_Schedule_list = new ArrayList<>();
    private ArrayList<String> Old_A_name_list = new ArrayList<>();
    

    @FXML
    public void switch_scene(MouseEvent event){
        

        try {
            if(Old_Store_m_location == null){
                Location_select Store_m_parent_location = new delete_location();                

                Old_Store_m_location = Store_m_parent_location.reset_a_Path();                                      //獲取delect_location返傳的路徑
                Old_Target_for_delete_location = Old_Store_m_location;                           //獲取delect_location返傳的路徑,即Target_for_delete.txt
                
                Old_Store_m_location = Paths.get(Old_Store_m_location).getParent().toString();                      //獲取Target_for_delete.txt的父路徑
                Old_Store_m_location = Paths.get(Old_Store_m_location + "\\Store_member_sheet.txt").toString();     //調整路徑位置          

                remove_old_data = new FileWriter(Old_Store_m_location, false);
                remove_old_data.write("");                                          //清理Store_member_sheet.txt
                remove_old_data.close();                

            }

            if (Old_Schedule_data_location == null) {                //讀取時段文字檔
                Location_select Store_m_parent_location = new delete_location();
                Old_Schedule_data_location = Store_m_parent_location.reset_a_Path();
                Old_Schedule_data_location = Paths.get(Old_Schedule_data_location).getParent().toString();
                Old_Schedule_data_location = Paths.get(Old_Schedule_data_location + "\\Schedule_data.txt").toString();

                try{
                    FileReader read_Schedule_data = new FileReader(Old_Schedule_data_location);
                    BufferedReader Schedule_line = new BufferedReader(read_Schedule_data);
                    String Schedule_line_name;

                    while ((Schedule_line_name = Schedule_line.readLine()) != null) {
                        Old_Schedule_list.add(Schedule_line_name);

                    }
                } catch(IOException e){
                    e.printStackTrace();

                }
            }

            if (Old_A_name_location == null) {                //讀取A_name文字檔
                Location_select Store_m_parent_location = new delete_location();
                Old_A_name_location = Store_m_parent_location.reset_a_Path();
                Old_A_name_location = Paths.get(Old_A_name_location).getParent().toString();
                Old_A_name_location = Paths.get(Old_A_name_location + "\\A_name_data.txt").toString();

                FileReader read_A_name_data = new FileReader(Old_A_name_location);
                BufferedReader A_name_line = new BufferedReader(read_A_name_data);
                String A_name;

                while ((A_name = A_name_line.readLine()) != null) {
                    Old_A_name_list.add(A_name);
                }

            }

            //讀取被選取刪除目標的文字檔
            try {
                FileReader read_D_target = new FileReader(Old_Target_for_delete_location);
                BufferedReader D_target_line = new BufferedReader(read_D_target);
                String D_target_name;

                while ((D_target_name = D_target_line.readLine()) != null) {
                    Old_D_target_list.add(D_target_name);

                }
            } catch(IOException e) {
                e.printStackTrace();

            }
            
            for (int i = 0; i < Old_D_target_list.size(); i++) {
                for (int j = 0; j < Old_A_name_list.size(); j++) {
                    if (Old_D_target_list.get(i).equals(Old_A_name_list.get(j))) {
                        Old_A_name_list.remove(j);
                        Old_Schedule_list.remove(j);

                        //覆寫A_name文字檔
                        try {
                            FileWriter new_A_name_data = new FileWriter(Old_A_name_location);
                            for (int k = 0; k < Old_A_name_list.size(); k++) {
                                new_A_name_data.write(Old_A_name_list.get(k));

                            }
                            new_A_name_data.close();
                            
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //覆寫Schedule文字檔
                        try {
                            FileWriter new_Schedule_data = new FileWriter(Old_Schedule_data_location);
                            for (int m = 0; m < Old_Schedule_list.size(); m++) {
                                new_Schedule_data.write(Old_Schedule_list.get(m));

                            }
                            new_Schedule_data.close();
                            
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }

            try {
                remove_old_data01 = new FileWriter(Old_Target_for_delete_location,false);
                remove_old_data01.write("");
                remove_old_data01.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
                                                
            root = FXMLLoader.load(getClass().getResource("Page/member_sheet.fxml"));            
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("視覺化輔助編輯班表");
            
            stage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }            



    }
}