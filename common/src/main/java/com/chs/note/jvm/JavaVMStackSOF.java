package com.chs.note.jvm;

/**
 * @author : HongSheng.Chen
 * @date : 2020/9/10 11:32
 */
public class JavaVMStackSOF {

    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
