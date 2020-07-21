package service;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import javax.script.*;


public class JavaScriptFunction {

    @Test
    public void print() throws Exception{
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
        inv.invokeMethod(obj, "helloaa", "Script Method !!" );
    }

    @Test
    public void file() throws Exception{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval(new java.io.FileReader(new File("E:\\candelete\\test.js")));
        Invocable inv = (Invocable) engine;
//        Object obj = engine.get("testFun");
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
        JSONObject data1 = new JSONObject();
        data1.put("value","8");
        data1.put("comment","");
        data1.put("datatype","");
        data1.put("isCase","");
        data1.put("length","");
        data.put("bjStatus",data1);
        JSONObject data2 = new JSONObject();
        data2.put("value","2");
        data2.put("comment","");
        data2.put("datatype","");
        data2.put("isCase","");
        data2.put("length","");
        data.put("acceptStatus",data2);
        json.put("row",data);
//        json.put("rule_id","9866264f-6047-4871-99d5-05ca53ac03b2");
//        json.put("database_id","99");
//        json.put("job_id","JOB_4_MAPPING");
//        json.put("rule_type","2");
        System.out.println("初始json："+json);
        String s = inv.invokeFunction("process", json).toString();
        System.out.println(s);
    }


    /**
     * 脚本变量
     * @throws Exception
     */
    @Test
    public void scriptVar() throws Exception{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        File file = new File("E:\\candelete\\test.js");
        //将File对象f直接注入到js脚本中并可以作为全局变量使用
        engine.put("files", file);
        engine.eval("print(files.getPath());print(files.getName());");
    }

    /**
     *  使用Script实现java接口
     * @throws Exception
     */
    public void runnableImpl() throws Exception{
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
     * @throws Exception
     */
    @Test
    public void multiScopes() throws Exception{
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



    public static void main(String[] args) throws Exception {
        new JavaScriptFunction().runnableImpl();

        List list = new ArrayList();
        list.add("1");
        list.add("1");
        list.add("1");

        for (Object object : list) {
            System.out.println(object);
        }

    }
}
