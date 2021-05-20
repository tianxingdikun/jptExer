package service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import work.compareTable.Column;

import javax.script.*;

import org.mozilla.javascript.Context;


public class JavaScriptFunction {

    @Test
    public void print() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval("print('hello word!!')");
    }

    @Test
    public void obj() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        StringBuffer script = new StringBuffer();
        script.append("var objb = new Object();");
        script.append("objb.helloaa = function(name){print('hello11, '+name);}");
        //执行这段script脚本
        engine.eval(script.toString());
        // javax.script.Invocable 是一个可选的接口
        // 检查你的script engine 接口是否已实现!
        // 注意：JavaScript engine实现了Invocable接口
        Invocable inv = (Invocable) engine;
        // 获取我们想调用那个方法所属的js对象
        Object obj = engine.get("objb");
        // 执行obj对象的名为hello的方法
        inv.invokeMethod(obj, "helloaa", "Script Method !!");
    }

    @Test
    public void file() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String a = "function process(jsonContent) {\n" +
                "var json = JSON.parse(jsonContent);\n" +
                "json.row.UPDATE_TIME = json.row.create_time;\n" +
                "return JSON.stringify(json);\n" +
                "}";
        engine.eval(a);
//        engine.eval(new java.io.FileReader(new File("E:\\candelete\\test0804.js")));
        Invocable inv = (Invocable) engine;
//        Object obj = engine.get("testFun");
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
        /*JSONObject data1 = new JSONObject();
        data1.put("value","8");
        data1.put("comment","asd");
        data1.put("datatype","fwe");
        data1.put("isCase","0");
        data1.put("length","100");
        data.put("update_time",data1);*/
        JSONObject data2 = new JSONObject();
        data2.put("value", "2");
        data2.put("comment", "fjs");
        data2.put("datatype", "long");
        data2.put("isCase", "0");
        data2.put("length", "50");
        data.put("create_time", data2);
        json.put("row", data);
//        json.put("rule_id","9866264f-6047-4871-99d5-05ca53ac03b2");
//        json.put("database_id","99");
//        json.put("job_id","JOB_4_MAPPING");
//        json.put("rule_type","2");
        System.out.println("初始json：" + json);
        String s = inv.invokeFunction("process", json).toString();
        System.out.println(s);
    }

    @Test
    public void filea() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String a = "function process() {}";
        engine.eval(a);
//        engine.eval(new java.io.FileReader(new File("E:\\candelete\\test0804.js")));
        Invocable inv = (Invocable) engine;
//        Object obj = engine.get("testFun");
        Column column = new Column("秦", "string", 100);
        String s = inv.invokeFunction("process", column).toString();
        System.out.println(s);
    }


    /**
     * 脚本变量
     *
     * @throws Exception
     */
    @Test
    public void scriptVar() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        File file = new File("E:\\candelete\\test.js");
        //将File对象f直接注入到js脚本中并可以作为全局变量使用
        engine.put("files", file);
        engine.eval("print(files.getPath());print(files.getName());");
    }

    /**
     * 使用Script实现java接口
     *
     * @throws Exception
     */
    public void runnableImpl() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // String里定义一段JavaScript代码脚本
        String script = "function run() { print('run called'); }";
        // 执行这个脚本
        engine.eval(script);

        // 从脚本引擎中获取Runnable接口对象（实例）. 该接口方法由具有相匹配名称的脚本函数实现。
        Invocable inv = (Invocable) engine;
        // 在上面的脚本中，我们已经实现了Runnable接口的run()方法
        Runnable runnable = inv.getInterface(Runnable.class);

        // 启动一个线程运行上面的实现了runnable接口的script脚本
        Thread thread = new Thread(runnable);
        thread.start();
    }

    /**
     * 脚本引擎的多个scope
     *
     * @throws Exception
     */
    @Test
    public void multiScopes() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        // 打印全局变量 "x"
        engine.put("x", "hello word!!");
        engine.eval("print(x);");
        // 上面的代码会打印"hello word！！"

        // 现在，传入另一个不同的script context
        ScriptContext context = new SimpleScriptContext();
        //新的Script context绑定ScriptContext的ENGINE_SCOPE
        Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);

        // 增加一个新变脸到新的范围 engineScope 中
        bindings.put("x", "word hello!!");
        // 执行同一个脚本 - 但这次传入一个不同的script context
        engine.eval("print(x);", bindings);
        engine.eval("print(x);");
    }


    public static void main160(String[] args) throws Exception {
        new JavaScriptFunction().runnableImpl();

        List list = new ArrayList();
        list.add("1");
        list.add("1");
        list.add("1");

        for (Object object : list) {
            System.out.println(object);
        }

    }


    /**
     * ---------------解释执行简单字符串---------------
     */
    public static void main174(String[] args) throws ScriptException {
        ScriptEngineManager seManager = new ScriptEngineManager();
        ScriptEngine se = seManager.getEngineByName("js");
        Object ret = se.eval("3+4;");
        System.out.println(ret);
    }

    public static void main189(String[] args) throws ScriptException {
        ScriptEngineManager seManager = new ScriptEngineManager();
        ScriptEngine se = seManager.getEngineByName("js");
        Bindings bindings = se.createBindings();
        bindings.put("user", "new User(\"张三\",19)");
        Object ret = se.eval("print(user.getName()); " +
                "if(user.age>=18) '已成年'; else '未成年';", bindings);
        System.out.println(ret);
    }


    /**
     * --------------编译执行简单字符串-------------------
     */
    public static void main201(String[] args) throws ScriptException {
        ScriptEngineManager seManager = new ScriptEngineManager();
        ScriptEngine se = seManager.getEngineByName("js");
        Compilable ce = (Compilable) se;
        String script = "println(user.getName()+'的年龄为'+user.getAge());" +
                "if(user.age>=18) '已成年'; else '未成年';";
        CompiledScript cs = ce.compile(script);
        Bindings bindings = se.createBindings();
        bindings.put("user", "new User(\"张三\",19)");
        Object ret = cs.eval(bindings);
        System.out.println(ret);
    }


    /**
     * -------解释执行js函数-------------
     */
    public static void main217(String[] args) throws ScriptException {
        ScriptEngineManager seManager = new ScriptEngineManager();
        ScriptEngine se = seManager.getEngineByName("js");
        String script = "function sum(a,b) { return a+b; }";
        se.eval(script);
        Object ret = se.eval("sum(3,4)");
    }

    /**
     * --------------编译执行js函数-------------------
     */
    public static void main226(String[] args) throws ScriptException {
        ScriptEngineManager seManager = new ScriptEngineManager();
        ScriptEngine se = seManager.getEngineByName("js");
        Compilable ce = (Compilable) se;
        String script = "function sum(a,b) { return a+b; } sum(a,b);";
        CompiledScript cs = ce.compile(script);
        Bindings bindings = se.createBindings();
        bindings.put("a", 3);
        bindings.put("b", 4);
        Object ret = cs.eval(bindings);
        System.out.println(ret);
    }

    /*-----------高级用法js函数-----------------*/
    public static void main240(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        // JavaScript code in a String
        String script = "function hello(name) { print('Hello, ' + name); }";
        // evaluate script
        engine.eval(script);
        // javax.script.Invocable is an optional interface.
        // Check whether your script engine implements or not!
        // Note that the JavaScript engine implements Invocable interface.
        Invocable inv = (Invocable) engine;
        // invoke the global function named "hello"
        inv.invokeFunction("hello", "Scripting!!");
    }

    /*---------------高级用法2js函数-----------------*/
    public static void main256(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        // JavaScript code in a String. This code defines a script object 'obj'
        // with one method called 'hello'.
        String script = "var obj = new Object(); obj.hello = function(name) { print('Hello, ' + name); }";
        // evaluate script
        engine.eval(script);
        // javax.script.Invocable is an optional interface.
        // Check whether your script engine implements or not!
        // Note that the JavaScript engine implements Invocable interface.
        Invocable inv = (Invocable) engine;
        // get script object on which we want to call the method
        Object obj = engine.get("obj");
        // invoke the method named "hello" on the script object "obj"
        inv.invokeMethod(obj, "hello", "Script Method !!");
    }


    public static void main282(String[] args) {
        Context ctx = Context.enter();
        try {
            Scriptable scope = ctx.initStandardObjects();
            String str = "9*(1+2)";
            Object result = ctx.evaluateString(scope, str, null, 1, null);
            double res = Context.toNumber(result);
            System.out.println(res);
        } finally {
            Context.exit();
        }
    }


    public static void main(String[] args) throws Exception {
        JavaScriptFunction test = new JavaScriptFunction();
        int a = 1;
        System.out.println("三种引擎，各尝试循环1000000次，单位ms");
        test.bbb(a);
//        test.abc(a);
        test.kkk(a);
    }

    public void bbb(int a) throws Exception {
//        int a = 100;
        String json = "{\"SURVEYOBJECTID\":\"234687268746287687326482832647\"}";
        long start = System.currentTimeMillis();
        String js = "function process(jsonContent) {\n" +
                " var json = JSON.parse(jsonContent);\n" +
                "var ADMINORG_Value = null;\n" +
                "if(json['SURVEYOBJECTID']!= undefined && json.SURVEYOBJECTID.value != null) { ADMINORG_Value = json.SURVEYOBJECTID.value.substring(2, 14); }\n" +
                "if (json['ADMINORG']== undefined){\n" +
                "json.ADMINORG = {};\n" +
                "json.ADMINORG.value = ADMINORG_Value;\n" +
                "}\n" +
                "if (json['TABNO_109_1']== undefined){\n" +
                "json.TABNO_109_1 = {};\n" +
                "json.TABNO_109_1.value = \"109_1\";\n" +
                "}\n" +
                "  return JSON.stringify(json);\n" +
                "}";
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("JavaScript");
        Compilable compilable = (Compilable) engine;
        CompiledScript compiledScript = compilable.compile(js);
        compiledScript.eval();
        Invocable invocable = (Invocable) compiledScript.getEngine();
        for (int i = 0; i < a; i++) {
            String outJson = invocable.invokeFunction("process", json).toString();
//            System.out.println("返回结果： " + outJson);
        }
        long end = System.currentTimeMillis();
        System.out.println("【ScriptEngine】时间 " + (end - start));

    }

    public static void abc(int a) {
//        int a = 100000;
        String json = "{\"SURVEYOBJECTID\":\"234687268746287687326482832647\"}";
        long start = System.currentTimeMillis();
        String js = "function process(jsonContent) {\n" +
                " var json = JSON.parse(jsonContent);\n" +
                "var ADMINORG_Value = null;\n" +
                "if(json['SURVEYOBJECTID']!= undefined && json.SURVEYOBJECTID.value != null) { ADMINORG_Value = json.SURVEYOBJECTID.value.substring(2, 14); }\n" +
                "if (json['ADMINORG']== undefined){\n" +
                "json.ADMINORG = {};\n" +
                "json.ADMINORG.value = ADMINORG_Value;\n" +
                "}\n" +
                "if (json['TABNO_109_1']== undefined){\n" +
                "json.TABNO_109_1 = {};\n" +
                "json.TABNO_109_1.value = \"109_1\";\n" +
                "}\n" +
                "  return JSON.stringify(json);\n" +
                "}";
        String jsFunction = "process";


        try {
            Context cx = Context.enter();
            Scriptable scope = cx.initStandardObjects();
            cx.evaluateString(scope, js, null, 1, null);
            Object functionArgs[] = {json};
            Function f = (Function) scope.get(jsFunction, scope);
            for (int i = 0; i < a; i++) {
                Object result = f.call(cx, scope, scope, functionArgs);
//                System.out.println("返回结果： " + Context.toString(result));
            }
        } finally {
            Context.exit();
        }

        long end = System.currentTimeMillis();
        System.out.println("【rhino时间】" + (end - start));
    }

    public void kkk(int a) throws Exception {
        String json = "{\"SURVEYOBJECTID\":{\"value\":\"234687268746287687326482832647\"}}";
        long start = System.currentTimeMillis();
        String js = "function process(jsonContent) {\n" +
                " var json = JSON.parse(jsonContent);\n" +
                "var ADMINORG_Value = null;\n" +
                "if(json['SURVEYOBJECTID']!= undefined && json.SURVEYOBJECTID.value != null) { ADMINORG_Value = json.SURVEYOBJECTID.value.substring(2, 14); }\n" +
                "if (json['ADMINORG']== undefined){\n" +
                "json.ADMINORG = {};\n" +
                "json.ADMINORG.value = ADMINORG_Value;\n" +
                "}\n" +
                "if (json['TABNO_109_1']== undefined){\n" +
                "json.TABNO_109_1 = {};\n" +
                "json.TABNO_109_1.value = \"109_1\";\n" +
                "}\n" +
                "  return JSON.stringify(json);\n" +
                "}";
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        Compilable compilable = (Compilable) engine;
        CompiledScript compiledScript = compilable.compile(js);
        compiledScript.eval();
        Invocable invocable = (Invocable) compiledScript.getEngine();
        for (int i = 0; i < a; i++) {
            String outJson = invocable.invokeFunction("process", json).toString();
            System.out.println("返回结果： " + outJson);
        }
        long end = System.currentTimeMillis();
        System.out.println("【nashorn】时间 " + (end - start));

    }


}
