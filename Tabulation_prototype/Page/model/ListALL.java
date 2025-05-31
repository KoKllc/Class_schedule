package Tabulation_prototype.Page.model;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import Tabulation_prototype.Page.location_function.location.delete_location;
import Tabulation_prototype.Page.location_function.Location_select;

public class ListALL extends SimpleFileVisitor<Path>{
    private Location_select Member_Location = new delete_location();
    private String A_new_path_member = null;
    private Path membertxt_path;
    private Path membertxt_path_original;
    private Path membertxt_path_original_parent;

    private FileWriter Writing_Members;

    private ArrayList<String> ALL_members = new ArrayList<String>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{      //掃描檔案
        if(file.toString().endsWith(".txt")){       
            if(A_new_path_member == null){
                A_new_path_member = Member_Location.reset_a_Path();       //獲取ALL_member的Member_A路徑
                membertxt_path = Paths.get(A_new_path_member);                 //String轉成Path型別
                membertxt_path_original = membertxt_path.getParent();          //獲取ALL_members的路徑
                membertxt_path_original_parent = membertxt_path_original;
    
                membertxt_path_original = Paths.get(membertxt_path_original + "\\Store_member_sheet.txt");                
                //System.out.println(membertxt_path_original);
            } 
            
            ALL_members.add(file.getFileName().toString());
            Writing_Members = new FileWriter(membertxt_path_original.toString(), true);
            Writing_Members.write(membertxt_path_original_parent + "\\ALL_members\\" + file.getFileName().toString() + "\n");
            Writing_Members.close();
                        
            return FileVisitResult.CONTINUE;    //繼續走訪
        }
        
        return FileVisitResult.SKIP_SUBTREE;    //如果Member一個也沒有，則不向這個以及下個目錄走訪
    }        
}

