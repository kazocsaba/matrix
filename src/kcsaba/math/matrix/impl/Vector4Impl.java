package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.MatrixFactory;
import kcsaba.math.matrix.Vector4;

/**
 *
 * @author Kazó Csaba
 */
class Vector4Impl extends VectorImpl implements Vector4 {

	public Vector4Impl() {
		super(4);
	}

	public double getX() {
		return getCoord(0);
	}

	public double getY() {
		return getCoord(1);
	}

	public double getZ() {
		return getCoord(2);
	}

	public double getH() {
		return getCoord(3);
	}

	public void setX(double value) {
		setCoord(0, value);
	}

	public void setY(double value) {
		setCoord(1, value);
	}

	public void setZ(double value) {
		setCoord(2, value);
	}

	public void setH(double value) {
		setCoord(3, value);
	}
	
	@Override
	public String toString() {
		return String.format("(%f; %f; %f; %f)", getX(), getY(), getZ(), getH());
	}

	public Vector4 plusVec(Vector4 v) {
		return MatrixFactory.createVector4(getX() + v.getX(), getY() + v.getY(), getZ() + v.getZ(), getH() + v.getH());
	}

	public Vector4 minusVec(Vector4 v) {
		return MatrixFactory.createVector4(getX() - v.getX(), getY() - v.getY(), getZ() - v.getZ(), getH() - v.getH());
	}
}
