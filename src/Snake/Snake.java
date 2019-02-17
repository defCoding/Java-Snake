package Snake;

import Segment.*;
import Grid.*;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

/**
 * This class models a snake for the game.
 * */
public class Snake {
  private ArrayList<Segment> segments = new ArrayList<Segment>();
  private int xVel, yVel, firstIndex, secondIndex, segSize;
  private boolean isMoving;
  private Grid grid;
  /** This is the constructor for the snake.
    * @param size The initial starting size.
    * @param segSize The size of the segments.
    * @param grid The grid the snake is on.
    * */
  public Snake(int size, int segSize, Grid grid) {
    this.grid = grid;
    this.segSize = segSize;
    int gridLength = grid.getGrid().length;
    Point startingPoint = grid.getGrid()[gridLength / 2][gridLength / 2];
    this.firstIndex = gridLength / 2;
    this.secondIndex = gridLength/ 2;
    Segment head = new Segment(startingPoint, Color.RED, segSize);
    this.xVel = 0;
    this.yVel = 0;
    this.isMoving = false;
    segments.add(head);
    for (int i = 0; i < size; i++) {
      Segment lastSegment = segments.get(segments.size() - 1);
      Segment newSegment = new Segment(new Point((int) lastSegment.getPoint().getX(), 
                                                 (int) lastSegment.getPoint().getY() + lastSegment.getSize()), 
                                       Color.BLACK, segSize);
      segments.add(newSegment);
    }
  }
  /**
   * Gets the segments ArrayList.
   * @return The ArrayList.
   * */
  public ArrayList<Segment> getSegments() {
    return this.segments;
  }
  /**
   * Adds a segment to Segments.
   * */
  public void addSegment() {
    Segment lastSegment = segments.get(segments.size() - 1);
    try {
      if (this.yVel != 0) {
        Segment newSegment = new Segment(new Point((int) lastSegment.getPoint().getX(), 
                                                   (int) lastSegment.getPoint().getY() + lastSegment.getSize() * -this.yVel), 
                                         Color.BLACK, segSize);
      } else {
        Segment newSegment = new Segment(new Point((int) lastSegment.getPoint().getX() + lastSegment.getSize() * -this.xVel, 
                                                   (int) lastSegment.getPoint().getY()), 
                                         Color.BLACK, segSize);
        segments.add(newSegment);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      if (this.yVel != 0) {
        Segment newSegment = new Segment(new Point((int) lastSegment.getPoint().getX() + lastSegment.getSize() * -this.xVel, 
                                                   (int) lastSegment.getPoint().getY()), 
                                         Color.BLACK, segSize);
        segments.add(newSegment);
      } else {
        Segment newSegment = new Segment(new Point((int) lastSegment.getPoint().getX(), 
                                                   (int) lastSegment.getPoint().getY() + lastSegment.getSize() * -this.yVel), 
                                         Color.BLACK, segSize);
        segments.add(newSegment);
      }
    }
    
  }
  /**
   * Changes the x velocity.
   * @param vel The new velocity.
   * */
  public void changeXVel(int vel) {
    this.xVel = vel;
  }
  /**
   * Changes the y velocity.
   * @param vel The new velocity.
   * */
  public void changeYVel(int vel) {
    this.yVel = vel;
  }
  /**
   * Allows the snake to move.
   * */
  public void startMoving() {
    this.isMoving = true;
  }
  /**
   * Checks if the snake is moving.
   * @return True if snake is moving.
   * */
  public boolean isMoving() {
    return this.isMoving;
  }
  /** 
   * Checks if head is legal.
   * @return True if head is legal, false otherwise.
   * */
  public boolean checkSnakeHead() {
    boolean legal = true;
    for (int i = 1; i < this.segments.size(); i++) {
      if (this.segments.get(0).equals(this.segments.get(i))) {
        legal = false;
        break;
      }
    }
    return legal;
  }
  /**
   * This method paints the snake.
   * @param g The graphics used.
   * */
  public void draw(Graphics g) {
    for (Segment seg : segments) {
      seg.draw(g);
    }
  }
  /** 
   * This method moves the snake.
   * */
  public void move() {
    Segment head = segments.get(0);
    Segment newHead = segments.remove(segments.size() - 1); // Removes last segment and saves it.
    newHead.move(head.getPoint());
    segments.add(1, newHead);
    
    this.firstIndex = this.firstIndex + yVel;
    this.secondIndex = this.secondIndex + xVel;
    head.move(this.grid.getGrid()[this.firstIndex][this.secondIndex]);
  }
}

