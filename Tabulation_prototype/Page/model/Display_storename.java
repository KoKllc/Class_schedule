package Tabulation_prototype.Page.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Display_storename {        //店名,店號顯示
    public SimpleStringProperty name;
    public SimpleStringProperty number;

    public Display_storename(String name,String number){
        this.name = new SimpleStringProperty(name);
        this.number = new SimpleStringProperty(number);
    }

    public String getName(){
        return name.get();
    }
    public void setName(String store_name){
        this.name.set(store_name);
    }

    public String getNumber(){     //get後第1個字 "N" 要大寫!?
        return number.get();
    }
    public void setNumber(String number){
        this.number.set(number);
    }

}
