package sit.tu_varna.bg.project.creator;

import sit.tu_varna.bg.project.contracts.Creator;
import sit.tu_varna.bg.project.enums.NamedColors;

/**
 * Абстрактен клас за създаване на обекти, който имплементира интерфейса Creator.
 */
public abstract class AbstractCreator implements Creator {
    private String parameters; // Параметрите за създаване на обектите

    /**
     * Конструктор за създаване на обект от класа AbstractCreator с дадени параметри.
     * @param parameters Параметрите за създаване на обектите.
     */
    public AbstractCreator(String parameters) {
        this.parameters = parameters;
    }

    /**
     * Метод, който проверява дали даденият цвят е валиден.
     * @param color Цветът, който трябва да се провери.
     * @return Връща true ако цветът е валиден, в противен случай връща false.
     */
    @Override
    public boolean validColor(String color) {
        for (NamedColors namedColor : NamedColors.values()) {
            if (namedColor.toString().equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод, който връща параметрите за създаване на обекти.
     * @return Параметрите за създаване на обекти.
     */
    public String getParameters() {
        return parameters;
    }

    /**
     * Метод, който задава новите параметри за създаване на обекти.
     * @param parameters Новите параметри за създаване на обекти.
     */
    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}

