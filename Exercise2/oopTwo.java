import java.util.Scanner;
class Dog{
    String name;
    String breed;
    Dog(){
        /*
         * default constructor
         */
    }
    Dog(String name, String breed){
        this.name = name;
        this.breed = breed;
    }
    void getter(){
        System.out.println("Name of dog: "+this.name);
        System.out.println("Breed Of Dog: "+this.breed);
    }
    void setter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the dog");
        this.name = sc.nextLine();
        System.out.println("Enter the breed of the dog");
        this.breed = sc.nextLine();
        sc.close();
    }
}
public class oopTwo {
   public static void main(String[] args){
        Dog dg = new Dog("amber","husky");
        dg.getter();
        dg.setter();
        dg.getter();
   }

}
