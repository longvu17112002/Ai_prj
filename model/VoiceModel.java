package model;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class VoiceModel {
	private String voiceText;
	private StringBuffer log;
	Configuration config = new Configuration();
	LiveSpeechRecognizer rec;

	public VoiceModel() {
		log = new StringBuffer();
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("src\\dic.dic");
		config.setLanguageModelPath("src\\lm.lm");
		try {
			rec = new LiveSpeechRecognizer(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getVoiceText() {
		return voiceText;
	}

	public void setVoiceText(String voiceText) {
		this.voiceText = voiceText;
	}

	public StringBuffer getLog() {
		return log;
	}

	public void setLog(StringBuffer log) {
		this.log = log;
	}

	public String getVoice() {
		rec.startRecognition(true);
		String result = null;
		SpeechResult speechResult = rec.getResult();
		if (speechResult.getHypothesis() != null) {
			result = speechResult.getHypothesis();
		}
		setVoiceText(result);

		rec.stopRecognition();
		return result;
	}
}
