package java.service;

import java.model.Point;
import java.model.Triangle;

public class TriangleService {
    public double perimeter(Triangle triangle) {

        return triangle.getA()+ triangle.getC()+triangle.getB();//todo
    }
}