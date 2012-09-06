package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.SubmatrixAccessor2;

/**
 * Provides access to submatrix views of 2x2 immutable matrices. The views themselves are also immutable.
 *
 * @author Kazó Csaba
 */
public class ImmutableSubmatrixViewAccessor2 extends ImmutableSubmatrixViewAccessor implements SubmatrixAccessor2 {

	ImmutableSubmatrixViewAccessor2(ImmutableMatrix2 matrix) {
		super(matrix);
	}

	@Override
	public ImmutableVector2 row(int index) {
		return (ImmutableVector2)super.row(index);
	}

	@Override
	public ImmutableVector2 column(int index) {
		return (ImmutableVector2)super.column(index);
	}

}
