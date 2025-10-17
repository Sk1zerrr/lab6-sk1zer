package ua.opnu.list.task1;

abstract class Animal {
    private String name;

    public Animal(String name) { this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    abstract String makeSound();
}

class Dog extends Animal {
    public Dog(String name) { super(name); }
    @Override String makeSound() { return "Woof!"; }
}

class Cat extends Animal {
    public Cat(String name) { super(name); }
    @Override String makeSound() { return "Meow!"; }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Rex");
        Animal cat = new Cat("Murka");

        System.out.println(dog.getName() + " says: " + dog.makeSound());
        System.out.println(cat.getName() + " says: " + cat.makeSound());
    }
}
