import java.util.*;
class Radix{
    public static void main(String args[]){
        Integer[] arr = {1, 4, 2, 3};
        List<List<Integer>> al = new ArrayList<>();
        int max = Collections.max(Arrays.asList(arr));
        int d=0;
        for(int i=0;i<10;i++){
            al.add(new ArrayList<>());
        }
        while(max!=0){
            d++;
            max/=10;
        }
        for(int i=0;i<d;i++){
            for(int j=0;j<arr.length;j++){
                int temp = arr[j]/(int) Math.pow(10,i);
                al.get(temp%10).add(arr[j]);
            }
            int a = 0;
            for(int j=0;j<arr.length;j++){
                for(int k=0;k<al.get(j).size();k++){
                    arr[a++] = al.get(j).get(k);
                }
                al.remove(j);
                al.add(new ArrayList<>());
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}