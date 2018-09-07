import {Component} from '@angular/core';
import {UserService} from '../_services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: 'login.component.html',
  styleUrls: ['login_screen.component.css'],
  providers: [UserService]
})

export class LoginComponent {}
