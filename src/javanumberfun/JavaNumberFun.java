package javanumberfun;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaNumberFun {

    // https://open.kattis.com/problems/numberfun
    // simple comparison program
    // accepted in kattis
    //
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numOfTests = GetInt(in);

        String[] ans = new String[numOfTests];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = OpPossibility(StringArray2IntArray(Line2StringArray(in),in));
        }

        PrintArray(ans);
    }// end main()

    private static void PrintArray(String[] arr) {
        for (String string : arr) {
            System.out.println(string);
        }
    }

    private static String OpPossibility(int[] arr) {
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if (a + b == c || (double)a / b == (double)c || a - b == c || a * b == c || 
                (double)b/a==(double)c || b-a==c) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }

    private static int[] StringArray2IntArray(String[] arr, Scanner input) {
        int[] res = new int[arr.length];
        try{
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(arr[i]);
            if(res[i]<1||res[i]>10000)
                throw new InputMismatchException();
        }
        return res;}catch(Exception e)
        {
            return StringArray2IntArray(Line2StringArray(input), input);
        }
    }

    private static String[] Line2StringArray(Scanner input) {
        String str = input.nextLine();
        String[] arr = str.split(" ", 3);
        return arr;
    }

    private static int GetInt(Scanner input) {
        try {
            int res = Integer.parseInt(input.nextLine());
            if (res < 1 || res > 10000) {
                throw new InputMismatchException();
            }
            return res;
        } catch (Exception e) {
            return GetInt(input);
        }
    }
}
