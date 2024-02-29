import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class JsonReaderService {
  private jsonsrc = 'assets/veiculos.json';

  constructor(private http: HttpClient) {}

  getVeiculos(): Observable<any> {
    return this.http.get<any>(this.jsonsrc);
  }

  getVeiculosByCategory(category: string): Observable<any> {
    return this.getVeiculos().pipe(
      map(data => data[category])
    );
  }
}
