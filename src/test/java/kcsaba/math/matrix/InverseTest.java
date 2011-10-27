package kcsaba.math.matrix;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kazó Csaba
 */
public class InverseTest {
	@Test
	public void test1() throws SingularityException {
		Matrix3 m=MatrixFactory.createMatrix3(new double[][]{
			{1,2,3},
			{0,1,4},
			{5,6,0}
		});
		
		Matrix3 minv=MatrixFactory.createMatrix3(new double[][]{
			{-24,18,5},
			{20,-15,-4},
			{-5,4,1}
		});
		
		assertEquals(0, m.inverse().error(minv), 1e-8);
	}
}
