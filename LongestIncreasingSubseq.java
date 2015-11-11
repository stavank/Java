//  Find the longest increasing subsequence
//  @uthor Stavan Karia
//  11/11/2015

  import java.util.*;
  
  
  public class LongestIncreasingSubseq{
    public static int LIS(int[] seq){
      int max = 0;
      int[] lis = new int[seq.length];
      // start with all sequences of length (the number itself)
      for(int k = 0; k < lis.length; k++)
        lis[k] = 1;

      // DP part of the algorithm  
      for (int i = 1; i < seq.length; i++){
        for (int j = 0; j < i; j++){
          if(seq[i] > seq[j] && lis[i] < lis[j]+1){
            lis[i] = lis[j] + 1;
          }
        }
      }
      for(int k = 0; k < lis.length; k++){
    	  if(max < lis[k]){  
          max = lis[k];
        }
      }
      return max;
    }
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      scanner.close();
      String[] inputArray = input.split(" ");
      int[] numbers = new int[inputArray.length];
      for(int i = 0; i < inputArray.length; i++){
        numbers[i] = Integer.parseInt(inputArray[i]);
      }
      
      int result = LIS(numbers); 
      System.out.println(result);
      
    }
  }
