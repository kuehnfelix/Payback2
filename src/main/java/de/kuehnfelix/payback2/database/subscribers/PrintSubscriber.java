package de.kuehnfelix.payback2.database.subscribers;

/**
 * A Subscriber that prints a message including the received items on completion
 *
 * @param <T> The publishers result type
 */
public class PrintSubscriber<T> extends OperationSubscriber<T> {
    private final String message;

    /**
     * A Subscriber that outputs a message onComplete.
     *
     * @param message the message to output onComplete
     */
    public PrintSubscriber(final String message) {
        this.message = message;
    }

    @Override
    public void onComplete() {
        System.out.println(String.format(message, getReceived()));
        super.onComplete();
    }
}
