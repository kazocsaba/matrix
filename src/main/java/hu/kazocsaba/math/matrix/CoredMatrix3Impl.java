package hu.kazocsaba.math.matrix;

/**
 *
 * @author Kazó Csaba
 */
class CoredMatrix3Impl extends CoredMatrixImpl implements Matrix3 {
	CoredMatrix3Impl(MatrixCore core) {
		super(core);
	}

	@Override
	public Vector3 mul(Vector3 v) {
		return (Vector3)super.mul(v);
	}

	@Override
	public Matrix3 mul(Matrix3 m) {
		return (Matrix3)super.mul(m);
	}

	@Override
	public Matrix3 transpose() {
		return (Matrix3)super.transpose();
	}

	@Override
	public Matrix3 transposedView() {
		return (Matrix3)super.transposedView();
	}

	@Override
	public Matrix3 plus(Matrix m) {
		return (Matrix3)super.plus(m);
	}

	@Override
	public Matrix3 minus(Matrix m) {
		return (Matrix3)super.minus(m);
	}

	@Override
	public Matrix3 times(double c) {
		return (Matrix3)super.times(c);
	}

	@Override
	public Matrix3 inverse() throws SingularityException {
		return (Matrix3)super.inverse();
	}

	@Override
	public Matrix3 normalized() {
		return (Matrix3)super.normalized();
	}
}
