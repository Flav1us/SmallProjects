package executorservice_matrix_mult;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import main.Matrix;

public class ESMatrixMult {

	public ESMatrixMult() {
		// TODO Auto-generated constructor stub
	}
	
	public static Matrix multiply(Matrix a, Matrix b) throws InterruptedException, ExecutionException {
		Matrix res = new Matrix(new int[a.values.length][b.values[0].length]);
		ExecutorService es = Executors.newFixedThreadPool(a.values.length); //свой поток для каждого столбца
		List<Future<int[]>> tasks = new LinkedList<Future<int[]>>(); 
		for(int i = 0; i < a.values.length; i++) {
			 tasks.add(es.submit(new RowCall(a, b, i)));
		}
		es.shutdown();
		/*System.out.println("mt sleep");
		Thread.sleep(995);
		System.out.println("mt awake");*/
		for(int i = 0; i < a.values.length; i++) {
			res.values[i] = tasks.iterator().next().get();
		}
		return res;	
	}

}
