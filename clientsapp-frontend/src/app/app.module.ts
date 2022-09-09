import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ClientListComponent } from './component/client-list/client-list.component';
import { AppRoutingModule } from "./app-routing.module";
import { AddClientComponent } from './component/add-client/add-client.component';
import {HttpClientModule} from "@angular/common/http";
import { ErrorPageComponent } from './component/error-page/error-page.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    ClientListComponent,
    AddClientComponent,
    ErrorPageComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
