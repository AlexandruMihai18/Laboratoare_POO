package task3.commands;

import task3.diagram.DiagramCanvas;
import task3.diagram.DiagramComponent;

public class ChangeColorCommand implements DrawCommand {
    private DiagramComponent diagramComponent;
    private String prevColor;
    private String color;

    public ChangeColorCommand(DiagramCanvas diagramCanvas, int index, String color) {
        diagramComponent = diagramCanvas.getComponent(index);
        this.color = color;
    }

    @Override
    public void execute() {
        prevColor = diagramComponent.getColor();
        diagramComponent.setColor(color);
    }

    @Override
    public void undo() {
        color = prevColor;
        diagramComponent.setColor(color);
    }
}
