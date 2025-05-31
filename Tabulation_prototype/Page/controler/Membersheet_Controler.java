package Tabulation_prototype.Page.controler;

import javafx.scene.input.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import Tabulation_prototype.Page.location_function.location.delete_location;
import Tabulation_prototype.Page.location_function.location.membersheet_location;
import Tabulation_prototype.Page.location_function.location.savepoint_location;
import Tabulation_prototype.Page.location_function.location.store_location;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Tabulation_prototype.Page.model.A_Member_name;
import Tabulation_prototype.Page.model.Display_storename;
import Tabulation_prototype.Page.model.Store_each_Members;
import Tabulation_prototype.Page.location_function.Location_select;
import Tabulation_prototype.Page.model.ListALL;




public class Membersheet_Controler implements Initializable{
    @FXML
    Pane pane_original = new Pane();             //大平面

    @FXML
    Button Button_FOR_Delete = new Button();    //休息替換鈕
    private int click_number = 0;

    private double D_button_asix_X;
    private double D_button_asix_Y;
    private String D_target_for_button;
    private String D_Button_targetlocation = null;
    private Path adjust_D_button_location = null;
    private String D_button_data_line;
    FileReader Read_file;

    @FXML
    GridPane gridpane_main = new GridPane();    //時間成員日期表

    private String put_the_name;                      //更換Label的text用

    @FXML
    GridPane gridpane_list = new GridPane();        //時段列表
    @FXML
    TextField text_input_item = new TextField();    //輸入欄
    @FXML
    Button Add_button = new Button();               //增加新的時段鈕
    
    public String inputname;                               //輸入時段名稱

    private List<String> Add_namelist = new ArrayList<String>();  //切換用的,暫存字串表

    private List<A_Member_name> A_name = new ArrayList<>();     //儲存時段的列表
    public int one_number = 1;

    private List<String> Delete_target_list = new ArrayList<>();    //移除的名單

    public Location_select Delete_list_Location = new delete_location();   //做一個指向Location_select的參考(Delete_list_Location),建立delect_location實例
    public Location_select Delete_list_Location01 = new delete_location();

    private String a_new_path = null;
    private String a_new_path01 = null;

    private String scheduledata_path = null;
    private Path scheduledatatxt_path;

    private String A_name_path = null;

    @FXML
    public TabPane menu_tablepane = new TabPane();

    @FXML
    ChoiceBox<String> My_choicebox = new ChoiceBox<>();   //門市選擇列表
    private ArrayList<String> Store = new ArrayList<>();          //門市
    private String a_new_path_store = null;     //Store存資料的txt位置
    Location_select store_list_Location = new store_location();
    @FXML
    public TableColumn TBcolumn_ = new TableColumn<>();     //成員列表
    @FXML
    public TableView TBview_ = new TableView<>();

    private String a_new_path_member = null;
    public Location_select member_list_location = new membersheet_location();
    public ArrayList<String> ALL_Store_members_dataName = new ArrayList<String>();

    public Path membertxt_path_original;
    public Path edit_membertxt_path_original;
    public ArrayList<Store_each_Members> ALL_Store_members = new ArrayList<Store_each_Members>();

    public int M_index;
    @FXML
    Label on_Gpane_label = new Label();     //Gridpane上的成員label
    @FXML
    Label Member_name_label = new Label();
    @FXML
    Label Member_rest_label = new Label();
    public ArrayList<String> M_elements = new ArrayList<String>();      //成員label的arraylist
    public String Selected_member;
    private int switch_ = 0;
    private int member_size = 0;
    private int Serial_number = 0;

    //-------------------------
    @FXML
    Label NEW_Label = new Label();
    public String Put_target;    
    public String Move_target = new String();
    public String arraged_Move_target = new String();
    public Arrage_the_String arrage_the_string = new Arrage_the_String();   //做一個指向Arrage_the_String的參考(arrage_the_string),建立Arrage_the_String實例

    public String get_target = new String();
    public String arraged_Get_target = new String();
    public Arrage_the_String arrage_get_string = new Arrage_the_String();

    //-------------------------
    private String IN_list_labelname = new String();
    //-------------------------
    @FXML
    TextField Input_day_Field = new TextField();
    @FXML
    Button Add_startday_button = new Button();
    @FXML
    TextArea prompt_text = new TextArea();
    @FXML
    CheckBox mycheckbox = new CheckBox();
    @FXML
    Label Day01 = new Label();
    @FXML
    Label Day02 = new Label();
    @FXML
    Label Day03 = new Label();
    @FXML
    Label Day04 = new Label();
    @FXML
    Label Day05 = new Label();
    @FXML
    Label Day06 = new Label();
    @FXML
    Label Day07 = new Label();
    private String Inputday_text = new String();
    private String[] Adjust_inputday;
    private ArrayList<String> the_day_list = new ArrayList<String>();
    private ArrayList<String> Days_collect = new ArrayList<String>();
    private String[] another_day = {"(一)","(二)","(三)","(四)","(五)","(六)","(日)"};
    private int[] total_day = {28,29,30,31};
    private int[] long_moth = {1,3,5,7,8,10,12};
    private int[] short_month = {2,4,6,9,11};
    private int month_total_day;
    private int month;
    private int date;
    //-------------------------
    @FXML
    ChoiceBox<String> Choice_a_store = new ChoiceBox<String>();   //店號選擇
    @FXML
    TableColumn TBcolumn_store_ = new TableColumn<>();      //店名
    @FXML
    TableColumn TBcolumn_number_ = new TableColumn<>();     //店號
    @FXML
    TableView TBview_store_ = new TableView<>();
    @FXML
    Label Store_NUM = new Label();      //店號顯示
    @FXML
    Label Store_NAM = new Label();      //店名顯示
    private ArrayList<String> ALL_Store_number = new ArrayList<String>();
    private ArrayList<Display_storename> ALL_Store_names = new ArrayList<Display_storename>();
    private Path adjust_storenumber_location = null;
    private String Storenumber_location = null;
    
    //-------------------------
    @FXML
    Menu Save_data = new Menu();    //存檔
    @FXML
    Label Member_load_label = new Label();      //載入用的Label
    public Location_select Save_point_location = new savepoint_location();          //班表存檔資料夾位置
    private Path Bufferdata_location = null;        //暫存班表的地方
    private Path Datanamelist_location = null;      //存檔名的地方
    private Path Select_dataname_location = null;
    private Path Datasave_location = null;

    Savedata_uicontroler close_data_window = new Savedata_uicontroler();
    public Parent savepoint_root;
    public Scene scene;
    public Stage stage;
    public Image icon;
    public ArrayList<String> dataname_list = new ArrayList<String>();
    private String adjust_gridpane_main;
    private String[] arranging_gridpane_main;
    private ArrayList<String> arranged_gridpane_main = new ArrayList<>();
    private ArrayList<String> available_gridpane_main = new ArrayList<>();
    private String adjust_available_gridpane_main;
    private String[] select_context;
    private ArrayList<String> elements_list = new ArrayList<>();
    
    //-------------------------
    @FXML
    FlowPane Time_rectangle_sheet = new FlowPane();
    @FXML
    Button Renew_button = new Button();

    //-------------------------


    private List<A_Member_name> Get_Data(){                
        List<A_Member_name> A_name = new ArrayList<>();
        A_Member_name a_member_name;

        for(int j = 0; j < one_number; j++){
            a_member_name = new A_Member_name();
            a_member_name.setname(inputname);
            A_name.add(a_member_name);

        }
        return A_name;                                      //返傳列表
    }
    
    

    @FXML
    void add_startday(){                    //按按鈕增加日期
        Inputday_text = Input_day_Field.getText().toString();
        prompt_text.setWrapText(true);

        if (Input_day_Field.getText().isEmpty() == true) {
            prompt_text.setText("提示:請輸入日期(月/日)!");            

        }else{
            if (Inputday_text.contains("/") == true && Inputday_text.length() <= 5) {       //字串總長度不超過5且含有 /
                Adjust_inputday = Inputday_text.split("/");
                for(String day:Adjust_inputday){
                    the_day_list.add(day);

                }

                try {                                                       //字串轉換為整數
                    month = Integer.parseInt(the_day_list.get(0));
                    date = Integer.parseInt(the_day_list.get(1));

                    if (month <= 12 && date <= 31) {                                      //12個月份
                        for (int i = 0; i < 7; i++) {
                            if (long_moth[i] == month) {
                                month_total_day = total_day[3];         //這個月有31天

                                //System.out.println(month+","+date);
                                //System.out.println(month_total_day);
                            }
                            else if (i < 5) {
                                if (2 == month && mycheckbox.isSelected() != true) {
                                    month_total_day = total_day[0];     //2月有28天

                                }
                                else if (2 == month && mycheckbox.isSelected() == true) {
                                    month_total_day = total_day[1];     //2月有29天

                                }
                                else if (short_month[i] == month) {
                                    month_total_day = total_day[2];     //這個月有30天

                                    //System.out.println(month+","+date);
                                    //System.out.println(month_total_day);
                                }
                                
                            }
                        }        
                        Days_collect.clear();   

                    for (int j = 1; j < 8; j++) {           //加7天                                                                                         
                        Days_collect.add(month + "/" + date + another_day[j-1]);                                                                                    

                        if (date >= month_total_day) {      //超過最大天數則減去最大天數,從1繼續算起
                            date = date - month_total_day;
                            month += 1;                     //加一個月

                            if (month >= 12) {
                                month = month - 12;         //超過則從1月繼續算起
                                month += 1;

                            }
                        }
                        date += 1;
                        }
                        Day01.setText(Days_collect.get(0));
                        Day02.setText(Days_collect.get(1));
                        Day03.setText(Days_collect.get(2));
                        Day04.setText(Days_collect.get(3));
                        Day05.setText(Days_collect.get(4));
                        Day06.setText(Days_collect.get(5));
                        Day07.setText(Days_collect.get(6));
                        
                    }                                    
                } catch (NumberFormatException e) {
                    prompt_text.setText("提示:請輸入整數，而非其它文字!");

                }                            
                
            }else{
                prompt_text.setText("提示:請在數字間加入 /");
            }
                                    
            the_day_list.clear();
        }

    }
    @FXML
    public void add_startday_keyversion(KeyEvent event){                //按Enter增加日期
        if (event.getCode() == event.getCode().ENTER) {
            Inputday_text = Input_day_Field.getText().toString();
            prompt_text.setWrapText(true);

            if (Input_day_Field.getText().isEmpty() == true) {                        
                prompt_text.setText("提示:請輸入日期(月/日)!");            

            }else{
                if (Inputday_text.contains("/") == true && Inputday_text.length() <= 5) {       //字串總長度不超過5且含有 /
                    Adjust_inputday = Inputday_text.split("/");
                    for(String day:Adjust_inputday){
                        the_day_list.add(day);

                    }

                    try {                                                       //字串轉換為整數
                        month = Integer.parseInt(the_day_list.get(0));
                        date = Integer.parseInt(the_day_list.get(1));

                        if (month <= 12 && date <= 31) {                                      //12個月份
                            for (int i = 0; i < 7; i++) {
                                if (long_moth[i] == month) {
                                    month_total_day = total_day[3];         //這個月有31天

                                    //System.out.println(month+","+date);
                                    //System.out.println(month_total_day);
                                }
                                else if (i < 5) {
                                    if (2 == month && mycheckbox.isSelected() != true) {
                                        month_total_day = total_day[0];     //2月有28天

                                    }
                                    else if (2 == month && mycheckbox.isSelected() == true) {
                                        month_total_day = total_day[1];     //2月有29天

                                    }
                                    else if (short_month[i] == month) {
                                        month_total_day = total_day[2];     //這個月有30天

                                        //System.out.println(month+","+date);
                                        //System.out.println(month_total_day);
                                    }
                                    
                                }
                            }        
                            Days_collect.clear();   

                        for (int j = 1; j < 8; j++) {           //加7天                                                                                         
                            Days_collect.add(month + "/" + date + another_day[j-1]);                                                                                    

                            if (date >= month_total_day) {      //超過最大天數則減去最大天數,從1繼續算起
                                date = date - month_total_day;
                                month += 1;                     //加一個月

                                if (month >= 12) {
                                    month = month - 12;         //超過則從1月繼續算起
                                    month += 1;

                                }
                            }
                            date += 1;
                            }
                            Day01.setText(Days_collect.get(0));
                            Day02.setText(Days_collect.get(1));
                            Day03.setText(Days_collect.get(2));
                            Day04.setText(Days_collect.get(3));
                            Day05.setText(Days_collect.get(4));
                            Day06.setText(Days_collect.get(5));
                            Day07.setText(Days_collect.get(6));
                            
                        }                                    
                    } catch (NumberFormatException e) {
                        prompt_text.setText("提示:請輸入整數，而非其它文字!");

                    }                            
                    
                }else{
                    prompt_text.setText("提示:請在數字間加入 /");
                }
                                        
                the_day_list.clear();
            }
        }
    }

    @FXML
    void Add_your_time(KeyEvent event){
        if (event.getCode() == event.getCode().ENTER) {
            inputname = text_input_item.getText().toString();

            if(a_new_path == null){
                a_new_path = Delete_list_Location01.reset_a_Path();      //調整路徑
                //System.out.println(a_new_path+"<---path");
            }
            //System.out.println(a_new_path);
            if (A_name_path == null) {
                A_name_path = Paths.get(a_new_path).getParent().toString();
                A_name_path = Paths.get(A_name_path + "\\A_name_data.txt").toString();

            }

            try {
                FileReader fileReader = new FileReader(a_new_path);             //讀取文字檔的路徑
                BufferedReader line = new BufferedReader(fileReader);
                String online_username;

                while((online_username = line.readLine()) != null){             //如果讀取到的不是空的話
                    Delete_target_list.add(online_username);                    //則把讀到的資料存進 Delete_target_list
                    
                }
                //System.out.println(Delete_target_list+"<----Delete_target_list!");

                for(int p = 0; p < Delete_target_list.size(); p++){
                    String D_user_name = Delete_target_list.get(p).toString();  //遍歷Delete_target_list

                    for(int q = 0; q < A_name.size(); q++){
                        String User_name = A_name.get(q).toString();            //遍歷A_name
                    
                        if(D_user_name.equals(User_name)){
                            A_name.remove(q);                                   //移除A_name的第q個
                            Add_namelist.remove(q);                             //移除Add_namelist的第q個
                            
                            try{                                                
                                FileWriter clear_write = new FileWriter(a_new_path, false);       //要跟FileReader分開寫,不然會蓋掉FileReader
                                clear_write.write("");                      //清掉文字檔
                                clear_write.close();

                                //System.out.println(A_name.size()+"<---size喔");
                            }catch(IOException e){
                                e.printStackTrace();
                            }
                            


                            System.out.println("刪除成功");

                        }            
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

            if(text_input_item.getText().isEmpty() != false){
                System.out.println("plz input text");

            }
            else{
                text_input_item.clear();
                gridpane_list.getChildren().clear();

                Get_Data();
                A_name.addAll(Get_Data());
                Add_namelist.add(inputname);
                //System.out.println(A_name.size());
                try{
                    for(int i = 0; i < A_name.size(); i++){
                        FXMLLoader fxmlLoader_time = new FXMLLoader();
                        fxmlLoader_time.setLocation(getClass().getResource("TIME.fxml"));    //載入時間的pane
                        HBox Time_hbox = fxmlLoader_time.load();

                        TIME_controler TIME_label_controler = fxmlLoader_time.getController();    //建立指向TIME_controler的參考,並賦值fxmlLoader_time.getControler
                        TIME_label_controler.set_a_Name(A_name.get(i));                           //引用TIME.fxml的方法                        

                        gridpane_list.add(Time_hbox, 0, i);

                    }
                    
                } catch(IOException e){
                    e.printStackTrace();

                }

                
                //把輸入的資料存進文字檔Schedule_data.txt----------
                try {
                    FileWriter write_scheduledata_txt = new FileWriter(scheduledata_path, false);
                    for (int index = 0; index < Add_namelist.size(); index++) {
                        write_scheduledata_txt.write(Add_namelist.get(index) + "\r\n");           //換行存入                        

                    }
                    write_scheduledata_txt.close();
                    
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                
                //A_name
                try {
                    FileWriter write_A_name = new FileWriter(A_name_path, false);
                    for (int i = 0; i < A_name.size(); i++) {
                        write_A_name.write(A_name.get(i) + "\r\n");
                    
                    }
                    write_A_name.close();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                //------------------------------

            } 
        }

    }

    @FXML
    public void Get_Label_inGpane(MouseEvent event){                  //替換gridpain_main上的Label
        Move_target = event.getPickResult().getIntersectedNode().getParent().getId().toString();
        arraged_Move_target = arrage_the_string.arrange_name(Move_target, ".", "]", 3);        

        for (int i = 0; i < gridpane_list.getChildren().size(); i++) {
            get_target = gridpane_list.getChildren().get(i).toString();
            arraged_Get_target = arrage_get_string.arrange_name(get_target, ".", "]", 3);

            if (arraged_Move_target.equals(arraged_Get_target)) {
                //System.out.println(i+"<<---i==");                
                IN_list_labelname = A_name.get(i).getname();
            }            
        }        

        for (int i = 0; i < Add_namelist.size(); i++) {         //建立一個label乘載gridpane_list上的名字            
            if (IN_list_labelname == Add_namelist.get(i)) {
                NEW_Label.setText(IN_list_labelname.toString());
                NEW_Label.setId(IN_list_labelname.toString());                            

                if (1 < Add_namelist.size()) {
                    pane_original.getChildren().remove(NEW_Label);

                }
                pane_original.getChildren().add(NEW_Label);     //把NEW_Label放置在pane_original
                NEW_Label.setVisible(false);                    //隱藏Label不顯示在Pane上
                //System.out.println(NEW_Label.getText());
                
            }
        }
    }

    @FXML
    public void Move_Label_to_Gpane(MouseEvent event){                  //放東西到gridpane_main
        Put_target = event.getPickResult().getIntersectedNode().getParent().getId();
        //System.out.println(Put_target+"<<<---put_target");

        pane_original.setOnMouseReleased(event01 -> {
            put_the_name =  event01.getPickResult().getIntersectedNode().getParent().getId().toString();
            System.out.println(put_the_name+"<<<---put_the_name");

            for (int i = 0; i < gridpane_main.getChildren().size(); i++) {
                Node get_Label_from_Gpane = gridpane_main.getChildren().get(i);
                //System.out.println(get_Label_from_Gpane.getId()+ "<<---get_label_from_gpane");                
                
                if (get_Label_from_Gpane.getId() == put_the_name) {
                    //System.out.println("<<---ok");

                    try {                        
                        if (NEW_Label.getText() != "") {                     //當NEW_Label的text有東西時才能使用
                            FXMLLoader Label_fxml = new FXMLLoader();
                            Label_fxml.setLocation(getClass().getResource("Label_.fxml"));
                            Pane pane_of_Label = Label_fxml.load();
                            show_Labelcontroler show_the_Label_in_Gpane = Label_fxml.getController();

                            click_number += 1;
                            show_the_Label_in_Gpane.set_a_Name(NEW_Label.getText() + "|" + Integer.toString(click_number));

                            //System.out.println(gridpane_main.getColumnIndex(get_Label_from_Gpane)+","+gridpane_main.getRowIndex(get_Label_from_Gpane));

                            //成員不可被時段替換掉-------------------------
                            if (gridpane_main.getColumnIndex(get_Label_from_Gpane) != 0 && gridpane_main.getRowIndex(get_Label_from_Gpane) != 0) {
                                gridpane_main.getChildren().set(i, pane_of_Label);
                                gridpane_main.setColumnIndex(pane_of_Label, gridpane_main.getColumnIndex(get_Label_from_Gpane));
                                gridpane_main.setRowIndex(pane_of_Label, gridpane_main.getRowIndex(get_Label_from_Gpane));
            
                            }
                            

                        }                        
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }          
            }

        });

    }

    @FXML
    public void delect_remove_Button(MouseEvent event){
        D_target_for_button = event.getPickResult().getIntersectedNode().getParent().getId().toString();
        
        D_button_asix_X = event.getScreenX();
        D_button_asix_Y = event.getScreenY();    
        
        if (adjust_D_button_location == null) {
            adjust_D_button_location = Paths.get(a_new_path01).getParent();      //建立D_Button_targetlocation的路徑
            D_Button_targetlocation = Paths.get(adjust_D_button_location + "\\Target_in_Gpane_for_delete.txt").toString();
            
        }
        try {
            Read_file = new FileReader(D_Button_targetlocation);     //讀取被紀錄文字檔的目標
            BufferedReader D_Button_target_data = new BufferedReader(Read_file);
            D_button_data_line = D_Button_target_data.readLine();            

            if (D_target_for_button.equals(D_button_data_line)) {               //切換成不同目標時移除舊的button
                if (Add_namelist.size() > 0) {
                    pane_original.getChildren().remove(Button_FOR_Delete);

                }                
                Button_FOR_Delete.setText("刪除");
                Button_FOR_Delete.relocate(D_button_asix_X, D_button_asix_Y);   //以滑鼠點擊位置建立button生成位置                                     
                pane_original.getChildren().add(Button_FOR_Delete);
                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button_FOR_Delete.setOnMouseClicked(event1 -> {
            for (int i = 0; i < gridpane_main.getChildren().size(); i++) {
                String D_Button_targetname = gridpane_main.getChildren().get(i).getId() + "_NEW_";
                Node D_Button_targetnode = gridpane_main.getChildren().get(i);           //從gridpane_main上抓取要替換的目標                

                if (D_Button_targetname.equals(D_button_data_line)) {
                    System.out.println(D_button_data_line + "<<<--D_button_data_line");
                    
                    try {                                                         //替換成休假
                        FXMLLoader Rest_fxmlloader = new FXMLLoader();
                        Rest_fxmlloader.setLocation(getClass().getResource("Rest_label.fxml"));
                        Pane Rest_labelname = Rest_fxmlloader.load();
                        
                        Rest_labelcontroler rest_labelcontroler = Rest_fxmlloader.getController();

                        click_number += 1;
                        rest_labelcontroler.replace_the_labelname(D_button_data_line + Integer.toString(click_number));

                        pane_original.getChildren().remove(Button_FOR_Delete);

                        gridpane_main.getChildren().set(i, Rest_labelname);     //把Rest_labelname加到gridpane_main的childen裡
                        gridpane_main.setColumnIndex(Rest_labelname, gridpane_main.getColumnIndex(D_Button_targetnode));
                        gridpane_main.setRowIndex(Rest_labelname, gridpane_main.getRowIndex(D_Button_targetnode));

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }            
        });
    }


    @FXML
    public void Add_member_on_Gpane(MouseEvent event){
        M_index = TBview_.getSelectionModel().getSelectedIndex();       //所點擊資料為第幾項
        Selected_member = TBcolumn_.getCellData(M_index).toString();    //從tablecolum上獲取點擊的資料        

        if (TBview_.getSelectionModel().isSelected(M_index)) {      //移除先前的選擇
            M_elements.add(Selected_member);
            TBview_.getSelectionModel().clearSelection();           //清除已選擇的選項->一點就清除剛剛所選的項目
            switch_ = 0;
            member_size = M_elements.size();

            if (M_elements.isEmpty() == false) {        //如果M_element有東西的話
                if (M_elements.size() > 1) {                    
                    for (int i = 1; i < M_elements.size(); i++) {                      
                        if (M_elements.get(i - 1).equals(Selected_member)) {
                            String delete_name_Gpane = gridpane_main.getChildren().get(8 * i).toString();     //移除gridpane上選擇的成員                                                    

                            //System.out.println("\\---刪除開始---\\");
                            //System.out.println(M_elements.get(i-1)+"<==移除先前M_element的元素");                            
                            M_elements.remove(i - 1);

                            //System.out.println(M_elements.get(member_size-2)+"<==移除後來點的M_element的元素");
                            M_elements.remove(member_size - 2);          
                        
                            for (int j = 0; j < gridpane_main.getChildren().size(); j++) {
                                if (delete_name_Gpane.equals(gridpane_main.getChildren().get(j).toString())) {                                    
                                    //System.out.println(gridpane_main.getChildren().get(j)+"<===getchildren清理目標元素");

                                    for (int k = 1; k < 8; k++) {                       //移除休假
                                        gridpane_main.getChildren().remove(j + 1);      //移除排在成員欄位後的第一個欄位重複刪7次(刪除時它會自動後往前補)                                        
                                    }

                                    gridpane_main.getChildren().remove(j);              //移除成員
                                }                                
                            }                     

                            
                            for (int L = 1; L < gridpane_main.getRowCount() - 1; L++) {             //重置gridpane_main上成員的舊位置
                                Node reset_old_order = gridpane_main.getChildren().get(8 * L);      //獲取成員

                                //System.out.println(gridpane_main.getRowCount()+"<--ROWCOUNT");
                                //System.out.println(gridpane_main.getChildren().get(8 * L)+"<--8*L");
                                //System.out.println(L+"<--L");
                                
                                for (int j = 1; j < 8; j++) {
                                    Node old_serial_number = gridpane_main.getChildren().get(8 * L + j);    //抓出成員的後7個休息
                                    gridpane_main.setRowIndex(old_serial_number, L);
                                }
                                gridpane_main.setRowIndex(reset_old_order, L);                //重新設置位置(從1開始--->1,2,3,4...)                                                           

                            }                                                                                                              
                            switch_ = 1;
                            
                            /*System.out.println("\\---刪除後剩下---\\");
                            for (int u = 0; u < M_elements.size(); u++) {
                                System.out.println(u+"<===u");
                                System.out.println(M_elements.get(u)+"<==get(u)");
                            }
                            System.out.println("________________");*/
                        }
                    }                    
                }
                if (switch_ == 0) {
                    Born_a_newlabel();

                }                
                switch_ = 0;               
                
            }

        }

        /*for (int i = 8; i < gridpane_main.getChildren().size(); i++) {
            Node G_label = gridpane_main.getChildren().get(i);
            //System.out.println("\\---目前位置---\\");                       
            //System.out.println("成員==>"+gridpane_main.getChildren().get(i).toString()+"__ROW位置__"+gridpane_main.getRowIndex(G_label).toString());

        }*/
    }
    public void Born_a_newlabel(){
        for (int j = 0; j < M_elements.size(); j++) {
            if (M_elements.size() - 1 == j) {                
                Member_name_label = new Label(M_elements.get(j));
                Member_name_label.setId(M_elements.get(j));
                Member_name_label.setFont(new Font(20));
                Member_name_label.setPadding(new Insets(11.25));
                gridpane_main.add(Member_name_label, 0, j + 1);

                /*System.out.println("\\---新增---\\");
                System.out.println(gridpane_main.getChildren().size()+"<===size");
                System.out.println((j+1)+"<===位置=="+Member_name_label.getId()+"<===id");
                System.out.println(gridpane_main.getRowIndex(Member_name_label)+"<===gridpane位置==");*/       
                
                for (int i = 1; i < 8; i++) {
                    Serial_number += 1;
                    Member_rest_label = new Label("休假");
                    Member_rest_label.setId("_REST_" + Serial_number);
                    Member_rest_label.setFont(new Font(20));            //字體大小
                    Member_rest_label.setPadding(new Insets(11.25));    //縫隙大小,距離框多遠
                    gridpane_main.add(Member_rest_label, i, j + 1);
                    
                }
                
            }
        }
    }

    @FXML
    void renew(MouseEvent event){       //更新長條圖
        Show_rectangle();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle agr1){
        RowConstraints a = new RowConstraints(50);              //設置星期一到五框框的固定大小50
        a.setVgrow(Priority.ALWAYS);                            //優先級
        gridpane_main.getRowConstraints().set(0, a);      //設置在第0列的位置

        if(a_new_path01 == null){
            a_new_path01 = Delete_list_Location.reset_a_Path();      //調整路徑
            //System.out.println(a_new_path+"<---path");
        }

        if(a_new_path_store == null){
            a_new_path_store = store_list_Location.reset_a_Path();      //調整路徑
            
            try {
                FileReader fileReader_store = new FileReader(a_new_path_store);
                BufferedReader line_store = new BufferedReader(fileReader_store);
                String name_store;
    
                while((name_store = line_store.readLine()) != null){      //讀取門市並加入到list中
                    Store.add(name_store);
    
                }
            } catch (IOException e) {
                e.printStackTrace();
    
            }
        }        

        //獲取Member_A,B,C的檔名,寫入文字檔----------
        if(a_new_path_member == null){
            a_new_path_member = member_list_location.reset_a_Path();       //獲取ALL_member的Member_A路徑
            Path membertxt_path = Paths.get(a_new_path_member);                 //String轉成Path型別
            membertxt_path_original = membertxt_path.getParent();          //獲取ALL_member資料夾的路徑
            
            try {
                Files.walkFileTree(membertxt_path_original, new ListALL());     //將資料導入walkFileTree中(路徑,實例化物件)

            } catch (IOException e) {
                e.printStackTrace();
            }                        
        }

        if (ALL_Store_members_dataName.isEmpty() == true) {
            edit_membertxt_path_original = membertxt_path_original.getParent();
            edit_membertxt_path_original = Paths.get(edit_membertxt_path_original + "\\Store_member_sheet.txt");    //改寫成Store_member_sheet的路徑
            
            try {
                FileReader read_eachPath = new FileReader(edit_membertxt_path_original.toString());
                BufferedReader store_context = new BufferedReader(read_eachPath);
                String dataName_store;

                while ((dataName_store = store_context.readLine()) != null) {
                    ALL_Store_members_dataName.add(dataName_store);     //儲存路徑到arraylist裡面

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //------------------------------
        if ( scheduledata_path == null) {            
            scheduledatatxt_path = Paths.get(a_new_path_store).getParent();
            scheduledata_path = Paths.get(scheduledatatxt_path + "\\Schedule_data.txt").toString();

            try {
                FileReader  read_scheduledata_txt = new FileReader(scheduledata_path);
                BufferedReader scheduledata_context = new BufferedReader(read_scheduledata_txt);
                String the_scheduledata_context;

                while ((the_scheduledata_context = scheduledata_context.readLine()) != null) {                                        
                    if (the_scheduledata_context != null) {
                        inputname = the_scheduledata_context;
                        Get_Data();
                        A_name.addAll(Get_Data());
                        Add_namelist.add(inputname);

                    }                                                                                   
                }
                gridpane_list.getChildren().remove(0);      //移除第0個元素(gridpane_list自帶的Group@79370d7c),避免順序亂掉
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }            

            try{
                for(int i = 0; i < A_name.size(); i++){
                    FXMLLoader fxmlLoader_time001 = new FXMLLoader();
                    fxmlLoader_time001.setLocation(getClass().getResource("TIME.fxml"));    //載入時間的pane
                    HBox Time_hbox = fxmlLoader_time001.load();

                    TIME_controler TIME_label_controler = fxmlLoader_time001.getController();    //建立指向TIME_controler的參考,並賦值fxmlLoader_time.getControler
                    TIME_label_controler.set_a_Name(A_name.get(i));                              //引用TIME.fxml的方法

                    gridpane_list.add(Time_hbox, 0, i);                    

                }
            } catch(IOException e){
                e.printStackTrace();

            }
           
            
        }

        //------------------------------
        //System.out.println(ALL_Store_members_dataName + "<<<");
        Choice_a_store.getItems().addAll(Store);      //把Members加入Choice_a_store(店號對應店名)

        TBcolumn_store_.setText("店名");
        TBcolumn_number_.setText("店號");
                        
        TBcolumn_store_.setCellValueFactory(new PropertyValueFactory<Display_storename,String>("name"));        //建立name欄位
        TBcolumn_number_.setCellValueFactory(new PropertyValueFactory<Display_storename,Integer>("number"));    //建立number欄位
        show_storename();

        Save_data.setOnAction(this::Save_Gpane_data);                //點擊Menu時才會觸發

        My_choicebox.getItems().addAll(Store);        //把Members加入My_choicebox
        My_choicebox.setOnAction(this::Get_member);

        Choice_a_store.setOnAction(this::choice_storename);     //點擊所選中的項目時才會觸發

        TBcolumn_.setText("門市");        
                    
        final ObservableList<Store_each_Members> Data = FXCollections.observableArrayList(       //UI初始顯示的文字
            new Store_each_Members("成員")
        );
        TBcolumn_.setCellValueFactory(new PropertyValueFactory<Store_each_Members,String>("name"));
        TBview_.setItems(Data);         //設置顯示的文字     
        
    }
    
    public void choice_storename(ActionEvent event){            //gridpane左上方的顯示資料,切換控制--->店名,店號
        String the_store_name = Choice_a_store.getValue();
        //System.out.println(gridpane_main.getChildren()+"<---childen");
        
        for (int index = 0; index < Store.size(); index++) {
            if (Store.get(index).equals(the_store_name)) {
                Store_NAM.setText(the_store_name);
                Store_NUM.setText(ALL_Store_number.get(index));

            }
        }        
        
    }

    public void Get_member(ActionEvent event){              //點擊店名得到成員
        String select_member = My_choicebox.getValue();
        //ObservableList<Members> data;
        //member_Tableview.getItems().clear();

        for (int index = 0; index < Store.size(); index++) {            
            if (select_member.equals(Store.get(index))) {                
                TBcolumn_.setText(Store.get(index));
                Switch_the_Select(index);
            }
        }


    }

    public void Switch_the_Select(Integer number){                      //切換對應的選項
        TBview_.getItems().clear();     //清空TBview_的Item     
        ALL_Store_members.clear();      //清空ALL_Store_member這個arraylist        
        
        try {
            FileReader read_Member_txt = new FileReader(ALL_Store_members_dataName.get(number).toString());
            BufferedReader Member_context = new BufferedReader(read_Member_txt);
            String the_context;

            while ((the_context = Member_context.readLine()) != null) {
                ALL_Store_members.add(new Store_each_Members(the_context));
                //System.out.println(ALL_Store_members.get(0) + "<<<<");
            }
            TBview_.getItems().addAll(ALL_Store_members);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show_storename(){                   //顯示店名與店號
        if (adjust_storenumber_location == null) {
            adjust_storenumber_location = Paths.get(a_new_path01).getParent();
            Storenumber_location = Paths.get(adjust_storenumber_location + "\\Store_Form_number.txt").toString();
                        
        }

        try {
            FileReader read_Number_text = new FileReader(Storenumber_location);
            BufferedReader Number_context = new BufferedReader(read_Number_text);
            String the_number_context;

            while ((the_number_context = Number_context.readLine()) != null) {
                ALL_Store_number.add(the_number_context);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int m = 0; m < Store.size(); m++) {
            ALL_Store_names.add(new Display_storename(Store.get(m), ALL_Store_number.get(m)));       

        }        
        TBview_store_.getItems().addAll(ALL_Store_names);

    }

    
    public void Save_Gpane_data(ActionEvent event){          //存檔
        if (Bufferdata_location == null) {
            Bufferdata_location = Paths.get(a_new_path01).getParent();
            Bufferdata_location = Paths.get(Bufferdata_location + "\\Buffer_data.txt");
        }
        if (Datanamelist_location == null) {
            Datanamelist_location = Paths.get(a_new_path01).getParent();
            Datanamelist_location = Paths.get(Datanamelist_location + "\\Data_namelist.txt");
        
        }       

        arranged_gridpane_main.clear();
        available_gridpane_main.clear();

        try {
            FileWriter clear_datacontext = new FileWriter(Bufferdata_location.toString(),false);
            clear_datacontext.write("");
            clear_datacontext.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            FileWriter writing_datacontext = new FileWriter(Bufferdata_location.toString(),false);            

            adjust_gridpane_main = gridpane_main.getChildren().toString().replace("[",",");     //把gridpane_main多餘的符號去掉
            adjust_gridpane_main = adjust_gridpane_main.replace("]",",");
            adjust_gridpane_main = adjust_gridpane_main.replace("=",",");
            adjust_gridpane_main = adjust_gridpane_main.replace("'","");
            arranging_gridpane_main = adjust_gridpane_main.split(",");

            //System.out.println(adjust_gridpane_main+"<+++");
            
            for (String word : arranging_gridpane_main) {
                arranged_gridpane_main.add(word);                
                
            }
            arranged_gridpane_main.remove(43);

            for(int P_index = 0; P_index < arranged_gridpane_main.size(); P_index++){       //讀寫時間段
                //System.out.println(arranged_gridpane_main.get(P_index)+"<><<");
                if (arranged_gridpane_main.get(P_index).equals(" Pane")) {         //時間段來自於Pane的id
                    //System.out.println("hello!!!");
                    arranged_gridpane_main.add(P_index + 1,"space01");              //因應後面的處理邏輯(除3以後餘為0的,會被抓起來)
                    arranged_gridpane_main.add(P_index + 2,"space02");              //Label,id,_REST_,styleclass,label,休假(他有5個,所以要再幫Pane補2個)

                    String adjust_symbol = arranged_gridpane_main.get(P_index + 4).replace("|", ",");
                    String[] adjust_name = adjust_symbol.split(",");    

                    if ((P_index + 5) < arranged_gridpane_main.size()) {
                        arranged_gridpane_main.set(P_index + 5, adjust_name[0].toString());    //補完後會有空字串佔位然後就顯示空白(故又把時段的id,重新調整再補上)
                    }
                    else{
                        arranged_gridpane_main.add(adjust_name[0]);
                    }
                    
                                                     
                }                
            }

            //System.out.println(arranged_gridpane_main+"<000");

            for (int i = 1; i < arranged_gridpane_main.size(); i++) {
                if (i % 3 == 0) {                    
                    available_gridpane_main.add(arranged_gridpane_main.get(i));
                    
                }
            }
            adjust_available_gridpane_main = available_gridpane_main.toString().replace("[","");    //把中跨號去掉
            adjust_available_gridpane_main = adjust_available_gridpane_main.replace("]","");
            adjust_available_gridpane_main = adjust_available_gridpane_main.replaceAll(" ", "");     //去掉空白

            //System.out.println(adjust_available_gridpane_main+"<---");

            writing_datacontext.write(adjust_available_gridpane_main);      //把gridpane_main存到Buffer_data裡
            writing_datacontext.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {           //清理data_namelist
            FileWriter clear_data_namelist = new FileWriter(Datanamelist_location.toString(),false);
            clear_data_namelist.write("");
            clear_data_namelist.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        try {
            savepoint_root = FXMLLoader.load(getClass().getResource("Savedata_ui.fxml"));
            scene = new Scene(savepoint_root);
            stage = new Stage();
            icon = new Image("/Tabulation_prototype/Img/scroll.png");

            stage.setMaxHeight(380);
            stage.setMaxWidth(609);

            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.setTitle("編輯檔案");
            stage.initModality(Modality.APPLICATION_MODAL);     //當關閉這個視窗時才能點前一個視窗                            
                                    
            stage.addEventHandler(ActionEvent.ANY, new EventHandler<ActionEvent>() {        //當點擊存檔或讀檔時關閉視窗
                public void handle(ActionEvent event){
                    //System.out.println(event.getTarget()+"<<--event target");                    
                    M_elements.clear();

                    if (Select_dataname_location == null) {
                        Select_dataname_location = Paths.get(Datanamelist_location.toString()).getParent();
                        Select_dataname_location = Paths.get(Select_dataname_location + "\\Selected_dataname.txt");
                    }

                    try {                            
                        FileReader read_a_dataname = new FileReader(Select_dataname_location.toString());
                        BufferedReader data_context = new BufferedReader(read_a_dataname);
                        String a_dataname_context;

                        while ((a_dataname_context = data_context.readLine()) != null) {
                            dataname_list.clear();
                            dataname_list.add(a_dataname_context);              //取得選取的檔案名稱
                            
                        }
                        
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    if (event.getTarget().toString().equals("Button[id=save_button, styleClass=button]'儲存'")) {                        
                        System.out.println("儲存");
                        
                        
                    }
                    else if (event.getTarget().toString().equals("Button[id=load_button, styleClass=button]'讀取'")) {
                        System.out.println("讀取");
                        if (Datasave_location == null) {
                            Datasave_location = Paths.get(Save_point_location.reset_a_Path());
                        }                        

                        try {
                            FileReader read_select_data = new FileReader(Datasave_location.toString() +"\\"+ dataname_list.get(0));
                            BufferedReader select_data_context = new BufferedReader(read_select_data);
                            String a_select_data_context;                            
                            
                            while ((a_select_data_context = select_data_context.readLine()) != null) {        
                                select_context = a_select_data_context.split(",");

                            }

                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }                        
                        elements_list.clear();

                        for(String word : select_context){                            
                            elements_list.add(word);

                        }

                        System.out.println("------");
                        /*for (int i = 0; i < elements_list.size(); i++) {
                            System.out.println(elements_list.get(i));
                        }
                        System.out.println(elements_list.size());*/
                        
                        Days_collect.clear();

                        int add_num = 1;                                              
                        for(int day_index = 0; day_index < 7;day_index++){                            
                            Days_collect.add(day_index, elements_list.get(day_index + add_num));

                            add_num += 1;
                        }

                        Day01.setText(elements_list.get(1));    //讀取日期
                        Day02.setText(elements_list.get(3));
                        Day03.setText(elements_list.get(5));
                        Day04.setText(elements_list.get(7));
                        Day05.setText(elements_list.get(9));
                        Day06.setText(elements_list.get(11));
                        Day07.setText(elements_list.get(13));
                        

                        //System.out.println(elements_list.size());

                        if (elements_list.size() > 14) {
                            int j = 0;
                            int k = 1; 

                            int Gpane_size = gridpane_main.getChildren().size();

                            for (int m = 0; m < (Gpane_size-8); m++) {                              //清空gridpane_main之前擺的資料
                                //System.out.println(gridpane_main.getChildren().get(8)+"<<8");
                                gridpane_main.getChildren().remove(8);
                            }

                            for (int i = 1; i <= (elements_list.size()-14)/2; i++) {            //扣掉日期的7天不算(14 = id + 名字 的總和)
                                Member_load_label = new Label(elements_list.get(13 + i*2));     //獲取element_list的成員,從第15個開始(從0開始算)
                                Member_load_label.setId(elements_list.get(12 + i*2));
                                Member_load_label.setFont(new Font(20));
                                Member_load_label.setPadding(new Insets(11.25));               //設置空白填充
                                
                                if (k == 1 && j == 0) {                                   
                                    M_elements.add(elements_list.get(13 + i*2));

                                }
                                if (j > 7) {            //一列有8個，超過就換下一列
                                    j = 0;
                                    k += 1;
                                    M_elements.add(elements_list.get(13 + i*2));
                                    
                                }
                                
                                
                                gridpane_main.setColumnIndex(Member_load_label,j);
                                gridpane_main.setRowIndex(Member_load_label,k);
                                gridpane_main.getChildren().addAll(Member_load_label);
                        
                                j += 1;
                            }
                            
                        }                                                
                    }
                }
                
            });
            stage.show(); 

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void Show_rectangle(){        
        Time_rectangle_sheet.getChildren().clear();

        String[] today_time;

        int[][] All_T = new int[7][];
        int[][] All_H = new int[7][];
    
        int[][] all_T_overlap = new int[7][];           //7天尾部重疊區
        int[][] all_H_overlap = new int[7][];           //7天頭部重疊區        

        int[][] T_classify = new int[7][3];          //把尾分類為[早,晚,夜]
        int[][] H_classify = new int[7][3];          //把頭分類為[早,晚,夜]

        //System.out.println(gridpane_main.getChildren().get(9).getId()+","+gridpane_main.getChildren().get(17).getId());
        
        for (int row_y = 1; row_y < 8; row_y++) {            //不同成員在同一天的時段分配(星期一 ---> 星期日)
            int[] T_number = new int[M_elements.size()];      //(尾)
            int[] H_number = new int[M_elements.size()];      //(頭)第n天的時段,頭的地方,尾<->頭                     

            //ArrayList Head_overlap_num = new ArrayList<>();
            //int Overlap_number = 0;

            for (int col_x = 1; col_x < M_elements.size() + 1; col_x++) {                
                //System.out.println("M:_"+gridpane_main.getChildren().get(col_x * 8 + row_y).getId().replace("-",",").replace("|", ","));
                
                String time_period = gridpane_main.getChildren().get(col_x * 8 + row_y).getId().replace("-",",").replace("|", ",");                                
                today_time = time_period.split(",");
                //System.out.println(today_time[0]+","+today_time[1]+"<<<");   
                
                //如果輸入的是時段的話
                if (today_time.length == 3) {
                    int Tail_num = Integer.parseInt(today_time[0]);     //(尾部)
                    int Head_num = Integer.parseInt(today_time[1]);     //把取得的字串資料轉為整數(頭部)                                                                            
                
                    T_number[col_x - 1] = Tail_num;
                    H_number[col_x - 1] = Head_num;
                }

                //如果輸入的是其他文字註記
                else{
                    T_number[col_x - 1] = -1;
                    H_number[col_x - 1] = -1;
                }                
            }
            All_T[row_y - 1] = T_number;    //每一天不同的成員的擁有的時段(尾部)
            All_H[row_y - 1] = H_number;    //頭部         

        }

        for (int order = 0; order < 2; order++) {            
            //-----找出最小的尾部-----
            if (order == 0) {                
                for (int T_order = 0; T_order < 7; T_order++) {
                    ArrayList Mor = new ArrayList<Integer>();           //早
                    ArrayList Nig = new ArrayList<Integer>();           //晚
                    ArrayList Early_mor = new ArrayList<Integer>();     //夜

                    for(int T_M_order = 0; T_M_order < M_elements.size(); T_M_order++){       //M-->Member 成員                     
                        if (All_T[T_order][T_M_order] < 12) {                   //早班  尾
                            Mor.add(All_T[T_order][T_M_order]);

                        }
                        else if (All_T[T_order][T_M_order] < 19) {                 //晚班  尾
                            Nig.add(All_T[T_order][T_M_order]);

                        }
                        else if (All_T[T_order][T_M_order] < 24) {                  //夜班  尾
                            Early_mor.add(All_T[T_order][T_M_order]);
                            
                        }
                    }
                    //-----從小排到大-----
                    Collections.sort(Mor);
                    Collections.sort(Nig);
                    Collections.sort(Early_mor);

                    //System.out.println("|mor:"+Mor.size()+"|nig:"+Nig.size()+"|ear:"+Early_mor.size());


                    for (int index = 0; index < 3; index++) {               //取得各[尾部]時段的最小值
                        if (index == 0 && Mor.size() > 0) {
                            for(int index01 = 0; index01 < Mor.size(); index01++){                            
                                if (Integer.valueOf(Mor.get(index01).toString()) != -1) {               //不將-1作為最小值
                                    T_classify[T_order][index] = Integer.valueOf(Mor.get(index01).toString());

                                }
                            }                        
                        }
                        else if (index == 1 && Nig.size() > 0) {
                            T_classify[T_order][index] = Integer.valueOf(Nig.get(0).toString());
                                                        
                        }
                        else if (index == 2 && Early_mor.size() > 0) {
                            T_classify[T_order][index] = Integer.valueOf(Early_mor.get(0).toString());

                        }
                        else{
                            T_classify[T_order][index] = 0;              //如果[尾部]什麼都沒有則把0存進那個位置
                        }
                    }                                                                
                }
            }

            //----------找出最大的頭部----------
            else if (order == 1) {
                ArrayList Mor = new ArrayList<Integer>();           //早
                ArrayList Nig = new ArrayList<Integer>();           //晚
                ArrayList Early_mor = new ArrayList<Integer>();     //夜

                for (int H_order = 0; H_order < 7; H_order++) {
                    for(int H_M_order = 0; H_M_order < M_elements.size(); H_M_order++){                            
                        if (All_H[H_order][H_M_order] < 19) {                   //早班  頭
                            Mor.add(All_H[H_order][H_M_order]);

                        }
                        else if (All_H[H_order][H_M_order] < 24) {              //晚班  頭
                            Nig.add(All_H[H_order][H_M_order]);

                        }
                        else if (All_H[H_order][H_M_order] < 8) {               //夜班  頭
                            Early_mor.add(All_H[H_order][H_M_order]);
                            
                        }
                    }
                    //-----從大排到小-----
                    Collections.sort(Mor,Collections.reverseOrder());
                    Collections.sort(Nig,Collections.reverseOrder());
                    Collections.sort(Early_mor,Collections.reverseOrder());


                    for (int index = 0; index < 3; index++) {               //取得各[頭部]時段的最小值
                        if (index == 0 && Mor.size() > 0) {
                            H_classify[H_order][index] = Integer.valueOf(Mor.get(0).toString());
                            //System.out.println(H_classify[index]);
                        }
                        else if (index == 1 && Nig.size() > 0) {
                            H_classify[H_order][index] = Integer.valueOf(Nig.get(0).toString());
                            //System.out.println(H_classify[index]);
                        }
                        else if (index == 2 && Early_mor.size() > 0) {
                            H_classify[H_order][index] = Integer.valueOf(Early_mor.get(0).toString());
                            //System.out.println(H_classify[index]);
                        }
                        else{
                            H_classify[H_order][index] = 0;              //如果[頭部]什麼都沒有則把0存進那個位置
                        }
                    }
                }                
            }
        }


        //尾部重疊區
        for (int day_time = 0; day_time < 7; day_time++){
            int[] T_overlap = new int[M_elements.size()];       //尾部重疊區
             
            for (int T_index = 0; T_index < M_elements.size(); T_index++) {
                if(0 < All_T[day_time][T_index] && All_T[day_time][T_index] < 9){                            //早班時段                           
                    T_overlap[T_index] = H_classify[day_time][2] - All_T[day_time][T_index];                           //第row_y-1天的尾部重疊
                    if(H_classify[day_time][2] == 0){                     //如果相減的對象值為零,則重疊區為零
                        T_overlap[T_index] = 0;
                    }

                    all_T_overlap[day_time] = T_overlap;
                }                         
                else if (12 < All_T[day_time][T_index] && All_T[day_time][T_index] < 19) {                   //晚班時段
                    T_overlap[T_index] = H_classify[day_time][0] - All_T[day_time][T_index];
                    if(H_classify[day_time][0] == 0){
                        T_overlap[T_index] = 0;
                    }

                    all_T_overlap[day_time] = T_overlap;
                }
                else if (19 < All_H[day_time][T_index] && All_H[day_time][T_index] < 24) {                    //大夜時段
                    T_overlap[T_index] = H_classify[day_time][1] - All_T[day_time][T_index];
                    if(H_classify[day_time][1] == 0){
                        T_overlap[T_index] = 0;
                    }
                    all_T_overlap[day_time] = T_overlap;
                }
                else{
                    T_overlap[T_index] = 0;
                    all_T_overlap[day_time] = T_overlap;
                }
            }            
        }

        //頭部重疊區
        for (int day_time = 0; day_time < 7; day_time++){
            int[] H_overlap = new int[M_elements.size()];       //頭部重疊區  

            for (int H_index = 0; H_index < M_elements.size(); H_index++) {
                if(12 < All_H[day_time][H_index] && All_H[day_time][H_index] < 19){                         //早班時段
                    H_overlap[H_index] = All_H[day_time][H_index] - T_classify[day_time][1];
                    if(T_classify[day_time][1] == 0){             //如果相減的對象值為零,則重疊區為零
                        H_overlap[H_index] = 0;
                    }
                    
                    all_H_overlap[day_time] = H_overlap;
                } 
                else if (19 < All_T[day_time][H_index] && All_T[day_time][H_index] < 24) {                   //晚班時段
                    H_overlap[H_index] = All_H[day_time][H_index] - T_classify[day_time][2];
                    if(T_classify[day_time][2] == 0){
                        H_overlap[H_index] = 0;
                    }

                    all_H_overlap[day_time] = H_overlap;
                }
                else if (0 < All_T[day_time][H_index] && All_T[day_time][H_index] < 9) {                    //大夜時段
                    H_overlap[H_index] = All_H[day_time][H_index] - T_classify[day_time][0];
                    if(T_classify[day_time][0] == 0){
                        H_overlap[H_index] = 0;
                    }

                    all_H_overlap[day_time] = H_overlap;
                }
                else{
                    H_overlap[H_index] = 0;
                    all_H_overlap[day_time] = H_overlap;
                }
            }            
        }
        

        for (int num02 = 0; num02 < 7; num02++) {
            for (int num03 = 0; num03 < M_elements.size(); num03++) {
                System.out.println(all_T_overlap[num02][num03]+"<<-尾_"+num03);
            }
        }
        for (int num02 = 0; num02 < 7; num02++) {
            for (int num03 = 0; num03 < M_elements.size(); num03++) {
                System.out.println(all_H_overlap[num02][num03]+"<<-頭_"+num03);
            }
        }


        for (int index = 0; index < Days_collect.size(); index++) {            //載入直條圖
            try {
                FXMLLoader show_rectangle = new FXMLLoader();
                show_rectangle.setLocation(getClass().getResource("Time_rectangle.fxml"));
                Pane time_rectangle_pane = show_rectangle.load();

                rectangle_controler time_rectangle_pane_controler = show_rectangle.getController();
                time_rectangle_pane_controler.set_dayname(Days_collect.get(index));

                for (int i = 0; i < M_elements.size(); i++) {
                    time_rectangle_pane_controler.set_Gpane(M_elements.get(i), i, All_T[index][i], all_T_overlap[index][i], all_H_overlap[index][i], All_T[index][i], All_H[index][i]);      //(成員名,第幾個)
                }            

                Time_rectangle_sheet.getChildren().add(time_rectangle_pane);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }                

    }
}
