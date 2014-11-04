package spoonProcessor;

import junit.framework.TestCase;
import spoon.Launcher;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;
import spoon.support.compiler.FileSystemFolder;
import java.io.File;

public class ListProcessorTest extends TestCase {

    /**
     * test three transformations : Immutability and inferences (LinkedList + ArrayList)
     * @throws Exception
     */
    public void testProcess() throws Exception {
        Launcher spoon = new Launcher();
        System.out.println(new File("src").getAbsoluteFile());
        spoon.addInputResource(new FileSystemFolder(new File("Spooner/src/main/java/spoonProcessed")));
        spoon.run();
        Factory factory = spoon.getFactory();
        ProcessingManager p = new QueueProcessingManager(factory);
        ListProcessor proc = new ListProcessor();
        p.addProcessor(proc);
        p.process(factory.Class().getAll());
       // assertEquals(3, proc.getInfArrayChange());
        //assertEquals(2, proc.getImListChange());
      //  assertEquals(3, proc.getInfLinkedListChange());
    }
}