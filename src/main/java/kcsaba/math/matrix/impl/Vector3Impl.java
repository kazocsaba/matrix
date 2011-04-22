package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Vector3;
import kcsaba.math.matrix.Vector4;
import kcsaba.math.matrix.backbone.Vector3Op;
import kcsaba.math.matrix.backbone.VectorOp;

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
	public Vector4 toHomogeneous() {
		return Vector3Op.toHomogeneous(this);
	}

	@Override
	public Vector3 cross(Vector3 v) {
		return Vector3Op.cross(this, v);
	}

	@Override
	public String toString() {
		return VectorOp.toString(this);
	}
}
