package Chap6_Class;

public class Computer {
    int sum(int ... values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }   
}
