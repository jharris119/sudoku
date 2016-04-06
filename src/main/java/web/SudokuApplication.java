package web;

import static spark.Spark.*;

public class SudokuApplication {
    public static void main(String... args) {
        staticFileLocation("/public");
        get("/hello", (req, res) -> "Hello World!");
    }
}
