package lab7.task1;

import lab7.task1.document.ItalicTextSegment;
import lab7.task1.document.BoldTextSegment;
import lab7.task1.document.PlainTextSegment;
import lab7.task1.document.UrlSegment;

public interface DocumentVisitor {
    void visit(ItalicTextSegment segment);
    void visit(BoldTextSegment segment);
    void visit(UrlSegment segment);
    void visit(PlainTextSegment segment);
    StringBuilder getDocument();
}
