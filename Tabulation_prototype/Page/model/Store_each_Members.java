package Tabulation_prototype.Page.model;

import javafx.beans.property.SimpleStringProperty;

public class Store_each_Members {                //成員物件建立
    public SimpleStringProperty name;

    public Store_each_Members(String name){
        this.name = new SimpleStringProperty(name);
    }

    public String getName(){        //必須得寫getName不得改大小寫，似乎是因為property要呼叫自身的方法getName
        return name.get();
    }

    public void setName(String name){
        this.name.set(name);    
    }

}
