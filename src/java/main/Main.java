package java.main;

import java.creator.TriangleFactory;
import java.creator.impl.TriangleFactoryImpl;
import java.model.Triangle;
import java.model.Warehouse;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] params = {
                {4, 5, 6},
                {1, 1, 7},
                {8, 9, 9},
                {7, 5, 4},
        };
        TriangleFactory factory = new TriangleFactoryImpl();
        List<Triangle> result = factory.createTriangles(params);
        System.out.println(result);
        Warehouse warehouse = Warehouse.getInstance();
        Triangle ob = result.get(0);
        ob.setA(5);
        System.out.println(warehouse);
        ob.setC(8);
        System.out.println(warehouse);
    }
}
