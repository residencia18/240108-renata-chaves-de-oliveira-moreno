import { Component, OnInit } from '@angular/core';
import { JsonReaderService } from './json-reader.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

class ButtonInfo {
  constructor(public label: string, public color: string) {}
}

@Component({
  selector: 'app-root',
  template: `
    <div class="container">
    <div class="search-bar">
    <input type="text" placeholder="Procurar categoria..." [(ngModel)]="categoriaPesquisa" />
    <button mat-icon-button (click)="pesquisarPorCategoria()">
      <mat-icon>search</mat-icon>
    </button>
  </div>
      <div class="button-container">
      
        <div class="button-row">
          <button mat-raised-button *ngFor="let button of categoryButtons" [class]="button.color" (click)="onCategoryButtonClick(button)">{{ button.label }}</button>
        </div>

        <div class="button-row2">
          <button mat-raised-button *ngFor="let button of vehicleButtons" [class]="button.color" (click)="onCategoryButtonClick(button)">{{ button.label }}</button>
        </div>

        <div class="button-row3">
          <button mat-raised-button *ngFor="let button of propertyButtons" [class]="button.color" (click)="onCategoryButtonClick(button)">{{ button.label }}</button>
        </div>

        <div class="button-row-roxo">
        <button mat-raised-button ="selecionarPropriedade('Supermarine Spitfire')">Supermarine Spitfire</button>
      </div>
      

        <div class="button-row-adicionar">
          <button mat-raised-button (click)="adicionarVeiculo()">Adicionar</button>
        </div>
      </div>
      <div class="info-footer" *ngIf="(filteredCategoryInfo$ | async) as info">
      <h2>{{ categoriaPesquisa || selectedCategory }}</h2>
      <ul>
        <li *ngFor="let item of info">
          {{ item.Name }} - {{ item.Model }} - {{ item.Engine }} - {{ item.NumberOfPassengers }}
          - {{ item.Autonomia }} - {{ item.Alcance }} - {{ item.Teto }}
        </li>
      </ul>
    </div>
    </div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  categoryButtons: ButtonInfo[] = [
    new ButtonInfo('Categorias', 'red-button'),
    new ButtonInfo('Avioes', 'purple-button'),
    new ButtonInfo('Carros', 'purple-button'),
    new ButtonInfo('Barcos', 'purple-button')
  ];

  vehicleButtons: ButtonInfo[] = [
    new ButtonInfo('Aviões', 'red-button'),
    new ButtonInfo('Supermarine Spitfire', 'blue-button'),
    new ButtonInfo('B-17 Flying Fortress', 'blue-button'),
    new ButtonInfo('P-51 Mustang', 'blue-button')
  ];

  propertyButtons: ButtonInfo[] = [
    new ButtonInfo('Supermarine Spitfire', 'red-button'),
    new ButtonInfo('Name', 'blue-button'),
    new ButtonInfo('Model', 'blue-button'),
    new ButtonInfo('Engine', 'blue-button'),
    new ButtonInfo('NumberOfPassagers', 'blue-button'),
    new ButtonInfo('Autonomia', 'blue-button'),
    new ButtonInfo('Alcance', 'blue-button'),
    new ButtonInfo('Teto', 'blue-button')
  ];

  categoriaPesquisa: string = '';
  selectedVehicle: string = '';
  filteredCategoryInfo$: Observable<any[]> | null = null;
  selectedCategory: string | null = null;

  constructor(private jsonReaderService: JsonReaderService) {}

  ngOnInit() {
    // Aqui você pode chamar métodos do serviço quando o componente é inicializado, se necessário.
  }

  onCategoryButtonClick(button: ButtonInfo) {
    this.selectedCategory = button.label;
    this.filteredCategoryInfo$ = this.jsonReaderService.getVeiculosByCategory(button.label).pipe(
      map(veiculos => veiculos)
    );
  }

  pesquisarPorCategoria() {
    this.filteredCategoryInfo$ = this.jsonReaderService.getVeiculosByCategory(this.categoriaPesquisa).pipe(
      map(veiculos => this.filterVeiculos(veiculos))
    );
  }

  filterVeiculos(veiculos: any[]): any[] {
    // Implement your filtering logic here based on the search input
    // For example, you can filter based on veiculo properties or any other criteria
    return veiculos;
  }

  adicionarVeiculo() {
    // Lógica para adicionar veículo à lista de veículos selecionados
    this.selectedVehicle = 'Novo Veículo';
  }
}
