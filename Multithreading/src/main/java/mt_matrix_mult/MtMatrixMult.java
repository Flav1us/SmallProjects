package mt_matrix_mult;

import main.Matrix;

public class MtMatrixMult {

	public MtMatrixMult() {
		// TODO Auto-generated constructor stub
	}

	public static Matrix multiply(Matrix a, Matrix b) {
		System.out.printf("%d, %d\n", a.values[0].length, b.values.length);
		assert(a.values[0].length == b.values.length);
		if(a.values[0].length == b.values.length) System.out.println(true);
		//assert values[0].length == b.values[0].length;
		Matrix M = new Matrix(new int[a.values.length][b.values[0].length]);
		System.out.printf("%d %d\n", a.values.length, M.values[0].length);
		for(int i = 0; i < M.values.length; i++) {
			new Thread(new RowCalculationThread(a, b, i, M.values[i])).start();
		}
		return M;
	}

}
