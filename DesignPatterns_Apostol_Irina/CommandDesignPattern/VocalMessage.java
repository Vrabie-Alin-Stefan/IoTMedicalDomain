package CommandDesignPattern;

public class VocalMessage implements Command {

    Message vocal;

    public VocalMessage(Message vocal)
    {
        this.vocal=vocal;
    }
    @Override
    public void execute() {
        vocal.vocal();
    }
}
