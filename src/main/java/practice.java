import java.util.*;
import java.util.stream.Collectors;

public class practice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(10);
        Optional<Integer> min = list.stream().min(Integer::compare).get().describeConstable();
        Optional<Integer> max1 = list.stream().max(Integer::compare).get().describeConstable();
        //  OptionalInt max = list.stream().mapToInt(list::get).max().;
        System.out.println("==========================solution===================");
        System.out.println(min);
        System.out.println(max1);



        // swapping the key as value
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"hello");
        map.put(2,"bye");

        Map<String, Integer> swappedMap = map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        swappedMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        // reverse traversal of map
        Map<Integer,String> map1 = new HashMap<Integer,String>();
        map1.put(1,"hello");
        map1.put(2,"bye");
        Set<Integer> integers = map1.keySet();
        int setsize  = integers.size();

        for(int i=setsize; i>0 ; i--){
            System.out.println(map1.get(i));
        }


        // array to list
        int[] array = new int[]{10,12,31,56,87};
        List<Integer> collect = Arrays.stream(array).boxed().toList();
        for (int i: collect) {
            System.out.print(i+" ");
        }


        // array list find an element
        List <Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(100);
        list2.add(10);
        list2.add(21);
        Integer i = list2.stream().filter(integer -> integer == 100).findAny().orElse(-1);
        System.out.println(" ");
        System.out.println("find an element "+i );

        //
    }
}
