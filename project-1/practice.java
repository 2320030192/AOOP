import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        
        Scanner sobj = new Scanner(System.in);
        
        int a[];

        int b[];

        System.out.print("\n Enter size of an array - ");

        int n = sobj.nextInt();

        a = new int[n];

        b = new int [a.length];   

        b = a;

        b[0]++;

        System.out.println("\n Enter any " + n + " elements ");

        for (int i = 0; i<n ; i++)
               a[i] = sobj.nextInt();
        

        System.out.println("\n Elements in array 'a' are  ");

        for (int i = 0; i<n ; i++)
        {
            System.out.print("\n Element number " + i + " is - " + a[i] );
        }

        System.out.println("\n\n Elements in array 'b' are  ");

        for (int i = 0; i<n ; i++)
        {
            System.out.print("\n\n Element number " + i + " is - " + b[i] );
        }

        sobj.close();

    }
    
}