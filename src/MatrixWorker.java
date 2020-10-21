
public class MatrixWorker implements IMatrixWorker {
    @Override
    public void print(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean haveSameDimension(double[][] m1, double[][] m2) {
        if (m1.length == m2.length && m1[0].length == m2[0].length) {
            return true;
        } else return false;
    }

    @Override
    public double[][] add(double[][] m1, double[][] m2) {
        double[][] mResult = new double[m1.length][m1[0].length];
        if (haveSameDimension(m1, m2)) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    mResult[i][j] = m1[i][j] + m2[i][j];
                }
            }
            return mResult;
        } else   throw new IllegalArgumentException();
    }

    @Override
    public double[][] subtract(double[][] m1, double[][] m2) {
        double[][] mResult = new double[m1.length][m1[0].length];
        if (haveSameDimension(m1, m2)) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    mResult[i][j] = m1[i][j] - m2[i][j];
                }
            }
            return mResult;
        } else   throw new IllegalArgumentException();
    }

    @Override
    public double[][] multiply(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length;
        int m2RowLength = m2.length;
        if (m1ColLength != m2RowLength)   throw new Error();
        int mRRowLength = m1.length;
        int mRColLength = m2[0].length;
        double[][] mResult = new double[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {
            for (int j = 0; j < mRColLength; j++) {
                for (int k = 0; k < m1ColLength; k++) {
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }

    public double determinant(double A[][]) {
        if (A.length == A[0].length) {
            double res;
            if (A.length == 1) res = A[0][0];
            else if (A.length == 2) res = A[0][0] * A[1][1] - A[1][0] * A[0][1];
            else {
                res = 0;
                for (int j1 = 0; j1 < A.length; j1++) {
                    double m[][] = generateArray(A, j1);
                    res += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1] * determinant(m);
                }
            }
            return res;
        } else   throw new IllegalArgumentException();
    }

    private double[][] generateArray(double A[][], int j1) {
        double m[][] = m = new double[A.length - 1][];
        for (int k = 0; k < (A.length - 1); k++)
            m[k] = new double[A.length - 1];

        for (int i = 1; i < A.length; i++) {
            int j2 = 0;
            for (int j = 0; j < A.length; j++) {
                if (j == j1)
                    continue;
                m[i - 1][j2] = A[i][j];
                j2++;
            }
        }
        return m;
    }

}
