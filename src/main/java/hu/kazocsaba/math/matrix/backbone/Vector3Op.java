package hu.kazocsaba.math.matrix.backbone;

import hu.kazocsaba.math.matrix.MatrixFactory;
import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.Vector3;
import hu.kazocsaba.math.matrix.Vector4;

/**
 * Implementations of the Vector3 functions for the benefit of Vector subclasses. These methods rely on the
 * {@link Matrix#get(int, int)}, {@link Matrix#set(int, int, double)}, {@link Matrix#getRowCount()}, and
 * {@link Matrix#getColumnCount()} functions, so all others can delegate to this class.
 * @author Kazó Csaba
 */
public final class Vector3Op extends VectorOp {
	private Vector3Op() {}
	
	/**
	 * @see Vector3#cross(Vector3)
	 */
	public static Vector3 cross(Vector3 caller, Vector3 v) {
		return MatrixFactory.createVector(
				caller.getY() * v.getZ() - caller.getZ() * v.getY(),
				caller.getZ() * v.getX() - caller.getX() * v.getZ(),
				caller.getX() * v.getY() - caller.getY() * v.getX());
	}

	/**
	 * @see Vector3#toHomogeneous
	 */
	public static Vector4 toHomogeneous(Vector3 caller) {
		return MatrixFactory.createVector(caller.getX(), caller.getY(), caller.getZ(), 1);
	}
}
