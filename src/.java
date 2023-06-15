import java.util.Arrays;

public class MatrixOperations {
    
    public static void main(String[] args) {
        int N = 3; // Розмір матриці
        int M = 3;
        
        // Завдання 1: Заповнити матрицю простими числами з вказаного діапазону
        int[][] matrix = fillMatrixWithPrimes(N, M, 14);
        printMatrix(matrix);
        
        // Завдання 2: Знайти число, яке повторюється найбільшу кількість разів
        int mostFrequentNumber = findMostFrequentNumber(matrix);
        System.out.println("Число, що повторюється найбільшу кількість разів: " + mostFrequentNumber);
        
        // Завдання 3: Знайти друге за величиною число
        int secondLargestNumber = findSecondLargestNumber(matrix);
        System.out.println("Друге за величиною число: " + secondLargestNumber);
        
        // Завдання 4: Обчислити суму елементів матриці
        int sum = calculateSum(matrix);
        System.out.println("Сума елементів матриці: " + sum);
        
        // Завдання 5: Знайти добуток двох матриць
        int[][] matrixA = {
            {1, 2},
            {3, 4}
        };
        int[][] matrixB = {
            {5, 6},
            {7, 8}
        };
        int[][] productMatrix = multiplyMatrices(matrixA, matrixB);
        printMatrix(productMatrix);
        
        // Завдання 6: Знайти суму двох матриць
        int[][] sumMatrix = addMatrices(matrixA, matrixB);
        printMatrix(sumMatrix);
        
        // Завдання 7: Відсортувати матрицю у порядку зростання елементів
        sortMatrix(matrix);
        printMatrix(matrix);
        
        // Завдання 8: Транспонувати матрицю
        int[][] transposedMatrix = transposeMatrix(matrix);
        printMatrix(transposedMatrix);
        
        // Завдання 9: Заповнити матрицю числами, які є сумою двох попередніх елементів
        int[][] fibonacciMatrix = generateFibonacciMatrix(N, M);
        printMatrix(fibonacciMatrix);
        
        // Завдання 10: Знайти максимальні елементи рядків
        int[] maxElements = findMaxElementsInRows(matrix);
        System.out.println("Максимальні елементи рядків: " + Arrays.toString(maxElements));
        
        // Завдання 11: Знайти рядок з максимальною сумою елементів
        int maxSumRowIndex = findRowWithMaxSum(matrix);
        System.out.println("Рядок з максимальною сумою елементів: " + maxSumRowIndex);
        
        // Завдання 12: Знайти стовпець з максимальною сумою елементів
        int maxSumColumnIndex = findColumnWithMaxSum(matrix);
        System.out.println("Стовпець з максимальною сумою елементів: " + maxSumColumnIndex);
        
        // Завдання 13: Поміняти місцями два вказані рядки матриці
        int[][] swappedRowsMatrix = swapRows(matrix, 0, 1);
        printMatrix(swappedRowsMatrix);
        
        // Завдання 14: Поміняти місцями два вказані стовпці матриці
        int[][] swappedColumnsMatrix = swapColumns(matrix, 0, 1);
        printMatrix(swappedColumnsMatrix);
        
        // Завдання 15: Утворити нову матрицю, останній стовпець якої містить суми елементів рядків вихідної матриці
        int[][] sumColumnMatrix = addRowSumsAsColumn(matrix);
        printMatrix(sumColumnMatrix);
    }
    
    // Завдання 1: Заповнити матрицю простими числами з вказаного діапазону
    public static int[][] fillMatrixWithPrimes(int N, int M, int startNumber) {
        int[][] matrix = new int[N][M];
        int number = startNumber;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                while (!isPrime(number)) {
                    number++;
                }
                matrix[i][j] = number;
                number++;
            }
        }
        
        return matrix;
    }
    
    // Перевірка, чи є число простим
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // Завдання 2: Знайти число, яке повторюється найбільшу кількість разів
    public static int findMostFrequentNumber(int[][] matrix) {
        int[] counts = new int[1000]; // Припустимо, що числа в матриці не перевищують 1000
        int mostFrequentNumber = 0;
        int maxCount = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int number = matrix[i][j];
                counts[number]++;
                
                if (counts[number] > maxCount) {
                    mostFrequentNumber = number;
                    maxCount = counts[number];
                }
            }
        }
        
        return mostFrequentNumber;
    }
    
    // Завдання 3: Знайти друге за величиною число
    public static int findSecondLargestNumber(int[][] matrix) {
        int largestNumber = Integer.MIN_VALUE;
        int secondLargestNumber = Integer.MIN_VALUE;
        
        for (int[] row : matrix) {
            for (int number : row) {
                if (number > largestNumber) {
                    secondLargestNumber = largestNumber;
                    largestNumber = number;
                } else if (number > secondLargestNumber && number < largestNumber) {
                    secondLargestNumber = number;
                }
            }
        }
        
        return secondLargestNumber;
    }
    
    // Завдання 4: Обчислити суму елементів матриці
    public static int calculateSum(int[][] matrix) {
        int sum = 0;
        
        for (int[] row : matrix) {
            for (int number : row) {
                sum += number;
            }
        }
        
        return sum;
    }
    
    // Завдання 5: Знайти добуток двох матриць
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int N = matrixA.length;
        int M = matrixA[0].length;
        int Q = matrixB[0].length;
        int[][] productMatrix = new int[N][Q];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < Q; j++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                productMatrix[i][j] = sum;
            }
        }
        
        return productMatrix;
    }
    
    // Завдання 6: Знайти суму двох матриць
    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int N = matrixA.length;
        int M = matrixA[0].length;
        int[][] sumMatrix = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        
        return sumMatrix;
    }
    
    // Завдання 7: Відсортувати матрицю у порядку зростання елементів
    public static void sortMatrix(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[] flattenedMatrix = new int[N * M];
        int index = 0;
        
        for (int[] row : matrix) {
            for (int number : row) {
                flattenedMatrix[index] = number;
                index++;
            }
        }
        
        Arrays.sort(flattenedMatrix);
        
        index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = flattenedMatrix[index];
                index++;
            }
        }
    }
    
    // Завдання 8: Транспонувати матрицю
    public static int[][] transposeMatrix(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] transposedMatrix = new int[M][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        
        return transposedMatrix;
    }
    
    // Завдання 9: Заповнити матрицю числами, які є сумою двох попередніх елементів
    public static int[][] generateFibonacciMatrix(int N, int M) {
        int[][] fibonacciMatrix = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    fibonacciMatrix[i][j] = 1;
                } else if (i == 1 && j == 0) {
                    fibonacciMatrix[i][j] = 1;
                } else {
                    fibonacciMatrix[i][j] = fibonacciMatrix[i-1][j] + fibonacciMatrix[i-2][j];
                }
            }
        }
        
        return fibonacciMatrix;
    }
    
    // Завдання 10: Знайти максимальні елементи рядків
    public static int[] findMaxElementsInRows(int[][] matrix) {
        int[] maxElements = new int[matrix.length];
        
        for (int i = 0; i < matrix.length; i++) {
            int maxElement = Integer.MIN_VALUE;
            for (int number : matrix[i]) {
                if (number > maxElement) {
                    maxElement = number;
                }
            }
            maxElements[i] = maxElement;
        }
        
        return maxElements;
    }
    
    // Завдання 11: Знайти рядок з максимальною сумою елементів
    public static int findRowWithMaxSum(int[][] matrix) {
        int maxSumRowIndex = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int number : matrix[i]) {
                rowSum += number;
            }
            if (rowSum > maxSum) {
                maxSum = rowSum;
                maxSumRowIndex = i;
            }
        }
        
        return maxSumRowIndex;
    }
    
    // Завдання 12: Знайти стовпець з максимальною сумою елементів
    public static int findColumnWithMaxSum(int[][] matrix) {
        int maxSumColumnIndex = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int j = 0; j < matrix[0].length; j++) {
            int columnSum = 0;
            for (int i = 0; i < matrix.length; i++) {
                columnSum += matrix[i][j];
            }
            if (columnSum > maxSum) {
                maxSum = columnSum;
                maxSumColumnIndex = j;
            }
        }
        
        return maxSumColumnIndex;
    }
    
    // Завдання 13: Поміняти місцями два вказані рядки матриці
    public static int[][] swapRows(int[][] matrix, int row1, int row2) {
        int[][] swappedMatrix = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            if (i == row1) {
                swappedMatrix[i] = matrix[row2];
            } else if (i == row2) {
                swappedMatrix[i] = matrix[row1];
            } else {
                swappedMatrix[i] = matrix[i];
            }
        }
        
        return swappedMatrix;
    }
    
    // Завдання 14: Поміняти місцями два вказані стовпці матриці
    public static int[][] swapColumns(int[][] matrix, int column1, int column2) {
        int[][] swappedMatrix = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == column1) {
                    swappedMatrix[i][j] = matrix[i][column2];
                } else if (j == column2) {
                    swappedMatrix[i][j] = matrix[i][column1];
                } else {
                    swappedMatrix[i][j] = matrix[i][j];
                }
            }
        }
        
        return swappedMatrix;
    }
    
    // Завдання 15: Утворити нову матрицю, останній стовпець якої містить суми елементів рядків вихідної матриці
    public static int[][] addRowSumsAsColumn(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] sumColumnMatrix = new int[N][M+1];
        
        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            for (int j = 0; j < M; j++) {
                rowSum += matrix[i][j];
                sumColumnMatrix[i][j] = matrix[i][j];
            }
            sumColumnMatrix[i][M] = rowSum;
        }
        
        return sumColumnMatrix;
    }
    
    // Допоміжний метод для виведення матриці на екран
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

Однак, варто зазначити, що для повного виконання коду потрібно також визначити метод `main`, з якого буде починатись виконання програми.

