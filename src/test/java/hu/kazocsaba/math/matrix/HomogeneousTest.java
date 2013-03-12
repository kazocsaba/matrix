package hu.kazocsaba.math.matrix;

import hu.kazocsaba.math.matrix.immutable.ImmutableMatrixFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kazó Csaba
 */
public class HomogeneousTest {
	@Test
	public void testToHomogeneous() {
		assertEquals(MatrixFactory.createVector(3.3, 1), MatrixFactory.createVector(new double[]{3.3}).toHomogeneous());
		assertEquals(MatrixFactory.createVector(3.3, 4.4, 1), MatrixFactory.createVector(3.3, 4.4).toHomogeneous());
		assertEquals(MatrixFactory.createVector(3.3, 4.4, 5.5, 1), MatrixFactory.createVector(3.3, 4.4, 5.5).toHomogeneous());
		assertEquals(MatrixFactory.createVector(new double[]{3.3, 4.4, 5.5, 6.6, 1}), MatrixFactory.createVector(3.3, 4.4, 5.5, 6.6).toHomogeneous());
		assertEquals(MatrixFactory.createVector(new double[]{3.3, 4.4, 5.5, 6.6, 7.7, 1}), MatrixFactory.createVector(new double[]{3.3, 4.4, 5.5, 6.6, 7.7}).toHomogeneous());
	}
	@Test
	public void testImmutableToHomogeneous() {
		assertEquals(MatrixFactory.createVector(3.3, 1), ((Vector)ImmutableMatrixFactory.createMatrix(new double[][]{{3.3}})).toHomogeneous());
		assertEquals(MatrixFactory.createVector(3.3, 4.4, 1), ImmutableMatrixFactory.createVector(3.3, 4.4).toHomogeneous());
		assertEquals(MatrixFactory.createVector(3.3, 4.4, 5.5, 1), ImmutableMatrixFactory.createVector(3.3, 4.4, 5.5).toHomogeneous());
		assertEquals(MatrixFactory.createVector(new double[]{3.3, 4.4, 5.5, 6.6, 1}), ImmutableMatrixFactory.createVector(3.3, 4.4, 5.5, 6.6).toHomogeneous());
		assertEquals(MatrixFactory.createVector(new double[]{3.3, 4.4, 5.5, 6.6, 7.7, 1}), ((Vector)ImmutableMatrixFactory.createMatrix(new double[][]{{3.3}, {4.4}, {5.5}, {6.6}, {7.7}})).toHomogeneous());
	}
	@Test
	public void testCoredToHomogeneous() {
		class TestCore extends MatrixCore {

			public TestCore(int dimension) {
				super(dimension, 1);
			}

			@Override
			public double getQuick(int row, int col) {
				switch (row) {
					case 0: return 3.3;
					case 1: return 4.4;
					case 2: return 5.5;
					case 3: return 6.6;
					case 4: return 7.7;
					default: throw new AssertionError();
				}
			}

			@Override
			public void setQuick(int row, int col, double value) {
				throw new UnsupportedOperationException("Not supported yet.");
			}
			
		}
		assertEquals(MatrixFactory.createVector(3.3, 1), ((Vector)MatrixFactory.create(new TestCore(1))).toHomogeneous());
		assertEquals(MatrixFactory.createVector(3.3, 4.4, 1), ((Vector)MatrixFactory.create(new TestCore(2))).toHomogeneous());
		assertEquals(MatrixFactory.createVector(3.3, 4.4, 5.5, 1), ((Vector)MatrixFactory.create(new TestCore(3))).toHomogeneous());
		assertEquals(MatrixFactory.createVector(new double[]{3.3, 4.4, 5.5, 6.6, 1}), ((Vector)MatrixFactory.create(new TestCore(4))).toHomogeneous());
		assertEquals(MatrixFactory.createVector(new double[]{3.3, 4.4, 5.5, 6.6, 7.7, 1}), ((Vector)MatrixFactory.create(new TestCore(5))).toHomogeneous());
	}
}
