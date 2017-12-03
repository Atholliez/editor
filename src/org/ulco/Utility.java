package org.ulco;

public class Utility {
    public static GraphicsObjects select(Point pt, double distance, Document document) {
        GraphicsObjects list = new GraphicsObjects();

        for (Layer layer : document.getm_layers()) {
            for (GraphicsObject object : layer.getm_list()) {
                if (object.isClosed(pt, distance)) {
                    list.add(object);
                }
            }
        }
        return list;
    }
}
