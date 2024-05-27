import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AngularFireModule } from '@angular/fire/compat';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { RegistrarUsuarioComponent } from './components/registrar-usuario/registrar-usuario.component';
import { VerificarCorreoComponent } from './components/verificar-correo/verificar-correo.component';
import { RecuperarPasswordComponent } from './components/recuperar-password/recuperar-password.component';
import { SpinnerComponent } from './shared/spinner/spinner.component';
import { environment } from 'src/environments/environment';
import { CommonModule } from '@angular/common';
import { ListaGadoComponent } from './lista-gado/lista-gado.component';
import { FilterGadoPipe } from './lista-gado/filter-gado.pipe';
import { CadastroGadoComponent } from './cadastro-gado/cadastro-gado.component';
import { RouterModule } from "@angular/router";
import { EditarGadoComponent } from './editar-gado/editar-gado.component';
import { CadastroPesoComponent } from './cadastro-peso/cadastro-peso.component';
import { HttpClientModule } from '@angular/common/http';
import { PesoService } from './peso.service';
import { GadoService } from './gado.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    RegistrarUsuarioComponent,
    VerificarCorreoComponent,
    RecuperarPasswordComponent,
    SpinnerComponent,
    ListaGadoComponent,
    FilterGadoPipe, 
    CadastroGadoComponent, 
    EditarGadoComponent, 
    CadastroPesoComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    CommonModule,
    FormsModule,
    RouterModule
    
  ],
  exports: [
    ListaGadoComponent, 
    FilterGadoPipe,
    CadastroGadoComponent
  ],
  providers: [PesoService, GadoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
