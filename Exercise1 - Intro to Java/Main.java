import java.util.Scanner;
import java.util.Arrays;
class Palindrome{
    String userInput;
    int[] arrInput;
    int cases=-1;
    Palindrome(){
        /*
            default constructor
         */
    }
    Palindrome(int[] param){
        arrInput = param;
        cases = 0;
    }
    Palindrome(String userInput){
        this.userInput = userInput;
        cases = 1;
    }
    public void getArr(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of parameters");
        int length = input.nextInt();
        input.nextLine();
        this.arrInput = new int[length];
        System.out.println("Enter the parameters: ");
        for(int i=0;i<this.arrInput.length;i++)
            this.arrInput[i] = input.nextInt();
        input.close();
        cases = 0;
    }
    public int[] reverseNumeric(){
        int[] revArr = new int[this.arrInput.length];
        for(int i=this.arrInput.length-1;i>=0; i--)
            revArr[(this.arrInput.length-1)-i] = this.arrInput[i];
        return revArr;
    }
    public boolean isPalindromeNumeric(){
        int[] revArr = reverseNumeric();
        return Arrays.equals(this.arrInput,revArr);
    }

    public String getString(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any string of choice: ");
        this.userInput = input.nextLine();
        input.close();
        cases = 1;
        return this.userInput;
    }
    public char[] reverse() {
        char[] arr = this.userInput.toCharArray();
        char[] revArr = new char[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            revArr[(arr.length - 1) - i] = arr[i];
        }
        return revArr;
    }
    public boolean isPalindrome(){
        char[] revArr = reverse();
        return Arrays.equals(revArr, this.userInput.toCharArray());
    }
    public void callAll(){
       switch(this.cases){
           case 0:
               if(isPalindromeNumeric())
                   System.out.println("the given array is a palindrome");
               else
                   System.out.println("the given array is not a palindrome");
               break;
           case 1:
               if(isPalindrome())
                   System.out.println("the given string is a palindrome");
               else
                   System.out.println("the given string is not a palindrome");
               break;
           default:
               System.out.println("The given parameters do not satisfy necessary test cases");
       }
    }
}

public class Main{
    public static void main(String[] args){
        //System.out.println("Hello world from intelliJ");
        Palindrome palindrome = new Palindrome();
        palindrome.getArr();
        palindrome.callAll();
    }
}
