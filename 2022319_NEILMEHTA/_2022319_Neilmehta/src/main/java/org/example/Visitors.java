package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Visitors {
    static ArrayList<VisitorInfo> VISITOR_LIST= new ArrayList<>(100);
    static int VISITOR_LIST_NUM=0;
    Scanner sc2 = new Scanner(System.in);
    void RegeisterMenu(){
        System.out.println("enter Visitor name");
        String vis_name= sc2.nextLine();
        System.out.println("enter Visitor age : ");
        int vis_age = sc2.nextInt();
        sc2.nextLine();
        System.out.println(" enter Visitor phone number");
        long vis_pno = sc2.nextLong();
        sc2.nextLine();
        System.out.println("enter visitor balance ");
        int vis_balance = sc2.nextInt();
        sc2.nextLine();
        System.out.println("enter visitor email");
        String vis_email= sc2.nextLine();
        System.out.println("enter visitor password");
        String vis_pass= sc2.nextLine();

        VisitorInfo new_vis= new VisitorInfo(vis_email,vis_pass,vis_name,vis_balance,vis_age,vis_pno);
        VISITOR_LIST.add(new_vis);
        VISITOR_LIST_NUM++;

        System.out.println("REGISTRATION SUCCESSFULL");



    }
    void ExploreZoo(){
        while(true) {
            System.out.println("Explore the Zoo:\n" +
                    "1. View Attractions\n" +
                    "2. View Animals\n" +
                    "3. Exit\n");
            int ch_explore_zoo = sc2.nextInt();
            sc2.nextLine();
            if (ch_explore_zoo == 1) {
                System.out.println("ATTRACTIONS IN THE ZOO");
                for (int variable = 0; variable < Admin.ATTRACTION_LIST.size(); variable++) {
                    System.out.println((variable + 1) + ". " + Admin.ATTRACTION_LIST.get(variable).getAttraction_name());

                }
                System.out.println("enter the attraction you want to visit: ");
                int choice_of_att = sc2.nextInt();
                sc2.nextLine();
                System.out.println(Admin.ATTRACTION_LIST.get(choice_of_att - 1).getAttraction_descreption());
            } else if (ch_explore_zoo == 2) {
                System.out.println("Animals in the zoo :");
                for (int j = 0; j < Admin.ANIMAL_LIST.size(); j++) {
                    System.out.println("Animal number " + (j + 1));
                    System.out.println("Animal name : " + Admin.ANIMAL_LIST.get(j).getAName());
                    System.out.println("Animal Descreption " + Admin.ANIMAL_LIST.get(j).getDescreption());
                    System.out.println("Animal sound " + Admin.ANIMAL_LIST.get(j).getSound());
                    System.out.println("Animal type " + Admin.ANIMAL_LIST.get(j).getType());
                    System.out.println();


                }
            } else if (ch_explore_zoo == 3) {
                System.out.println("Exiting .........");
                break;
            }
        }


    }
    void BuyMembership(VisitorInfo current_visitor, int index){
        System.out.println("Buy Membership:\n" +
                "1. Basic Membership (₹20)\n" +
                "2. Premium Membership (₹50)\n");
        int Membership_choice = sc2.nextInt();
        sc2.nextLine();
        System.out.println("enter discount code ");
        String Discount_code= sc2.nextLine();
        if(Discount_code.equals("None")){
            if(Membership_choice==1){
                current_visitor.setMembership("basic");
                current_visitor.setVis_balance(current_visitor.getVis_balance()-20);
                VISITOR_LIST.set(index,current_visitor);
            }
            else if(Membership_choice ==2 ){
                current_visitor.setMembership("premium");
                current_visitor.setVis_balance(current_visitor.getVis_balance()-50);
                VISITOR_LIST.set(index,current_visitor);

            }
        }
        else{
            for(int j=0; j<Admin.DISCOUNTS_LIST.size(); j++){
                if(Admin.DISCOUNTS_LIST.get(j).getDiscount_category().equals(Discount_code)){
                    int discount_percent= Admin.DISCOUNTS_LIST.get(j).getDiscount_percentage();
                    if(Membership_choice== 1){
                        current_visitor.setMembership("Basic");
                        current_visitor.setVis_balance(current_visitor.getVis_balance()-(20- 20*(discount_percent)/100));
                        VISITOR_LIST.set(index,current_visitor);

                    }
                    else if(Membership_choice ==2 ){
                        current_visitor.setMembership("premium");
                        current_visitor.setVis_balance(current_visitor.getVis_balance()-(50- 50*(discount_percent)/100));
                        VISITOR_LIST.set(index,current_visitor);

                    }

                }
            }
        }
        System.out.println(VISITOR_LIST.get(index).getMembership()+"purchased and now your remaining balance is " + VISITOR_LIST.get(index).getVis_balance() );


    }
    void Buy_tickets(VisitorInfo current_visitor, int visitor_number){
        System.out.println("Buy Tickets:\n" +
                "Enter the number of tickets\n");
        int no_of_tickets= sc2.nextInt();
        sc2.nextLine();
        for(int iterator=0;iterator<no_of_tickets;iterator++){
            for(int i=0;i<Admin.ATTRACTION_LIST.size();i++){
                System.out.println((i+1)+". "+Admin.ATTRACTION_LIST.get(i).getAttraction_name()+ " rupees "+Admin.ATTRACTION_LIST.get(i).getAttraction_price());

            }
            int choice_of_tickets = sc2.nextInt();
            sc2.nextLine();
            current_visitor.setAttraction_tickets(choice_of_tickets-1);
            Admin.ATTRACTION_LIST.get(choice_of_tickets-1).setTicketed_visitors();
            current_visitor.setVis_balance(current_visitor.getVis_balance() - Admin.ATTRACTION_LIST.get(choice_of_tickets -1).getAttraction_price());
            VISITOR_LIST.set(visitor_number,current_visitor);
            System.out.println("ticket bought sucessfully your current balance is " + VISITOR_LIST.get(visitor_number).getVis_balance());




        }


    }
    void View_discounts(){
        for(int i=0; i< Admin.DISCOUNTS_LIST.size(); i++){
            System.out.print(i+1+" : ");
            System.out.println(Admin.DISCOUNTS_LIST.get(i).getDiscount_category()+"   " +Admin.DISCOUNTS_LIST.get(i).getDiscount_percentage()+" % :"+ Admin.DISCOUNTS_LIST.get(i).getDiscount_code() );

        }
    }

    void visit_animals(){
        System.out.println("Visit animals ");
        System.out.println("Choose the animals to visit");
        for(int ij=0 ;ij<Admin.ANIMAL_LIST.size(); ij++){
            System.out.println((ij+1) + " "+ Admin.ANIMAL_LIST.get(ij).getAName());

        }
        int which_animal= sc2.nextInt();
        sc2.nextLine();
        System.out.println("Animal name is " + Admin.ANIMAL_LIST.get(which_animal-1).getAName());
        System.out.print("1.Feed the animal \n2.Read about animal");
        int what_to_do = sc2.nextInt();
        sc2.nextLine();

        if(what_to_do== 1){
            System.out.println(Admin.ANIMAL_LIST.get(which_animal-1).getSound());
        }
        else if(what_to_do== 2){
            System.out.println(Admin.ANIMAL_LIST.get(which_animal-1).getDescreption());
        }




    }
    void visit_attractions(VisitorInfo current_visitor, int visitor_number){
        while(true){
            System.out.println("Select an attraction to visit");
            int var;
            for(var =0 ;var < Admin.ATTRACTION_LIST.size(); var++){
                System.out.println((var+1) + " "+ Admin.ATTRACTION_LIST.get(var).getAttraction_name());

            }
            System.out.println(var+1 + " EXIT");
            int choice_att= sc2.nextInt();
            sc2.nextLine();
            int Att_list_number = choice_att -1;
            if(current_visitor.getMembership().equals("premium")){
                System.out.println("thank you vor visiting " + Admin.ATTRACTION_LIST.get(choice_att-1).getAttraction_name());

            }
            else if(current_visitor.getMembership().equals("None")){
                System.out.println("pls buy basic membership");

            }
            else if(current_visitor.getMembership().equals("basic")){
                int ret_val = current_visitor.getAttraction_tickets(Att_list_number);
                if(ret_val== 1){
                    System.out.println("1 ticket used thank you for visiting");
                    current_visitor.removeAttraction_list(Att_list_number);
                    VISITOR_LIST.set(visitor_number,current_visitor);
                }
                else if(ret_val ==0){
                    System.out.println("you dont have the ticket please buy ticket first");
                }

            }
        }
    }
    void Login_menu(){
        System.out.println("Enter email :");
        String vis_email = sc2.nextLine();
        System.out.println("Enter visitor password");
        String vis_pass= sc2.nextLine();
        for(int i=0 ; i<VISITOR_LIST.size(); i++){
            if((VISITOR_LIST.get(i).getVis_email().equals(vis_email))  && VISITOR_LIST.get(i).getVis_pass().equals(vis_pass)  ){
                VisitorInfo current_visitor = VISITOR_LIST.get(i);
                System.out.println("Login succesful");
                System.out.println();
                while(true) {
                    System.out.println("Visitor Menu:\n" +
                            "1. Explore the Zoo\n" +
                            "2. Buy Membership\n" +
                            "3. Buy Tickets\n" +
                            "4. View Discounts\n" +
                            "5. View Special Deals\n" +
                            "6. Visit Animals\n" +
                            "7. Visit Attractions\n" +
                            "8. Leave Feedback\n" +
                            "9. Log Out\n");
                    int vis_choice = sc2.nextInt();
                    if (vis_choice == 1) {
                        ExploreZoo();

                    }
                    else if(vis_choice== 9){
                        break;
                    }
                    else if(vis_choice == 2){
                        BuyMembership(current_visitor,i);

                    }
                    else if(vis_choice== 3){
                        if(current_visitor.getMembership().equals("premium") || current_visitor.getMembership().equals("Premium")){
                            System.out.println("you have premium membership .. ");
                        }
                        else if(current_visitor.getMembership().equals("None")){
                            System.out.println("Pls buy a basic membership to purchase tickets sir ");
                        }
                        else if(current_visitor.getMembership().equals("basic") || current_visitor.getMembership().equals("Basic")){
                            Buy_tickets(current_visitor,i);


                        }

                    }
                    else if( vis_choice == 4){
                        View_discounts();
                        // view discount

                    }
                    else if( vis_choice == 8){
                        // Leave feedback

                        System.out.println("Leave feedback");
                        System.out.println("ENTER FEEDBACK : MAX 200 WORDS");
                        String feedback = sc2.nextLine();
                        sc2.nextLine();
                        current_visitor.setVis_feedback(feedback);
                    }
                    else if( vis_choice == 6){
                        // visit animals
                        visit_animals();
                    }
                    else if( vis_choice == 7){
                        visit_attractions(current_visitor,i);

                    }
                    else if( vis_choice ==5){
                        // the spl deal wont apply until you call this function
                        int percentage=0;
                        // View special deals
                        for(int rand_var=0; rand_var<Admin.WHEN_APPLICABLE_NUMBER.size(); rand_var++){
                            System.out.println("If you buy " + Admin.WHEN_APPLICABLE_NUMBER.get(rand_var) +" tickets then you will get "
                            + Admin.INT_SPL_DEALS.get(rand_var));
                            if(current_visitor.sizeOfAttractionTickets() == Admin.WHEN_APPLICABLE_NUMBER.get(rand_var)){
                                percentage= Admin.INT_SPL_DEALS.get(rand_var);


                            }
                        }
                        current_visitor.setSpl_deal_percentage(percentage);


                    }

                }

            }
        }
    }
}
