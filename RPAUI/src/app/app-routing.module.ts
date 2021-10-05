import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccuracyParametersComponent } from './pages/accuracy-parameters/accuracy-parameters.component';
import { EditRpaComponent } from './pages/edit-rpa/edit-rpa.component';
import { HomeComponent } from './pages/home/home.component';
import { ParameterToleranceComponent } from './pages/parameter-tolerance/parameter-tolerance.component';
import { SearchResultsComponent } from './pages/search-results/search-results.component';
import { ValidationErrorsComponent } from './pages/validation-errors/validation-errors.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full',
  },

  {
    path: 'parameter-tolerances',
    component: ParameterToleranceComponent,
  
  },
  {
    path: 'validation-errors',
    component: ValidationErrorsComponent,
    pathMatch: 'full',
  },
  {
    path: 'search-results',
    component: SearchResultsComponent,
    pathMatch: 'full',
  },
  {
    path: 'edit-rpa',
    component:EditRpaComponent,
    pathMatch: 'full',
  },
  {
    path: 'accuracy-parameters',
    component: AccuracyParametersComponent,
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
