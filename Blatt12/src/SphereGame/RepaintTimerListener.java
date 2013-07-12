import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RepaintTimerListener implements ActionListener {
	SphereGamePanel panel;

	RepaintTimerListener(SphereGamePanel p) {
		this.panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		panel.repaint();
	}
}
