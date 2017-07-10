/**
 * write by lee
 */
import java.util.Arrays;

public class lifeOfgame {
	public static void main(String[] args) {
		int row = 0;
		row = 31;
		int col = 80;
		int[][] arr = new int[31][80];
		int[][] counter = new int[33][82];
		for (int i = 3; i < 77; i++) {
			arr[15][i] = 1;
		}
		String ANSI_CLS = "\u001b[2J";
		lifeOfgame obj = new lifeOfgame();
		while(true) {
		    //显示更新后得细胞存活状态
	        obj.display(arr, row, col);
			//统计周围8个细胞存活数
	        obj.count(arr, row, col, counter);
             //更新array
	        obj.update(arr, row, col, counter);

            //重置周围细胞存活数
	        for (int i = 0; i < row + 2; i++)
	        	Arrays.fill(counter[i], 0);

            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println(ANSI_CLS);
            System.out.flush();
        }
	}
	
	/**
	 * 计算细胞周围存活数
	 * @param arr
	 * @param row
	 * @param col
	 * @param counter
	 */
	public void count(int[][] arr, int row, int col, int[][] counter) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(arr[i][j] == 1){
					counter[i][j] += 1;
					counter[i][j+1] += 1;
					counter[i][j+2] += 1;
					counter[i+1][j] += 1;
					counter[i+1][j+2] += 1;
					counter[i+2][j] += 1;
					counter[i+2][j+1] += 1;
					counter[i+2][j+2] += 1;
				}
			}
		}
	}
	
	/**
	 * 更新细胞生命状态
	 * @param arr
	 * @param row
	 * @param col
	 * @param counter
	 */
	public void update(int[][] arr, int row, int col, int[][] counter) {
		for(int i = 1; i < row+1; i ++){
			for (int j = 1; j < col + 1; j++) {
				if(counter[i][j]<2 || counter[i][j] > 3){
					arr[i-1][j-1] = 0;
				}else if (counter[i][j] == 3) {
					arr[i-1][j-1] = 1;
				}
			}
		}
	}
	
	/**
	 * 更新显示细胞生命状态
	 * @param arr
	 * @param row
	 * @param col
	 */
	public void display(int[][] arr, int row, int col) {
		System.out.println("-------------------------------------------------------------------------------");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if(arr[i][j] == 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
                if (j == col - 1) System.out.println();
            }
        System.out.println("------------------------------------end---------------------------------------\n");
	}
}
