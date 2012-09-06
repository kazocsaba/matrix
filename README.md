Matrix library
==============

This library provides simple matrix data structures and
associated operations. For ease of use, certain matrix
sizes have specialized subtypes, e.g. `Matrix3` for 3x3
matrices, `Vector` for nx1 matrices, and `Vector2` for 2x1
matrices. The subtypes define convenience functions (like
`Vector3.getX()`) or provide additional function overrides
with more concrete return types (like `Matrix3.mul(Vector3)`,
which returns `Vector3`).

Using
-----

The library resides in the central Maven repository with
group ID `hu.kazocsaba.math` and artifact ID `matrix`. If
you use a project management system which can fetch dependencies
from there, you can just add the library as a dependency. E.g.
in Maven:

	<dependency>
		<groupId>hu.kazocsaba.math</groupId>
		<artifactId>matrix</artifactId>
		<version>a.b.c</version>
	</dependency>

You can also browse the [online javadoc](http://kazocsaba.github.com/matrix/apidocs/index.html).

Type safety
-----------

Classes of this library ensure that any `Matrix` object
that is created will implement the subtype that
matches its dimensions the closest. For example,
multiplying a 3x4 matrix and a 4x3 matrix will result in
a 3x3 matrix that can be cast to type `Matrix3`.

The type hierarchy is as follows:

* Matrix: root type, implemented by all matrix objects
	* Matrix2: 2x2 matrix
	* Matrix3: 3x3 matrix
	* Vector: matrix with a single column
		* Vector2: 2D vector (2x1 matrix)
		* Vector3: 3D vector (3x1 matrix)
		* Vector4: 4D vector (4x1 matrix)

New versions of the library might introduce new specialized
types.

Creating instances
------------------

Default implementations of the matrix types can be
constructed using the `MatrixFactory` class. Unless otherwise
noted in the documentation, all functions
of the `Matrix` interface and its subinterfaces must use
this factory to construct new instances.

Immutable implementations are also available. The contents
of matrices of type `ImmutableMatrix` are guaranteed to stay
the same as when they were constructed. Instances can be
created using `ImmutableMatrixFactory`.

NOTE: Matrices returned by `ImmutableMatrix` objects from `Matrix`
functions (e.g. `transpose()` or `plus()`) are _not_ immutable.

Custom implementation
---------------------

The `MatrixCore` class can be used to create a matrix backed by
a custom data structure. For example:

	public class DiagonalMatrixCore extends MatrixCore {
		private final double[] elements;

		DiagonalMatrixCore(int size) {
			// the actual dimensions of the matrix is 'size x size'
			super(size, size);
			elements = new double[size];
		}

		// the 'quick' functions can assume that the arguments have already been checked

		@Override
		public double getQuick(int row, int col) {
			if (row==col)
				return elements[row];
			else
				return 0;
		}

		@Override
		public void setQuick(int row, int col, double value) {
			if (row!=col) throw new UnsupportedOperationException();
			elements[row]=value;
		}
	}
	
	...
	
	// create a 5x5 diagonal matrix
	Matrix d=MatrixFactory.create(new DiagonalMatrixCore(5));
	
	// the Matrix instance is strongly typed, like all instances created by the library
	Matrix3 m=(Matrix3)MatrixFactory.create(new DiagonalMatrixCore(3));

Displaying matrices
-------------------

The `MatrixPrinter` class can be used to produce human-readable
representations of matrices.
