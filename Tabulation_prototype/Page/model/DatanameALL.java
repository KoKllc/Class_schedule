package Tabulation_prototype.Page.model;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import Tabulation_prototype.Page.location_function.Location_select;
import Tabulation_prototype.Page.location_function.location.delete_location;


public class DatanameALL extends SimpleFileVisitor<Path>{
    private Location_select Dataname_list_Location = new delete_location();

    private String A_new_path_dataname = null;
    private Path datatxt_path;

    private FileWriter Writing_Members;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{      //掃描檔案
        if(file.toString().endsWith(".txt")){  

            if(A_new_path_dataname == null){
                A_new_path_dataname = Dataname_list_Location.reset_a_Path();       
                datatxt_path = Paths.get(A_new_path_dataname).getParent();
    
                datatxt_path = Paths.get(datatxt_path + "\\Data_namelist.txt");                
                //System.out.println(membertxt_path_original);
            } 
            

            Writing_Members = new FileWriter(datatxt_path.toString(), true);
            
            Writing_Members.write(file.getFileName().toString() + "\n");
            Writing_Members.close();

            return FileVisitResult.CONTINUE;    //繼續走訪
        }
        
        return FileVisitResult.SKIP_SUBTREE;    //如果Member一個也沒有，則不向這個以及下個目錄走訪
    }        
}
