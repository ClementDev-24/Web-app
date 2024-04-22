package Map;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mapSolution {
    public static void main(String[] args) {
        Map<String, Integer> map =new HashMap<String, Integer>();
        Scanner sc =new Scanner(System.in);
        int data = sc.nextInt();
        sc.nextLine();
        for(int i =0 ; i<data ;i++){
            String name = sc.nextLine();
            int number = sc.nextInt();
            map.put(name,number);
            sc.nextLine();
        }
        while(sc.hasNext()){
            String name = sc.nextLine();
            if (map.containsKey(name)){
                System.out.println(name +"="+map.get(name));
            }
            else {
                System.out.println("Not found");
            }
        }
        }
    }


