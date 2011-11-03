package hu.kazocsaba.math.matrix;

import hu.kazocsaba.math.matrix.backbone.Vector3Op;

/**
 *
 * @author Kazó Csaba
 */
class Vector3Impl extends VectorImpl implements Vector3 {

	public Vector3Impl() {
		super(3);
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
		return Vector3Op.toHomogeneous(this);
	}

	@Override
	public Vector3 cross(Vector3 v) {
		return Vector3Op.cross(this, v);
	}

	@Override
	public String toString() {
		return Vector3Op.toString(this);
	}

	@Override
	public Vector3 plus(Matrix m) {
		return (Vector3)Vector3Op.plus(this, m);
	}

	@Override
	public Vector3 minus(Matrix m) {
		return (Vector3)Vector3Op.minus(this, m);
	}

	@Override
	public Vector3 times(double c) {
		return (Vector3)Vector3Op.times(this, c);
	}

	@Override
	public Vector3 normalized() {
		return (Vector3)Vector3Op.normalized(this);
	}
}
