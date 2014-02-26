package net.drailing.findviewsbyannotation.support;

import java.lang.reflect.Field;

import android.app.Activity;

public class FindViewsByAnnotations {

	public static void init(Fragment frgmt, View v){
		
		for(Field f : frgmt.getClass().getDeclaredFields()){
			if(f.isAnnotationPresent(InitWithId.class)){
				InitWithId val = f.getAnnotation(InitWithId.class);
				f.setAccessible(true);
				try {
					f.set(frgmt, v.findViewById(val.value()));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void init(View v) {
		
		for (Field f : v.getClass().getDeclaredFields()) {
			if (f.isAnnotationPresent(InitWithId.class)) {
				InitWithId val = f.getAnnotation(InitWithId.class);
				f.setAccessible(true);
				try {
					f.set(v, v.findViewById(val.value()));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void init(Activity ctx){
		
		for(Field f : ctx.getClass().getDeclaredFields()){
			if(f.isAnnotationPresent(InitWithId.class)){
				InitWithId val = f.getAnnotation(InitWithId.class);
				f.setAccessible(true);
				try {
					f.set(ctx, ctx.findViewById(val.value()));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	
	
}
