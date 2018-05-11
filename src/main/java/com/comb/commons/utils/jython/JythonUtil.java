package com.comb.commons.utils.jython;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 */
public class JythonUtil {

    public static void printOnConsole() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("days=('mod','Tue','Wed','Thu','Fri','Sat','Sun'); ");   ///执行python脚本
        interpreter.exec("print days[1];");
    }

    public static void getReturn() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("E:\\ideaworkspace\\xcore\\src\\main\\resources\\my_utils.py");
        PyFunction func = (PyFunction) interpreter.get("adder",PyFunction.class);

        int a = 2010, b = 2;
        PyObject pyobj = func.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println("anwser = " + pyobj.toString());
    }

//    public static void main(String[] args) {
//        PythonInterpreter interpreter = new PythonInterpreter();
//        interpreter.execfile("E:\\ideaworkspace\\xcore\\src\\main\\resources\\readExcelEasy.py");
//    }



}
