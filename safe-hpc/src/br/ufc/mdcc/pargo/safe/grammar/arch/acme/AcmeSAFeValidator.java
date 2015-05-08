package br.ufc.mdcc.pargo.safe.grammar.arch.acme;

import java.net.URL;
import java.util.Set;

import org.acmestudio.acme.core.exception.AcmeVisitorException;
import org.acmestudio.acme.core.resource.IAcmeResource;
import org.acmestudio.acme.element.AbstractAcmeElementVisitor;
import org.acmestudio.acme.element.IAcmeElement;
import org.acmestudio.acme.environment.error.AcmeError;
import org.acmestudio.acme.model.IAcmeModel;
import org.acmestudio.acme.type.IAcmeSynchronousTypeChecker;
import org.acmestudio.acme.type.IAcmeTypeChecker;
import org.acmestudio.standalone.environment.StandaloneEnvironment;
import org.acmestudio.standalone.environment.StandaloneEnvironment.TypeCheckerType;
import org.acmestudio.standalone.resource.StandaloneResourceProvider;

public class AcmeSAFeValidator {

	private String familyFilename = "safe-hts-fam.acme";
	
	public static void main(String[] args) {
	    try{
	      (new AcmeSAFeValidator()).go();
	    }catch(Exception e) {
	      e.printStackTrace();
	    }
	  }
	
	public void go() throws Exception {
	    
		URL acmeFileURL = this.getClass().getResource(familyFilename);
		System.out.println(acmeFileURL.getFile());
		
	    // The synchronous typechecker allows you to be certain at any given time
	    // that the typechecking state is stable.
	    // By default, the system uses an asynchronous type checker.
	    StandaloneEnvironment.instance().useTypeChecker(TypeCheckerType.SYNCHRONOUS);
	    IAcmeResource resource = StandaloneResourceProvider.instance().acmeResourceForString(acmeFileURL.getFile());
	    IAcmeModel model = resource.getModel();
	    IAcmeTypeChecker checker = resource.getEnvironment().getTypeChecker();
	    if(checker instanceof IAcmeSynchronousTypeChecker) {
	    	IAcmeSynchronousTypeChecker tc = (IAcmeSynchronousTypeChecker)checker;
	    	tc.typecheckAllModelsNow();
	    }
	    model.visit(new visitor(), null);
	    
	    // call this to trigger the event dispatcher thread shutdown.
	    StandaloneResourceProvider.instance().releaseResource(resource);
	  }
	
	class visitor extends AbstractAcmeElementVisitor {
		  @Override
		public void postVisit(IAcmeElement element, Object data) throws AcmeVisitorException {
			  boolean typechecked = element.getContext().getEnvironment().getTypeChecker().typechecks(element);
			  System.out.println("Element "+element.getQualifiedName()+" does " + (typechecked ? "" : "not ") + "typecheck.");
			  if(!typechecked) {
				  // note: currently, this gets only the root cause of the errors (i.e. leaves of the error tree).
				  Set<? extends AcmeError> errs = element.getContext().getEnvironment().errorsByAffiliatedObject(element);
				  for(AcmeError err : errs) {
					  System.out.println("--> " + err.toString());
				  }
			  }
		}
	  }
}
