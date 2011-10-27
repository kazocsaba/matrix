package kcsaba.math.matrix;

import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

/**
 *
 * @author Kazó Csaba
 */
public class SvdTest {

	@Test
	public void testSquare() {
		testSize(2, 2);
		testSize(3, 3);
		testSize(10, 10);
	}

	@Test
	public void testMoreRows() {
		testSize(2, 1);
		testSize(3, 2);
		testSize(20, 4);
		testSize(20, 15);
	}

	@Test
	public void testMoreCols() {
		testSize(1, 2);
		testSize(2, 3);
		testSize(4, 20);
		testSize(15, 20);
	}

	private void testSize(int rows, int cols) {
		Matrix m = MatrixFactory.createMatrix(rows, cols);

		Random rnd = new Random(3476425L);

		for (int tries = 0; tries < 10; tries++) {
			for (int row = 0; row < rows; row++)
				for (int col = 0; col < cols; col++)
					m.set(row, col, (rnd.nextDouble() - .5) * 2000);
		}
		SingularValueDecomposition svd = m.svd();
		assertEquals(0, m.error(svd.getU().mul(svd.getS()).mul(svd.getV().transpose())), 1e-8);
	}
}
