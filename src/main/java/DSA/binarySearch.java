package DSA;


public class binarySearch {
    public static int search(int arr[] ,int value){
        int start = 0;
        int end = arr.length-1;
        boolean asc = false;

        if (arr[start]<arr[end]){
            asc = true;
        }
            while (start <= end) {
                int mid = (start + end) / 2;
                if (asc) {
                if (value > arr[mid]) {
                    start = mid + 1;
                } else if (value < arr[mid]) {
                    end = mid - 1;
                } else {
                    return mid;
                }
               }
                else {
                    if (value > arr[mid]){
                        end = mid - 1;
                    }
                     else if (value < arr[mid]) {
                       start = mid +1;
                     }
                     else {
                      return mid;
                      }
                }
            }
        return -1;
    }
    public static boolean SortValidation(int[] arrays, int length){
        if (length == 1 || length == 0)
            return true;

        return arrays[length - 1] >= arrays[length - 2] && SortValidation(arrays, length - 1);
    }
    public static void main(String[] args) {
        int arr[] =new int[]{10,20,0,40,50};
        int length = arr.length-1;
//        int result = search(arr, 31);
        boolean result = SortValidation(arr,length);
        System.out.println(result);

    }
}
