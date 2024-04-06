import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-country-form',
  templateUrl: './country-form.component.html',
  styleUrls: ['./country-form.component.css']
})
export class CountryFormComponent implements OnInit {
  camposDoForm: any[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<any>('https://restcountries.com/v3.1/all').subscribe(data => {
      if (data && data.length > 0) {
        const firstRecord = data[0];
        this.camposDoForm = Object.keys(firstRecord).map(key => ({
          tipo: 'text',
          nome: key,
          rotulo: key
        }));
      }
    });
  }
}
