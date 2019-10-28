package com.object.creation.tryer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			
			
			Class.forName("com.object.creation.tryer.Deneme");

			Class<?> type = Deneme.class;

			Class<?> ref = Class.forName("com.object.creation.tryer.Deneme");
			Deneme deneme1 = (Deneme) ref.newInstance();
			System.out.println("with class forname => " + deneme1.getName());

			Deneme deneme2 = (Deneme) type.getClassLoader().loadClass("com.object.creation.tryer.Deneme").newInstance();
			System.out.println("with get classloader => " + deneme2.getName());

			Deneme deneme3 = (Deneme) type.newInstance();
			System.out.println("with newInstance() => " + deneme3.getName());

			// Constructor invoke any constructor.
			Constructor<?> constructor = type.getConstructor();
			Deneme deneme4 = (Deneme) constructor.newInstance();
			System.out.println("with constructor newInstance() => " + deneme4.getName());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();

		Deneme deneme = new Deneme();

		Class<?> denemeCls = deneme.getClass();
		System.out.println("class name => " + denemeCls.getName());

		try {
			Constructor<?> constructor = denemeCls.getConstructor();
			System.out.println("constructor name => " + constructor.getName());

			Method[] methodArr = denemeCls.getMethods();
			for (int i = 0; i < methodArr.length; i++) {
				System.out.println("method => " + methodArr[i]);
			}

			Method methodcall1 = denemeCls.getDeclaredMethod("getPower", int.class);
			Object result1 = methodcall1.invoke(deneme, 10);
			System.out.println(result1);

			Field field = denemeCls.getDeclaredField("name");
			// be accessible private field
			field.setAccessible(true);
			field.set(deneme, "JAVA");
			Object result2 = field.get(deneme);
			System.out.println(result2);

			Field[] fieldArr = denemeCls.getDeclaredFields();
			for (int i = 0; i < fieldArr.length; i++) {
				System.out.println("field name => " + fieldArr[i].getName());

				System.out.println("field type => " + fieldArr[i].getType().getSimpleName());
				fieldArr[i].setAccessible(true);
				System.out.println("field value => " + fieldArr[i].get(deneme));

				System.out.println("field type is string => " + fieldArr[i].getType().isAssignableFrom(String.class));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
