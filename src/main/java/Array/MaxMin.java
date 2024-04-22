package Array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxMin {
    public static void main(String[] args) {
        int arr[] = new int[5];
        arr[0] = 21;
        arr[1] = 59;
        arr[2] = 65;
        arr[3] = 15;
        arr[4] = 84;
        int arr1[] = new int[]{20, 31, 84, 25, 95, 65, 25};
        int result = Arrays.stream(arr).max().getAsInt();
        int result1 = Arrays.stream(arr).min().getAsInt();
        System.out.println(result);
        System.out.println(result1);


        // comparing to array for matching items

        System.out.println("comparing to array for matching items");
        List<Integer> result2 = Arrays.stream(arr).boxed().filter(integer -> Arrays.stream(arr1).anyMatch(value -> value == integer)).collect(Collectors.toList());
        for (int re : result2) {
            System.out.println(re);
        }
        // sorting an array
        int[] array = Arrays.stream(arr).sorted().toArray();
        System.out.println("sorting an array");
        System.out.println(Arrays.toString(array));

        //sorting array in descending
        int[] array3 = IntStream.range(1, arr.length).map(value -> arr.length - 1).toArray();
        System.out.println("sorting array in descending");
        System.out.println(Arrays.toString(array3));
        //remove duplicates in an array


        System.out.println("adding two Integer arrays");
        // adding two arrays
        int concatIntArray[] = IntStream.concat(Arrays.stream(arr), Arrays.stream(arr1)).toArray();
        for (int res : concatIntArray) {
            System.out.println(res);
        }


        String[] array1 = {"apple", "banana", "orange"};
        String[] array2 = {"grape", "kiwi", "melon"};

        //adding two string array
        System.out.println("adding two string array");
        String[] mergedArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(String[]::new);
        for (String res1 : mergedArray) {
            System.out.println(res1);
        }


        // adding the first element of an array and first element of second array
        System.out.println(" The addition of first element in both the array ");
        String s = Arrays.stream(array1).findFirst().orElse("hello") + Arrays.stream(array2).findFirst().orElse("hello");
        System.out.println(s);


        // adding the first element of an array and last element of second array
        System.out.println("adding the first element of an array and last element of second array");
        String s3 = Arrays.stream(array1).findFirst().orElse("hello") + Arrays.stream(array2).reduce((s1, s2) -> s2).orElse("bye");
        System.out.println(s3);


        // total count in both the array
        System.out.println("the count of values inside the array");
        long l = Arrays.stream(array1).count() + Arrays.stream(array2).count();
        System.out.println(l);


        // combine first half and the second half of another array
        int midPoint = arr.length / 2;

        // Combine the first half of array1 with the second half of array2
        Object[] combinedArray = IntStream.range(0, arr.length / 2).mapToObj(value -> arr[value]).toArray();

        combinedArray = Arrays.copyOf(combinedArray, combinedArray.length + array2.length - midPoint);
        System.arraycopy(array2, midPoint, combinedArray, combinedArray.length - array2.length + midPoint, array2.length - midPoint);
        // Print the result
        System.out.println(Arrays.toString(combinedArray));


        // adding the number of an array
        System.out.println("adding the number of an array");
        int sumOfSingleArray = Arrays.stream(arr).sum();
        System.out.println(sumOfSingleArray);

        // multiplying the number of an array
        System.out.println("multiplying the number of an array");
        OptionalInt multiplyOfSingleArray = Arrays.stream(arr).reduce((left, right) -> left * right);
        System.out.println(multiplyOfSingleArray.getAsInt());


    }

}
