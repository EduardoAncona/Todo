package ancona.todo;

/**
 * Created by HP18 on 27/05/2015.
 */
public class Car {
    private String make;
    private String year;
    private  int icon;
    private  String condition;

    public  Car(String make,String year,int icon, String condition){
        super();
        this.make=make;
        this.year=year;
        this.icon=icon;
        this.condition=condition;



    }



    public  String getMake(){
        return make;
    }

    public  String getYear(){
        return year;
    }

    public  int getIcon(){
        return icon;
    }
    public String getCondition(){
        return condition;
    }
}
