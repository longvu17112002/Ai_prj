package view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import controller.AssistantController;
import model.VoiceModel;

public class AssistantView{
	private AssistantFrame frame;
	StringBuffer log = new StringBuffer();

	public AssistantView() throws IOException {
		frame = new AssistantFrame();
		log.append("-Assistant: Hello I'm Assistant \n");
		log.append("-Assistant: Talk to me by select the microphone \n");
	}

	public void handleEvent(AssistantController controller) {
		frame.recordBtn.addActionListener(controller);
	}

	public void createView() {
		frame.setVisible(true);
	}

	public void showLog(VoiceModel model) {
		model.setLog(log);
		frame.outPanel.setText(model.getLog().toString());
	}

	public void openGoogle() throws URISyntaxException, IOException {
		Desktop desk = Desktop.getDesktop();
		log.append("-Assistant: Opening Google\n");
		System.out.println("Opening: Google");
		URI uri = new URI("http://google.com/");
		desk.browse(uri);
	}

	public void openYoutube() throws URISyntaxException, IOException {
		Desktop desk = Desktop.getDesktop();
		log.append("-Assistant: Opening Youtube\n");
		System.out.println("Opening: Youtube");
		URI uri = new URI("http://youtube.com/");	
		desk.browse(uri);
	}
	
	public void whatYourName() {
		log.append("-Assistant: My name Assistant");
		System.out.println("My name Assistant\n");
	}
	
	public void notHear() {
		log.append("-Assistant: Excuse me, could you repeat the question?\n");
	}
}
