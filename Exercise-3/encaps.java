import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.StringBuffer;

class Car{
	private String company_name;
	private String model_name;
	private int year;
	private double mileage;
	Car(){
		/*
		   default constructor;
		*/
	}
	private Car(String company_name, String model_name, int year,double mileage){
	   this.company_name = company_name;
	   this.model_name = model_name;
	   this.year = year;
	   this.mileage = mileage;
	}
	public void setter(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to modify class values?");
		String choice = sc.nextLine();
		switch(choice){
		   case "yes":
		   	this.company_name = sc.nextLine();
			this.model_name = sc.nextLine();
			this.year = sc.nextInt();
			sc.nextLine();
			break;
		  case "no" : System.out.println("Exit function");
		}
		sc.close();
		
	}
	public void getter(){
		System.out.println("Car model: "+this.company_name);
		System.out.println("Car company: "+ this.model_name);
		System.out.println("Car release date: "+ this.year);
		System.out.println("Car mileage: "+this.mileage);

	}
	public static void main(String[] args){
		Car f1 = new Car("A series","mercedes",2019,3000.4);
		f1.getter();
	}
}
public class encaps{
	public static void main(String[] args){
		Car.main(args);

	}
}
