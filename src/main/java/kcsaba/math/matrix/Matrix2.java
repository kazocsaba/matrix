package kcsaba.math.matrix;

/**
 * A 3x3 matrix.
 * @author Kazó Csaba
 */
public interface Matrix2 extends Matrix {
	/**
	 * Multiplies this matrix with the argument and returns the result.
	 * @param v a vector
	 * @return the product of this matrix and the vector
	 * @throws NullPointerException if the argument is null
	 */
	public Vector2 mul(Vector2 v);
	/**
	 * Multiplies this matrix with the argument and returns the result.
	 * @param m a matrix
	 * @return the product of this matrix and the argument
	 * @throws NullPointerException if the argument is null
	 */
	public Matrix2 mul(Matrix2 m);
	
	@Override
	public Matrix2 transpose();
	@Override
	public Matrix2 plus(Matrix m);
	@Override
	public Matrix2 minus(Matrix m);
	@Override
	public Matrix2 times(double c);
	@Override
	public Matrix2 inverse() throws SingularityException;
	@Override
	public Matrix2 normalized();
}
