package lesson1;

import java.util.Random;

public class Lesson1 {
    public static void main(String[] args) {
        /*
  Не знаю насколько верен вариант с интерфейсом, но условие задачи таким методом реализации я не нарушаю.
 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
 Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
 соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
 У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
 Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет
         */

        Random rand = new Random();
        Actions[] actions = new Actions[3];

        int distance = rand.nextInt(10);
        int heigth = rand.nextInt(10);
        actions[0] = new Human("Борис", distance, heigth);

        distance = rand.nextInt(10);
        heigth = rand.nextInt(10);
        actions[1] = new Robot("111011001", distance, heigth);

        distance = rand.nextInt(10);
        heigth = rand.nextInt(10);
        actions[2] = new Cat("Барсик", distance, heigth);

        Barrier[] barriers = new Barrier[6];

        boolean isRoad;
        for (int i = 0; i < barriers.length; i++) {
            distance = rand.nextInt(10);
            isRoad = rand.nextBoolean();
            if (isRoad) {
                barriers[i] = new Road("Дорога " + i, distance);
            } else {
                barriers[i] = new Wall("Стена " + i, distance);
            }
        }

        for (int i = 0; i < actions.length; i++) {
            boolean result = true;
            for (int j = 0; j < barriers.length; j++) {


                if (Human.class == actions[i].getClass()) {
                    result = barriers[j].moving((Human) actions[i]);
                }

                if (Robot.class == actions[i].getClass()) {
                    result = barriers[j].moving((Robot) actions[i]);
                }

                if (Cat.class == actions[i].getClass()) {
                    result = barriers[j].moving((Cat) actions[i]);
                }

                if (!result) {
                    break;
                }
            }

            if (result) {
                System.out.println("Успех!!");
            } else {
                System.out.println("Безуспешно!!");
            }
        }
    }
}