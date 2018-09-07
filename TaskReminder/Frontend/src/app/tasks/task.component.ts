import {Component, OnInit} from '@angular/core';
import {User} from '../_models/user';
import {UserService} from '../_services/user.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-tasks',
  templateUrl: 'task.component.ts'
})
export class TaskComponent implements OnInit {
  currentUser: User;
  users: User[] = [];

  constructor(private userService: UserService) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.loadAllUsers();
  }

  deleteUser(id: number) {
    this.userService.delete(id).pipe(first()).subscribe(() => {
      this.loadAllUsers();
    });
  }

  private loadAllUsers() {
    this.userService.getAll().pipe(first()).subscribe(users => {
      this.users = users;
    });
  }
}
