package org.example;

public class DISCOUNTS implements Manage{
    private String discount_category;
    private int discount_percentage;
    private String discount_code;

    static int discount_modifier_index;


    public DISCOUNTS(String discount_category,int discount_percentage) {
        this.discount_category = discount_category;
        this.discount_percentage=discount_percentage;

        this.discount_code= discount_category.toUpperCase() + discount_percentage;

    }

    public String getDiscount_category() {
        return discount_category;
    }

    public void setDiscount_category(String discount_category) {
        this.discount_category = discount_category;
    }

    public int getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(int discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public void Add(){
        Admin.DISCOUNTS_LIST.add(this);



    }

    public void View(){

    }
    public void Modify(){
        Admin.DISCOUNTS_LIST.set(discount_modifier_index,this);




    }
    public void Remove(){
        Admin.DISCOUNTS_LIST.remove(this);


    }


    static void Display_to_admin(){
        System.out.println("Set Discounts:\n" +
                "1. Add Discount\n" +
                "2. Modify Discount\n" +
                "3. Remove Discount\n" +
                "4. Exit\n");
    }

    public String getDiscount_code() {
        return discount_code;
    }

    public void setDiscount_code(String discount_code) {
        this.discount_code = discount_code;
    }
}
