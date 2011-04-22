package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.MatrixFactory;
import kcsaba.math.matrix.Vector3;
import kcsaba.math.matrix.Vector4;

/**
 *
 * @author Kazó Csaba
 */
class Vector3Impl extends VectorImpl<Vector3> implements Vector3 {

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
	public Vector4 toHomogen() {
		return MatrixFactory.createVector4(getX(), getY(), getZ(), 1);
	}

	@Override
	public Vector3 cross(Vector3 v) {
		return MatrixFactory.createVector3(
				getY() * v.getZ() - getZ() * v.getY(),
				getZ() * v.getX() - getX() * v.getZ(),
				getX() * v.getY() - getY() * v.getX());
	}

	@Override
	public String toString() {
		return String.format("(%f; %f; %f)", getX(), getY(), getZ());
	}
}
