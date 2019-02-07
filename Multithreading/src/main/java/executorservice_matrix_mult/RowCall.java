package executorservice_matrix_mult;

import java.util.concurrent.Callable;

import main.Matrix;

public class RowCall implements Callable<int[]> {

	Matrix a, b;
	int col;
	
	public RowCall(Matrix a, Matrix b, int col) {
		this.a = a;
		this.b = b;
		this.col = col;
	}

	public int[] call() {
		//System.out.println("thread run");
		int[] res = new int[b.values[0].length];
		for(int j = 0; j < b.values[0].length; j++) {
			for(int t = 0; t < b.values.length; t++) {
				res[j] += a.values[col][t]*b.values[t][j];
			}
		}
		return res;
	}

}
