   package Lab.Abstraction;
   

   abstract class Shape{
    abstract void calculatearea();
    void displayShape() {
        System.out.println("This is a SHape");
    }
   }
class Rectangle extends Shape{
    float lenghth;
    float width;

    Rectangle(float lenghth, float width){
        this.lenghth = lenghth;
        this.width = width;
    }
    @Override
    void calculatearea(){
        float area = lenghth*width;
        System.out.println("Shape area:"+ area +"m");
    }
}
class Circle extends Shape {
    float radius;

    Circle(float radius){
        this.radius = radius;
    }
    @Override
    void calculatearea(){
        int area = (int) (Math.PI * radius*radius);
        System.out.println("SHape area:"+radius+"m");
    }
}
public class ABS{
    public static void main (String[] args){
        Shape rectangle = new Rectangle(40,30);
        Shape circle = new Circle(5);
        rectangle.displayShape();
        rectangle.calculatearea();
       circle.displayShape();
        circle.calculatearea();
    }
}