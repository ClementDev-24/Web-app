package List;

import java.util.ArrayList;
import java.util.List;

public class ListProblems {

    public void indexFinder(int list , int index){
        List<Integer> line1 = new ArrayList<Integer>();
        List<Integer> line2 = new ArrayList<Integer>();
        List<Integer> line3 = new ArrayList<Integer>();
        List<Integer> line5 = new ArrayList<Integer>();
        line1.add(41);
        line1.add(77);
        line1.add(74);
        line1.add(22);
        line1.add(44);
        line2.add(12);
        line3.add(37);
        line3.add(34);
        line3.add(36);
        line3.add(52);
        line5.add(20);
        line5.add(22);
        line5.add(33);
        int value = 0;
        if (list!=4){
            if (list == 1){
                if (index<line1.size()) {
                    value = line1.get(index - 1);
                    System.out.println(value);
                }
                else {
                    System.out.println("ERROR!");
                }

            } else if (list == 2) {
                if (index<line2.size()) {
                    value = line2.get(index - 1);
                    System.out.println(value);
                }else {
                    System.out.println("ERROR!");
                }
            } else if (list == 3) {
                if (index<line3.size()) {
                    value = line3.get(index - 1);
                    System.out.println(value);
                }
                else {
                    System.out.println("ERROR!");
                }
            } else if (list == 5) {
                if (index<line5.size()) {
                    value = line5.get(index - 1);
                    System.out.println(value);
                }
                else {
                    System.out.println("ERROR!");
                }
                }
        }
        else {
            System.out.println("ERROR!");
        }
    }
    public static void main(String[] args) {
        ListProblems listProblems = new ListProblems();
        listProblems.indexFinder(5,2);
    }
}
