package Food;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * This class models food for the snake.
 * */
public class Food {
  private Point point;
  private Color color;
  private final int DIAMETER;
  /**
   * This is the constructor for Food.
   * @param point The point denoting the Food's position.
   * */
  public Food(Point point) {
    this.point = point;
    this.color = Color.GREEN;
    this.DIAMETER = 10;
  }
  /**
   * This gets the Point.
   * @return The point denoting the Food's position.
   * */
  public Point getPoint() {
    return this.point;
  }
  /**
   * This method moves the Food.
   * @param Point The new point.
   * */
  public void move(Point point) {
    this.point = point;
  }
  /**
   * This draws the Food.
   * @param g The graphics used.
   * */
  public void draw(Graphics g) {
    g.setColor(this.color);
    g.fillOval((int) this.point.getX(), (int) this.point.getY(),
               this.DIAMETER, this.DIAMETER);
  }
}