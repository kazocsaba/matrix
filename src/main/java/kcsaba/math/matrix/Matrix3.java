package kcsaba.math.matrix;

/**
 * A 3x3 matrix.
 * @author Kazó Csaba
 */
public interface Matrix3 extends Matrix<Matrix3> {
	@Override
	public Matrix3 transpose();
	/**
	 * Multiplies this matrix with the argument and returns the result.
	 * @param v a vector
	 * @return the product of this matrix and the vector
	 * @throws NullPointerException if the argument is null
	 */
	public Vector3 mul(Vector3 v);
	/**
	 * Multiplies this matrix with the argument and returns the result.
	 * @param m a matrix
	 * @return the product of this matrix and the argument
	 * @throws NullPointerException if the argument is null
	 */
	public Matrix3 mul(Matrix3 m);
}
