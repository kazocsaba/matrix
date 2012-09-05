package hu.kazocsaba.math.matrix;

/**
 *
 * @author Kazó Csaba
 */
class CoredVector4Impl extends CoredVectorImpl implements Vector4 {
	CoredVector4Impl(MatrixCore core) {
		super(core);
	}

	@Override
	public double getX() {
		return getCoordQuick(0);
	}

	@Override
	public double getY() {
		return getCoordQuick(1);
	}

	@Override
	public double getZ() {
		return getCoordQuick(2);
	}

	@Override
	public double getH() {
		return getCoordQuick(3);
	}

	@Override
	public void setX(double value) {
		setCoordQuick(0, value);
	}

	@Override
	public void setY(double value) {
		setCoordQuick(1, value);
	}

	@Override
	public void setZ(double value) {
		setCoordQuick(2, value);
	}

	@Override
	public void setH(double value) {
		setCoordQuick(3, value);
	}

	@Override
	public Vector4 plus(Matrix m) {
		return (Vector4)super.plus(m);
	}

	@Override
	public Vector4 minus(Matrix m) {
		return (Vector4)super.minus(m);
	}

	@Override
	public Vector4 times(double c) {
		return (Vector4)super.times(c);
	}

	@Override
	public Vector4 normalized() {
		return (Vector4)super.normalized();
	}
}
