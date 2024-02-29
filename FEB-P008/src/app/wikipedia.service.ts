import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class WikipediaService {
  private apiUrl = 'http://localhost:3000/wikipedia-search';

  constructor(private http: HttpClient) {}

  search(term: string): Observable<any> {
    // Agora, faça a chamada para o seu servidor local
    return this.http.get<any>(`${this.apiUrl}?term=${term}`);
  }
}

