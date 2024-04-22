package Set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class hashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val  = sc.nextInt();
        String[] pairLeft = new String[val];
        String[] pairRight = new String[val];
        for (int i = 0 ; i<val ; i++){
               pairLeft[i]= sc.next();
               pairRight[i]= sc.next();
        }
        Set<String> set = new HashSet();
        for(int i=0; i<val ; i++){
            set.add(pairLeft[i]+pairRight[i]);
            System.out.println(set.size());
        }
    }
}
