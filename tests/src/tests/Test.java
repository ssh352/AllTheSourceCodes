package tests;

class Test{
	public static void main(String[] args) {
		int[][] a = new int[][] { //
			{ 1, 0, 1, 2, 3 }, //
			{ 1, 2, 0, 2, 4 }, //
			{ 0, 2, 1, 0, 5 }, //
			{ 0, 0, 1, 2, 6 },//
			{ 1, 2, 3, 4, 5 }
		};
		int[][] b = new int[][] { //
			{ 1, 0, 1, 2, 3 }, //
			{ 1, 2, 0, 2, 4 }, //
			{ 0, 2, 1, 0, 5 }, //
			{ 0, 0, 1, 2, 6 },//
			{ 1, 2, 3, 4, 5 }
		};
		printMatrix(squareMatrixMutiplyByRecursive(new ChildMatrix(a, 0, 0, a.length), new ChildMatrix(b, 0, 0, b.length), 0, 0, 0, 0));
	}

	/**
	 * 打印矩阵
	 *
	 * @param matrix
	 */
	private static void printMatrix(int[][] matrix) {
		for (int[] is : matrix) {
			for (int i : is) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 基于分治法的矩阵乘法
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	private static int[][] squareMatrixMutiplyByRecursive(ChildMatrix matrixA, ChildMatrix matrixB, int lastStartRowA, int lastStartColumnA, int lastStartRowB,
	        int lastStartColumnB) {
		int[][] c = new int[matrixA.length][matrixA.length];
		if (matrixA.length == 1) {
			c[0][0] = matrixA.getFromParentMatrix(matrixA.startRow, matrixA.startColumn) * //
			          matrixB.getFromParentMatrix(matrixB.startRow, matrixB.startColumn);
			return c;
		}
		int childLength = matrixA.length / 2;
		// 第一步：分解
		ChildMatrix childMatrixA11 = new ChildMatrix(matrixA.parentMatrix, lastStartRowA, lastStartColumnA, childLength);
		ChildMatrix childMatrixA12 = new ChildMatrix(matrixA.parentMatrix, lastStartRowA, lastStartColumnA + childLength, childLength);
		ChildMatrix childMatrixA21 = new ChildMatrix(matrixA.parentMatrix, lastStartRowA + childLength, lastStartColumnA, childLength);
		ChildMatrix childMatrixA22 = new ChildMatrix(matrixA.parentMatrix, lastStartRowA + childLength, lastStartColumnA + childLength, childLength);

		ChildMatrix childMatrixB11 = new ChildMatrix(matrixB.parentMatrix, lastStartRowB, lastStartColumnB, childLength);
		ChildMatrix childMatrixB12 = new ChildMatrix(matrixB.parentMatrix, lastStartRowB, lastStartColumnB + childLength, childLength);
		ChildMatrix childMatrixB21 = new ChildMatrix(matrixB.parentMatrix, lastStartRowB + childLength, lastStartColumnB, childLength);
		ChildMatrix childMatrixB22 = new ChildMatrix(matrixB.parentMatrix, lastStartRowB + childLength, lastStartColumnB + childLength, childLength);
		// 第二步：解决
		int[][] temp1 = squareMatrixMutiplyByRecursive(childMatrixA11, childMatrixB11, 0, 0, 0, 0);
		int[][] temp2 = squareMatrixMutiplyByRecursive(childMatrixA12, childMatrixB21, 0, childLength, childLength, 0);
		int[][] c11 = sumMatrix(temp1, temp2);

		int[][] temp3 = squareMatrixMutiplyByRecursive(childMatrixA11, childMatrixB12, 0, 0, 0, childLength);
		int[][] temp4 = squareMatrixMutiplyByRecursive(childMatrixA12, childMatrixB22, 0, childLength, childLength, childLength);
		int[][] c12 = sumMatrix(temp3, temp4);

		int[][] temp5 = squareMatrixMutiplyByRecursive(childMatrixA21, childMatrixB11, childLength, 0, 0, 0);
		int[][] temp6 = squareMatrixMutiplyByRecursive(childMatrixA22, childMatrixB21, childLength, childLength, childLength, 0);
		int[][] c21 = sumMatrix(temp5, temp6);

		int[][] temp7 = squareMatrixMutiplyByRecursive(childMatrixA21, childMatrixB12, childLength, 0, 0, childLength);
		int[][] temp8 = squareMatrixMutiplyByRecursive(childMatrixA22, childMatrixB22, childLength, childLength, childLength, childLength);
		int[][] c22 = sumMatrix(temp7, temp8);
		// 第三步：合并
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (i < childLength && j < childLength) {
					c[i][j] = c11[i][j];
				} else if (i < childLength && j < c.length) {
					int[][] child = c12;
					c[i][j] = child[i][j - childLength];
				} else if (i < c.length && j < childLength) {
					int[][] child = c21;
					c[i][j] = child[i - childLength][j];
				} else {
					int[][] child = c22;
					c[i][j] = child[i - childLength][j - childLength];
				}
			}
		}
		return c;
	}

	private static int[][] sumMatrix(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				c[i][j] += a[i][j];
				c[i][j] += b[i][j];
			}
		}
		return c;
	}

	/**
	 * ChildMatrix 表示某个矩阵的一个子矩阵
	 *
	 * @author D.K
	 *
	 */
	static class ChildMatrix {
		/**
		 * 父矩阵
		 */
		int[][] parentMatrix;
		/**
		 * 子矩阵在父矩阵中的起始行坐标
		 */
		int startRow;
		/**
		 * 子矩阵在父矩阵中的起始列坐标
		 */
		int startColumn;
		/**
		 * 子矩阵长度
		 */
		int length;

		public ChildMatrix(int[][] parentMatrix, int startRow, int startColumn, int length) {
			super();
			this.parentMatrix = parentMatrix;
			this.startRow = startRow;
			this.startColumn = startColumn;
			this.length = length;
		}

		/**
		 * 获取父矩阵的row行，colum列元素
		 *
		 * @param row
		 * @param colum
		 * @return
		 */
		public int getFromParentMatrix(int row, int colum) {
			return parentMatrix[row][colum];
		}
	}

};