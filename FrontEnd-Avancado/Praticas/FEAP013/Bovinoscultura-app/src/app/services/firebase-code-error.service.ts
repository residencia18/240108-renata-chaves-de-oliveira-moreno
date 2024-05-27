import { Injectable } from '@angular/core';
import { FirebaseCodeErrorEnum } from '../utils/firebase-code-error';

@Injectable({
  providedIn: 'root',
})
export class FirebaseCodeErrorService {
  constructor() {}

  codeError(code: string) {
    switch (code) {
      // Email já existe
      case FirebaseCodeErrorEnum.EmailAlreadyInUse:
        return 'O usuário já existe';

      // Senha fraca
      case FirebaseCodeErrorEnum.WeakPassword:
        return 'A senha é muito fraca';

      // E-mail inválido
      case FirebaseCodeErrorEnum.InvalidEmail:
        return 'E-mail inválido';

      // Senha incorreta
      case FirebaseCodeErrorEnum.WrongPassword:
        return 'Senha incorreta';

      // Usuário não encontrado
      case FirebaseCodeErrorEnum.UserNotFound:
        return 'Usuário não encontrado';

      default:
        return 'Erro desconhecido';
    }
  }
}
