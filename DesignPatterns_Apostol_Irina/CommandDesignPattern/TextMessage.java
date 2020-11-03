package CommandDesignPattern;

public class TextMessage implements Command{

    Message text;
    public TextMessage(Message text){
        this.text=text;
    }

    @Override
    public void execute() {
        text.text();
    }
}
