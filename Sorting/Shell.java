import java.util.*;
class Shell {
    public static void main(String args[]){
        int[] arr = {1,4,2,3};
        int gap = 2;
        for(int i=gap;i<arr.length;i++){
            int temp=arr[i];
            int j=i-gap;
            while(j>=0 && arr[j]>temp){
                arr[j+gap]=arr[j];
                j-=gap;
            }
            arr[j+gap]=temp;
        }
    }
}