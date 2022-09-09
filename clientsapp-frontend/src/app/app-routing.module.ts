import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ClientListComponent} from "./component/client-list/client-list.component";
import {ErrorPageComponent} from "./component/error-page/error-page.component";
import {AddClientComponent} from "./component/add-client/add-client.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: ClientListComponent },
  { path: 'add-client', component: AddClientComponent },
  { path: '**', component: ErrorPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
