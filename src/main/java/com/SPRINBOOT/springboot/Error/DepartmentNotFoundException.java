package com.SPRINBOOT.springboot.Error;

public class DepartmentNotFoundException extends Exception {
    public DepartmentNotFoundException() {
    }
 
    public DepartmentNotFoundException(String var1) {
       super(var1);
    }
 
    public DepartmentNotFoundException(String var1, Throwable var2) {
       super(var1, var2);
    }
 
    public DepartmentNotFoundException(Throwable var1) {
       super(var1);
    }
 
    protected DepartmentNotFoundException(String var1, Throwable var2, boolean var3, boolean var4) {
       super(var1, var2, var3, var4);
    }
}
