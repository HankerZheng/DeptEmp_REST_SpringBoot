package net.antra.hanz.exception.controller;

/**
 * Created by hanzheng on 8/4/17.
 */
public class CourseNotFoundException extends Exception{

    public CourseNotFoundException(String message) {
        super(message);
    }
    public CourseNotFoundException(String property, String value) {
        super("Course " + property + "(" + value + ") is not found in the database!!");
    }
}
