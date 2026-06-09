package StructuralDesignPatterns.BridgeDesignPattern.BadPractice;

public class Rectangle extends Shape{
    @Override
    public void rasterDraw() {
        System.out.println("Drawing Rectangle using Raster Rendering");
    }
}
