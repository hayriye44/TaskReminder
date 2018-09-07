import {Component, OnInit, Output, EventEmitter} from '@angular/core';
import {User} from '../_models/user';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {first} from 'rxjs/operators';
import {AuthenticationService} from '../_services/authentication.service';
import {AlertService} from '../_services/alert.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login-screen',
  templateUrl: 'login_screen.component.html',
  styleUrls: ['login_screen.component.css']
})


export class LoginScreenComponent implements OnInit {

  @Output() loggedIn = new EventEmitter<User>();
  private _loginSuccess = false;
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private authenticationService: AuthenticationService,
    private alertService: AlertService) {}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  // convenience getter for easy access to form fields
  get formControl() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;
    this.authenticationService.login(this.formControl.username.value, this.formControl.password.value)
    .pipe(first())
    .subscribe(
      data => {
        this.router.navigate([this.returnUrl]);
      },
      error => {
        this.alertService.error(error);
        this.loading = false;
      });
  }

//   public loginUser(nameElement: any, passElement: any): Boolean {
//     const newUser: User = new User(0, nameElement.value, passElement.value);
//     this.loggedIn.emit(newUser);
//
//     return false;
// }

}
