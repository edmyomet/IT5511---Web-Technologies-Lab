import java.util.Scanner;
import java.util.Arrays;
import java.lang.Integer;

class Armstrong{
    int[] array;
    Armstrong(){
        /*
        default constructor, no purpose as of yet
         */
    }
    Armstrong(int[] array){
        this.array = new int[array.length];
        this.array = array;
    }
    public void getArr(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of parameters: ");
        int length = input.nextInt();
        input.nextLine();
        this.array = new int[length];
        System.out.println("Enter the parameters: ");
        for(int i=0;i<this.array.length;i++)
            this.array[i] = input.nextInt();
        input.close();
    }
    public int  calculateSum(){
        int sum = 0;
        for (int j : this.array) {
            sum += (int) Math.pow(j, this.array.length);
        }
        return sum;
    }
    public int arrayToNum(){
        int num = 0;
        int i = this.array.length;
        for(int j : this.array){
            num += j * (int)Math.pow(10,i-1);
            i--;
        }
        return num;
    }
    public boolean isArmstrong(){
        int newNum = arrayToNum();
        int checkNum = calculateSum();
        return newNum== checkNum;
    }
    public void callAll(){
        if(isArmstrong())
            System.out.println("the given array of numbers form an armstrong number");
        else
            System.out.println("the given array of numbers do not form an armstrong number");
    }
}

public class ArmstrongMainClass{
    public static void main(String[] args){
        int[] arr = {1,4,9};
        Armstrong armstrong = new Armstrong(arr);
        //armstrong.getArr();
        armstrong.callAll();
    }
}
