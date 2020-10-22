import pojo.Matrix;

public interface IMatrixWorker {
    public void print(double[][] m);
    public boolean haveSameDimension(double[][] m1, double[][] m2);
    public double[][] add(double[][] m1, double[][] m2);
    public double[][] subtract(double[][] m1, double[][] m2);
    public double[][] multiply(double[][] m1, double[][] m2);
    public void print(Matrix m);
    public boolean haveSameDimension(Matrix m1, Matrix m2);
    public double[][] add(Matrix m1, Matrix m2);
    public double[][] subtract(Matrix m1, Matrix m2);
    public double[][] multiply(Matrix m1, Matrix m2);
}
