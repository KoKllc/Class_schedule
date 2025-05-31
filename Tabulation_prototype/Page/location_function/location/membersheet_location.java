package Tabulation_prototype.Page.location_function.location;

import java.nio.file.FileSystems;
import Tabulation_prototype.Page.location_function.Location_select;

public class membersheet_location extends Location_select{      //成員文字檔路徑
    
    public String reset_a_Path(){
        Path = FileSystems.getDefault().getPath("Tabulation_prototype").toAbsolutePath().toString();    //獲取路徑
        Path = Path.replace("\\", ",");     //編輯路徑
        Re_path_list = Path.split(",");                  //編輯路徑
        
        for(String word:Re_path_list){
            Re_Path_wordlist.add(word);

        }
        Re_Path_wordlist.add("Data_save\\ALL_members\\Member_A.txt");
        
        for(int i = 0; i < Re_Path_wordlist.size(); i++){
            New_Path = New_Path + Re_Path_wordlist.get(i) + "\\";

        }
        return New_Path;
    }
}
