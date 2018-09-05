import {Component} from '@angular/core';
import {UserServices} from '../user/user.services';

@Component({
  selector: 'app-login',
  templateUrl: 'login.component.html',
  styleUrls: ['login_screen.component.css'],
  providers: [UserServices]
})

export class LoginComponent {}
