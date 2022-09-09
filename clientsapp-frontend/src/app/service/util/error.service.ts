import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";

/*
  Based on https://angular.io/tutorial/toh-pt6#error-handling
 */
@Injectable({
  providedIn: 'root'
})
export class ErrorService {

  constructor() { }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   *
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
