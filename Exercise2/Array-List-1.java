import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class arrayListImpl{
    ArrayList<String> animeNames;
    ArrayList<Integer> releaseDates;
    int size;
    arrayListImpl(){
        /* 
         * default constructor
         */
        this.animeNames = new ArrayList<String>();
        this.releaseDates = new ArrayList<Integer>();
    }
    arrayListImpl(ArrayList<String>animeNames, ArrayList<Integer>releaseDates){
        this.animeNames = new ArrayList<String>();
        this.releaseDates = new ArrayList<Integer>();
        this.animeNames = animeNames;
        this.releaseDates = releaseDates;

    }
    void append(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        this.size = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the anime names and their corresponding release dates");
        for( int i = 0; i<this.size; i++){
            this.animeNames.add(sc.nextLine());
            this.releaseDates.add(sc.nextInt());
            sc.nextLine();
        }
        sc.close();
        
    }
    void accessElement(int index){
        if(index >= this.size){
            System.out.println("Exit code error");
            return;
        }
        System.out.println("The anime name is: "+animeNames.get(index));
        System.out.println("The respective release date is: "+releaseDates.get(index));
    }
    void accessString(){
        for (String i : animeNames)
            System.out.println(i);
    }
    void accessAll(){
        System.out.print("Anime: \t\t Release Dates:");
        for( int i = 0; i < this.size; i++)
            System.out.println(animeNames.get(i) + "\t\t" + releaseDates.get(i));
    }
}

public class arrayList_q1{
    public static void main(String[] args){        
        arrayListImpl example = new arrayListImpl();
        example.append();
        example.accessElement(0);
    }
}
