package com.lc.server.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
	private List<Entity> entitys = null;
	private List<Mapping> mappings = null;

// 	key -> servlet-name   value -> servlet class
	private Map<String, String> entityMap = new HashMap<String, String>();
//	key -> url-pattern    value ->servlet-name
	private Map<String, String> mappingMap = new HashMap<String, String>();

	public WebContext(List<Entity> entitys, List<Mapping> mappings) {
		super();
		this.entitys = entitys;
		this.mappings = mappings;
		
		for(Entity entity : entitys) {
			entityMap.put(entity.getName(),entity.getClz());
		}
		for(Mapping mapping : mappings) {
			for(String pattern : mapping.getPatterns()) {
				mappingMap.put(pattern,mapping.getName());
				//System.out.println(pattern);
			}
			
		}
		
	}

	public WebContext() {
	}

	public String getClz(String pattern) {
		String name = mappingMap.get(pattern);
		
		return entityMap.get(name);
	}

}
