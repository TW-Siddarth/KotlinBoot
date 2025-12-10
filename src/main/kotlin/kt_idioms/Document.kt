package com.thoughtworks.bootcamp2025.kt_idioms

import com.thoughtworks.bootcamp2025.kt_idioms.Status.*
import java.util.*

class Document() {
	var title: String = ""
	var content: String = ""
	var status: Status = DRAFT
	var lastModified: Date = Date()

	fun save() {
		println("Saving document: '" + this.title + "'");
		this.lastModified = Date()
	}

	fun print() {
		println("--- Document: $title ---")
		println(content)
		println("---------------------------------")
	}
}

enum class Status { DRAFT, REVIEW, PUBLISHED }


fun createReviewReadyDocument(title: String, content: String): Document {
	return Document().apply {
		this.title = title
		this.content = content
		status = REVIEW
	}
}

fun doThingToDocument(doc: Document) {
	doc.print()
	doc.save()
}

fun saveAndPrintDocument(doc: Document?) {
	doc?.let(::doThingToDocument)
}

fun finalizeAndPrint(doc: Document) {
	with(doc) {
		status = PUBLISHED
		save()
		print()
	}
}