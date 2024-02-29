// app.component.ts

import { Component } from '@angular/core';
import { WikipediaService } from './wikipedia.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  searchResults: any[] = [];
  searchTerm: string = '';
  title = "Wikipedia";
  noResultsMessage: string = '';

  constructor(private wikipediaService: WikipediaService) {}

  onSearch() {
    if (this.searchTerm.trim() !== '') {
      this.wikipediaService.search(this.searchTerm).subscribe((data) => {
        this.searchResults = data.query.search;
        this.noResultsMessage = this.searchResults.length === 0 ? `Nenhum resultado encontrado para "${this.searchTerm}"` : '';
      });
    } else {
      // Limpar resultados se o termo de busca estiver vazio
      this.searchResults = [];
      this.noResultsMessage = '';
    }
  }
}

