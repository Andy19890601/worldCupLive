/* @(#) Page.java
 * Project:	carlicense
 * Package: cn.videoworks.carlicense.vo
 * Author:	LuoChuan
 * Date:	Apr 12, 2013
 * Copyright © 2010-2013 by Beijing VideoWorks Technology Co., Ltd. All rights reserved.
 */
package cn.edu.pku.live.util;


/**
 * @author rainisic
 * 
 */
public class Page {

	/** Default page size. */
	public static final int DEFAULT_SIZE = 6;
			//Integer.parseInt(getProperty("page.default_size"));

	/** Total page count. */
	private int count;

	/** Current page. */
	private int index;

	/** Page size. */
	private int size;

	/**
	 * Default constructor.
	 */
	public Page() {
		size = DEFAULT_SIZE;
		count = 1;
		index = 0;
	}
	
	/**
	 * Default constructor.
	 * @param index
	 * @param count
	 */
	public Page(int index, int count){
		this.index = index;
		this.count = count;
	}
	
	/**
	 * Default constructor.
	 * @param index
	 * @param count
	 * @param size
	 */
	public Page(int count, int index, int size){
		this.index = index;
		this.count = count;
		this.size = size;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Page [count=" + count + ", index=" + index + ", size=" + size
				+ "]";
	}
	
	
}
