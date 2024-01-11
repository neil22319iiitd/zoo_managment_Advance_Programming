package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Welcome to Zootopia !!");
//        System.out.println();
//        System.out.println("1. Enter as admin");
//        System.out.println("2. Enter as visitor");
//        System.out.println("3. View special deals ");

        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("Welcome to ZOOtopia!\n" +
                    "\n" +
                    "1. Enter as Admin\n" +
                    "2. Enter as a Visitor\n" +
                    "3. View Special Deals\n");

            int choice= sc.nextInt();
            sc.nextLine();
            if(choice==1){
                System.out.println("enter username and password");
                String username= sc.nextLine();
                String password= sc.nextLine();
                if(username.equals(Admin.username )&& password.equals(Admin.password)){
                    Admin.Welcome();
                    Admin.Menu();
                    Admin new_Admin = new Admin();
                    new_Admin.choice_ask();



                }
                else{
                    System.out.println("wrong id or password");
                }


            }
            else if(choice == 2) {
                while (true) {
                    System.out.println("1. Register\n" +
                            "2. Login\n"+ "3.Exit");
                    int choice_to_users = sc.nextInt();
                    sc.nextLine();
                    if (choice_to_users == 1) {
                        Visitors new_visitor_register = new Visitors();
                        new_visitor_register.RegeisterMenu();


                    }
                    else if( choice_to_users == 2){
                        Visitors new_vistor_login = new Visitors();
                        new_vistor_login.Login_menu();

                    }
                    else{
                        System.out.println("Login/ failed terminated .....");
                        break;
                    }

                }
            }
            else if(choice ==4){
                System.out.println("thank you \nvisit again please.......");
                break;
            }

        }


    }
}
