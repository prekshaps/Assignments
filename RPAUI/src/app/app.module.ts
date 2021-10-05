import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { MatCardModule } from '@angular/material/card';
import { MaterialModule } from './shared/material.module';
import { SearchResultsComponent } from './pages/search-results/search-results.component';
import { EditRpaComponent } from './pages/edit-rpa/edit-rpa.component';
import { ValidationErrorsComponent } from './pages/validation-errors/validation-errors.component';
import { ParameterToleranceComponent } from './pages/parameter-tolerance/parameter-tolerance.component';
import { AccuracyParametersComponent } from './pages/accuracy-parameters/accuracy-parameters.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeService } from './services/home.service';
import { UserListComponent } from './pages/user-list/user-list.component';
import { UserComponent } from './pages/user/user.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    SearchResultsComponent,
    EditRpaComponent,
    ValidationErrorsComponent,
    ParameterToleranceComponent,
    AccuracyParametersComponent,
    UserListComponent,
    UserComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [HomeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
-[]