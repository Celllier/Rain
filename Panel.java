import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Panel extends JPanel {
    private List<Drop> drops;
    private final int height = 600;
    private final int width = 500;

    Panel(){
        setBackground(Color.GRAY);
        drops = createDrops();
    }

    public void update(){
        revalidate();
        repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        for(Drop drop : drops){
            g2d.fillRect(drop.getX(), drop.getY(), drop.getWeight(), drop.getLength());
        }
        g2d.dispose();
    }

    private List<Drop> createDrops(){
        List<Drop> drops1 = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 80; i++){
            Drop drop = new Drop(random.nextInt(width), random.nextInt(height));
            drops1.add(drop);
        }
        return drops1;
    }

    public void makeFall(){
        for (Drop drop : drops){
            drop.fall();

            if(drop.getY() > height){
                drop.reset();
            }
        }

    }
}
