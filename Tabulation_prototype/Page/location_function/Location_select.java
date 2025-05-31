package Tabulation_prototype.Page.location_function;

import java.util.ArrayList;

public abstract class Location_select {
    public String Path = new String();         //路徑變更
    public String[] Re_path_list;
    public ArrayList Re_Path_wordlist = new ArrayList<String>();
    public String New_Path = new String();

    private String Delete_list_Location;        //刪除暫存的路徑

    public abstract String reset_a_Path();        //方法原型(抽象方法)
    
}