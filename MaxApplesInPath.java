// Find maximum apples that can be collected in a path in a 2d matrix from top left corner to bottom right corner of matrix
// from 0, 0 to length-1, length-1
// given input matrix {{10,10,1},{1,10,31},{1,10,1}}
// @uthor Stavan Karia
// 11/11/2015

public class MaxApplesInPath{
  public static int maxOfTwo(int a, int b){
    return a > b ? a : b;
  }
  public static int getMaxApples(int[][] matrix){
    int[][] Sum = new int[matrix.length][matrix[0].length];
    int prevCol,prevRow;
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[0].length; j++){
        prevCol = 0;
        prevRow = 0;
        if(j>0){
          prevCol = Sum[i][j-1];
        }
        if(i>0){
          prevRow = Sum[i-1][j];
        }
        Sum[i][j] = matrix[i][j] + maxOfTwo(prevRow,prevCol);
      }
    }
    return Sum[matrix.length-1][matrix[0].length-1];
  }
  public static void main(String[] args){
  int [][] matrix = {{10,10,1},{1,10,31},{1,10,1}};
  int result = getMaxApples(matrix);
  System.out.println(result);
  }
}
