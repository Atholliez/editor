package org.ulco;

import java.lang.reflect.Constructor;

public class JSON {
    static public GraphicsObject parse(String json) {
        GraphicsObject o = null;
        String str = json.replaceAll("\\s+", "");
        String type = str.substring(str.indexOf("type") + 5, str.indexOf(","));

        type = type.substring(0, 1).toUpperCase() + type.substring(1);

        Class c;
        try {
            c = Class.forName("org.ulco."+ type);
            Class[] parametres = new Class[]{String.class};
            Constructor constru = c.getConstructor(parametres);
            o = (GraphicsObject)constru.newInstance(new String[]{str});
        }
        catch (Exception except) {
            except.printStackTrace();
        }
        return o;
    }

    static public Group parseGroup(String json) {
        return new Group(json);
    }
    static public Layer parseLayer(String json) {
        return new Layer(json);
    }
    static public Document parseDocument(String json) {
        return new Document(json);
    }
}
