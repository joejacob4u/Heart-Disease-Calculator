import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.Labeled;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.apache.commons.lang3.StringUtils;







import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;

import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.semgraph.SemanticGraph;
import edu.stanford.nlp.trees.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.util.CoreMap;



public class CoreNlp {
	
	Med2Controller mc;
	
	
	String[] words;
	
	int pressFlag,cholFlag,sugarFlag,weightFlag,weight,age,chest,heartFlag,ageFlag,internetFlag=0;
	int sex=-1;
	int pressure=-1,chol=-1,check=-1,heartbeat=-1;
	int sugar=-1;
	int disease=-1;
	String temp;
public String addString(String text,int type) throws IOException
{
	Measure measure=new Measure();
	VerifySpell vs=new VerifySpell();
	HeartDisease hd=new HeartDisease();
	  Properties props = new Properties();
	    props.put("annotators", "tokenize, ssplit, pos,lemma,ner,parse");
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	    InternetConnection internet=new InternetConnection();
	    if(internet.isInternetReachable()==true)
	    {
	    	Pos pos1=new Pos();
	 	   //String str1=pos1.doPos(text);
	 	    words = text.split(" ");  
	 	   int len=words.length;
	 	    int i=0;
	 	   weight=-1;age=-1;
	 	   for (i=0;i<len;i++)  
	 	   {  
	 	    
	 	    	words[i]=vs.checkIt(words[i]);
	 	    }
	 	   temp = StringUtils.join(words, ' ');
	    }
	    else
	    {
	    	if(internetFlag==0)
	    	{
	    	Voice talk=new Voice("kevin16");
	    	talk.say("Please connect to the internet");
	    	DialogFX dialog = new DialogFX();
	        dialog.setTitleText("No internet!");
	        dialog.setMessage("A network can help you better,continue anyway?");
	        dialog.showDialog();
	    	}
	    	internetFlag=1;
	    	temp=new String(text);
	    	System.out.println("No internet!!");
	    }
	    
	   
	     
	    
	    
	    // read some text in the text variable
	    
	    
	    // create an empty Annotation just with the given text
	    Annotation document = new Annotation(temp);
	    
	    // run all Annotators on this text
	    pipeline.annotate(document);
	    
	    // these are all the sentences in this document
	    // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
	    List<CoreMap> sentences = document.get(SentencesAnnotation.class);
	    
	    for(CoreMap sentence: sentences) {
	      // traversing the words in the current sentence
	      // a CoreLabel is a CoreMap with additional token-specific methods
	      for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
	        // this is the text of the token
	    	  String word = token.get(TextAnnotation.class);
	    	  
	        
	        //Finding sex
	        if(word.contains("male")|| word.contains("female") || word.contains("woman") || word.contains("man") || word.contains("women") || word.contains("men"))
	        {  
	        	String res=checkAll();
	        	if(res.contains("ok"))
	        	{
	        		
	        	
	        	if(word.contains("man") || word.contains("men") || word.contains("male"))
	        	{
	        		sex=1;
	        	}
	        	if(word.contains("woman") || word.contains("women") || word.contains("female"))
	        	{
	        		sex=0;
	        	}
	        	
	        	 
	        }
	        	else 
		        {
		        	return res;
		        }
		       
	        	
	        }
	        
	        // this is the POS tag of the token
	        String pos = token.get(PartOfSpeechAnnotation.class);
	        System.out.println("WORD = "+word+ "POS = "+pos);
	        
	      
	        if(pos.contains("NN") )
	        {
	        	 if(word.contains("glucose")||word.contains("sugar"))
	 	        {
	        		String res=checkAll();
	        		if(res.contains("ok"))
	        		{
	        			sugarFlag=1;
	 	        }
	        		else
	        		{
	        			return res;
	        		}
	 	        }
	        	if(word.contains("pressure"))
	        	{
	        		String res=checkAll();
	        		 if(res.contains("ok"))
	        		 {
	        			 pressFlag=1; 
	        		 }
	        		 else
	        		 {
	        			 return res;
	        		 }
	        	}
	        	if(word.contains("cholesterol"))
	        	{
	        		String res=checkAll();
	        		if(res.contains("ok"))
	        		{
	        			cholFlag=1;	
	        		}
	        		else
	        		{
	        			return res;
	        		}
	        	}
	        		
	        	
	        	
	        	
	        	if(word.contains("age"))
	        	{
	        		String res=checkAll();
	        	if(res.contains("ok"))
	        	{
	        		ageFlag=1;
	        	}
	        	else
	        	{
	        		return res;
	        	}
	        }
	        }
	        if(pos.contains("CD"))
	        {
	        	if(pressFlag==1)
	        	{
	        	pressFlag=0;
	        	 pressure=measure.measurePress(Integer.parseInt(word));
	        	//database
	        	
	        	if(pressure==0)
	        	{
	        		
	        		
                    return "pressError";
                    
	        		}
	        	}
	        	if(cholFlag==1)
	        	{
	        		cholFlag=0;
	        	 chol=measure.measureChol(Integer.parseInt(word));
	        	
	        	if(chol==0)
	        	{
	        		cholFlag=3;
	        		return "cholError";
	        	}
	        	}
	        	if(sugarFlag==1)
	        	{
	        		sugarFlag=0;
	        		 sugar=measure.measureSugar(Integer.parseInt(word));
	        		if(sugar<0)
	        		{
	        			
	        			return "sugarError";
	        		}
	        	}
	        	if(ageFlag==1)
	        	{
	        		ageFlag=0;
	        		age=Integer.parseInt(word);
	        	}
	        	
	        	if(heartFlag==1)
	        	{
	        		heartFlag=0;
	        		heartbeat=Integer.parseInt(word);
	        		if(heartbeat<71 || heartbeat>202)
	        		{
	        			return "wrongBeat";
	        		}
	        	}
	        }
	       
	        // this is the NER label of the token
	        String ne = token.get(NamedEntityTagAnnotation.class); 
	       // System.out.println(ne);
	        if(pos.contains("JJ"))
	        {
	        	 check=hd.searchDisease(word);
	        	if(check!=0)
	        	{
	        		 chest=check;
	        		System.out.println("chest is:"+chest);
	        	}
	        	//else
	        	//{
	        		//return "chestError";
	        	//}
	        }
	        if(ne.contains("DURATION")&&pos.contains("CD"))
	        	
	        {
	        	 age=Integer.parseInt(word);
	        	
	        }
	        
	        if(pos.contains(".") || pos.contains(","))
	        {
	        	if(pressFlag==1)
	        	{
	        		return "pressNull";
	        	}
	        	if(cholFlag==1)
	        	{
	        		return "cholNull";
	        	}
	        	if(sugarFlag==1)
	        	{
	        		return "sugarNull";
	        	}
	        	if(heartFlag==1)
	        	{
	        		return "heartNull";
	        	}
	        	if(ageFlag==1)
	        	{
	        		return "ageNull";
	        	}
	        	 
	        	
	        }
	        if(word.equalsIgnoreCase("Heart") )
	        {
	        	heartFlag=1;
	        }
	        if((word.equalsIgnoreCase("positive")||word.equalsIgnoreCase("negative"))&&type==0)
	        {
	        	if(word.contains("pos"))
	        	{
	        		disease=1;
	        	}
	        	if(word.contains("neg"))
	        	{
	        		disease=0;
	        	}
	        }
	      }

	      // this is the parse tree of the current sentence
	     // Tree tree = sentence.get(TreeAnnotation.class);

	      // this is the Stanford dependency graph of the current sentence
	     // SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
	      //System.out.println(dependencies);
	    }
	   
	    if(age<0)
        {
        	return "noAge";
        }
	    if(sex<0)
	    {
	    	return "noSex";
	    }
	    if(chest<=0)
	    {
	    	return "chestError";
	    }
	    
	    if(heartbeat<0)
	    {
	    	return "heartNull";
	    }
	    if(sugar==-1)
	    {
	    	return "sugarNull";
	    }
	    if(chol<0)
	    {
	    	return "cholNull";
	    }
	    if(pressure<0)
	    {
	    	return "pressNull";
	    }
	    if(type==0)
	    {
	    if(disease==-1 && type==0)
	    {
	    	return "diseaseNull";
	    }
	    }
        if(cholFlag==0&&pressFlag==0&&weightFlag==0&&sugarFlag==0&&age>0&&sex>=0&&chest>0&&heartFlag==0&&type==0)
        {
        	
        	Database db=new Database();
        	db.insDatabase(sex,age,chest,pressure,chol,sugar,heartbeat,disease,"Training");
        	return "ok";
        }
        else
        {
        	Database db=new Database();
        	db.insDatabase(sex,age,chest,pressure,chol,sugar,heartbeat, disease=1,"Training");
        	return "ok";
        }
	              
	    	   
}
public String checkAll()
{
	if(pressFlag==1)
	{
		return "pressNull";
	}
	if(cholFlag==1)
	{
		return "cholNull";
	}
	if(sugarFlag==1)
	{
		return "sugarNull";
	}
	if(ageFlag==1)
	{
		return "noAge";
	}
	if(heartFlag==1)
	{
		return "heartNull";
	}
	return "ok";
	
}

}


