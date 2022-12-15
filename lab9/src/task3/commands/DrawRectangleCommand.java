package task3.commands;


import task3.diagram.DiagramCanvas;
import task3.diagram.DiagramComponent;

public class DrawRectangleCommand implements DrawCommand {
    private final DiagramCanvas diagramCanvas;
    private DiagramComponent new_component;
    int size;

    public DrawRectangleCommand(DiagramCanvas diagramCanvas) {
        this.diagramCanvas = diagramCanvas;
        new_component = null;
        size = 0;
    }

    @Override
    public void execute() {
        new_component = new DiagramComponent();
        diagramCanvas.addComponent(new_component);
        size++;
    }

    @Override
    public void undo() {
        diagramCanvas.removeComponent(new_component);
        size--;
        new_component = diagramCanvas.getComponent(size);
    }
}
