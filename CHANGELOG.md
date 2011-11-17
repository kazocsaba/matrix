Changelog
=========

Version 1.1.0 (2011.11.17):

- Introduced functions `Matrix.getQuick/setQuick` and `Vector.getCoordQuick/setCoordQuick` which skip index checking; refactor library functions to use these
  after they have checked their parameters.
- Added Matrix.eig() eigen decomposition.
- The default matrix implementations now use `double[]` instead of `double[][]` to store their elements.

Version 1.0.0 (2011.11.02):

- Moved everything to package `hu.kazocsaba.math.matrix`.
- Merged `MatrixUtil` into `MatrixFactory`.
- Pulled in the SVD and LU decompositions from Jama and drop the dependency.
- Added `MatrixPrinter.printCode(Matrix)`, and `createMatrix(double[][])`, `createVector(double[])`, `createMatrix2(double[][])`, and `createMatrix3(double[][])` to `MatrixFactory`.
- Renamed `MatrixFactory.createVector2(double,double)`, `createVector3(double,double,double)`, and `createVector4(double,double,double,double)` all to `createVector`.

Legacy changes
--------------

*These are the changes from the time before the library made it into the central Maven repository and had different group ID and artifact ID.*

Version 2.0.2 (2011.07.22): No library changes (project management related update).

Version 2.0.1 (2011.07.18): Added functions `Matrix.error(Matrix)`, `Matrix.normalize()`, and `Matrix.normalized()`.

Version 2.0.0 (2011.04.25):

- Removed generic types from matrix interfaces.
- Added immutable implementations.
- Removed `MatrixFactory.createVector(Vector)` variants; use `MatrixFactory.copy` instead.
- `Vector3.toHomogen()` changed to `Vector3.toHomogeneous`.

Version 1.1.0 (2010.01.26):

- The interfaces are now generic so that plus, minus, times, and inverse return the correct types. In favour of these, `plusVec` and `minusVec` have been removed.
- New types `Matrix2` and `Matrix3` (for 2x2 and 3x3 matrices) providing correct return types for transpose and multiplication with certain arguments.
- Removed the ambiguous `MatrixFactory.createMatrix(Matrix)` function and added `MatrixFactory.copy` and `MatrixFactory.createLike`.
- Added `toString` to `Vector2` implementation.
- Removed redundant function `MatrixUtil.copyOf`.

Version 1.0.11 (2010.01.20): New function `Matrix.times`.

Version 1.0.10 (2009.11.20): Fix typo in the documentation of `Vector3.toHomogen()`: the fourth coordinate will indeed be 1.

Version 1.0.9 (2009.11.12): Fix parameter checking in `Vector.getSubmatrix`.

Version 1.0.8 (2009.08.10): Add new type `Vector2`.

Version 1.0.7 (2009.08.09): 'Copy constructors' in factory, new functions `minus`, `subtract`, and `setSubmatrix`.

Version 1.0.6 (2008.12.10): Fix SVD and pseudoinverse when matrix has less rows than columns.

Version 1.0.5 (2008.11.19): Fix pseudoinverse.

Version 1.0.4 (2008.11.17): New function to calculate the 2-norm.

Version 1.0.3 (2008.10.18): New function to calculate determinant.

Version 1.0.2 (2008.09.29): Fix vector transpose operation.

Version 1.0.1 (2008.08.04):

- Added MatrixPrinter utility class for displaying matrices.
- Added MatrixUtil with some simple factory methods.

Version 1.0.0 (2008.07.29)
