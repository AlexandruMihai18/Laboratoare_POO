package lab7.task1;

import lab7.task1.document.ItalicTextSegment;
import lab7.task1.document.BoldTextSegment;
import lab7.task1.document.PlainTextSegment;
import lab7.task1.document.UrlSegment;

public class DokuWikiVisitor implements DocumentVisitor {
    private StringBuilder dokuDocument = new StringBuilder();
    @Override
    public void visit(ItalicTextSegment segment) {
        StringBuilder dokuString = new StringBuilder();
        dokuString.append("//");
        dokuString.append(segment.getContent());
        dokuString.append("//");
        dokuDocument.append(dokuString);
    }

    @Override
    public void visit(BoldTextSegment segment) {
        StringBuilder dokuString = new StringBuilder();
        dokuString.append("**");
        dokuString.append(segment.getContent());
        dokuString.append("**");
        dokuDocument.append(dokuString);
    }

    @Override
    public void visit(UrlSegment segment) {
        StringBuilder dokuString = new StringBuilder();
        dokuString.append("[[");
        dokuString.append(segment.getContent());
        dokuString.append("|");
        dokuString.append(segment.getDescription());
        dokuString.append("]]");
        dokuDocument.append(dokuString);
    }

    @Override
    public void visit(PlainTextSegment segment) {
        StringBuilder dokuString = new StringBuilder(segment.getContent());
        dokuDocument.append(dokuString);
    }

    @Override
    public StringBuilder getDocument() {
        return dokuDocument;
    }
}
