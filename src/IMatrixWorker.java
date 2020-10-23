import pojo.Matrix;

public interface IMatrixWorker {
    public void print(Matrix m);

    public boolean haveSameDimension(Matrix m1, Matrix m2);

    public double[][] add(Matrix m1, Matrix m2);

    public double[][] subtract(Matrix m1, Matrix m2);

    public double[][] multiply(Matrix m1, Matrix m2);
}
