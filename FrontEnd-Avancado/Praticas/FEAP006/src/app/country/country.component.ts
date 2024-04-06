import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  constructor(private http: HttpClient) { }

  getFirstCountryFields(): Observable<any[]> {
    return this.http.get<any>('https://restcountries.com/v3.1/all').pipe(
      map((response: any[]) => {
        const firstCountry = response[0];
        const fields = [];

        for (const key in firstCountry) {
          if (Object.prototype.hasOwnProperty.call(firstCountry, key)) {
            fields.push({
              po: 'text',
              nome: key,
              rotulo: key
            });
          }
        }

        return fields;
      })
    );
  }
}
