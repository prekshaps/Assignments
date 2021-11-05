import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {UserModule} from './components/user/user.module';

import { AppRoutes } from './app-routing.module';
import { SearchResultsComponent } from './components/search-results/search-results.component';


@NgModule({
  imports:      [ BrowserModule, AppRoutes, UserModule ],
  declarations: [ AppComponent, SearchResultsComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
