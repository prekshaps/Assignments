import { RouterModule, Routes } from '@angular/router';
import { SearchResultsComponent } from '../search-results/search-results.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserComponent } from './user.component';

const routes: Routes = [
  { path: '', component: UserComponent },
  {path:'user-list', component:UserListComponent,pathMatch:'full'}
];

export const UserRoutes = RouterModule.forChild(routes);

