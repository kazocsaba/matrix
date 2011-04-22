package kcsaba.math.matrix.backbone;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.Matrix2;
import kcsaba.math.matrix.Matrix3;
import kcsaba.math.matrix.Vector;
import kcsaba.math.matrix.Vector2;
import kcsaba.math.matrix.Vector3;
import kcsaba.math.matrix.Vector4;

/**
 * Helper class which checks that a specific matrix instance has the correct type.
 * @author Kazó Csaba
 */
class TypeChecker {
	private TypeChecker() {}
	public static boolean check(Matrix m) {
		if (m.getColumnCount() == 1) {
			switch (m.getRowCount()) {
				case 2:
					return m instanceof Vector2;
				case 3:
					return m instanceof Vector3;
				case 4:
					return m instanceof Vector4;
				default:
					return m instanceof Vector;
			}
		} else {
			if (m.getRowCount() == 2 && m.getColumnCount() == 2) return m instanceof Matrix2;
			if (m.getRowCount() == 3 && m.getColumnCount() == 3) return m instanceof Matrix3;
			return true;
		}
	}
}
