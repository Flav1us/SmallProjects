package main;

import java.util.concurrent.ExecutionException;

import executorservice_matrix_mult.ESMatrixMult;
import mt_matrix_mult.MtMatrixMult;
import mt_matrix_mult.TestArray;

public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[][] a_v = {{1, 1},{1, 1},{1, 1},{1, 1}};
		int[][] b_v = {{1, 4, 1, 1}, {1, 1, 4, 1}};
		Matrix c = ESMatrixMult.multiply(new Matrix(a_v), new Matrix(b_v));
		System.out.println(c.toString());
		
		
	}

	private static void mt_matrix_mul() throws InterruptedException {
		int[][] a_v = {{1},{1}};
		int[][] b_v = {{1, 1}};
		Matrix c = MtMatrixMult.multiply(new Matrix(a_v), new Matrix(b_v));
		Thread.sleep(100);
		System.out.println(c.toString());
	}

	private static void testArrays() {
		int[] arr = {0, 0, 0};
		new TestArray(arr).inc();;
		System.out.println(arr[0] + "\t test");
	}
}
