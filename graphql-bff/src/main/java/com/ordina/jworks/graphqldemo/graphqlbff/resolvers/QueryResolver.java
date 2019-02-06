package com.ordina.jworks.graphqldemo.graphqlbff.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ordina.jworks.graphqldemo.graphqlbff.carclient.CarClient;
import com.ordina.jworks.graphqldemo.graphqlbff.carclient.model.Car;
import com.ordina.jworks.graphqldemo.graphqlbff.employeeclient.EmployeeClient;
import com.ordina.jworks.graphqldemo.graphqlbff.employeeclient.model.Employee;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class QueryResolver implements GraphQLQueryResolver{

    private final CarClient carClient;
    private final EmployeeClient employeeClient;

    public QueryResolver(CarClient carClient, EmployeeClient employeeClient) {
        this.carClient = carClient;
        this.employeeClient = employeeClient;
    }

    public Employee getEmployee(Integer id) {
        return employeeClient.getEmployee(id).getContent();
    }

    public Collection<Employee> getEmployees() {
        return employeeClient.getEmployees().getContent();
    }

    public Car getCar(Integer id){
        return carClient.getCar(id).getContent();
    }

    public Collection<Car> getCars(){
        return carClient.getCars().getContent();
    }
}
