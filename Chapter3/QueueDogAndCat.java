package Chapter3;

import java.sql.Timestamp;
import java.util.*;

public class QueueDogAndCat {
    public static void main(String[] args) {
        QueueDogAndCat q = new QueueDogAndCat();
        try {
            q.enqueu(new Dog("dog1"));
            Thread.sleep(1);
            q.enqueu(new Cat("cat1"));
            Thread.sleep(1);
            q.enqueu(new Cat("cat2"));
            Thread.sleep(1);
            q.enqueu(new Dog("dog2"));
            Thread.sleep(1);
            q.enqueu(new Dog("dog3"));
            Thread.sleep(1);
            q.enqueu(new Cat("cat3"));
            System.out.println(q.dequeueCat().getName());
            System.out.println(q.dequeueDog().getName());
            System.out.println(q.dequeueAny().getName());
            System.out.println(q.dequeueAny().getName());
            System.out.println(q.dequeueCat().getName());
            System.out.println(q.dequeueDog().getName());
        } catch (InterruptedException e) {
        }

    }

    LinkedList<Dog> dogList = new LinkedList<Dog>();
    LinkedList<Cat> catList = new LinkedList<Cat>();

    public void enqueu(Animal animal) {
        if (animal instanceof Dog) {
            dogList.add((Dog) animal);
        } else if (animal instanceof Cat) {
            catList.add((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogList.size() == 0)
            return catList.poll();
        if (catList.size() == 0)
            return dogList.poll();

        Dog dog = dogList.peek();
        Cat cat = catList.peek();

        if (dog.getStamp().compareTo(cat.getStamp()) < 0) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }

    }

    public Dog dequeueDog() {
        return dogList.poll();
    }

    public Cat dequeueCat() {
        return catList.poll();
    }

    static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    }

    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }

    static abstract class Animal {
        Timestamp stamp;
        String name;

        public Animal(String name) {
            this.name = name;
            this.stamp = new Timestamp(System.currentTimeMillis());
        }

        public Timestamp getStamp() {
            return this.stamp;
        }

        public String getName() {
            return this.name;
        }
    }
}
