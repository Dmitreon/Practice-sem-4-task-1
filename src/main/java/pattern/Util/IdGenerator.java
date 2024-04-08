package pattern.Util;

/**
 Класс для генерации уникальных идентификаторов
 */
public class IdGenerator {
    private static int currentId;

    /**
     Увеличивает и возвращает следующий уникальный ID
     */
    public static int increment(){
        return ++currentId;
    }
}
