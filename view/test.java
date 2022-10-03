package view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.decoder.adaptation.Stats;
import edu.cmu.sphinx.decoder.adaptation.Transform;
import edu.cmu.sphinx.speakerid.Segment;
import edu.cmu.sphinx.speakerid.SpeakerCluster;
import edu.cmu.sphinx.speakerid.SpeakerIdentification;
import edu.cmu.sphinx.util.TimeFrame;

public class test {
	public static void main(String[] args) throws IOException {
		StringBuffer result = new StringBuffer();
		Configuration config = new Configuration();
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("src\\dic.dic");
		config.setLanguageModelPath("src\\lm.lm");
		LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
		rec.startRecognition(true);
		SpeechResult speechResult = null;

		while ((speechResult = rec.getResult()) != null) {
			result.append(" " + (speechResult.getHypothesis()));
			System.out.println(result.toString());
			rec.stopRecognition();
			break;
		}
	}

}