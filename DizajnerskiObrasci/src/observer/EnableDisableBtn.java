package observer;

import java.io.Serializable;

import frames.LeftFrame;
import frames.RightFrame;

public class EnableDisableBtn implements Observer, Serializable {
	
	private LeftFrame leftFrame;
	private RightFrame rightFrame;

	public EnableDisableBtn(LeftFrame leftFrame, RightFrame rightFrame) {
		//super();
		this.leftFrame = leftFrame;
		this.rightFrame = rightFrame;
	}

	@Override
	public void updateBtn(int i) {
		
		if(i == 0) {
			leftFrame.getTglbtnModify().setEnabled(false);
			leftFrame.getTglbtnDelete().setEnabled(false);
			leftFrame.getTglbtnDeleteAll().setEnabled(false);
			
			rightFrame.getToTop().setEnabled(false);
			rightFrame.getToBottom().setEnabled(false);
			rightFrame.getUp().setEnabled(false);
			rightFrame.getDown().setEnabled(false);
			
		}else if(i==1) {
			leftFrame.getTglbtnModify().setEnabled(true);
			leftFrame.getTglbtnDelete().setEnabled(true);
			leftFrame.getTglbtnDeleteAll().setEnabled(true);

			rightFrame.getToTop().setEnabled(true);
			rightFrame.getToBottom().setEnabled(true);
			rightFrame.getUp().setEnabled(true);
			rightFrame.getDown().setEnabled(true);

		}else if(i > 1) {
			leftFrame.getTglbtnModify().setEnabled(false);
			leftFrame.getTglbtnDelete().setEnabled(false);
			leftFrame.getTglbtnDeleteAll().setEnabled(true);
			
			rightFrame.getToTop().setEnabled(false);
			rightFrame.getToBottom().setEnabled(false);
			rightFrame.getUp().setEnabled(false);
			rightFrame.getDown().setEnabled(false);
		}
		
	}

}
