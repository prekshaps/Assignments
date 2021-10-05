import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';

export interface RpaData {
  po:number;
  rpa:number;
  shipment:number;
  vendor:string;
  vendorname:string;
}


const data: RpaData[] = [
  {po:1,rpa:1111,shipment:1122,vendor:'GT102',vendorname:'vendor1'},
  {po:2,rpa:2222,shipment:1133,vendor:'GT103',vendorname:'vendor2'},
  {po:3,rpa:3333,shipment:1144,vendor:'GT104',vendorname:'vendor3'},
  {po:4,rpa:1111,shipment:1122,vendor:'GT102',vendorname:'vendor1'},
  {po:5,rpa:5555,shipment:1122,vendor:'GT105',vendorname:'vendor4'},
  {po:6,rpa:6666,shipment:1166,vendor:'GT106',vendorname:'vendor6'},
  {po:7,rpa:7777,shipment:1177,vendor:'GT107',vendorname:'vendor7'}
];



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  addFilterFlag = false;
  selectedCustomColumn;

  displayedColumns = ['po','rpa','shipment','vendor','vendorname'];
  customFilters = [];
  groupByColumns = [];

  dataSource = new MatTableDataSource<RpaData>();

  constructor() {
    this.dataSource.data = data;
  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  addFilter(columnName) {
    this.customFilters.push({ column: columnName, value: '' });
    this.selectedCustomColumn = null;
  }

  ifExists(columnName) {
    for (const iterator of this.customFilters) {
      if (iterator.column == columnName) {
        return false;
      }
    }
    return true;
  }

  customSearch() {
    this.dataSource.data = data.filter(row => this.multipleFilterPredicate(row));
    this.dataSource._updateChangeSubscription();
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }

  multipleFilterPredicate(row) {
    for (const iterator of this.customFilters) {
      if (iterator.value != '' && (row[iterator.column] + '').toLocaleLowerCase().indexOf(iterator.value) == -1) {
        return false;
      
    }
  }
    return true;
  
  }

  clearCustomFilter() {
    this.customFilters = [];
    this.dataSource.data = data;
    this.dataSource._updateChangeSubscription();
  }

  clearCommonFilter(inp) {
    this.dataSource.filter = undefined;
    inp.value = '';
  }

  

  /*filterValues = {};
  dataSource = new MatTableDataSource();
  displayedColumns: string[] = ['po','rpa','shipment','vendor','vendorname'];
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;


  filterSelectObj = [];
  constructor(
  ) {

    // Object to create Filter for
    this.filterSelectObj = [
      {
        name: 'PO',
        columnProp: 'po',
        options: []
      }, {
        name: 'RPA',
        columnProp: 'rpa',
        options: []
      }, {
        name: 'SHIPMENT',
        columnProp: 'shipment',
        options: []
      },
       {
        name: 'VENDOR',
        columnProp: 'vendor',
        options: []
      },
      {
        name: 'VENDORNAME',
        columnProp: 'vendorname',
        options: []
      }
    ]
  }

  ngOnInit() {
    this.getRemoteData();

    // Overrride default filter behaviour of Material Datatable
    this.dataSource.filterPredicate = this.createFilter();
  }

  // Get Uniqu values from columns to build filter
  getFilterObject(fullObj, key) {
    const uniqChk = [];
    fullObj.filter((obj) => {
      if (!uniqChk.includes(obj[key])) {
        uniqChk.push(obj[key]);
      }
      return obj;
    });
    return uniqChk;
  }

  // Get remote serve data using HTTP call
  getRemoteData() {

    const remoteDummyData = [
      {
        "po": 1,
        "rpa": 1111,
        "shipment": 111122,
        "vendor": "GT102",
        "vendorname": "vendor1"
      },
      {
        "po": 2,
        "rpa": 2222,
        "shipment": 111122,
        "vendor": "GT103",
        "vendorname": "vendor2"
        
      },
      {
        "po": 3,
        "rpa": 33333,
        "shipment": 111133,
        "vendor": "GT104",
        "vendorname": "vendor3"
        
      },
      {
        "po": 4,
        "rpa": 44444,
        "shipment": 111144,
        "vendor": "GT105",
        "vendorname": "vendor4"
        
      },
      {
        "po": 5,
        "rpa": 55555,
        "shipment": 111122,
        "vendor": "GT106",
        "vendorname": "vendor5"
      },
      {
        "po": 6,
        "rpa": 66666,
        "shipment": 111166,
        "vendor": "GT107",
        "vendorname": "vendor5"
       
      },
      {
        "po": 7,
        "rpa": 777777,
        "shipment": 111177,
        "vendor": "GT106",
        "vendorname": "vendor5"
      }
    
    ];
    this.dataSource.data = remoteDummyData;

    this.filterSelectObj.filter((o) => {
      o.options = this.getFilterObject(remoteDummyData, o.columnProp);
    });
  }

  // Called on Filter change
  filterChange(filter, event) {
    //let filterValues = {}
    this.filterValues[filter.columnProp] = event.target.value.trim().toLowerCase()
    this.dataSource.filter = JSON.stringify(this.filterValues)
  }

  // Custom filter method fot Angular Material Datatable
  createFilter() {
    let filterFunction = function (data: any, filter: string): boolean {
      let searchTerms = JSON.parse(filter);
      let isFilterSet = false;
      for (const col in searchTerms) {
        if (searchTerms[col].toString() !== '') {
          isFilterSet = true;
        } else {
          delete searchTerms[col];
        }
      }

      console.log(searchTerms);

      let nameSearch = () => {
        let found = false;
        if (isFilterSet) {
          for (const col in searchTerms) {
            searchTerms[col].trim().toLowerCase().split(' ').forEach(word => {
              if (data[col].toString().toLowerCase().indexOf(word) != -1 && isFilterSet) {
                found = true
              }
            });
          }
          return found
        } else {
          return true;
        }
      }
      return nameSearch()
    }
    return filterFunction
  }


  // Reset table filters
  resetFilters() {
    this.filterValues = {}
    this.filterSelectObj.forEach((value, key) => {
      value.modelValue = undefined;
    })
    this.dataSource.filter = "";
  }*/
}
  

