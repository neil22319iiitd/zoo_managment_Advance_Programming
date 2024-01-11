package org.example;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    static ArrayList<Attractions> ATTRACTION_LIST= new ArrayList<>(100);
    static int cur_index_attlist=0;

    static ArrayList<Animals> ANIMAL_LIST= new ArrayList<>(100);
    static int ANIMAL_LIST_NUM=0;

    static ArrayList<Animals> MAMMAL_LIST = new ArrayList<>(100);
    static int MAMMAL_LIST_NUM=0;

    static ArrayList<Animals> AMPHIBIAN_LIST = new ArrayList<>(100);
    static int AMPHIBIAN_LIST_NUM=0;

    static ArrayList<Animals> REPTILES_LIST= new ArrayList<>(100);
    static int REPTILES_LIST_NUM=0;

    static ArrayList<DISCOUNTS> DISCOUNTS_LIST= new ArrayList<>(100);
    static int DISCOUNT_LIST_NUM=0;
    static ArrayList<Integer> INT_SPL_DEALS= new ArrayList<>(100);
    static ArrayList<Integer> WHEN_APPLICABLE_NUMBER = new ArrayList<>(100);

    static String username= "admin";  // its not made private because it's not a variable it is a constant
    static String password= "admin";

    Scanner sc1= new Scanner(System.in);

    static void Welcome(){
        System.out.println("Logged in as admin");

    }
    static void Menu(){
        System.out.println("1. Manage Attractions\n" +
                "2. Manage Animals\n" +
                "3. Schedule Events\n" +
                "4. Set Discounts\n" +
                "5. Set Special Deal\n" +
                "6. View Visitor Stats\n" +
                "7. View Feedback\n" +
                "8. Exit\n");


    }
    void choice_ask(){
        while(true) {
            int ch1 = sc1.nextInt();
            sc1.nextLine();
            if (ch1 == 1) {
                while(true) {
                    System.out.println("Manage Attractions:\n" +
                            "1. Add Attraction\n" +
                            "2. View Attractions\n" +
                            "3. Modify Attraction\n" +
                            "4. Remove Attraction\n" +
                            "5. Exit\n");
                    int choice_Att = sc1.nextInt();
                    sc1.nextLine();
                    if (choice_Att == 1) {
                        System.out.print("Enter attraction name : ");
                        String attraction_name = sc1.nextLine();
                        System.out.println();
                        System.out.print("Enter attraction descreption : ");
                        String attraction_descreption = sc1.nextLine();
                        Attractions att1 = new Attractions(attraction_name, attraction_descreption);
                        att1.Add();
                        cur_index_attlist++;


                    } else if (choice_Att == 2) {
                        // view attractions
                        Attractions attt = ATTRACTION_LIST.get(0);
                        attt.View();
                    } else if (choice_Att == 3) {
                        // modify
                        System.out.print("Enter attraction index(0,1,2) to modify please : ");
                        int att_number = sc1.nextInt();
                        sc1.nextLine();
                        System.out.println("enter the new name and the desc. of the attraction");
                        String attraction_name = sc1.nextLine();
                        String attraction_descreption = sc1.nextLine();
                        Attractions obj = new Attractions(attraction_name, attraction_descreption);
                        Attractions.modify_var = att_number;
                        obj.Modify();


                    } else if (choice_Att == 4) {
                        // remove
                        System.out.println("enter the attraction name to removed ");
                        String attraction_name_given= sc1.nextLine();
                        int index_to_be_removed;
                        for(int i=0; i<ATTRACTION_LIST.size(); i++){
                            if(ATTRACTION_LIST.get(i).getAttraction_name().equals(attraction_name_given)){
                                index_to_be_removed=i;
                                Attractions.index_to_be_removed=index_to_be_removed;
                                ATTRACTION_LIST.get(i).Remove();
                                break;
                            }
                        }






                    }
                    else if(choice_Att==5 ){
                        Menu();
                        break;
                    }
                }


            }
            else if(ch1 == 8){
                break;
            }
            else if(ch1==2){
                while(true){
                    Animals.prinatble();
                    int ch_to_animals= sc1.nextInt();
                    sc1.nextLine();
                    if(ch_to_animals==1){

                        // ADD ANIMALS;
                        System.out.println("enter name of animal");
                        String Aname = sc1.nextLine();
                        System.out.println("enter type of animal (amphibian) (reptile) (mammal)");
                        String type = sc1.nextLine();
                        System.out.println(" enter descreption of animal for user to read ");
                        String descreption = sc1.nextLine();
                        System.out.println(" enter the sound made by animal");
                        String sound = sc1.nextLine();

                        Animals new_animal= new Animals(Aname,type,descreption,sound);
                        new_animal.Add();
                        ANIMAL_LIST_NUM++;

                        //System.out.println(ANIMAL_LIST.get(ANIMAL_LIST_NUM-1).getAName());



                    }
                    else if(ch_to_animals==2){
                        // update animal details
                        System.out.println("enter animal name to modify please ");
                        String Aname= sc1.nextLine();
                        for(int i=0;i<ANIMAL_LIST.size();i++){
                            if(ANIMAL_LIST.get(i).getAName().equals(Aname)){
                                System.out.println(" what do you want to change \n"+"1. name");
                                int change_type= 1;
                                sc1.nextLine();
                                String A_type= ANIMAL_LIST.get(i).getType();
                                if(change_type== 1){
                                    System.out.println("enter new name ");
                                    String new_name = sc1.nextLine();
                                    Animals animalia= new Animals(new_name,ANIMAL_LIST.get(i).getType(),ANIMAL_LIST.get(i).getDescreption(),ANIMAL_LIST.get(i).getSound());
                                    Animals.varying_variable=i;

                                    animalia.Modify();

                                    if(A_type.equals("mammal")){
                                        for(int j=0;j< MAMMAL_LIST.size();j++){
                                            if(MAMMAL_LIST.get(j).getAName().equals(Aname)){
                                                MAMMAL_LIST.set(j,animalia);
                                            }
                                        }

                                    }
                                    else if(A_type.equals("reptile")){
                                        for(int j=0;j< REPTILES_LIST.size();j++){
                                            if(REPTILES_LIST.get(j).getAName().equals(Aname)){
                                                REPTILES_LIST.set(j,animalia);
                                            }
                                        }

                                    }

                                    else if(A_type.equals("amphibian")){
                                        for(int j=0;j< AMPHIBIAN_LIST.size();j++){
                                            if(AMPHIBIAN_LIST.get(j).getAName().equals(Aname)){
                                                AMPHIBIAN_LIST.set(j,animalia);
                                            }
                                        }

                                    }
                                    System.out.println(animalia.getAName() + " is the new name of the animal");
                                }


                            }
                        }
                        //System.out.println(ANIMAL_LIST.get(0).getAName());
                    }
                    else if(ch_to_animals==3){
                        // remove animal
                        System.out.println("Enter name of animal to be removed ");
                        String ani_name= sc1.nextLine();
                        Animals animal_deleted;
                        String animal_type;
                        for(int i=0; i< ANIMAL_LIST.size();i++){
                            ANIMAL_LIST_NUM--;
                            if(ANIMAL_LIST.get(i).getAName().equals(ani_name)){
                                animal_deleted= ANIMAL_LIST.get(i);
                                animal_type= ANIMAL_LIST.get(i).getType();
                                animal_deleted.Remove();

                                if(animal_type.equals("mammal")){
                                    for(int j=0; j< MAMMAL_LIST.size();j++){
                                        if(MAMMAL_LIST.get(j).getAName().equals(ani_name)){
                                            MAMMAL_LIST.remove(j);
                                            System.out.println("removed succesfully ");
                                            MAMMAL_LIST_NUM--;
                                        }
                                    }
                                }
                                else if(animal_type.equals("reptile")){
                                    for(int j=0; j< REPTILES_LIST.size();j++){
                                        if(REPTILES_LIST.get(j).getAName().equals(ani_name)){
                                            REPTILES_LIST.remove(j);
                                            System.out.println("removed succesfully ");
                                            REPTILES_LIST_NUM--;
                                        }
                                    }
                                }
                                else if(animal_type.equals("amphibian")){
                                    for(int j=0; j< AMPHIBIAN_LIST.size();j++){
                                        if(AMPHIBIAN_LIST.get(j).getAName().equals(ani_name)){
                                            AMPHIBIAN_LIST.remove(j);
                                            System.out.println("removed succesfully ");
                                            AMPHIBIAN_LIST_NUM--;
                                        }
                                    }
                                }
                            }
                        }




                    }
                    else if(ch_to_animals==4){
                        Menu();
                        break;
                    }

                }
                // manage animals

            }
            else if(ch1==4){
                // manage discounts

                while(true) {
                    DISCOUNTS.Display_to_admin();
                    int choice_of_discounts= sc1.nextInt();
                    sc1.nextLine();
                    if (choice_of_discounts == 1) {
                        // ADD DISCOUNTS
                        System.out.println("Enter discount_name");
                        String Discount_category = sc1.nextLine();
                        System.out.println("Enter discount_percentage ");
                        int discount_percentage = sc1.nextInt();
                        sc1.nextLine();

                        DISCOUNTS new_discount = new DISCOUNTS(Discount_category, discount_percentage);
                        new_discount.Add();
                        DISCOUNT_LIST_NUM++;
                        System.out.println("DISCOUNT ADDED SUCESSFULLY ");
                        //System.out.println(DISCOUNTS_LIST.get(0).getDiscount_category());


                    }
                    else if(choice_of_discounts==4){
                        Menu();
                        break;
                    }
                    else if(choice_of_discounts== 2){
                        // modify discounts
                        System.out.println("enter discount name to modify");
                        String name_of_dis= sc1.nextLine();
                        for(int i=0; i< DISCOUNTS_LIST.size();i++){
                            if(DISCOUNTS_LIST.get(i).getDiscount_category().equals(name_of_dis)){
                                DISCOUNTS.discount_modifier_index=i;
                                System.out.println("1. discount category" + "\n2.discount percentage");
                                int modifier= sc1.nextInt();
                                sc1.nextLine();
                                if(modifier==1){
                                    System.out.println("enter new discount category");
                                    String new_discount_category= sc1.nextLine();
                                    DISCOUNTS modified_discount=new DISCOUNTS(new_discount_category,DISCOUNTS_LIST.get(i).getDiscount_percentage());
                                    modified_discount.Modify();
                                }
                                else if(modifier== 2){
                                    System.out.println("enter new discount percentage ");
                                    int new_discount_percentage= sc1.nextInt();
                                    DISCOUNTS modified_discount = new DISCOUNTS(DISCOUNTS_LIST.get(i).getDiscount_category(),new_discount_percentage);
                                    modified_discount.Modify();
                                }
                            }
                        }
                        System.out.println("Discount modified ");
                        //System.out.println(DISCOUNTS_LIST.get(0).getDiscount_category());
                    }
                    else if(choice_of_discounts== 3){
                        System.out.println("Enter name of discount to remove ");
                        String name_of_dis = sc1.nextLine();
                        for(int i=0; i< DISCOUNTS_LIST.size();i++){
                            if(DISCOUNTS_LIST.get(i).getDiscount_category().equals(name_of_dis)){
                                DISCOUNTS_LIST.get(i).Remove();
                                DISCOUNT_LIST_NUM--;
                                break;
                            }
                        }
                        System.out.println("Discount removed succesfully ");
                        //System.out.println(DISCOUNTS_LIST.get(0).getDiscount_category());


                    }

                }


            }
            else if(ch1==5){
                while(true) {
                    // set special deals
                    System.out.println("Enter \n1.ADD SPECIALS\n2.REMOVE SPECIALS 3. exit specials");
                    int choice_spl = sc1.nextInt();
                    sc1.nextLine();

                    if (choice_spl == 1) {
                        System.out.println(" percentage of spl ");
                        int percentage_spl = sc1.nextInt();
                        sc1.nextLine();
                        INT_SPL_DEALS.add(percentage_spl);
                        System.out.println(" condition of special ex- (2,3,4) tickets bought in order to avail special deals");
                        int spl_cond = sc1.nextInt();
                        sc1.nextLine();
                        WHEN_APPLICABLE_NUMBER.add(spl_cond);

                        System.out.println("added the deal succesfully ");
                        System.out.println( "deal applicale only when you buy "+ WHEN_APPLICABLE_NUMBER.get(0) +" tickets ");
                        System.out.println(INT_SPL_DEALS.get(0) +" is the percentage ");

                    } else if (choice_spl == 2) {
                        System.out.println("enter the condition for discount ex-2,3,4 tickets ");
                        int spl_cond = sc1.nextInt();
                        int index_given = WHEN_APPLICABLE_NUMBER.indexOf(spl_cond);

                        WHEN_APPLICABLE_NUMBER.remove(index_given);
                        INT_SPL_DEALS.remove(index_given);


                        System.out.println("special condition removed ");


                    }
                    else if ( choice_spl ==3){
                        Menu();
                        break;
                    }
                }

            }
            else if( ch1== 7){
                // view feedback
                for(int ijk=0; ijk<Visitors.VISITOR_LIST.size(); ijk++){
                    if(!(Visitors.VISITOR_LIST.get(ijk).getVis_feedback().equals("None"))){
                        System.out.println(Visitors.VISITOR_LIST.get(ijk).getVis_Name() +" has the feedback that "+ Visitors.VISITOR_LIST.get(ijk).getVis_feedback());



                    }
                }
            }
            else if( ch1== 6){
                // View visitor stats
                int Total_visitors= Visitors.VISITOR_LIST.size();
                System.out.println("Total vistors :"+ Total_visitors);
                int Total_revenue=0;

                for(int ij=0 ;ij<Visitors.VISITOR_LIST.size(); ij++){
                    if(Visitors.VISITOR_LIST.get(ij).getMembership().equals("premium")){
                        Total_revenue+= 50;
                    }
                    else if(Visitors.VISITOR_LIST.get(ij).getMembership().equals("basic")){
                        Total_revenue+=20;

                    }

                }
            }

            else if( ch1== 3){
                // schedule events
                System.out.println("Schedule events \n"+"1. open/close the specific attraction\n" +"2. set price of entry tickets ");
                int ch_of_events= sc1.nextInt();
                sc1.nextLine();
                if(ch_of_events== 1){
                    System.out.println("enter attraction name :   (if on entering the name it does not do anything press enter again , ignore if it does)  ");
                    String att_name = sc1.nextLine();

                    for(int var=0; var < ATTRACTION_LIST.size(); var++){
                        if(ATTRACTION_LIST.get(var).getAttraction_name().equals(att_name)){
                            //System.out.println("hello ");
                            if(ATTRACTION_LIST.get(var).isIs_open()){
                                System.out.println("Attraction is open Do you want to close it ?(Yes/No) ");
                                String answer = sc1.nextLine();
                                if(answer.equals("Yes")){
                                    ATTRACTION_LIST.get(var).setIs_open();
                                    //System.out.println(ATTRACTION_LIST.get(var).isIs_open());
                                }


                            }
                            else{
                                System.out.println("Attraction is closed do you want to open it ?(Yes/No) ");
                                String answer = sc1.nextLine();
                                if(answer.equals("Yes")){
                                    ATTRACTION_LIST.get(var).setIs_open();

                                    //System.out.println(ATTRACTION_LIST.get(var).isIs_open());
                                }

                            }
                            Menu();

                            break;


                        }
                    }

                }
                else if(ch_of_events ==2){
                    System.out.println("enter attraction name : ");
                    String att_name = sc1.nextLine();
                    System.out.println("enter the price to set : ");
                    int att_price= sc1.nextInt();
                    sc1.nextLine();
                    for(int var =0 ; var < ATTRACTION_LIST.size(); var++){
                        if(ATTRACTION_LIST.get(var).getAttraction_name().equals(att_name)){
                            ATTRACTION_LIST.get(var).setAttraction_price(att_price);
                            //System.out.println(ATTRACTION_LIST.get(var).getAttraction_price());


                        }
                    }

                    Menu();


                }

            }





        }
    }


}
