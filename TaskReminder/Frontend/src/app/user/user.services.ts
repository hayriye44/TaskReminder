import {Injectable} from '@angular/core';
import {User} from './user.model';

@Injectable()
export class UserServices {
  users: User[] = [
    new User(1, 'admin', 'admin'),
    new User(2, 'user', 'user'),
  ];

  public login(user: User) {

  }

}
