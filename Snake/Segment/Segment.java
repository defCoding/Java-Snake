package Homework_10.Segment;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

/**
 * This class models one segment of a snake.
 * */
public class Segment {
  private Point point;
  private Color color;
  private int diameter;
  /**
   * This is the constructor.
   * @param point The point denoting its position.
   * @param color The color of the segment.
   * @param size The size of each segment.
   * */
  public Segment(Point point, Color color, int size) {
    this.point = point;
    this.color = color;
    this.diameter = size;
  }
  /**
   * Gets the point.
   * @return The point.
   * */
  public Point getPoint() {
    return this.point;
  }
  /**
   * Gets the diameter of the segment.
   * @return The diameter.
   * */
  public int getSize() {
    return diameter;
  }
  /**
   * Moves a segment to the given coordinates.
   * @param point The new point.
   * */
  public void move(Point point) {
    this.point = point;
  }
  /**
   * toString method for Segment.
   * @return The string representing the segment.
   * */
  public String toString() {
    return this.point.toString();
  }
  /**
   * Checks if two segments are the same.
   * @param other The other segment.
   * @return True if the segments are the same.
   * */
  public boolean equals(Segment other) {
    return this.point.equals(other.getPoint());
  }
  /**
   * Draws the segment.
   * @param g The graphics used.
   * */
  public void draw(Graphics g) {
    g.setColor(this.color);
    g.fillOval((int) this.point.getX(), (int) this.point.getY(),
               this.diameter, this.diameter);
  }
}