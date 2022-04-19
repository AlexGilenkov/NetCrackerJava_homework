package com.netcracker.homework3;

public class Student {
    private String name;
    private int quizScore;
    private int quizCount;

    public Student(String name) {
        this.name = name;
        quizCount = 0;
        quizScore = 0;
    }

    public String getName() {
        return name;
    }

    public int getQuizScore() {
        return quizScore;
    }

    public void addQuiz(int score){
        this.quizScore += score;
        quizCount++;
    }

    public int getAverageScore(){
        return quizScore/quizCount;
    }
}

class StudentTester{
    public static void test(){
        Student student = new Student("Ivan");

        student.addQuiz(34);
        student.addQuiz(65);
        student.addQuiz(73);

        System.out.println(student.getName());
        System.out.println(student.getQuizScore());
        System.out.println(student.getAverageScore());
    }
}
