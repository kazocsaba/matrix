package hu.kazocsaba.math.matrix.backbone;

import hu.kazocsaba.math.matrix.Matrix2;
import hu.kazocsaba.math.matrix.SubmatrixAccessor2;
import hu.kazocsaba.math.matrix.Vector2;


class SubmatrixAccessor2Impl extends SubmatrixAccessorImpl implements SubmatrixAccessor2 {

	SubmatrixAccessor2Impl(Matrix2 matrix) {
		super(matrix);
	}

	@Override
	public Vector2 row(int index) {
		return (Vector2)super.row(index);
	}

	@Override
	public Vector2 column(int index) {
		return (Vector2)super.column(index);
	}

}
