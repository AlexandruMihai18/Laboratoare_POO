package lab7.task2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * Counter for java files of a given directory using java.nio API
 */
public class JavaFilesVisitor extends SimpleFileVisitor<Path> {

    private ArrayList<Path> javaFiles = new ArrayList<>();

    public final ArrayList<Path> getJavaFiles() {
        return javaFiles;
    }

    /**
     * TODO - override the visitFile(Path file, BasicFileAttributes attr) method of the SimpleFileVisitor.
     * Add to javaFiles all the Java related files: the ones with .java and .class extensions.
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().endsWith(".java")
                || file.getFileName().toString().endsWith(".class"))
            javaFiles.add(file);
        return super.visitFile(file, attrs);
    }

    public static void main(String[] args) {

        Path startingDir = Paths.get("./lab7/src/lab7");
        JavaFilesVisitor filesVisitor = new JavaFilesVisitor();

        /*
         * The walkFileTree methods does a depth-first traversal of a directory, starting from startingDir.
         * When it reaches a file, the visitFile method is invoked on the currently visited file.
         */
        /**
         * The walkFileTree does not work for me, if I were to guess probably the startingDir is wrongly assumed
         */
        try {
            Files.walkFileTree(startingDir, filesVisitor);
            ArrayList<Path> javaFiles = filesVisitor.getJavaFiles();

            // TODO: Print the number of files visited and their names
            System.out.println("Number of files visited: " + javaFiles.size());
            for (Path file : javaFiles) {
                System.out.println(file.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}