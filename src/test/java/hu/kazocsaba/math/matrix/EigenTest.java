package hu.kazocsaba.math.matrix;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kazó Csaba
 */
public class EigenTest {
	@Test
	public void testEig() {
		Matrix3 m=MatrixFactory.createMatrix3(new double[][] {
			{0,1,-1},
			{1,1,0},
			{-1,0,1}
		});
		EigenDecomposition eig = m.eig();
		
		assertEquals(2, eig.getEigenvalue(0), 1e-8);
		assertEquals(0, eig.getEigenvalueIm(0), 1e-8);
		assertEquals(1, Math.abs(eig.getEigenvector(0).normalized().dot(MatrixFactory.createVector(1, 1, -1).normalized())), 1e-8);
		
		assertEquals(1, eig.getEigenvalue(1), 1e-8);
		assertEquals(0, eig.getEigenvalueIm(1), 1e-8);
		assertEquals(1, Math.abs(eig.getEigenvector(1).normalized().dot(MatrixFactory.createVector(0, 1, 1).normalized())), 1e-8);
		
		assertEquals(-1, eig.getEigenvalue(2), 1e-8);
		assertEquals(0, eig.getEigenvalueIm(2), 1e-8);
		assertEquals(1, Math.abs(eig.getEigenvector(2).normalized().dot(MatrixFactory.createVector(2, -1, 1).normalized())), 1e-8);
	}
}
