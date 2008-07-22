package kcsaba.math.matrix;

/**
 * The singular value decomposition of a matrix.
 * @author Kazó Csaba
 */
public interface SingularValueDecomposition {
	/**
	 * Returns the left singular vectors.
	 * @return the left singular vectors
	 */
	public Matrix getU();
	
	/**
	 * Returns the right singular vectors.
	 * @return the right singular vectors
	 */
	public Matrix getV();
	
	/**
	 * Returns the diagonal matrix of singular values.
	 * @return the diagonal matrix of singular values
	 */
	public Matrix getS();
	
}
