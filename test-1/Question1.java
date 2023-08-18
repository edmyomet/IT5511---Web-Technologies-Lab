import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Integer;

class checkDuplicates{
    int[] arr;
    checkDuplicates(){
        /*
         * default constructor
         */
    }
    checkDuplicates(int[] arr){
        this.arr = new int[arr.length];
        this.arr = arr;
    }
    public void getArr(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the # of parameters ");
        int length = sc.nextInt();
        sc.nextLine();
        this.arr = new int[length];
        //sc.nextLine();
        System.out.println("enter the parameters");
        for( int i = 0; i< length; i++){
            this.arr[i] = sc.nextInt();
        }
        sc.close();

    }
    public int returnLength(){
        int count = 0;
        for( int i=0;i<this.arr.length; i++){
            if(this.arr[i] == -1)
                continue;
            for(int j = i+1; j < this.arr.length; j ++){
                if(this.arr[i] == this.arr[j]){
                    arr[j] = -1;
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(this.arr));
        return this.arr.length - count;
    }
    public void callAll(){
        System.out.println("the length after removing all duplicates is: " + returnLength());
    }
}
class checkSum{
    int[] checkArr;
    int sum = 0;
    checkSum(){
        /*
         * default contructor
         */
    }
    checkSum(int [] checkArr){
        this.checkArr = new int[checkArr.length];
        this.checkArr = checkArr;
    }
    public void getAll(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the # of parameters:");
        int length = sc.nextInt();
        sc.nextLine();
        this.checkArr = new int[length];
        for(int i = 0; i< length; i++)
            this.checkArr[i] = sc.nextInt();
        sc.close();
    }
    public int getSum(){
        for( int i : this.checkArr){
            if( i % 10 == 0)
                this.sum += i;
        }
        return this.sum;
    }
    public boolean isSumThirty(){
        this.sum = getSum();
        return this.sum == 30 || this.sum == 40 || this.sum ==50 || this.sum ==60;
    }
    public void callAll(){
        if(isSumThirty()){
            System.out.println("Test case passed, the sum is: " + this.sum);
        }
        else{
            System.out.println("Test case was not passed, the sum is: " + this.sum);
        }
    }
}
public class Main{
    public static void sum2(){
        int arr[] = {50,50,20,10};
        checkSum cs = new checkSum(arr);
        cs.callAll();
    }
    public static void sum1(){
        checkDuplicates cd = new checkDuplicates();
        cd.getArr();
        cd.callAll();
    }
    public static void main(String[] args){
        //sum1();
        sum2();
    }
}
