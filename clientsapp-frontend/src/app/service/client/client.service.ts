import { Injectable } from '@angular/core';
import {catchError, Observable, of, tap} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {MinimalClient} from "../../model/minimal-client";
import {ErrorService} from "../util/error.service";
import {NewClient} from "../../model/new-client";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private clientPath = '/api/client';

  constructor(private http: HttpClient, private errorService: ErrorService) { }

  public getClients(): Observable<MinimalClient[]> {
    return this.http.get<MinimalClient[]>(this.clientPath + "/all")
      .pipe(
        tap(_ => console.log('fetched clients')),
        catchError(this.errorService.handleError<MinimalClient[]>('getClients', []))
      );
  }

  public createClient(client: NewClient): Observable<void> {
    return this.http.post<void>(this.clientPath + "/create", client);
  }

}
