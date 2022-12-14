package Labs.L05Polymorphism.P02Shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    public Shape(Double perimeter, Double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public abstract Double calculatePerimeter();

    public abstract Double calculateArea();

}
