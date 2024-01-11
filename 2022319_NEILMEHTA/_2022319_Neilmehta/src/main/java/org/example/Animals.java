package org.example;

public class Animals  implements Manage{
    private String Aname;
    private String type;
    private String descreption;
    private String sound;

    static int varying_variable;

    public Animals(String Aname , String type , String descreption , String sound) {
        this.descreption = descreption;
        this.Aname=Aname;
        this.sound=sound;
        this.type=type;

    }


    public String getAName() {
        return Aname;
    }

    public void setAName(String Aname) {
        this.Aname = Aname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }



    @Override
    public void Add(){
        Admin.ANIMAL_LIST.add(this);

        if(this.type.equals("mammal")){
            Admin.MAMMAL_LIST.add(this);
            Admin.MAMMAL_LIST_NUM++;


        }
        else if(this.type.equals("amphibian")){
            Admin.AMPHIBIAN_LIST.add(this);
            Admin.AMPHIBIAN_LIST_NUM++;
        }
        else if(this.type.equals("reptile")){
            Admin.REPTILES_LIST.add(this);
            Admin.REPTILES_LIST_NUM++;
        }


        System.out.println("animal succesfully added");

    }

    @Override
    public void View(){
        System.out.println("hello");


    }
    @Override
    public void Modify(){
        Admin.ANIMAL_LIST.set(varying_variable,this);

    }
    @Override
    public void Remove(){
        Admin.ANIMAL_LIST.remove(this);
        System.out.println("succesfully removed");

    }

    static void prinatble(){
        System.out.println("Manage Animals:\n" +
                "1. Add Animal\n" +
                "2. Update Animal Details\n" +
                "3. Remove Animal\n" +
                "4. Exit\n");
    }


}
