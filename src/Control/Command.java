package Control;

public interface Command {
    public void execute();
    
    public class Null implements Command{

        @Override
        public void execute() {
        }
        
    }
}
