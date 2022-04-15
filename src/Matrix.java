public class Matrix {
    public int rows;
    public int columns;
    public int[][] matrix;

    public Matrix(int rows1, int columns1) {

        rows = rows1;
        columns = columns1;
        this.matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public Matrix sum(Matrix matrix1) {

        Matrix m = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int tmp = matrix1.getElement(i, j) + this.getElement(i, j);
                m.setElement(i, j, tmp);
            }
        }
        return m;
    }

    public Matrix product(Matrix matrix1) {
        Matrix m = new Matrix(rows, matrix1.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix1.columns; j++) {
                m.setElement(i, j, 0);
                for (int k = 0; k < columns; k++) {
                    m.matrix[i][j] = m.matrix[i][j] + this.matrix[i][k] * matrix1.matrix[k][j];
                }
            }
        }
        return m;

    }

    public void setElement(int row, int column, int value) {
        this.matrix[row][column] = value;
    }

    public int getElement(int row, int column) {
        return matrix[row][column];
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            String str1 = new String();
            for (int j = 0; j < columns; j++) {
                str1 += matrix[i][j] + " ";
            }
            str.append(str1 + "\n");
        }
        return str + "";
    }

    public String toStringArr(int[][] res) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            String str1 = new String();
            for (int j = 0; j < columns; j++) {
                str1 += res[1][j] + " ";
            }
            str.append(str1 + "\n");
        }
        return str + "";
    }

    public int[][] sumColumns() {

        int[] sumc = new int[columns];
        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < columns; j++) {
                sum += matrix[j][i];
            }
            sumc[i] = sum;
        }
        int res[][] = new int[2][columns];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                res[0][j] = sumc[j];
                res[1][j] = j;
            }
        }
        sort(res);
        return res;
    }

    public void sort(int[][] res) {

        for (int i = 0; i < columns; i++) {
            int min = res[0][i];
            int minI = i;
            for (int j = i + 1; j < columns; j++) {
                if (res[0][j] < min) {
                    min = res[0][j];
                    minI = j;
                }
            }
            if (i != minI) {
                int tmp = res[0][i];
                int tmp1 = res[1][i];
                res[0][i] = res[0][minI];
                res[1][i] = res[1][minI];
                res[0][minI] = tmp;
                res[1][minI] = tmp1;
            }
        }
    }
}
