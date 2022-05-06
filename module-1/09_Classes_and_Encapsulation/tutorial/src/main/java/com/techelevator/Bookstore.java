package com.techelevator;

/**
 * Bookstore
 */
public class Bookstore {

    public static void main(String[] args) {

        System.out.println("Welcome to the Tech Elevator Bookstore");
        System.out.println();

        // Add the instance variables
        private String title;
        private String author;
        private double price;


        // Step Three: Test the getters and setters

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        Book twoCities = new Book();
        twoCities.setTitle("A Tale of Two Cities");
        twoCities.setAuthor("Charles Dickens");
        twoCities.setPrice(14.99);
        System.out.println("Title: " + twoCities.getTitle() + ", Author: " + twoCities.getAuthor() + ", Price: $" + twoCities.getPrice());



        // Step Five: Test the Book constructor








        // Step Nine: Test the ShoppingCart class
        
    }
}