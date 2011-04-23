package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.Vector3;
import kcsaba.math.matrix.Vector4;
import kcsaba.math.matrix.backbone.Vector3Op;

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
		return getCoord(0);
	}

	@Override
	public double getY() {
		return getCoord(1);
	}

	@Override
	public double getZ() {
		return getCoord(2);
	}

	@Override
	public void setX(double value) {
		setCoord(0, value);
	}

	@Override
	public void setY(double value) {
		setCoord(1, value);
	}

	@Override
	public void setZ(double value) {
		setCoord(2, value);
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
}
