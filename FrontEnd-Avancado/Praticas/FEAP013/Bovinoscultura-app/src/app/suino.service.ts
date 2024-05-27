import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Gado } from './gado.model'; // Importe o modelo de bovinos

@Injectable({
  providedIn: 'root'
})
export class GadoService {
  private gadoSubject = new BehaviorSubject<Gado[]>([]); // Inicialize com um array vazio
  aves$ = this.gadoSubject.asObservable();

  constructor() {
    this.loadGadoFromLocalStorage();
  }

  private loadGadoFromLocalStorage() {
    const gadoFromLocalStorage = JSON.parse(localStorage.getItem('gado') || '[]');
    this.gadoSubject.next(gadoFromLocalStorage);
  }

  getGados(): Gado[] {
    return this.gadoSubject.value;
  }

  updateGados(gado: Gado[]): void {
    localStorage.setItem('aves', JSON.stringify(gado));
    this.gadoSubject.next(gado);
  }
}
