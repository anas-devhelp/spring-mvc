package com.jSolutions.tags;

import java.util.Collection;

public class TagsUtil {
	public static boolean contains(Collection<?> coll, Object o) {
		if (coll == null) return false;
		return coll.contains(o);
	}
}
