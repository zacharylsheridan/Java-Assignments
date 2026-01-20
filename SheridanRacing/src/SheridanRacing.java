/*
 * Zachary Sheridan
 * Dr Reco Knowles 
 * 26 November 2023
 * SheridanRacing
 * 
 * This program is designed to run an applet that creates two boxes "cars" that start at a starting line and race. It includes speed options as well as start and stop options.
 * 
 * NOTE: The JApplet type has deprecated. I was only able to get this to work on a browser version of Java that was much older. I was also warned not to use applets in regualar coding. That said, here is the code.
 * This should theoretically work.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class SheridanRacing extends JApplet implements ActionListener {
   int speed1 = 0;
   int speed2 = 0;
 
   JButton startButton = new JButton("Start");
   JButton endButton = new JButton("End");
   JTextField speedField1 = new JTextField(3);
   JTextField speedField2 = new JTextField(3);
 
   Thread carThread1, carThread2;
 
   public void init() {
      Container contentPane = getContentPane();
      contentPane.setLayout(new FlowLayout());
 
      contentPane.add(startButton);
      startButton.addActionListener(this);
 
      contentPane.add(endButton);
      endButton.addActionListener(this);
 
      contentPane.add(new JLabel("Speed of Car 1:"));
      contentPane.add(speedField1);
      contentPane.add(new JLabel("Speed of Car 2:"));
      contentPane.add(speedField2);
   }
 
   public void paint(Graphics g) {
      super.paint(g);
      g.drawLine(20, 100, 500, 100); // draw the Start Line
      g.fillRect(20, 80, 15, 20); // draw Car 1
      g.fillRect(20, 120, 15, 20); // draw Car 2
   }
 
   public void actionPerformed(ActionEvent e) {
      Object source = e.getSource();
 
      if (source == startButton) {
         // read speed from the text fields
         speed1 = Integer.parseInt(speedField1.getText());
         speed2 = Integer.parseInt(speedField2.getText());
 
         // create and start threads for the cars
         carThread1 = new CarThread(this, 20, 80, speed1);
         carThread1.start();
         carThread2 = new CarThread(this, 20, 120, speed2);
         carThread2.start();
      }
      else if (source == endButton) {
         // stop the threads
         carThread1.stop();
         carThread2.stop();
      }
   }
}
 
class CarThread extends Thread {
   SheridanRacing applet;
   int x, y, speed;
 
   public CarThread(SheridanRacing applet, int x, int y, int speed) {
      this.applet = applet;
      this.x = x;
      this.y = y;
      this.speed = speed;
   }
 public void run() {
      Graphics g = applet.getGraphics();
      while (true) {
         try {
            sleep(100 - speed);
         } catch (InterruptedException e) {}
 
         g.setColor(Color.white);
         g.fillRect(x, y, 15, 20); // erase the car
         x++;
         g.setColor(Color.black);
         g.fillRect(x, y, 15, 20); // draw the car
      }
   }
}
