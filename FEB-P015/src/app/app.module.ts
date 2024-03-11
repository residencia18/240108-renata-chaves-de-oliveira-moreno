import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';




// Modulos
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AngularFireModule } from '@angular/fire/compat'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

// Componentes
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { RegistrarUsuarioComponent } from './components/registrar-usuario/registrar-usuario.component';
import { VerificarCorreoComponent } from './components/verificar-correo/verificar-correo.component';
import { RecuperarPasswordComponent } from './components/recuperar-password/recuperar-password.component';
import { SpinnerComponent } from './shared/spinner/spinner.component';
import { CadastroSuinoComponent } from './components/cadastro-suino/cadastro-suino.component';


import { EdicaoPesoComponent } from './components/edicao-peso/edicao-peso.component';
import { CadastroPesoComponent } from './components/cadastro-peso/cadastro-peso.component';
import { CommonModule } from '@angular/common';
import { ListagemSuinosComponent } from './components/listagem-suinos/listagem-suinos.component';
import { CalcularIdadeEmMesesPipe } from './components/listagem-suinos/calcular-idade-em-meses.pipe';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { ControlePesoComponent } from './components/controle-peso/controle-peso.component';
import { FiltroSuinosPipe } from './filtro-suinos.pipe';
import { SuinoService } from './services/suinos.service';
import { environment } from 'src/environments/environment.prod';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    RegistrarUsuarioComponent,
    VerificarCorreoComponent,
    RecuperarPasswordComponent,
    SpinnerComponent,
    EdicaoPesoComponent,
    CadastroPesoComponent,
    CadastroSuinoComponent,
    ListagemSuinosComponent,
    CalcularIdadeEmMesesPipe,
    FooterComponent,
    HeaderComponent,
    ControlePesoComponent,
    FiltroSuinosPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    SuinoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
