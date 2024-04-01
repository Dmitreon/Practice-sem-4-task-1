package pattern.observer;

import pattern.model.Triangle;

public interface TriangleObserver {
    void update(Triangle triangle);
}
