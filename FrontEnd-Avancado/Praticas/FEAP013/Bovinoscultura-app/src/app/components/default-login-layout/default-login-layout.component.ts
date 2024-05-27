import { Component, EventEmitter, Input, Output } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth';
import firebase from 'firebase/app';

@Component({
  selector: 'app-default-login-layout',
  templateUrl: './default-login-layout.component.html',
  styleUrls: ['./default-login-layout.component.scss']
})
export class DefaultLoginLayoutComponent {
  @Input() title: string = "";
  @Input() primaryBtnText: string = "";
  @Input() secondaryBtnText: string = "";
  @Input() disablePrimaryBtn: boolean = true;
  @Output("submit") onSubmit = new EventEmitter();
  @Output("navigate") onNavigate = new EventEmitter();

  constructor(private afAuth: AngularFireAuth) {}

  async submit(){
    this.onSubmit.emit();
  }

  async navigate(){
    this.onNavigate.emit();
  }

  async loginWithGoogle() {
    try {
      const provider = new firebase.auth.GoogleAuthProvider();
      await this.afAuth.signInWithPopup(provider);
      // Aqui você pode redirecionar o usuário após o login
    } catch (error) {
      console.error('Erro no login com Google:', error);
    }
  }
}

  navigate(){
    this.onNavigate.emit();
  }
}
