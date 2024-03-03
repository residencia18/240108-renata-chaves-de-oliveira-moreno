import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'; // Importe o CommonModule

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { CadastroAtendimentoComponent } from './cadastro-atendimento/cadastro-atendimento.component';
import { AtendimentosComponent } from './atendimentos/atendimentos.component';

@NgModule({
  declarations: [
    AppComponent,

    CadastroAtendimentoComponent,
      AtendimentosComponent,
      
  ],
  imports: [
    BrowserModule,
    CommonModule, // Adicione o CommonModule aqui
    AppRoutingModule,
    RouterModule.forRoot([]),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
