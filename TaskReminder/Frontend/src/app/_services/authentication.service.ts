import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class  AuthenticationService {
  constructor(private http: HttpClient) { }
  // public login(user: User) {
  //   return new Promise((resolve, reject) => {
  //     const foundUser = this.users.find(usr => usr.isValidLogin(user));
  //     if (!foundUser) {
  //       reject('Username or Password Invalid');
  //     } else {
  //       resolve(foundUser);
  //     }
  //   });
  // }

  login(username: string, password: string) {
    return this.http.post<any>(`${config.apiUrl}/users/authenticate`, { username: username, password: password })
    .pipe(map(user => {
      // login successful if there's a jwt token in the response
      if (user && user.token) {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user));
      }

      return user;
    }));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }
}
