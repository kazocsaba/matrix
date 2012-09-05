package hu.kazocsaba.math.matrix;

/**
 *
 * @author Kazó Csaba
 */
class CoredVector2Impl extends CoredVectorImpl implements Vector2 {
	CoredVector2Impl(MatrixCore core) {
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
	public void setX(double value) {
		setCoordQuick(0, value);
	}

	@Override
	public void setY(double value) {
		setCoordQuick(1, value);
	}

	@Override
	public Vector2 plus(Matrix m) {
		return (Vector2)super.plus(m);
	}

	@Override
	public Vector2 minus(Matrix m) {
		return (Vector2)super.minus(m);
	}

	@Override
	public Vector2 times(double c) {
		return (Vector2)super.times(c);
	}

	@Override
	public Vector2 normalized() {
		return (Vector2)super.normalized();
	}
}
