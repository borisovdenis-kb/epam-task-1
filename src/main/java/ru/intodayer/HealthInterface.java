package ru.intodayer;


public interface HealthInterface {
    default int decreaseHealth(int health, int value) {
        int hp = health - value;
        return (hp <= 0 ? 0 : hp);
    }
}
