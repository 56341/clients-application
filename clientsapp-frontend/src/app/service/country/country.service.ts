import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, tap} from "rxjs";
import {ErrorService} from "../util/error.service";

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  private countryPath = '/api/country';

  constructor(private http: HttpClient, private errorService: ErrorService) { }

  public getCountries(): Observable<string[]> {
    return this.http.get<string[]>(this.countryPath + "/all")
      .pipe(
        tap(_ => console.log('fetched countries')),
        catchError(this.errorService.handleError<string[]>('getCountries', []))
      );
  }
}
