// Following row added to define global 'config' variable
///<reference path="../../../typings.d.ts"/>
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../_models/user';

@Injectable()
export class UserService {
  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<User[]>(`${config.apiUrl}/users`);
  }

  getById(id: number) {
    return this.http.get(`${config.apiUrl}/users/` + id);
  }

  register(user: User) {
    return this.http.post(`${config.apiUrl}/users/register`, user);
  }

  update(user: User) {
    return this.http.put(`${config.apiUrl}/users/` + user.id, user);
  }

  delete(id: number) {
    return this.http.delete(`${config.apiUrl}/users/` + id);
  }

  // users: User[] = [
  //   new User(1, 'admin', 'admin'),
  //   new User(2, 'user', 'user'),
  // ];


}
