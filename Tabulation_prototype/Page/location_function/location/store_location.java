package Tabulation_prototype.Page.location_function.location;

import java.nio.file.FileSystems;
import Tabulation_prototype.Page.location_function.Location_select;

public class store_location extends Location_select{
    public String reset_a_Path(){
        Path = FileSystems.getDefault().getPath("Tabulation_prototype").toAbsolutePath().toString();
        Path = Path.replace("\\",",");      //把 "\" 替換成 ","
        Re_path_list = Path.split(",");                  //用","把Path切分
        
        for(String word:Re_path_list){
            Re_Path_wordlist.add(word);

        }
        Re_Path_wordlist.add("Data_save\\Store_Form.txt");   //修正到目標路徑

        for(int i = 0; i < Re_Path_wordlist.size(); i++){
            New_Path = New_Path + Re_Path_wordlist.get(i) + "\\";

        }
        return New_Path;
    }
}
