public class Document {
    private String title;
    private String content;
    private String author;

    public Document(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DocumentTest {

    @Test
    public void testDocumentCreation() {
        String title = "Sample Title";
        String content = "This is the content of the document.";
        String author = "John Doe";

        Document document = new Document(title, content, author);

        assertNotNull(document);
        assertEquals(title, document.getTitle());
        assertEquals(content, document.getContent());
        assertEquals(author, document.getAuthor());
    }

    @Test
    public void testDocumentTitle() {
        
        String title = "Another Title";
        Document document = new Document(title, "Sample content", "Jane Doe");

        assertEquals("Another Title", document.getTitle());
    }

    @Test
    public void testDocumentContent() {
        String content = "Different content";
        Document document = new Document("Sample Title", content, "Jane Doe");

        assertEquals("Different content", document.getContent());
    }

    @Test
    public void testDocumentAuthor() {
        String author = "Alice";
        Document document = new Document("Sample Title", "Sample content", author);

        assertEquals("Alice", document.getAuthor());
    }
}
