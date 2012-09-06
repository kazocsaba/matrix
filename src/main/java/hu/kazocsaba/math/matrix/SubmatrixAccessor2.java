package hu.kazocsaba.math.matrix;

/**
 * Provides strongly typed access to submatrices of a 2x2 matrix. The exact semantics of the accessor methods depend
 * on the implementation.
 *
 * @author Kazó Csaba
 */
public interface SubmatrixAccessor2 extends SubmatrixAccessor {
	@Override
	public Vector2 row(int index);
	@Override
	public Vector2 column(int index);
}
