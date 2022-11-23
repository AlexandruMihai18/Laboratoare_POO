package lab7.task1.document;

import lab7.task1.DocumentVisitor;

public class ItalicTextSegment extends TextSegment {
    public ItalicTextSegment(String content) {
        super(content);
    }

    public void accept(DocumentVisitor docV) {
        docV.visit(this);
    }
}
