package Tabulation_prototype.Page.controler;



import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class rectangle_controler {
    @FXML
    Pane time_rectangle_pane = new Pane();

    @FXML
    Label member_name = new Label();
    @FXML
    Label day_name = new Label();
    @FXML
    GridPane Rec_gpane = new GridPane();
    
    @FXML
    AnchorPane rec_anchorpane = new AnchorPane();   //放長方形用的

    
    @FXML
    Rectangle Rec = new Rectangle();
    @FXML
    Rectangle overlap_T_Rec = new Rectangle();
    @FXML
    Rectangle overlap_H_Rec = new Rectangle();

    public Double overlap_T;
    public Double overlap_H;


    public void set_dayname(String name){
        day_name.setText(name);
        day_name.setId(name);

    }

    public void set_Gpane(String member, int name_Rowindex, int Tail_time, int T_overlap, int H_overlap, int T_num, int H_num){
        Rec = new Rectangle();
        overlap_T_Rec = new Rectangle();
        overlap_H_Rec = new Rectangle();
        rec_anchorpane = new AnchorPane();
        int difference_num = H_num - T_num;
        double new_T_overlap;
        double new_H_overlap;

        member_name = new Label(member);
        member_name.setFont(new Font(15));
        member_name.setPadding(new Insets(11.5));           
        
        Rec_gpane.setPadding(new Insets(3));
        Rec_gpane.setColumnIndex(member_name, 0);
        Rec_gpane.setRowIndex(member_name, name_Rowindex);

        //重疊的尾部
        if (difference_num < 0) {                   //大夜相減可能為負的
            difference_num = difference_num * -1;
        }           
        new_T_overlap = Double.valueOf(T_overlap) * 200 / difference_num;
        new_H_overlap = Double.valueOf(H_overlap) * 200 / difference_num;        

        //尾重疊
        overlap_T_Rec.setWidth(new_T_overlap);
        overlap_T_Rec.setHeight(45);
        overlap_T_Rec.setFill(Color.rgb(222, 75, 75));
        
        //頭重疊
        overlap_H_Rec.setWidth(new_H_overlap);
        overlap_H_Rec.setHeight(45);
        overlap_H_Rec.setFill(Color.rgb(222, 75, 75));

        
        if (Tail_time == -1) {            
            rec_anchorpane.setStyle("-fx-background-color:#ABABAB");    //初始底色為灰色

        }
        else if (Tail_time < 12) {            
            rec_anchorpane.setStyle("-fx-background-color:#95FE5D");    //初始底色為綠色

        }
        else if (Tail_time < 19) {            
            rec_anchorpane.setStyle("-fx-background-color:#FEF67B");    //初始底色為黃色

        }
        else if (Tail_time < 24) {            
            rec_anchorpane.setStyle("-fx-background-color:#517AD2");    //初始底色為藍色

        }
        rec_anchorpane.getChildren().addAll(overlap_T_Rec, overlap_H_Rec);
        overlap_H_Rec.setX(150 - new_H_overlap);        //頭部重疊位置


        Rec_gpane.setColumnIndex(rec_anchorpane, 1);
        Rec_gpane.setRowIndex(rec_anchorpane, name_Rowindex);    

        Rec_gpane.getChildren().addAll(member_name,rec_anchorpane);
    }
}
