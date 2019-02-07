package main;

public class Matrix {

	public int[][] values;

	public Matrix(int[][] values) {
		this.values = values;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < values.length; i++) {
			for(int j = 0; j < values[0].length; j++) {
				sb.append(values[i][j]).append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
