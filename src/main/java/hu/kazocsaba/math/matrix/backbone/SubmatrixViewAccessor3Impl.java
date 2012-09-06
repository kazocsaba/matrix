package hu.kazocsaba.math.matrix.backbone;

import hu.kazocsaba.math.matrix.Matrix3;
import hu.kazocsaba.math.matrix.SubmatrixAccessor3;
import hu.kazocsaba.math.matrix.Vector3;


class SubmatrixViewAccessor3Impl extends SubmatrixViewAccessorImpl implements SubmatrixAccessor3 {

	SubmatrixViewAccessor3Impl(Matrix3 matrix) {
		super(matrix);
	}

	@Override
	public Vector3 row(int index) {
		return (Vector3)super.row(index);
	}

	@Override
	public Vector3 column(int index) {
		return (Vector3)super.column(index);
	}

}
