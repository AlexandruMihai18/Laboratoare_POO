package lab7.task1;

import lab7.task1.document.ItalicTextSegment;
import lab7.task1.document.BoldTextSegment;
import lab7.task1.document.PlainTextSegment;
import lab7.task1.document.UrlSegment;

public class MarkdownVisitor implements DocumentVisitor {
    private StringBuilder markDocument = new StringBuilder();
    @Override
    public void visit(ItalicTextSegment segment) {
        StringBuilder markString = new StringBuilder();
        markString.append("*");
        markString.append(segment.getContent());
        markString.append("*");
        markDocument.append(markString);
    }

    @Override
    public void visit(BoldTextSegment segment) {
        StringBuilder markString = new StringBuilder();
        markString.append("**");
        markString.append(segment.getContent());
        markString.append("**");
        markDocument.append(markString);
    }

    @Override
    public void visit(UrlSegment segment) {
        StringBuilder markString = new StringBuilder();
        markString.append("[");
        markString.append(segment.getDescription());
        markString.append("](");
        markString.append(segment.getContent());
        markString.append(")");
        markDocument.append(markString);
    }

    @Override
    public void visit(PlainTextSegment segment) {
        StringBuilder markString = new StringBuilder(segment.getContent());
        markDocument.append(markString);
    }

    @Override
    public StringBuilder getDocument() {
        return markDocument;
    }
}
