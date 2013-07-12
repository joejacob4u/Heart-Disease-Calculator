import java.util.Collection;

import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;


public class Parser {
	public void parseIt(String text)
	{
		LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
        Tree parse = lp.apply(text);
parse.pennPrint();
        TreebankLanguagePack tlp = new PennTreebankLanguagePack();
 	   GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
 	   GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
 	   Collection tdl = gs.typedDependenciesCollapsed();
 	   System.out.println(tdl);
	}

}
