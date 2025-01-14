package Business_logic_classes;

public class Doctor {
    private static int idcounter=1;
    private int id;
    private String name;
    private String speciality;
    public Doctor(String name,String speciality){

        this.id=idcounter++;
        this.name=name;
        this.speciality=speciality;
    }
    public int getId(){
        return id;
    }
    //override
    public String toString(){
        return "Doctor ID :" + id +",Name:"+ name +",Speciality :"+speciality;
    }

}
