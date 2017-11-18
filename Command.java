package application;

import java.util.Stack;
public interface Command{
	public void execute();
	public void undo();
}
//public final class History {
//	private static History in = null;
//	private final Stack<Board> undo = new Stack<Board>();
//	public void add(final Board cc) {
//		undo.push(cc);
//		//cc.add();
//	}
	
	

