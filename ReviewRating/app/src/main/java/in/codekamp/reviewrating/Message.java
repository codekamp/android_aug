package in.codekamp.reviewrating;

/**
 * Created by cerebro on 05/10/17.
 */

public class Message {
    public String text;
    public String to;
    public String from;

    public Message(String text, String to, String from) {
        this.text = text;
        this.to = to;
        this.from = from;
    }
}
