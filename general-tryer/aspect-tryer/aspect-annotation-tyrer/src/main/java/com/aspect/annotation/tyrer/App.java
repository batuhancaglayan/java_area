package com.aspect.annotation.tyrer;

import org.aspectj.lang.Aspects;

import com.aspect.annotation.tyrer.trigger.DenemeTrigger;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//        Class myConcreteAspectClass;
//		try {
//			myConcreteAspectClass = Class.forName("com.aspect.annotation.tyrer.aspect.DenemeAspect");
//	        Aspects.aspectOf(myConcreteAspectClass);
//	 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		DenemeTrigger denemeTrigger = new DenemeTrigger();
		String abc = denemeTrigger.trigger();
		System.out.println(abc);
	}
}
