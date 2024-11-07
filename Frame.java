import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.sql.Time;

public class Frame extends JFrame {
    private int width = 500;
    private int height = 600;
    private Panel panel;
    Timer timer;
    private BufferStrategy bufferStrategy;

    Frame(){
        super("Rain simulation");
        panel = new Panel();
        panel.setLayout(null);
        setContentPane(panel);

        setVisible(true);
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setIgnoreRepaint(true);
        createBufferStrategy(2);
        bufferStrategy = getBufferStrategy();

        run();
    }

    private void run() {
        if (timer == null) {
            Timer timer = new Timer(20, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("drop");
                    panel.makeFall();
                    panel.update();
                }
            });

            timer.start();
        }
    }
//    private void render(){
//        Graphics g = bufferStrategy.getDrawGraphics();
//        if (!bufferStrategy.contentsLost()) {
//            panel.paintComponent(g);  // Call the drawing method explicitly
//            bufferStrategy.show();
//        }
//        g.dispose();
//    }
}
