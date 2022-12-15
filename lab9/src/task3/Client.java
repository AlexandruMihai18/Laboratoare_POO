package task3;

import task3.commands.*;
import task3.diagram.DiagramCanvas;
import task3.diagram.Invoker;

public class Client {

    private Invoker invoker;
    private DiagramCanvas diagramCanvas;

    Client() {
        invoker = new Invoker();
        diagramCanvas = new DiagramCanvas();
    }

    public void showDiagram() {
        diagramCanvas.show();
    }

    public void newDiagram() {
        diagramCanvas = new DiagramCanvas();
        invoker.restart();
    }

    public void executeAction(String commandName, String... args) {
        DrawCommand command;
        try {
            CommandType commandType = CommandType.fromString(commandName);
            if (commandType == null) {
                throw new IllegalArgumentException();
            }
            command = getCommand(commandType, args);

        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid command: " + commandName);
            System.out.println("Available commands:");
            for (CommandType type : CommandType.values()) {
                System.out.println("\t- " + type.text);
            }
            return;
        }

        invoker.execute(command);
    }

    private DrawCommand getCommand(CommandType type, String... args) throws IllegalArgumentException {
        try {
            switch (type) {
                case DRAW_RECTANGLE:
                    return new DrawRectangleCommand(diagramCanvas);
                case RESIZE:
                    return new ResizeCommand(diagramCanvas, Integer.parseInt(args[0]), Double.parseDouble(args[1]));
                case CONNECT:
                    return new ConnectComponentsCommand(diagramCanvas, args[0], args[1]);
                case CHANGE_TEXT:
                    return new ChangeTextCommand(diagramCanvas, Integer.parseInt(args[0]), args[1]);
                case CHANGE_COLOR:
                    return new ChangeColorCommand(diagramCanvas, Integer.parseInt(args[0]), args[1]);
            }
            ;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    public void undo() {
        invoker.undo();
    }

    public void redo() {
        invoker.redo();
    }
}
