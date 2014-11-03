package spoonProcessor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;


    public class ReplaceProcessorDecl extends AbstractProcessor<CtVariable> {
        List<CtTypeReference<?>> actualTypeArguments;
        
        CtTypeReference actualType;
        
        public void process(CtVariable varDecl) {
            actualTypeArguments = varDecl.getType().getActualTypeArguments();
            actualType = varDecl.getType();
            System.out.println(actualType);
            if (actualTypeArguments.toString().equals("[java.lang.String]")) {// summum de la mocheté a changer impérativement

               actualType.setSimpleName("LinkedList");
              //  actualTypeArguments.get(0).setSimpleName("android.linge.truc");
            }
        }

        @Override
        public void processingDone() {
            String simpleName, body;
            char header;
            super.processingDone();



        }
    }


