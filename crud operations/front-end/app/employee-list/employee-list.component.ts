import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { DeleteDialogComponent } from '../delete-dialog/delete-dialog.component';

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
  showSpinner = false;


  constructor(private employeeService: EmployeeServiceService, private router: Router, public dialog: MatDialog, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getEmployees();
  }
  private getEmployees() {
    this.showSpinner = true;
    setTimeout(() => {
      this.showSpinner = false;
    }, 3000)
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
    let dialogRef = this.dialog.open(DeleteDialogComponent, {
      height: '200px',
      width: '400px',
    });
    dialogRef.afterClosed().subscribe(result => {
      this.deleteresult = `${result}`;
      if (ld > 0) {
        for (let eachemp of this.employeearray) {
          console.log(this.deleteresult);
          if (this.deleteresult === "true") {
            this.employeeService.deleteEmployee(eachemp.id).subscribe(data => {
              console.log(data);
              this.getEmployees();
            });

            const snack = this.snackBar.open('item deleted', 'undo', {
              duration: 2000,
            })
          }
        }
      }
      else {
        alert("Please select atleast one record");
      }
    })
  }

  employeeDetails(id: number) {
    this.router.navigate(['details', id]);
  }

}

