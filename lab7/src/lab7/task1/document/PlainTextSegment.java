package lab7.task1.document;

import lab7.task1.DocumentVisitor;

public class PlainTextSegment extends TextSegment{
    public PlainTextSegment(String content) {
        super(content);
    }

    public void accept(DocumentVisitor docV) {
        docV.visit(this);
    }
}
