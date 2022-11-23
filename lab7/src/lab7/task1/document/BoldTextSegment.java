package lab7.task1.document;

import lab7.task1.DocumentVisitor;

public class BoldTextSegment extends TextSegment {
    public BoldTextSegment(String content) {
        super(content);
    }

    public void accept(DocumentVisitor docV) {
        docV.visit(this);
    }
}
