package org.example;

import java.util.ArrayList;

public class VisitorInfo {
    private String vis_email;
    private String vis_pass;
    private String vis_Name;
    private int vis_balance;
    private int vis_age;
    private long vis_pno;

    private String vis_feedback;

    private String membership= "None";

    private int spl_deal_percentage = 0;

    private ArrayList<Integer> attraction_tickets = new ArrayList<>(100);



    public VisitorInfo(String vis_email,String vis_pass,String vis_Name, int vis_balance,int vis_age, long vis_pno) {
        this.vis_Name=vis_Name;
        this.vis_email = vis_email;
        this.vis_age=vis_age;
        this.vis_balance=vis_balance;
        this.vis_pno=vis_pno;
        this.vis_pass=vis_pass;

    }

    public String getVis_email() {
        return vis_email;
    }

    public void setVis_email(String vis_email) {
        this.vis_email = vis_email;
    }

    public String getVis_pass() {
        return vis_pass;
    }

    public void setVis_pass(String vis_pass) {
        this.vis_pass = vis_pass;
    }

    public String getVis_Name() {
        return vis_Name;
    }

    public void setVis_Name(String vis_Name) {
        this.vis_Name = vis_Name;
    }

    public int getVis_balance() {
        return vis_balance;
    }

    public void setVis_balance(int vis_balance) {
        this.vis_balance = vis_balance;
    }

    public int getVis_age() {
        return vis_age;
    }

    public void setVis_age(int vis_age) {
        this.vis_age = vis_age;
    }

    public long getVis_pno() {
        return vis_pno;
    }

    public void setVis_pno(long vis_pno) {
        this.vis_pno = vis_pno;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }


    public void setAttraction_tickets(int attraction_index){
        this.attraction_tickets.add(attraction_index);

    }

    public void removeAttraction_tickets(int attraction_index){
        for(int i=0; i< this.attraction_tickets.size();i++){
            if(this.attraction_tickets.get(i) == attraction_index){
                this.attraction_tickets.remove(i);
            }
        }
    }
    public int getAttraction_tickets( int att_no){
        for(int i=0;i<this.attraction_tickets.size();i++){
            if(this.attraction_tickets.get(i)== att_no){
                return 1;
            }
        }
        return 0;
    }

    public void removeAttraction_list( int att_no){
        for(int i=0;i<this.attraction_tickets.size(); i++){
            if(this.attraction_tickets.get(i) == att_no){
                this.attraction_tickets.remove(i);
                break;
            }
        }
    }
    public int sizeOfAttractionTickets(){
        return this.attraction_tickets.size();

    }

    public String getVis_feedback() {
        return vis_feedback;
    }

    public void setVis_feedback(String vis_feedback) {
        this.vis_feedback = vis_feedback;
    }

    public int getSpl_deal_percentage() {
        return spl_deal_percentage;
    }

    public void setSpl_deal_percentage(int spl_deal_percentage) {
        this.spl_deal_percentage = spl_deal_percentage;
    }

    public void apply_spl_deal_percentage(){
        int tot_cost=0;
        if(this.getMembership().equals("basic")){
            for(int i=0; i< this.attraction_tickets.size(); i++){
                tot_cost+= Admin.ATTRACTION_LIST.get(this.attraction_tickets.get(i)).getAttraction_price();

            }
            this.setVis_balance( this.getVis_balance() + (tot_cost*(spl_deal_percentage))/100);
            System.out.println(" you have been refunded "  + (tot_cost*(spl_deal_percentage))/100);

        }


    }
}
