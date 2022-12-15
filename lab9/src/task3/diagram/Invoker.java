package task3.diagram;

import task3.commands.DrawCommand;

import java.util.LinkedList;

public class Invoker {

    LinkedList<DrawCommand> commands = new LinkedList<>();
    LinkedList<DrawCommand> undoneCommands = new LinkedList<>();

    /**
     * Clear up all the used resources, start fresh :D
     */
    public void restart() {
        commands = new LinkedList<>();
        undoneCommands = new LinkedList<>();
    }

    /**
     * Executes a given command
     *
     * @param command
     */
    public void execute(DrawCommand command) {
        command.execute();
        commands.add(command);
    }

    /**
     * Undo the latest command
     */
    public void undo() {
        DrawCommand lastCommand = commands.removeLast();
        lastCommand.undo();
        undoneCommands.add(lastCommand);
    }

    /**
     * Redo command previously undone. Cannot perform a redo after an execute, only after at least one undo.
     */
    public void redo() {
        DrawCommand lastCommand = undoneCommands.removeLast();
        lastCommand.execute();
        commands.add(lastCommand);
    }
}
