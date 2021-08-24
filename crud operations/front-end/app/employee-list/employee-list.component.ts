import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';
import { Employee } from '../employee';
import { EmployeeServiceService } from '../employee-service.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  public employees: Employee[];
  employeearray: Array<Employee> = [];
  deleteresult: String;
  toggleBool: boolean = true;

  constructor(private employeeService: EmployeeServiceService, private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }
  private getEmployees() {
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
    })
  }

  isActive(e: any, employeeitem: Employee) {
    if (e.target.checked) {
      this.employeearray.push(employeeitem);
      this.toggleBool = false;
    } else {
      var r = this.employeearray.indexOf(employeeitem);
      this.employeearray.splice(r, 1);
      this.toggleBool = true;
    }
  }

  updateEmployee() {
    var l = this.employeearray.length;
    if (l > 1 || l == 0) {
      if (l > 1) {
        alert("select only single record " + l);
      }
      if (l == 0) {
        alert("please select single record do you want to update " + l);
      }
    }
    if (l == 1) {
      var employee = this.employeearray[0];

      this.router.navigate(['update', employee.id]);
    }

  }
  deleteEmployee() {
    var ld = this.employeearray.length;
    if (ld > 0) {
      for (let eachemployee of this.employeearray) {
        this.employeeService.deleteEmployee(eachemployee.id)
          .subscribe(
            data => {
              console.log(data);
              Swal.fire(
                'Done',
                'Employee Successfully deleted',
                'success'
              )
              this.getEmployees();
            },
            error => console.log(error));
      }
    }
    else {
      alert("Please select atleast one record");
    }
  }

  employeeDetails(id: number) {
    this.router.navigate(['details', id]);
  }

}
