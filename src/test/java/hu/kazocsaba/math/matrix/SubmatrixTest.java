package hu.kazocsaba.math.matrix;

import hu.kazocsaba.math.matrix.immutable.ImmutableMatrix;
import hu.kazocsaba.math.matrix.immutable.ImmutableMatrixFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kazó Csaba
 */
public class SubmatrixTest {
	@Test
	public void testSubmatrix() {
		Matrix m=MatrixFactory.createMatrix(new double[][]{
			{1,   2,  3,  4,  5},
			{6,   7,  8,  9, 10},
			{11, 12, 13, 14, 15},
			{16, 17, 18, 19, 20}
		});
		
		check(m.getSub().column(1), 2, 7, 12, 17);
		check(m.getSub().matrix2(1, 1), new double[][]{{7,8},{12,13}});
		check(m.getSub().matrix3(0, 2), new double[][]{{3,4,5},{8,9,10},{13,14,15}});
		check(m.getSub().row(2), 11, 12, 13, 14, 15);
		check(m.getSub().rowVector(1, 1, 3), 7, 8, 9);
		check(m.getSub().rowVector2(2, 0), 11, 12);
		check(m.getSub().rowVector3(1, 2), 8, 9, 10);
		check(m.getSub().rowVector4(0, 1), 2, 3, 4, 5);
		check(m.getSub().vector(0, 4, 3), 5, 10, 15);
		check(m.getSub().vector2(0, 0), 1, 6);
		check(m.getSub().vector3(1, 2), 8, 13, 18);
		check(m.getSub().vector4(0, 3), 4, 9, 14, 19);
	}
	
	@Test
	public void testViews() {
		ImmutableMatrix reference=ImmutableMatrixFactory.createMatrix(new double[][]{
			{1,   2,  3,  4,  5},
			{6,   7,  8,  9, 10},
			{11, 12, 13, 14, 15},
			{16, 17, 18, 19, 20}
		});
		
		check(reference.transposedView(), new double[][]{
			{1,  6,  11, 16},
			{2,  7,  12, 17},
			{3,  8,  13, 18},
			{4,  9,  14, 19},
			{5,  10, 15, 20}
		});
		
		{
			Matrix m=MatrixFactory.copy(reference);
			Vector view=m.viewSub().column(4);
			check(view, 5, 10, 15, 20);
			view.scale(-1);
			check(view, -5, -10, -15, -20);
			check(m, new double[][]{
				{1,   2,  3,  4,  -5},
				{6,   7,  8,  9, -10},
				{11, 12, 13, 14, -15},
				{16, 17, 18, 19, -20}
			});
			m.scale(-1);
			check(view, 5, 10, 15, 20);
		}
		{
			Matrix m=MatrixFactory.copy(reference);
			Matrix view=m.viewSub().matrix(2, 0, 2, 3);
			check(view, new double[][]{
				{11, 12, 13},
				{16, 17, 18}
			});
			view.scale(-1);
			check(view, new double[][]{
				{-11, -12, -13},
				{-16, -17, -18}
			});
			check(m, new double[][]{
				{1,     2,   3,  4,  5},
				{6,     7,   8,  9, 10},
				{-11, -12, -13, 14, 15},
				{-16, -17, -18, 19, 20}
			});
			m.scale(-1);
			check(view, new double[][]{
				{11, 12, 13},
				{16, 17, 18}
			});
		}
		{
			Matrix m=MatrixFactory.copy(reference);
			Vector3 view=m.viewSub().rowVector3(3, 2);
			check(view, 18, 19, 20);
			view.scale(-1);
			check(view, -18, -19, -20);
			check(m, new double[][]{
				{1,   2,   3,   4,   5},
				{6,   7,   8,   9,  10},
				{11, 12,  13,  14,  15},
				{16, 17, -18, -19, -20}
			});
			m.scale(-1);
			check(view, 18, 19, 20);
		}
	}
	
	private static void check(Vector v, double... elements) {
		assertEquals(elements.length, v.getDimension());
		for (int i=0; i<v.getDimension(); i++)
			assertEquals(elements[i], v.getCoord(i), 0);
	}
	private static void check(Matrix m, double[][] elements) {
		assertEquals(elements.length, m.getRowCount());
		assertEquals(elements[0].length, m.getColumnCount());
		for (int row=0; row<m.getRowCount(); row++) for (int col=0; col<m.getColumnCount(); col++)
			assertEquals(elements[row][col], m.get(row, col), 0);
	}
}
