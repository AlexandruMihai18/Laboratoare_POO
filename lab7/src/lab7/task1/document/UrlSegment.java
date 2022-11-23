package lab7.task1.document;

import lab7.task1.DocumentVisitor;

public class UrlSegment extends TextSegment{
    private String description;

    public UrlSegment(String url, String description) {
        super(url);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void accept(DocumentVisitor docV) {
        docV.visit(this);
    }
}
