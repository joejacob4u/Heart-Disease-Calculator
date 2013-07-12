import java.io.IOException;
import java.util.List;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;


public class Ner {
	public void doNer(String s1) throws IOException
	{
		 String serializedClassifier = "/Users/joejacob4u/Box/Box Documents/Projects/Medicine/classifiers/english.muc.7class.distsim.crf.ser.gz";
		 
		

		 AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);
	        
	        System.out.println(classifier.classifyWithInlineXML(s1));
	        
	        
	}

}
