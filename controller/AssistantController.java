package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import java.net.URISyntaxException;

import model.VoiceModel;
import view.AssistantView;

public class AssistantController implements ActionListener {
	private AssistantView view;
	private VoiceModel model;

	public AssistantController() {

	}

	public AssistantController(VoiceModel model) throws IOException {
		super();
		this.model = model;
		this.view = new AssistantView();
		this.view.handleEvent(this);
		view.createView();

	}

	public void show() {
		view.showLog(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("record")) {
			System.out.println("is record");
			String result = model.getVoice();
//			System.out.println(result);
			System.out.println(model.getVoiceText());
			if (result.toLowerCase().contains("google"))
				try {
					view.openGoogle();
					show();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (result.toLowerCase().contains("youtube"))
				try {
					view.openYoutube();
					show();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (result.toLowerCase().contains("name")|| result.toLowerCase().contains("what your name")) {
				view.whatYourName();
				show();

			}
			else {
				view.notHear();
				show();
			}
		}

	}

}
