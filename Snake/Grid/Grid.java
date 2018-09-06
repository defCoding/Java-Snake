package Homework_10.Grid;

import java.awt.Point;

/**
 * This class models the grid that snake exists on.
 * */
public class Grid {
  private Point[][] matrix;
  /**
   * This is the constructor for the matrix.
   * @param frameSize The size of the frame.
   * @param segSize The size of each segment of the snake.
   * */
  public Grid(int frameSize, int segSize) {
    int matrixSize = (frameSize) / segSize;
    this.matrix = new Point[matrixSize][matrixSize];
    for (int i = 0; i < matrixSize; i++) { // i is for y.
      for (int j = 0; j < matrixSize; j++) { // j is for x.
        matrix[i][j] = new Point(j * segSize, i * segSize);
      }
    }   
  } 
  /**
   * This gets the matrix.
   * @return The matrix.
   * */
  public Point[][] getGrid() {
    return matrix;
  }
}
    