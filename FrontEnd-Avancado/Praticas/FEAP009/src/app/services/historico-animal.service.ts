import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HistoricoAnimalService {

  constructor(private http: HttpClient) { }

  getHistoricoAnimal(brinco: number): Observable<any[]> {
    // Substitua 'URL_DA_SUA_API' pela URL real da sua API que fornece os dados de histórico
    return this.http.get<any[]>(`https://suinocultura-a16ad-default-rtdb.firebaseio.com/pesos/${brinco}.json`);

  }
}


