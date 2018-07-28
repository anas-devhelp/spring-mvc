package com.jSolutions.entities.security;

public interface PermissionsNames {
	public static final String CREATE="CAN_CREATE";
	public static final String READ="CAN_READ";
	public static final String UPDATE="CAN_UPDATE";
	public static final String DELETE="CAN_DELETE";
	public static final String[] PERMISSIONS_ARR=new String[] {CREATE, READ, UPDATE, DELETE};
	public static final String[] ENTITIES_ARR=new String[] {"CATEGORY", "USER"};
}
