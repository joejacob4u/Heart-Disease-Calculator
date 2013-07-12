import weka.classifiers.Evaluation;
import weka.classifiers.meta.ClassificationViaRegression;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.experiment.InstanceQuery;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;



public class Weka {
	public double start() throws Exception
	{
		double pred=0;
		InstanceQuery query = new InstanceQuery();
		query.setDatabaseURL("jdbc:mysql://localhost:8889/Health");
		InstanceQuery query2 = new InstanceQuery();
		query2.setDatabaseURL("jdbc:mysql://localhost:8889/Health");
		 query.setUsername("root");
		 query.setPassword("root");
		 query2.setUsername("root");
		 query2.setPassword("root");
		 query.setQuery("SELECT * FROM Training");
		 Instances train = query.retrieveInstances();
		 train.setClassIndex(train.numAttributes() - 1);
		
		 
		 query2.setQuery("SELECT * FROM Test");
		 Instances test=query2.retrieveInstances();
		 
		 test.setClassIndex(test.numAttributes() - 1);
		 
		 
		 
		J48 classified=new J48();
		 classified.buildClassifier(train);
		 //Evaluation eval = new Evaluation(test);
		 //eval.evaluateModel(classified, test);
		 //System.out.println(eval.toSummaryString("\nResults\n======\n", false));
		 for (int i = 0; i < train.numInstances(); i++) {
		       //test.instance(i).setMissing(test.numAttributes() - 1);	 
			    pred = classified.classifyInstance(train.instance(i));
			   System.out.print("ID: " + train.instance(i).value(0));
			   System.out.print(", actual: " + train.classAttribute().value((int) train.instance(i).classValue()));
			   System.out.println(", predicted: " + train.classAttribute().value((int) pred));
	}
          return pred;
}}
