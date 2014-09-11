/**
 * 3.7  An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis. People must adOPT either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.You may use the built-in LinkedList data structure.
 *
 * 思路: Use 2 queues to store cats and dogs, in dequeue, compare the oldest cat and dog
 *
 * 时间复杂度: O(1)
 * 空间复杂度: O(n)
 */

import java.util.LinkedList;

public abstract class Animal {
    private int order;
    protected String name;
    public Animal(String n) {
        name = n;
    }

    public void setOrder(int ord) {
        order = ord;
    }
    
    public int getOrder() {
        return order;
    }
    
    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}
    
public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0; // timestamp
    
    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if(a instanceof Dog) {
            dogs.addLast((Dog)a);
        }
        else if(a instanceof Cat) {
            cats.addLast((Cat)a);
        }
    }
        
    public Dog dequeueDogs() {
        return dogs.poll();
    }
        
    public Cat dequeueCats() {
        return cats.poll();
    }
        
    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }
            
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }
}
    
public class Dog extends Animal {
    public Dog(String n) {
        super(n);
    }
}
        
public class Cat extends Animal {
    public Cat(String n) {
        super(n);
    }
}

