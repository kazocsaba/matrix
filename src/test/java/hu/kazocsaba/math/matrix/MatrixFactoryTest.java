package hu.kazocsaba.math.matrix;

import hu.kazocsaba.math.matrix.Matrix3;
import hu.kazocsaba.math.matrix.Vector3;
import hu.kazocsaba.math.matrix.Vector4;
import hu.kazocsaba.math.matrix.MatrixFactory;
import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.Vector2;
import hu.kazocsaba.math.matrix.Vector;
import hu.kazocsaba.math.matrix.Matrix2;
import java.util.HashSet;
import java.util.Set;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kazó Csaba
 */
public class MatrixFactoryTest {

	private static Set<Matrix> instances;

	private Class<? extends Matrix> getClassFor(int rows, int cols) {
		if (cols==1) {
			switch (rows) {
				case 2: return Vector2.class;
				case 3: return Vector3.class;
				case 4: return Vector4.class;
				default: return Vector.class;
			}
		} else if (rows==2 && cols==2)
			return Matrix2.class;
		else if (rows==3 && cols==3)
			return Matrix3.class;
		else
			return Matrix.class;
	}
	@BeforeClass
	public static void setUp() {
		instances=new HashSet<Matrix>();
		for (int rows=1; rows<=5; rows++) for (int cols=1; cols<=5; cols++) {
			Matrix m=MatrixFactory.createMatrix(rows, cols);
			assertTrue(rows==m.getRowCount() && cols==m.getColumnCount());
			instances.add(m);
		}
	}
	@Test
	public void testCreateMatrixWithDim() {
		for (Matrix m : instances) {
			assertTrue(getClassFor(m.getRowCount(), m.getColumnCount()).isInstance(m));
		}
	}
	@Test
	public void testCreateLike() {
		for (Matrix m : instances) {
			assertTrue(getClassFor(m.getRowCount(), m.getColumnCount()).isInstance(MatrixFactory.createLike(m)));
		}
	}
	@Test
	public void testCopy() {
		for (Matrix m : instances) {
			assertTrue(getClassFor(m.getRowCount(), m.getColumnCount()).isInstance(MatrixFactory.copy(m)));
		}
	}
}