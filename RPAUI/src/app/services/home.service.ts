import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,of, Subject } from 'rxjs';
import { USERS } from '../shared/users';
@Injectable({
  providedIn: 'root'
})

export class HomeService {
  

  setGroupFilter$ = new Subject<any>();
  getGroupFilter = this.setGroupFilter$.asObservable();

  constructor() {}

  fetchUsers(): Observable<any> {
    return of(USERS);
  }
}
