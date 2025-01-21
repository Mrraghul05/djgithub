import java.io.*;
class EmployeeManagement implements Serializable{
    private int id;
    private String position;
    private String name;
    private int salary;
    public EmployeeManagement(int id,String position,String name,int salary){
        this.id=id;
        this.position=position;
        this.name=name;
        this.salary=salary;
    }
    public void display(){
        System.out.println("id :"+id);
        System.out.println("position :"+position);
        System.out.println("name :"+name);
        System.out.println("salary :"+salary);
    }
}

public class Serialize {
    public static void main(String[] args){
        EmployeeManagement emp=new EmployeeManagement(001,"HR","Raghul",50000);

        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Employee.txt"))){
            oos.writeObject(emp);
            System.out.println("serialaze sucess");
        }catch(Exception e){
            System.out.println("fail to serialize"+e.getMessage());
        }
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Employee.txt"))){
            EmployeeManagement deserialize=(EmployeeManagement) ois.readObject();
            System.out.println("deserialize sucess");
            deserialize.display();
        }catch(Exception e){
            System.out.println("fail to deserialize"+e.getMessage());
        }
    }
}
