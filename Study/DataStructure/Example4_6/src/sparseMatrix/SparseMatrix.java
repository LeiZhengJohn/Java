package sparseMatrix;

public class SparseMatrix {
	public TripleNode[] data;
	public int rows;
	public int cols;
	public int nums;

	public SparseMatrix(int maxSize){
		data = new TripleNode[maxSize];
		for (int i = 0; i < data.length; i++) {
			data[i] = new TripleNode();
		}
		rows = 0;
		cols = 0;
		nums = 0;
	}

	public static int[][] parseToShuzu(int r,int c,String[] s){
		int[][] matrix = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				matrix[i][j] = 0;
			}
		}
		for (int i = 0; i < s.length; i++) {
			String[] str = s[i].split(",|£¬");
			int[] temp = {Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2])};
			if(temp[0] < r && temp[1] < c) {
				matrix[temp[0]][temp[1]] = temp[2];
			}else {
				return null;
			}		
		}
		return matrix;
	}
	
	public int[][] parseToShuzu(SparseMatrix m){
		int[][] matrix = new int[m.rows][m.cols];
		for (int i = 0; i < m.rows; i++) {
			for (int j = 0; j < m.cols; j++) {
				matrix[i][j] = 0;
			}
		}
		for (int i = 0; i < m.data.length; i++) {
			matrix[m.data[i].row][m.data[i].column]	 = m.data[i].value;
		}
		return matrix;
	}

	public SparseMatrix(int mat[][]){
		int i = 0;
		int j = 0;
		int k = 0;
		int count = 0;
		rows = mat.length;
		cols = mat[0].length;
		for (i = 0; i < mat.length; i++) {
			for (j = 0; j < mat[i].length; j++) {
				if(mat[i][j] != 0){
					count++;
				}
			}
		}
		nums = count;
		data = new TripleNode[nums];
		for (i = 0; i < mat.length; i++) {
			for (j = 0; j < mat[i].length; j++) {
				if(mat[i][j] != 0){
					data[k] = new TripleNode(i,j,mat[i][j]);
					k++;
				}
			}
		}
	}

	public SparseMatrix fastTranspose(){
		SparseMatrix tm = new SparseMatrix(nums);
		tm.cols = this.rows;
		tm.rows = this.cols;
		tm.nums = this.nums;
		int i = 0;
		int j = 0;
		int k = 0;
		int num[],cpot[];
		if(nums > 0){
			num = new int[cols];
			cpot = new int[cols];
			for (i = 0; i < cols; i++) {
				num[i] = 0;
			}
			for (i = 0; i < nums; i++) {
				j = data[i].column;
				num[j]++;
			}
			cpot[0] = 0;
			for (i = 1; i < cols; i++) {
				cpot[i] = cpot[i - 1] + num[i - 1];
			}
			for (i = 0; i < nums; i++) {
				j = data[i].column;
				k = cpot[j];
				tm.data[k].row = data[i].column;
				tm.data[k].column = data[i].row;
				tm.data[k].value = data[i].value;
				cpot[j]++;
			}
		}
		return tm;
	}
}
