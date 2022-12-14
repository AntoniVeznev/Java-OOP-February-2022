package Labs.L05Polymorphism.P02Shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double perimeter, Double area) {
        super(perimeter, area);
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        return Math.PI * (2 * radius);
    }

    @Override
    public Double calculateArea() {
        return Math.PI * radius * 2;
    }
}
