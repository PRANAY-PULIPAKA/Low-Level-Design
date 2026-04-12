package StructuralDesignPatterns.BridgeDesignPattern.GoodPractice;

public class RasterRenderer implements Renderer{
    @Override
    public void renderCircle(double radius) {
        System.out.println("Raster Rendering: Drawing a circle with radius: " + radius);
    }

    @Override
    public void renderRectangle(double width, double height) {
        System.out.println("Raster Rendering: Drawing a rectangle with width: " + width + " height: " + height);
    }
}
