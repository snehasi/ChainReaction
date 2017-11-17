package application;

public class CommandManager {
	private Command lastcommand;
	public CommandManager() {}
	public void executeCommand(Command c) {
		c.execute();
		lastcommand=c;
	}
	public boolean isUndoAvailable() {
		return lastcommand!=null;
	}
	public void undo() {
		assert(lastcommand!=null);
			lastcommand.undo();
			lastcommand=null;
		}
	}

