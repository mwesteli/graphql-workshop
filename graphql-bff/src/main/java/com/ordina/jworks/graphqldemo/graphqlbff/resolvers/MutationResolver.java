package com.ordina.jworks.graphqldemo.graphqlbff.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ordina.jworks.graphqldemo.graphqlbff.employeeclient.EmployeeClient;
import com.ordina.jworks.graphqldemo.graphqlbff.employeeclient.model.ContractType;
import com.ordina.jworks.graphqldemo.graphqlbff.employeeclient.model.Employee;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    private final EmployeeClient employeeClient;

    public MutationResolver(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    public CompletableFuture<Employee> addEmployee(String firstName,
                                                  String lastName,
                                                  String email,
                                                  String mobile,
                                                  String carLicensePlate,
                                                  ContractType contractType
                                ) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setMobile(mobile);
        employee.setCarLicencePlate(carLicensePlate);
        employee.setContractType(contractType);
        return CompletableFuture.supplyAsync(() -> employeeClient.save(employee).getContent());
    }

}
