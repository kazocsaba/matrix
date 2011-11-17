package hu.kazocsaba.math.matrix;

/**
 * The eigenvectors and eigenvalues of a matrix. It provides the eigenvector-eigenvalue pairs in
 * descending order of the real part of the eigenvalues.
 * @author Kazó Csaba
 */
public interface EigenDecomposition {
	/**
	 * Returns the number of eigenvectors and eigenvalues. This is equal to the size of the original square matrix.
	 * @return the number of eigenvectors and eigenvalues
	 */
	public int size();
	
	/**
	 * Returns the real part of an eigenvalue.
	 * @param index the index of the eigenvalue to return
	 * @return the real part of an eigenvalue
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	public double getEigenvalue(int index);
	
	/**
	 * Returns the imaginary part of an eigenvalue.
	 * @param index the index of the eigenvalue to return
	 * @return the imaginary part of an eigenvalue
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	public double getEigenvalueIm(int index);
	
	/**
	 * Returns the eigenvector corresponding to the 'index'-th eigenvalue.
	 * @param index the index of the eigenvector to return
	 * @return an eigenvector
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	public Vector getEigenvector(int index);
}
