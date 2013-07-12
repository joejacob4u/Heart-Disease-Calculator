import java.io.IOException;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class Pos {
	String tagged;
	public String doPos(String str)
	{
		 MaxentTagger tagger;
			try {
				tagger = new MaxentTagger("/Users/joejacob4u/Box/Box Documents/Projects/Medicine/taggers/bidirectional-distsim-wsj-0-18.tagger");
				
			    tagged = tagger.tagString(str);
			    System.out.println(tagged);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tagged;
	}

}
