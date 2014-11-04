package spoonProcessor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;
import spoon.support.reflect.declaration.CtConstructorImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceProcessorDecl extends AbstractProcessor<CtConstructorImpl> {


    /**
     * Replace all ArrayList in the constructor
     * ex :
     * A = new Arraylist....
     * A.add(1)
     * A.add(2)
     * to
     * A = Lists.newArrayList(1,2)
     * @param element  Read all elements in Constructor
     */
    @Override
    public void process(CtConstructorImpl element) {

        CtBlock body = element.getBody();
        List<CtStatement> statement = body.getStatements();
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> arrayInst = new ArrayList<>();
        ArrayList<String> finalInst = new ArrayList<>();
        ArrayList<Integer> toRem = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        int i = 0;

        /**
         * Complete arrayInst
         */
        for (CtStatement ct : statement) {

            String s = ct.toString();
            lines.add(s);
            if (s.contains("new java.util.ArrayList")) {
                arrayInst.add(returnInst(s));
                String g = i + "";
                map.put(returnInst(s), g);

            }
            i++;
        }

        /**
         * Complete finalInst and toRem
         */
        for (String s : arrayInst) {
            String ph = "";
            String be = "";
            for (String s2 : lines) {

                if (s2.contains(s + ".add(")) {
                    if (ph.equals("")) {
                        ph = s2.substring(s2.indexOf(".add(") + 5, s2.lastIndexOf(")"));
                    } else {
                        ph += "," + s2.substring(s2.indexOf(".add(") + 5, s2.lastIndexOf(")"));
                    }
                    be = s;
                    toRem.add(lines.indexOf(s2));
                }
            }
            if (!be.equals("")) {
                finalInst.add(be + "= Lists.newArrayList(" + ph + ")" + "|" + map.get(be));
            }

        }

        /**
         * Replace the change to do
         */
        i = 0;
        for (CtStatement ct : statement) {
            for (String s : finalInst) {
                int j = Integer.parseInt(returnEnd(s));
                if (i == j) {
                    statement.set(i, getFactory().Code().createCodeSnippetStatement(returnBeg(s)));
                }

            }
            for (int k : toRem) {
                if (i == k) {
                    statement.set(i, getFactory().Code().createCodeSnippetStatement(""));
                }
            }
            i++;
        }

        element.getBody().setStatements(statement);

    }


    /**
     *
     * @return Return the first word
     */
    public static String returnInst(String string) {
        String[] tab = string.split(" ");
        String[] tab2 = string.split("=");
        if (tab[0].length() > tab2[0].length()) return tab2[0];
        return tab[0];
    }

    /**
     *
     * @return the text after "|"
     */
    public static String returnEnd(String s) {
        return s.substring(s.lastIndexOf("|") + 1, s.length());
    }

    /**
     *
     * @return the text before "|"
     */
    public static String returnBeg(String s) {
        return s.substring(0, s.lastIndexOf("|"));
    }

    @Override
    public void processingDone() {
        super.processingDone();
    }
}


