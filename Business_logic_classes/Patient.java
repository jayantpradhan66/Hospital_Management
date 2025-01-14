package Business_logic_classes;

public class Patient {
    // no outside member can access directly
    private static int idcounter=1;
    private int id;
    private String name;
    private String gender;
    private int age;
    private String address;
    //using constructor public person can access from patient class indirectly
    public Patient(String name ,String gender,int age  , String address){
        this.id=idcounter++;
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.address=address;

    }
    public int getId(){
        return id;
    }
    //overwrite
    public String toString(){
        return "Patient id :" + id + ",Name: " + name + ", Gender:" + gender + ",Age:" + age + ",Address:" + address ;
    }



}
