import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RepaintTimerListener implements ActionListener {
	SphereFrame frame;

	RepaintTimerListener(SphereFrame f) {
		this.frame = f;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		frame.repaint();
	}
}
