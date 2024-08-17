public class Main {
    public static void main(String[] args) {
        Document wordDoc = DocumentFactory.createDocument("word");
        if (wordDoc != null) {
            wordDoc.open();
            wordDoc.save();
            wordDoc.close();
        }

        Document pdfDoc = DocumentFactory.createDocument("pdf");
        if (pdfDoc != null) {
            pdfDoc.open();
            pdfDoc.save();
            pdfDoc.close();
        }

        Document excelDoc = DocumentFactory.createDocument("excel");
        if (excelDoc != null) {
            excelDoc.open();
            excelDoc.save();
            excelDoc.close();
        }
    }
}
