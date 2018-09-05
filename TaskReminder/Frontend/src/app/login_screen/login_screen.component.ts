import {Component, Output, EventEmitter} from '@angular/core';
import {User} from '../user/user.model';

@Component({
  selector: 'app-login-screen',
  templateUrl: 'login_screen.component.html',
  styleUrls: ['login_screen.component.css']
})


export class LoginScreenComponent {

  @Output() loggedIn = new EventEmitter<User>();

  public loginUser(name: string, pass: string): Boolean {
    const newUser: User = new User(0, name, pass);
    this.loggedIn.emit(newUser);

    return false;
}

}
