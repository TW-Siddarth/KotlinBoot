package module1java;

import java.util.Date;

public class Document {
	private String title;
	private String content;
	private Status status = Status.DRAFT;
	private Date lastModified = new Date();

	public enum Status { DRAFT, REVIEW, PUBLISHED }

	// Getters and Setters
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }

	public Status getStatus() { return status; }
	public void setStatus(Status status) { this.status = status; }

	public Date getLastModified() { return lastModified; }
	public void setLastModified(Date lastModified) { this.lastModified = lastModified; }

	public void save() {
		System.out.println("Saving document: '" + this.title + "'");
		this.lastModified = new Date();
	}

	public void print() {
		System.out.println("--- Document: " + title + " ---");
		System.out.println(content);
		System.out.println("---------------------------------");
	}


	// 1
	public Document createReviewReadyDocument(String title, String content) {
		Document doc = new Document();
		doc.setTitle(title);
		doc.setContent(content);
		doc.setStatus(Status.REVIEW);
		return doc;
	}

	// 2
	public void saveAndPrintDocument(Document doc) {
		if (doc != null) {
			doc.save();
			doc.print();
		}
	}

	// 3
	public String getDocumentSummary(Document doc) {
		String summary = "Title: '" + doc.getTitle() + "', Status: " + doc.getStatus();
		// Potentially more logic...
		return summary.toUpperCase();
	}

	// 4
	public Document logAndSave(Document doc) {
		// Side effect
		System.out.println("LOG: Document '" + doc.getTitle() + "' to be saved at " + doc.getLastModified());
		doc.save(); // Primary action
		return doc;
	}

	// 5
	public void finalizeAndPrint(Document doc) {
		doc.setStatus(Status.PUBLISHED);
		doc.save();
		doc.print();
	}
}