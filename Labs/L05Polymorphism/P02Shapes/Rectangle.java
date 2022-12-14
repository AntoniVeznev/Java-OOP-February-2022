package Labs.L05Polymorphism.P02Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double perimeter, Double area) {
        super(perimeter, area);
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        return (this.height + this.width) * 2;
    }

    @Override
    public Double calculateArea() {
        return this.height * this.width;
    }
}
