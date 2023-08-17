import java.util.Scanner;
import java.util.Arrays;
import java.lang.Integer;
class FibonacciSeries{
    int[] arrFib;
    FibonacciSeries(){
        /*
        default constructor
         */
    }
    FibonacciSeries(int[] arrFib){
        this.arrFib = new int[arrFib.length];
        this.arrFib = arrFib;
    }

    public void getArr(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of parameters: ");
        int length = input.nextInt();
        input.nextLine();
        this.arrFib = new int[length];
        System.out.println("Enter the parameters: ");
        for(int i=0;i<this.arrFib.length;i++)
            this.arrFib[i] = input.nextInt();
        input.close();
    }
    public int[] fibonacciGen(){
        // function to generate a series of fibonacci numbers
        int temp1 = 0, temp2 = 1, limit = this.arrFib.length;
        int[] tempArr = new int[this.arrFib.length];
        for(int i = 0;i < this.arrFib.length; i++) {
            tempArr[i] = temp1 + temp2;
            temp2 = temp1;
            temp1 = tempArr[i];
        }
        return tempArr;
    }
    public boolean isFibSeries(){
        return Arrays.equals(fibonacciGen(),this.arrFib);
    }
    public void callAll(){
        if(isFibSeries())
            System.out.println("The array of numbers forms a fibonacci series");
        else
            System.out.println("the array of numbers do not form a fibonacci series");
    }
}
public class FibonacciSeriesMain{
    public static void main(String[] args){
        FibonacciSeries fibonacci = new FibonacciSeries();
        fibonacci.getArr();
        fibonacci.callAll();
    }
}