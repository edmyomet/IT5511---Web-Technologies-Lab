class Person{
    String name;
    int age;
    Person(){
        /*
        default constructor
         */
    }
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void print(){
        System.out.println("This Person's name is: "+this.name);
        System.out.println("This Person's age is: "+ this.age );
    }
}
public class oopOne {
    public static void main(String[] args){
        Person p1 = new Person("Shruthi",19);
        Person p2 = new Person("neelabh",21);
        p1.print();
        p2.print();
    }
}
