package aed;

import java.util.Scanner;

public class Entregable4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        if(equivalentStrings(a,b)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }

    static boolean equivalentStrings(String a, String b){

        if(a.length() == 1){
            return a.equals(b);
        }
        if(a.equals(b)) return true;
        if(a.length() % 2 == 1) return false;
        if(b.length() % 2 == 1) return false;
        int amid = a.length() / 2;
        int bmid = b.length() / 2;
        String a1 = a.substring(0, amid);
        String b1 = b.substring(0, bmid);
        String a2 = a.substring(amid);
        String b2 = b.substring(bmid);
        //if(a1.equals(b1) && a2.equals(b2)) return true;
        //if(a1.equals(b2) && a2.equals(b1)) return true;

        if ((equivalentStrings(a1, b2) && equivalentStrings(a2, b1)) || (equivalentStrings(a1, b1) && equivalentStrings(a2, b2) )  ) {
            return true;
        }
        else return false;
        }
}
