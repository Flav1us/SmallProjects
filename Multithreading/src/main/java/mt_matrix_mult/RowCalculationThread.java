package mt_matrix_mult;

import main.Matrix;

public class RowCalculationThread implements Runnable {
	Matrix a, b;
	int col;
	int[] res;

	public RowCalculationThread(Matrix a, Matrix b, int col, int[] res) {
		super();
		this.a = a;
		this.b = b;
		this.col = col;
		this.res = res;
	}

	public void run() {
		System.out.println("thread run");
		for(int j = 0; j < b.values[0].length; j++) {
			for(int t = 0; t < b.values.length; t++) {
				res[j] += a.values[col][t]*b.values[t][j];
			}
		}
	}

}
