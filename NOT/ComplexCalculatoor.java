
public class ComplexCalculatoor {
    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(2.0, 3.0);
        ComplexNumber num2 = new ComplexNumber(1.0, 2.0);

        ComplexNumber sum = num1.add(num2);
        ComplexNumber difference = num1.subtract(num2);
        ComplexNumber product = num1.multiply(num2);
        ComplexNumber quotient = num1.divide(num2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    @Override
    public String toString() {
        String sign = (imaginary >= 0) ? "+" : "-";
        return real + " " + sign + " " + Math.abs(imaginary) + "i";
    }
}
