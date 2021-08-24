import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee'
import { EmployeeServiceService } from '../employee-service.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeServiceService, private router: Router) { }
  ngOnInit() {
  }
  saveEmployee(){
  this.employeeService.createEmployee(this.employee).subscribe( data =>{
    this.goToEmployeeList();
  },
  error => console.log(error));
}
goToEmployeeList(){
  this.router.navigate(['/employees']);
}
onSubmit(){
  Swal.fire(
    'Done',
    'Employee Successfully added',
    'success'
  )

 this.saveEmployee();
}

}