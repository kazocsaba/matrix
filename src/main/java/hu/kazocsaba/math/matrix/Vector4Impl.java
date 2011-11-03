package hu.kazocsaba.math.matrix;

import hu.kazocsaba.math.matrix.backbone.VectorOp;

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
