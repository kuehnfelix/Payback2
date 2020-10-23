package de.kuehnfelix.payback2.database.subscribers;

import org.bson.Document;

/**
 * A Subscriber that prints the json version of each document
 */
public class PrintDocumentSubscriber extends OperationSubscriber<Document> {

    @Override
    public void onNext(final Document document) {
        super.onNext(document);
        System.out.println(document.toJson());
    }
}