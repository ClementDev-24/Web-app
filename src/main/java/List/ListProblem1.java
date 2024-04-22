package List;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ListProblem1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Size of the List");
        int size = sc.nextInt();

        List<Integer> list = new ArrayList<Integer>();
        for(int i=0 ; i<size; i++){
           int value = sc.nextInt();
           list.add(value);
        }
        System.out.println("Number of operations");
        int operation = sc.nextInt();
        for (int i = 0 ; i< operation;i++){
            System.out.println("Type Insert for insert operation");
            System.out.println("Type Delete for delete operation");
            String operationToDo= sc.next();
            if (Objects.equals(operationToDo, "Insert")){
                int index= sc.nextInt();
                int newValue = sc.nextInt();
                if (index<list.size()) {
                    list.add(index, newValue);
                    list.forEach(System.out::print);
                }
                else {
                    System.out.println("ERROR!");
                }
            } else if (Objects.equals(operationToDo,"Delete")) {
                int deleteIndex =0;
                if (deleteIndex<list.size()) {
                    list.remove(deleteIndex);
                }
                else {
                    System.out.println("ERROR!");
                }
            }
        }
    }
}
