package lesson1;

public class Cat implements Actions {
    private String name;
    private int runDistance;
    private int jumpHeight;

    public Cat(String name, int distance, int jumpHeight) {
        this.name = name;
        this.runDistance = distance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public  void run() {
        System.out.println("Кот " + this.name + " сила " + this.getRunDistance());
    }

    @Override
    public  void jump() {
        System.out.println("Кот " + this.name + " прыгает " + this.getJumpHeight());
    }

    public int getRunDistance() {
        return this.runDistance;
    }

    public int getJumpHeight() {
        return this.jumpHeight;
    }
}