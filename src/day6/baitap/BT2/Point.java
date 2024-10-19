package day6.baitap.BT2;

public abstract class Point {
    int X,Y;

    public Point() {
        this.X=0;
        this.Y=0;
    }

    public Point(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public void move(int dx,int dy) {
        this.X += dx;
        this.Y += dy;
    }

    public abstract void draw();
}
