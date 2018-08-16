import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginScreenComponent} from './LoginScreen/login_screen.component';
import {Route} from '@angular/router';

// const appRoutes: Route = [
//   {
//     path: '',
//     component: LoginScreenComponent,
//   }
// ];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
