package hu.kazocsaba.math.matrix;

/**
 * Provides strongly typed access to submatrices of a 3x3 matrix. The exact semantics of the accessor methods depend
 * on the implementation.
 *
 * @author Kazó Csaba
 */
public interface SubmatrixAccessor3 extends SubmatrixAccessor {
	@Override
	public Vector3 row(int index);
	@Override
	public Vector3 column(int index);
}
