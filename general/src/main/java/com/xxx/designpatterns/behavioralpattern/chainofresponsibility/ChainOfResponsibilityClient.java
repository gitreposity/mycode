package com.xxx.designpatterns.behavioralpattern.chainofresponsibility;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  比如说公司请假需要审批，举个不恰当的例子，
 *  如果请假小于3天，主管审批；3-10天的，经理审批；10-30天的，
 *  总经理审批；超过30天的，不批准等等。这就得一步步去判断，
 *  如果撇开设计模式不看的话，那么我们可以使用if…else…把它解决了，
 *  但是问题可想而知，实际中的复杂程度时远远超过这个例子的。
 */
public class ChainOfResponsibilityClient {
    public static void main(String[] args) {
        Leader director = new Director("张三");
        Leader manager = new Manager("李四");
        Leader gManager = new GeneralManager("王五");

        // 组织好责任链对象的关系
        director.setNextLeader(manager);
        manager.setNextLeader(gManager);

        // 开始请假操作
        LeaveRequest request = new LeaveRequest("倪升武", 100, "在家睡觉");
        director.handleRequest(request);
    }
}

/**
 * @Description 封装请假的基本信息
 *
 */
@Data
@NoArgsConstructor
class LeaveRequest {

    private String name;
    private int leaveDays;
    private String reason;

    public LeaveRequest(String name, int leaveDays, String reason) {
        this.name = name;
        this.leaveDays = leaveDays;
        this.reason = reason;
    }
}


/**
 * @Description 领导的抽象类
 *
 */
@Data
@NoArgsConstructor
abstract class Leader {

    protected String name;

    //责任链上的后继对象，即这个对象无法处理，就转移给下一个Leader
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }
    // 设定责任链上的后继对象
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * 处理请求的核心的业务方法
     * 需要不同继承该类的领导自己实现
     */
    public abstract void handleRequest(LeaveRequest request);

}

/**
 * @Description 主任
 * @author Ni Shengwu
 *
 */
class Director extends Leader {

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {

        int days = request.getLeaveDays(); //获取请假天数
        String name = request.getName(); //获取请假人姓名
        String reason = request.getReason(); // 获取请假理由

        if(days <= 3) { //如果满足3天内的要求，主任直接审批
            System.out.println("员工" + name + "请假" + days + "天，理由：" + reason);
            System.out.println("主任" + this.name + "审批通过");
        } else {
            System.out.println("请假天数过多，主任" + this.name + "没法处理");
            if(this.nextLeader != null) { //否则，如果链上存在下一个Leader，就让他处理
                this.nextLeader.handleRequest(request);
            }
        }
    }

}


/**
 * @Description 经理
 *
 */
class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {

        int days = request.getLeaveDays(); //获取请假天数
        String name = request.getName(); //获取请假人姓名
        String reason = request.getReason(); // 获取请假理由

        if(days <= 10) { //如果满足10天内的要求，经理直接审批
            System.out.println("员工" + name + "请假" + days + "天，理由：" + reason);
            System.out.println("经理" + this.name + "审批通过");
        } else {
            System.out.println("请假天数过多，经理" + this.name + "没法处理");
            if(this.nextLeader != null) { //否则，如果链上存在下一个Leader，就让他处理
                this.nextLeader.handleRequest(request);
            }
        }
    }

}

/**
 * @Description 总经理
 * @author Ni Shengwu
 *
 */
class GeneralManager extends Leader {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {

        int days = request.getLeaveDays(); //获取请假天数
        String name = request.getName(); //获取请假人姓名
        String reason = request.getReason(); // 获取请假理由

        if(days <= 30) { //如果满足30天内的要求，总经理直接审批
            System.out.println("员工" + name + "请假" + days + "天，理由：" + reason);
            System.out.println("总经理" + this.name + "审批通过");
        } else {
            System.out.println("请假天数过多，总经理" + this.name + "没法处理");
            if(this.nextLeader != null) { //否则，如果链上存在下一个Leader，就让他处理
                this.nextLeader.handleRequest(request);
            } else {
                System.out.println("请假不成功");
            }
        }
    }
}
