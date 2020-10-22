
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

    public double determinant(double m1[][]) {
        if (m1.length == m1[0].length) {
            double res;
            if (m1.length == 1) res = m1[0][0];
            else if (m1.length == 2) res = m1[0][0] * m1[1][1] - m1[1][0] * m1[0][1];
            else {
                res = 0;
                for (int j1 = 0; j1 < m1.length; j1++) {
                    double m[][] = generateArray(m1, j1);
                    res += Math.pow(-1.0, 1.0 + j1 + 1.0) * m1[0][j1] * determinant(m);
                }
            }
            return res;
        } else   throw new IllegalArgumentException();
    }

    private double[][] generateArray(double m1[][], int j1) {
        double m[][]  = new double[m1.length - 1][];
        for (int k = 0; k < (m1.length - 1); k++)
            m[k] = new double[m1.length - 1];

        for (int i = 1; i < m1.length; i++) {
            int j2 = 0;
            for (int j = 0; j < m1.length; j++) {
                if (j == j1)
                    continue;
                m[i - 1][j2] = m1[i][j];
                j2++;
            }
        }
        return m;
    }

}
