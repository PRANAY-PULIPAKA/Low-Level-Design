package StructuralDesignPatterns.BridgeDesignPattern.BadPractice;

public class Circle extends Shape{
    @Override
    public void rasterDraw() {
        System.out.println("Drawing Circle using Raster Rendering");
    }
}
