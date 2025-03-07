package BS;
//the brute force solution of this problem would be a simple linear search.
public class LowerBound {
    public static void main(String[] args){
        int[] arr = {1,2,2,3,4,5,6,7,8,9,9,9,10,10,12};
        int k =11;
        System.out.println(ans(arr,k));
    }
    static int ans(int[] arr, int k){
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] >= k){
                 ans = mid;
                 //there can be repetition
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;

        /*
        while (start < end) {
            int mid = same as above

            if (arr[mid] >= k)
                end = mid;
            else
                start = mid + 1;
        }

        return start;
         */
    }
}
