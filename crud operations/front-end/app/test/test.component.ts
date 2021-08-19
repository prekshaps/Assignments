import { Component, OnInit } from '@angular/core';

@Component({
  selector: '[app-test]',
  template: `<div>Inline template</div><h1>`,
  
  styles:[`
  div{
    color: red;
  }`]
})
export class TestComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
