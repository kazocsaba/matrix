package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.SubmatrixAccessor3;

/**
 * Provides access to submatrix views of 2x2 immutable matrices. The views themselves are also immutable.
 *
 * @author Kazó Csaba
 */
public class ImmutableSubmatrixViewAccessor3 extends ImmutableSubmatrixViewAccessor implements SubmatrixAccessor3 {

	ImmutableSubmatrixViewAccessor3(ImmutableMatrix3 matrix) {
		super(matrix);
	}

	@Override
	public ImmutableVector3 row(int index) {
		return (ImmutableVector3)super.row(index);
	}

	@Override
	public ImmutableVector3 column(int index) {
		return (ImmutableVector3)super.column(index);
	}

}
