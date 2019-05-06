/**
 * Date:     2019/4/1822:35
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.basic.reference;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用弱引用
 * 2019/4/18  22:35
 * created by zhoumb
 */
public class WeekReferenceTest {
    private static ReferenceQueue<NormalObject> referenceQueue = new ReferenceQueue<>();

    @Test
    public void testWeekReference() throws InterruptedException {
        List<WeakReference<NormalObject>> weakReferenceList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            WeakReference<NormalObject> weekReference = new WeakReference<NormalObject>(new NormalObject("name" + i), referenceQueue);
            weakReferenceList.add(weekReference);
        }
        checkQueue();
        WeakReference<NormalObject> normalObjectWeakReference = weakReferenceList.get(0);
        NormalObject normalObject = normalObjectWeakReference.get();
        System.out.println(normalObject.getName());
        System.gc();
        Thread.sleep(1000);
        System.out.println("--------------------------------------------");
        checkQueue();
    }

    private static void checkQueue() {
        Reference<NormalObject> ref = null;
        while ((ref = (Reference<NormalObject>) referenceQueue.poll()) != null) {
            if (ref != null) {
                System.out.println("reference object:" + ref.get());
            }
        }
    }
}
