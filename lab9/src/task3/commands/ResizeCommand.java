package task3.commands;


import task3.diagram.DiagramCanvas;
import task3.diagram.DiagramComponent;

public class ResizeCommand implements DrawCommand {
    private final DiagramComponent diagramComponent;
    private double percentage;
    private int prevWidth;
    private int prevHeight;

    public ResizeCommand(DiagramCanvas diagramCanvas, int index, double percentage) {
        this.diagramComponent = diagramCanvas.getComponent(index);
        this.percentage = percentage;
    }

    @Override
    public void execute() {
        int currentWidth = diagramComponent.getWeight();
        int currentHeight = diagramComponent.getHeight();

        prevWidth = currentWidth;
        prevHeight = currentHeight;

        currentWidth = (int) (((double) currentWidth * percentage) / 100);
        currentHeight = (int) (((double) currentHeight * percentage) / 100);

        diagramComponent.setWeight(currentWidth);
        diagramComponent.setHeight(currentHeight);
    }

    @Override
    public void undo() {
        diagramComponent.setWeight(prevWidth);
        diagramComponent.setHeight(prevHeight);
    }
}
