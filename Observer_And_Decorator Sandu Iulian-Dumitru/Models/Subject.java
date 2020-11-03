package Models;

public interface Subject {
    void attach();
    void detach(Doctor doc);
    void notifyDoctor();
}
