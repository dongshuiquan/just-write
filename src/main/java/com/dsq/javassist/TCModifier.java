package com.dsq.javassist;


import javassist.*;

/**
 * Created by DELL on 2018/9/25.
 */
public class TCModifier {
    public static String DO_TASK_PNL = null;
    public static String DECISION_DLG = null;

    static {

        DECISION_DLG = "com.dsq.javassist.HelloWorld";
    }

    public static String modify() {
        String ret = null;
        try {
            ClassPool pool = ClassPool.getDefault();

            pool.importPackage("java.util");
            pool.importPackage("javax.swing");

            ClassLoader loader = TCModifier.class.getClassLoader();
            //TCModifier.modifyDoTaskPanel(pool, loader);
            TCModifier.modifyDecisionDialog(pool, loader);
        }
        catch (Exception e) {
            ret = "TCModifier.modify() Error: " + e.getMessage();
            e.printStackTrace();
        }
        return ret;
    }

    public static void modifyDecisionDialog(ClassPool pool, ClassLoader loader) throws Exception {
        CtClass clzReview = pool.get(DECISION_DLG);
        if (clzReview.isFrozen()) {
            return;
        }
        CtMethod method = clzReview.getDeclaredMethod("test");
        String st = "{  new com.dsq.javassist.DecisionDialogUtil();}";
        //String st = "{ System.out.println(12); }";
        method.insertAfter(st);
        clzReview.toClass(loader, null);
    }

    public static void modifyDoTaskPanel(ClassPool pool, ClassLoader loader) throws Exception {
        CtClass clzDO = pool.get(DO_TASK_PNL);
        if (clzDO.isFrozen()) {
            return;
        }
        CtField hMap = CtField.make((String)"public HashMap hMap = new HashMap();", (CtClass)clzDO);
        clzDO.addField(hMap);
        CtClass p1 = pool.get("com.teamcenter.rac.aif.AIFDesktop");
        CtClass p21 = pool.get("javax.swing.JPanel");
        CtClass p22 = pool.get("com.teamcenter.rac.aif.AbstractAIFDialog");
        CtClass p3 = pool.get("com.teamcenter.rac.kernel.TCComponentTask");
        CtClass[] ps1 = new CtClass[]{p1, p21, p3};
        CtConstructor cnsDO1 = clzDO.getDeclaredConstructor(ps1);
        String st1 = "{ hMap.clear(); hMap.put(\"desktop\", $1); hMap.put(\"panel\", $2); hMap.put(\"task\", $3); }";
        cnsDO1.insertAfter(st1);
        CtClass[] ps2 = new CtClass[]{p1, p22, p3};
        CtConstructor cnsDO2 = clzDO.getDeclaredConstructor(ps2);
        String st2 = "{ hMap.clear(); hMap.put(\"desktop\", $1); hMap.put(\"dialog\", $2); hMap.put(\"task\", $3); DoTaskPanelUtil util = new DoTaskPanelUtil(this); util.doCustomization(); }";
        cnsDO2.insertAfter(st2);
        clzDO.toClass(loader, null);
    }
}

