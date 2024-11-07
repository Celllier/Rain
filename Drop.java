import java.util.Random;

public class Drop {
    private int x;
    private int y;
    private int z;
    private int ySpeed;
    private final int length;
    private final int weight;

    public Drop(int x, int y){
        this.x = x;
        this.y = y;

        Random random = new Random();
        z = random.nextInt(0, 20);
        ySpeed = map(z, 0, 20, 22, 12);
        length = map(z, 0, 20, 8, 20);
        weight = map(z, 0, 20, 2,4);
    }

    int getX(){
        return x;
    }
    int getY(){
        return y;
    }

    public int getLength() {return length;}

    public int getWeight() {
        return weight;
    }

    void fall(){
       y += ySpeed;
    }

    public void reset(){

        Random random = new Random();
        y = random.nextInt(-200, -100);
        x = random.nextInt(500);
    }

    private int map(int val, int minInp, int maxInp, int minOut, int maxOut){
        return minOut + (val - minInp) * (maxOut - minOut) / (maxInp - minInp);
    }
}
