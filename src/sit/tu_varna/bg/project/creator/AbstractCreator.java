package sit.tu_varna.bg.project.creator;

import sit.tu_varna.bg.project.contracts.Creator;
import sit.tu_varna.bg.project.enums.NamedColors;

public abstract class AbstractCreator implements Creator {
    private String parameters;

    public AbstractCreator(String parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean validColor(String color) {
        for (NamedColors namedColor : NamedColors.values()) {
            if (namedColor.name().equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}
