import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginScreenComponent} from './LoginScreen/login_screen.component';
import {RouterModule, Routes} from '@angular/router';

const appRoutes: Routes = [
  {path: '', component: AppComponent},
  {
    path: 'login',
    component: LoginScreenComponent,
  }
];

@NgModule({
  declarations: [
    AppComponent, LoginScreenComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
