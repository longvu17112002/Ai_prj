import java.awt.EventQueue;

import controller.AssistantController;
import model.VoiceModel;

public class run {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoiceModel model = new VoiceModel();
					AssistantController controller = new AssistantController(model);
					controller.show();
//					new AssistantView().openGoogle();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
