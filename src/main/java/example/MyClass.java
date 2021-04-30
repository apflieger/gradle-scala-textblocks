package example;

public class MyClass {

    public static void main(String[] args) {
        record Rec(){} // Proves that the java version is good
        new Hello().print("""
                Hello world!
                """);
    }
}
