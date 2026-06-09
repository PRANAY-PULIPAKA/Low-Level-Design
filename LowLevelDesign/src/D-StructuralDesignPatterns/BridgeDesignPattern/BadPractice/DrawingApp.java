package StructuralDesignPatterns.BridgeDesignPattern.BadPractice;

public class DrawingApp {
    public static void main(String[] args) {
            Shape circle = new Circle();
            circle.rasterDraw();
            Shape rectangle = new Rectangle();
            rectangle.rasterDraw();
    }
}
