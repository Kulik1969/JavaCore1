package lesson1;

public class Human implements Actions {
    private String name;
    private int runDistance;
    private int jumpHeight;

    public Human(String name, int distance, int jumpHeight) {
        this.name = name;
        this.runDistance = distance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public  void run() {
        System.out.println("Человек " + this.name + " сила " + this.getRunDistance());
    }

    @Override
    public  void jump() {
        System.out.println("Человек " + this.name + " прыгает " + this.getJumpHeight());
    }

    public int getRunDistance() {
        return this.runDistance;
    }

    public int getJumpHeight() {
        return this.jumpHeight;
    }

}