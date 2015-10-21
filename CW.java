public class CW
{
  public static void main(String[] args)
  {
    int[][] multi1 = { {1,2,3},
                       {4,5,6},
                       {7,8,9} };
    int[][] multi2 = { {1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12},
                       {13,14,15,16} };
    int[][] multi3 = { {1,2,3,4,5},
                       {6,7,8,9,10},
                       {11,12,13,14,15},
                       {16,17,18,19,20},
                       {21,22,23,24,25} };    
    printMulti(multi1);
    printMultiCW(multi1);
    printMulti(multi2);
    printMultiCW(multi2);
    printMulti(multi3);
    printMultiCW(multi3);
  }

  public static void printMulti(int[][] multi)
  {
    for (int i = 0; i < multi.length; i++) {
      for (int j = 0; j < multi[i].length; j++) {
        System.out.printf("%3d", multi[i][j]);
      }
      System.out.println();
    }
  }

  public static void printMultiCW(int[][] multi)
  {
    //0 = going right
    //1 = going down
    //2 = going left
    //3 = going up
    int state = 0;
    int rightBound = multi[0].length-1;
    int downBound = multi.length-1;
    int leftBound = 0;
    int upperBound = 0;

    //now lets print it cw
    while (!stopCondition(rightBound, downBound, leftBound, upperBound)) {
      switch (state) {
        case 0:
          int i0 = upperBound;
          for (int j0 = leftBound; j0 <= rightBound; j0++) {
            System.out.print(multi[i0][j0] + " ");
          }
          upperBound++;
          break;
        case 1:
          int j1 = rightBound;
          for (int i1 = upperBound; i1 <= downBound; i1++) {
            System.out.print(multi[i1][j1] + " ");
          }
          rightBound--;
          break;
        case 2:
          int i2 = downBound;
          for (int j2 = rightBound; j2 >= leftBound; j2--) {
            System.out.print(multi[i2][j2] + " ");
          } 
          downBound--;
          break;
        case 3:
          int j3 = leftBound;
          for (int i3 = downBound; i3 >= upperBound; i3--) {
            System.out.print(multi[i3][j3] + " ");
          }
          leftBound++;
          break;
      }
      state = (state + 1) % 4;
    }
    System.out.println();
  }

  public static boolean stopCondition(int r, int d, int l, int u)
  {
    if (r - l == -1)
      return true; 
    return false;
  }
}
