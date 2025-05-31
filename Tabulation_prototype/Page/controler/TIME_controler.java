package Tabulation_prototype.Page.controler;

import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;
import Tabulation_prototype.Page.location_function.location.delete_location;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import Tabulation_prototype.Page.model.A_Member_name;
import Tabulation_prototype.Page.location_function.Location_select;

public class TIME_controler {
    @FXML
    Label time_label = new Label();
    @FXML
    Button Delete_button = new Button();
    @FXML
    HBox Time_hbox = new HBox();

    public A_Member_name a_member_name;    //建立指向A_Member_name的參考
    
    Location_select Delete_list_Location = new delete_location();   //做一個指向Location_select的參考(Delete_list_Location),建立delect_location實例
    private String a_new_path = new String();

    public static String D_target;

    private int member_size = 0;

    public void set_a_Name(A_Member_name a_member_name){
        this.a_member_name = a_member_name;

        time_label.setText(a_member_name.getname());    //設置time_label的顯示文字

        time_label.setId(a_member_name.toString());
        Delete_button.setId(a_member_name.toString());      //設置time_label的ID
        Time_hbox.setId(a_member_name.toString());
    }


    @FXML
    public void remove_function(MouseEvent event){
        this.D_target = event.getPickResult().getIntersectedNode().getParent().getId();     //獲取Node的ID
        
        //System.out.println(time_label.getId()+"<----label喔");

        a_new_path = Delete_list_Location.reset_a_Path();

        member_size = Time_hbox.getChildren().size();

        try {
            FileWriter write_data = new FileWriter(a_new_path, true);   //用true避免他被覆寫掉

            write_data.write(D_target + "\n");

            write_data.close();
            //System.out.println("successfully wrote!");

        } catch (IOException e) {  
            e.printStackTrace();
            //System.out.println("an error occurred!");

        }

        for(int i = 0; i < member_size; i++){
            Time_hbox.getChildren().remove(0);  //根據hobox中的元素數量多寡,逐個移除元素

        }
    }

}
