package java.model;

import java.observer.Observable;
import java.observer.TriangleObserver;
import java.observer.impl.TriangleObserverImpl;
import java.Util.IdGenerator;

import java.util.StringJoiner;

public class Triangle {
    private final int id;
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;

    public Triangle(Point vertexA, Point vertexB, Point vertexC) {
        this.id = IdGenerator.generateId();
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
    }

    public int getId() {
        return id;
    }

    public Point getVertexA() {
        return vertexA;
    }

    public void setVertexA(Point vertexA) {
        this.vertexA = vertexA;
    }

    public Point getVertexB() {
        return vertexB;
    }

    public void setVertexB(Point vertexB) {
        this.vertexB = vertexB;
    }

    public Point getVertexC() {
        return vertexC;
    }

    public void setVertexC(Point vertexC) {
        this.vertexC = vertexC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (id != triangle.id) return false;
        if (!vertexA.equals(triangle.vertexA)) return false;
        if (!vertexB.equals(triangle.vertexB)) return false;
        return vertexC.equals(triangle.vertexC);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + vertexA.hashCode();
        result = 31 * result + vertexB.hashCode();
        result = 31 * result + vertexC.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "id=" + id +
                ", vertexA=" + vertexA +
                ", vertexB=" + vertexB +
                ", vertexC=" + vertexC +
                '}';
    }
}
