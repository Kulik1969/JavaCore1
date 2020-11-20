package lesson3;

import java.util.ArrayList;
import java.util.Arrays;

/*
Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
Задача:
-Даны классы: Fruit, Apple extends Fruit, Orange extends Fruit.
-Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
-Для хранения фруктов внутри коробки использовать ArrayList
-Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
-Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут
в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать
коробки с яблоками и апельсинами;
-Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку
фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается,
а в другую перекидываются объекты, которые были в первой;
-Не забываем про метод добавления фрукта в коробку
 */
class Lesson3 {

    public static void main(String[] args) {
        //Задача1
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"A", "B", "C"} ;
        swap(arr1,1,4);
        swap(arr2,0,2);

        //Задача2
        String[] arrayOfStrings = {"A", "B", "C", "D"};
        asList(arrayOfStrings);

        //Задача3
        Box<Orange> or = new Box<>();
        Box<Orange> or1 = new Box<>();
        Box<Apple> ap = new Box<>();
        Box<Apple> ap1 = new Box<>();
        System.out.println("Задача3");
        System.out.println("'g' - addFruit: ");
        or.addFruit(new Orange(),10);
        or1.addFruit(new Orange(),12);
        ap.addFruit(new Apple(),8);
        ap1.addFruit(new Apple(),4);
        System.out.println("Box 1: "+or.getWeight());
        System.out.println("Box 2: "+or1.getWeight());
        System.out.println("Box 3: "+ap.getWeight());
        System.out.println("Box 4: "+ap1.getWeight());
        System.out.println("'e' - compare(): ");
        System.out.println("Box 1 equals box 3: "+or.compare(ap));
        System.out.println("Box 2 equals box 4: "+or1.compare(ap1));
        System.out.println("'f' - pourTo(): ");
        or.pourTo(or1);
        ap.pourTo(ap1);
        System.out.println("'d' - getWeight(): ");
        System.out.println("Box 1: "+or.getWeight());
        System.out.println("Box 2: "+or1.getWeight());
        System.out.println("Box 3: "+ap.getWeight());
        System.out.println("Box 4: "+ap1.getWeight());


    }
    public static void swap(Object[] arr, int n1, int n2){
        System.out.println("Задача1: "+Arrays.toString(arr));
        Object sw = arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=sw;
        System.out.println("Результат замены: "+Arrays.toString(arr)+"\n================================");
    }
    public static <T> void asList(T[]arr){

        ArrayList<T> alt = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Задача2 и результат конвертации : "+alt+"\n================================");
    }
}
