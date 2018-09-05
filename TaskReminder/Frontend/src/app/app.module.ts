import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginScreenComponent} from './login_screen/login_screen.component';
import {AppRoutingModule} from './app-routing.module';
import {LoginComponent} from './login_screen/login.component';
import {HomeComponent} from './home/home.component';
import {UserServices} from './user/user.services';


@NgModule({
  declarations: [AppComponent, HomeComponent, LoginComponent, LoginScreenComponent ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [UserServices],
  bootstrap: [AppComponent]
})
export class AppModule {
}
