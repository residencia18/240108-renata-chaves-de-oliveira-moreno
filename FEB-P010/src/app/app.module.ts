import { MatIconModule } from '@angular/material/icon';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; // Importe o HttpClientModule
import { AppComponent } from './app.component';
import { JsonReaderService } from './json-reader.service';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    // ... outros componentes
  ],
  imports: [
    BrowserModule,
    HttpClientModule, // Adicione o HttpClientModule aqui
    FormsModule,
    MatIconModule,
    BrowserAnimationsModule,
    // ... outros módulos
  ],
  providers: [JsonReaderService], // Fornecendo o JsonReaderService como um provedor
  bootstrap: [AppComponent],
})
export class AppModule { }
