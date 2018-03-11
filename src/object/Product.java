/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.io.Serializable;
/**
 *
 * @author Kavinesh
 */
public class Product implements Serializable {
    
    private int id;
    private int stock;
    private String name;
    private String type;
    private Double price;
    
    public Product(int id, int stock, String name, String type, Double price){
     
        this.id = id;
        this.stock = stock;
        this.name = name;
        this.type = type;
        this.price = price;
     }
    public Product(){

}    

    public int getID(){
        return id;
}
    
     public void setID(int id) {
        this.id = id;
}    
        
    public int getStock(){
        return stock;
}
    
     public void setStock(int stock){
         this.stock = stock;
}
     public String getName(){
         return name;
}
     public void setName(String name){
         this.name = name;
}   
     public String getType(){
         return type;
     }
     
     public void setType(String type){
         this.type = type;
     }
     
     public Double getPrice(){
         return price;
     }
     
     public void setPrice(Double price){
         this.price = price;
     }
     
     







}
