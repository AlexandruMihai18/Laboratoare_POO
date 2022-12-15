package task3.commands;

import task3.diagram.DiagramCanvas;
import task3.diagram.DiagramComponent;

public class ChangeTextCommand implements DrawCommand {
    private DiagramComponent diagramComponent;
    private String prevText;
    private String text;

    public ChangeTextCommand(DiagramCanvas diagramCanvas, int index, String text) {
        diagramComponent = diagramCanvas.getComponent(index);
        this.text = text;
    }

    @Override
    public void execute() {
        prevText = diagramComponent.getText();
        diagramComponent.setText(text);
    }

    @Override
    public void undo() {
        text = prevText;
        diagramComponent.setText(text);
    }
}
