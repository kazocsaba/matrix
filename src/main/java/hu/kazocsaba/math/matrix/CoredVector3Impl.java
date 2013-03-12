package hu.kazocsaba.math.matrix;

import hu.kazocsaba.math.matrix.backbone.Vector3Op;

/**
 *
 * @author Kazó Csaba
 */
class CoredVector3Impl extends CoredVectorImpl implements Vector3 {
	CoredVector3Impl(MatrixCore core) {
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
	public Vector4 toHomogeneous() {
		return (Vector4)Vector3Op.toHomogeneous(this);
	}

	@Override
	public Vector2 fromHomogeneous() {
		return (Vector2)Vector3Op.fromHomogeneous(this);
	}

	@Override
	public Vector3 cross(Vector3 v) {
		return Vector3Op.cross(this, v);
	}

	@Override
	public Vector3 plus(Matrix m) {
		return (Vector3)super.plus(m);
	}

	@Override
	public Vector3 minus(Matrix m) {
		return (Vector3)super.minus(m);
	}

	@Override
	public Vector3 times(double c) {
		return (Vector3)super.times(c);
	}

	@Override
	public Vector3 normalized() {
		return (Vector3)super.normalized();
	}
}
