import java.util.Arrays;
import java.util.stream.Collectors;

public class Generics {
    public static <T> void printArray(T[] val) {

        for(T t :val){
            System.out.println(t);
        }
    }
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1,2,3};
        printArray(numbers);
        String[] strings = new String[]{"Hello","World"};
        printArray(strings);
    }
}
