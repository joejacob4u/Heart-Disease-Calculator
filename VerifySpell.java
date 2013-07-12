import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.xeustechnologies.googleapi.spelling.SpellChecker;
import org.xeustechnologies.googleapi.spelling.SpellCorrection;
import org.xeustechnologies.googleapi.spelling.SpellResponse;


public class VerifySpell {
	   
	SpellCorrection sc;
	String[] word;
	public String checkIt(String text)
	{
		
		String corrected=null;
		int flag=0; 
		SpellChecker checker = new SpellChecker();
		SpellResponse spellResponse = checker.check(text);
          if(spellResponse.getCorrections()!=null) 
          {
        	 
	      for( SpellCorrection sc : spellResponse.getCorrections() )
	     {
        	  
	    		    System.out.println( sc.getValue() );
			         corrected= sc.getValue().toString();
                     word=corrected.split("\t"); 
			          
		          
	     }
	      return word[0];
	      
          }
          else
          {
        	  return text;
          }
	}
          
          
	

}
