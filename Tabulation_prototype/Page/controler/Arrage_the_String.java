package Tabulation_prototype.Page.controler;

import java.util.ArrayList;

public class Arrage_the_String {
    public String input_name = new String();
    public String[] adjust_name;
    public ArrayList<String> adjusted_name = new ArrayList<String>();
    public String Name = new String();

    public String arrange_name(String input_name, String symbol, String replace_symbol, int position){
        this.input_name = input_name.replace(symbol, replace_symbol);
        adjust_name = this.input_name.split(replace_symbol);

        for(String word:adjust_name){
            adjusted_name.add(word);

        }
        Name = adjusted_name.get(position);

        adjusted_name.clear();

        return Name;
    }    

}
