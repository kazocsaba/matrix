package kcsaba.math.matrix;

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