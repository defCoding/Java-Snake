package DrawUtil;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import Snake.*;
import Food.*;
import Game.*;

/**
 * This class draws the snake and food.
 * */
public class DrawUtil extends JComponent {
  private Snake snake;
  private Food food;
  private boolean gameOver;
  /**
   * This is the constructor for a drawUtil.
   * @param snake The Snake that is to be drawn.
   * @param food The Food that is to be drawn.
   * */
  public DrawUtil(Snake snake, Food food) {
    this.snake = snake;
    this.food = food;
    this.gameOver = false;
  }
  /**
   * This gets gameOver.
   * @return True if game over is true, false otherwise.
   * */
  public boolean getGameOver() {
    return this.gameOver;
  }
  /**
   * This sets gameOver to the given value.
   * @param value The boolean.
   * */
  public void setGameOver(boolean value) {
    this.gameOver = value;
  }
  /**
   * This draws the snake and food.
   * @param g The graphics used.
   * */
  public void paintComponent(Graphics g) {
    if (!this.gameOver) {
      snake.draw(g);
      food.draw(g);
    } else {
      g.setColor(Color.RED);
      g.setFont(new Font("Serif", Font.BOLD, 48));
      g.drawString("GAME OVER.", Game.FRAMESIZE / 4, Game.FRAMESIZE / 4);
    }
  }
}
