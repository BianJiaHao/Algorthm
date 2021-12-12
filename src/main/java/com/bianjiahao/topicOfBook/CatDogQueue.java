package com.bianjiahao.topicOfBook;

import java.time.Period;
import java.util.Queue;

/**
 * 猫狗队列
 * @Author Obito
 * @Date 2021/12/12 3:38 下午
 */
public class CatDogQueue {

    public class Pet {
        public String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public class Cat extends Pet {
        public Cat(String type) {
            super("cat");
        }
    }

    public class Dog extends Pet {
        public Dog(String type) {
            super("dog");
        }
    }

    public class PetEnterQueue {
        public Pet pet;
        public int count;

        public PetEnterQueue(Pet pet, int count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public int getCount() {
            return count;
        }

        public String getEnterType() {
            return this.pet.type;
        }
    }

    public class CatAndDogQueue {
        public Queue<PetEnterQueue> catQueue;
        public Queue<PetEnterQueue> dogQueue;
        public int count;

        public CatAndDogQueue(Queue<PetEnterQueue> catQueue, Queue<PetEnterQueue> dogQueue, int count) {
            this.catQueue = catQueue;
            this.dogQueue = dogQueue;
            this.count = 0;
        }

        public void add(Pet pet) {
            if ("cat".equals(pet.getType())){
                this.catQueue.add(new PetEnterQueue(pet,this.count++));
            }else if ("dog".equals(pet.getType())){
                this.dogQueue.add(new PetEnterQueue(pet,this.count++));
            }
        }

        public Cat pollCat(){
            if (!catQueue.isEmpty()){
                return (Cat) this.catQueue.poll().getPet();
            }else {
                throw new RuntimeException("CatQueue is Empty!");
            }
        }

        public Dog pollDog(){
            if (!dogQueue.isEmpty()){
                return (Dog) this.dogQueue.poll().getPet();
            }else {
                throw new RuntimeException("DogQueue is Empty!");
            }
        }

        public Pet pollAll(){
            if (!this.catQueue.isEmpty() && !this.dogQueue.isEmpty()){
                if (this.catQueue.peek().getCount() < this.dogQueue.peek().getCount()){
                    return this.catQueue.poll().getPet();
                }else {
                    return this.dogQueue.poll().getPet();
                }
            }else if (!this.catQueue.isEmpty()){
                return this.catQueue.poll().getPet();
            }else if (!this.dogQueue.isEmpty()){
                return this.dogQueue.poll().getPet();
            }else {
                throw new RuntimeException("CatQueue and DogQueue is all Empty!");
            }
        }

        public boolean isEmpty(){
            return this.catQueue.isEmpty() && this.dogQueue.isEmpty();
        }

        public boolean isDogEmpty(){
            return this.dogQueue.isEmpty();
        }

        public boolean isCatEmpty(){
            return this.catQueue.isEmpty();
        }
    }
}
