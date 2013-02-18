package net.drailing.findviewsbyannotation.support;

import java.lang.reflect.Field;

import android.app.Activity;

public class FindViewsByAnnotations {

	
	public static void init(Activity ctx){
		
		for(Field f : ctx.getClass().getDeclaredFields()){
			if(f.isAnnotationPresent(InitWithId.class)){
				InitWithId debug = f.getAnnotation(InitWithId.class);
				f.setAccessible(true);
				try {
					f.set(ctx, ctx.findViewById(debug.value()));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	
	
}
