package hu.kazocsaba.math.matrix;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
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
		SortedMap<Double,Vector> eigenvalues=new TreeMap<Double, Vector>();
		for (int i=0; i<3; i++)
			eigenvalues.put(eig.getEigenvalue(i), eig.getEigenvector(i));
		Iterator<Entry<Double, Vector>> iterator = eigenvalues.entrySet().iterator();
		
		Entry<Double, Vector> entry = iterator.next();
		assertEquals(-1, entry.getKey(), 1e-8);
		assertEquals(1, Math.abs(entry.getValue().normalized().dot(MatrixFactory.createVector(2, -1, 1).normalized())), 1e-8);
		
		entry = iterator.next();
		assertEquals(1, entry.getKey(), 1e-8);
		assertEquals(1, Math.abs(entry.getValue().normalized().dot(MatrixFactory.createVector(0, 1, 1).normalized())), 1e-8);
		
		entry = iterator.next();
		assertEquals(2, entry.getKey(), 1e-8);
		assertEquals(1, Math.abs(entry.getValue().normalized().dot(MatrixFactory.createVector(1, 1, -1).normalized())), 1e-8);
	}
}
