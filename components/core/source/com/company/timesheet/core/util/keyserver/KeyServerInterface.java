package com.company.timesheet.core.util.keyserver;

/**
 * 
 * @author Rahul
 */
public interface KeyServerInterface {
	
	/**
	 * 
	 * @param paramString
	 * @return
	 */
	public abstract KeyServerBlock nextId(String paramString);

}
