// Find the number of ways a which a bot can go fro point a to point b
// a bot can take 1, 2 , 3 steps only

import java.util.*;

public class BotNumOfWays{
  public static int numOfWays(int dist){
    if (dist == 0){
      return 0;
    }
    int[] solution = new int[dist+1];
    solution[1] = 1;
    if (dist>=2)
        solution[2] = 1 + solution[1];
    if (dist>=3)
        solution[3] = 1 + solution[2] + solution[1];
    if (dist >= 4){
      for(int i = 4; i <= dist; i++){
        solution[i] = solution[i-1] + solution[i-2] + solution[i-3];
      }
    }
    return solution[dist];
  }
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int distance = Integer.parseInt(scanner.nextLine());
    int ways = numOfWays(distance);
    System.out.println(ways);
  }
}
