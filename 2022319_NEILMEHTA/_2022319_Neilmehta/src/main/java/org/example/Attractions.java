package org.example;

import java.util.Scanner;

public class Attractions implements Manage {
    static int modify_var;
    static String remove_att;

    private int attraction_price= 12;

    int ticketed_visitors=0;

    boolean is_open = true;

    static int index_to_be_removed;


    Scanner sc2= new Scanner(System.in);




    public String getAttraction_name() {
        return attraction_name;
    }

    public void setAttraction_name(String attraction_name) {
        this.attraction_name = attraction_name;
    }

    private String attraction_name;  // -- var

    public String getAttraction_descreption() {
        return attraction_descreption;
    }

    public void setAttraction_descreption(String attraction_descreption) {
        this.attraction_descreption = attraction_descreption;
    }

    private String attraction_descreption;  // -- var

    public Attractions(String attraction_name, String attraction_descreption){
        this.attraction_descreption= attraction_descreption;
        this.attraction_name= attraction_name;
    }

      static void  Options(){
          System.out.println("1. Add Attraction\n" +
                  "2. View Attractions\n" +
                  "3. Modify Attraction\n" +
                  "4. Remove Attraction\n" +
                  "5. Exit\n");





      }
      @Override
      public void Add(){
        Admin.ATTRACTION_LIST.add(this);
      }
      @Override
      public void View(){
          for(int var1=0; var1< Admin.ATTRACTION_LIST.size();var1++){
              System.out.println("Name of attraction is : "+ Admin.ATTRACTION_LIST.get(var1).getAttraction_name());
              System.out.println();
              System.out.println("Attraction descreption is " + Admin.ATTRACTION_LIST.get(var1).getAttraction_descreption());
              System.out.println();

          }

      }
      @Override
      public void Modify(){
        Admin.ATTRACTION_LIST.set(modify_var,this);
          System.out.println("attraction has been modified ! ");


      }
      @Override
      public void Remove(){
//        for(int vari=0 ;vari< Admin.ATTRACTION_LIST.size();vari++){
//            System.out.println(remove_att);
//            if(Admin.ATTRACTION_LIST.get(vari).attraction_name.equals(remove_att)){
//                Admin.ATTRACTION_LIST.remove(vari);
//                Admin.cur_index_attlist--;
//                System.out.println("attraction removed succssfully");
//                break;
//            }
//        }
          //System.out.println("hello");
          Admin.ATTRACTION_LIST.remove(index_to_be_removed);
          Admin.AMPHIBIAN_LIST_NUM--;

      }

    void Option_given(){
          int choice_Att= sc2.nextInt();
          if(choice_Att==1){
              String attraction_name= sc2.nextLine();
              String attraction_descreption= sc2.nextLine();



          }

      }

    public int getAttraction_price() {
        return attraction_price;
    }

    public void setAttraction_price(int attraction_price) {
        this.attraction_price = attraction_price;
    }

    public int getTicketed_visitors() {
        return ticketed_visitors;
    }

    public void setTicketed_visitors() {
        this.ticketed_visitors++;
    }

    public boolean isIs_open() {
        return is_open;
    }

    public void setIs_open() {
        this.is_open = !(this.is_open);
    }
}
