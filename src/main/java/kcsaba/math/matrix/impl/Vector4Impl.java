package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Vector4;

/**
 *
 * @author Kazó Csaba
 */
class Vector4Impl extends VectorImpl<Vector4> implements Vector4 {

	public Vector4Impl() {
		super(4);
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
	public double getH() {
		return getCoord(3);
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
	public void setH(double value) {
		setCoord(3, value);
	}
	
	@Override
	public String toString() {
		return String.format("(%f; %f; %f; %f)", getX(), getY(), getZ(), getH());
	}
}
