package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.Vector4;
import kcsaba.math.matrix.backbone.VectorOp;

/**
 *
 * @author Kazó Csaba
 */
class Vector4Impl extends VectorImpl implements Vector4 {

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
		return VectorOp.toString(this);
	}

	@Override
	public Vector4 plus(Matrix m) {
		return (Vector4)VectorOp.plus(this, m);
	}

	@Override
	public Vector4 minus(Matrix m) {
		return (Vector4)VectorOp.minus(this, m);
	}

	@Override
	public Vector4 times(double c) {
		return (Vector4)VectorOp.times(this, c);
	}

	@Override
	public Vector4 normalized() {
		return (Vector4)VectorOp.normalized(this);
	}
}
