package in.codekamp.reviewrating;

/**
 * Created by cerebro on 19/09/17.
 */

public class NewMessageEvent {

    public int senderId;
    public String message;

    public NewMessageEvent(int senderId, String message) {
        this.senderId = senderId;
        this.message = message;
    }
}
