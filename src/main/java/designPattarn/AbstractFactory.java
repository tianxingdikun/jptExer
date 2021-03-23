package designPattarn;

/**
 * 设计模式3-抽象工厂模式
 */
public class AbstractFactory {

    /**
     *实例化对象中包含所有方法
     *
     * 不好扩展；违反对修改关闭，对扩展开放
     * @param args
     */
    public static void main(String[] args) {
        // 第一步就要选定一个“大厂”
//        ComputerFactory cf = new AmdFactory();
        // 从这个大厂造 CPU
//        CPU cpu = cf.makeCPU();
        // 从这个大厂造主板
//        MainBoard board = cf.makeMainBoard();
        // 从这个大厂造硬盘
//        HardDisk hardDisk = cf.makeHardDisk();

        // 将同一个厂子出来的 CPU、主板、硬盘组装在一起
//        Computer result = new Computer(cpu, board, hardDisk);
    }

}
