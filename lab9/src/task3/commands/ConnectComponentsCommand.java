package task3.commands;

import task3.diagram.DiagramCanvas;
import task3.diagram.DiagramComponent;

public class ConnectComponentsCommand implements DrawCommand {
    private DiagramComponent diagramComponent1;
    private DiagramComponent diagramComponent2;
    private String index1;
    private String index2;

    public ConnectComponentsCommand(DiagramCanvas diagramCanvas, String index1, String index2) {
        diagramComponent1 = diagramCanvas.getComponent(Integer.parseInt(index1));
        diagramComponent2 = diagramCanvas.getComponent(Integer.parseInt(index2));
        this.index1 = index1;
        this.index2 = index2;
    }

    @Override
    public void execute() {
        diagramComponent1.connectTo(index2);
        diagramComponent2.connectTo(index1);
    }

    @Override
    public void undo() {
        diagramComponent2.removeConnection(index1);
        diagramComponent1.removeConnection(index2);
    }
}
