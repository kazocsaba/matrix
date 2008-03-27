
package kcsaba.math.matrix;

/**
 *
 * @author Kazó Csaba
 */
public class MatrixFactory {
	private MatrixFactory() {}
	
	public static Matrix createMatrix(int rows, int cols) {
		if (cols==1)
			return createVector(rows);
		else
			return new Matrix(rows, cols);
	}
	
	public static Vector createVector(int dim) {
		switch (dim) {
			case 3: return createVector3();
			case 4: return createVector4();
			default: return new Vector(dim);
		}
	}

	public static Vector4 createVector4() {
		return new Vector4();
	}

	public static Vector4 createVector4(double x, double y, double z, double h) {
		return new Vector4(x, y, z, h);
	}

	public static Vector3 createVector3() {
		return new Vector3();
	}
	
	public static Vector3 createVector3(double x, double y, double z) {
		return new Vector3(x, y, z);
	}
	
}
