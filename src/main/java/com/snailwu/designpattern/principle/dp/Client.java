package com.snailwu.designpattern.principle.dp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 吴庆龙
 * @date: 2020/1/9 5:25 下午
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
class Employee { // 总公司员工
    private String id;
}

@Getter
@Setter
@ToString
@AllArgsConstructor
class SubEmployee { // 分公司员工
    private String id;
}

class CompanyManager {
    public List<Employee> getAllEmp() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Employee(i + ""));
        }
        return list;
    }

    public void printAllEmp(SubCompanyManager scm) {
        // 打印分公司员工
        scm.printEmp();

        // 打印总公司员工
        getAllEmp().forEach(System.out::println);
    }
}

class SubCompanyManager {
    public List<SubEmployee> getAllEmp() {
        List<SubEmployee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new SubEmployee(i + ""));
        }
        return list;
    }

    public void printEmp() {
        getAllEmp().forEach(System.out::println);
    }
}

public class Client {
    public static void main(String[] args) {
        CompanyManager cm = new CompanyManager();
        cm.printAllEmp(new SubCompanyManager());
    }
}
